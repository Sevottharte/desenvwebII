package br.com.javaweb.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.javaweb.dao.AlunoDAO;
import br.com.javaweb.dao.OrientadorDAO;
import br.com.javaweb.domain.Aluno;
import br.com.javaweb.domain.Orientador;
import br.com.javaweb.util.FacesUtil;

@ManagedBean
@ViewScoped
public class AlunoBean {

	private Aluno alunoCadastro;
	private List<Aluno> listaAlunos;
	private List<Aluno> listaAlunosFiltrados;
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public List<Aluno> getListaAlunosFiltrados() {
		return listaAlunosFiltrados;
	}
	public void setListaAlunosFiltrados(List<Aluno> listaAlunosFiltrados) {
		this.listaAlunosFiltrados = listaAlunosFiltrados;
	}
	public Aluno getAlunoCadastro() {
		if (alunoCadastro == null) {
			alunoCadastro = new Aluno();
		}
		return alunoCadastro;
	}
	public void setAlunoCadastro(Aluno alunoCadastro) {
		this.alunoCadastro = alunoCadastro;
	}
	public void novo() {
		alunoCadastro = new Aluno();
	}
	public void salvar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.salvar(alunoCadastro);
			alunoCadastro = new Aluno(); // limpa o objeto no modelo
			FacesUtil.adicionarMsgInfo("Aluno salvo com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir um aluno: " +
					ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.excluir(alunoCadastro);
			FacesUtil.adicionarMsgInfo("Aluno removido com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir um aluno: " +
					ex.getMessage());
		}
	}
	public void editar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.editar(alunoCadastro);
			FacesUtil.adicionarMsgInfo("Aluno editado com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar os dados do aluno: " +
					ex.getMessage());
		}
	}

	public void carregar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			listaAlunos = alunoDAO.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os alunos: " +
					ex.getMessage());
		}
	}
	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("alucod");
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				AlunoDAO alunoDAO = new AlunoDAO();
				alunoCadastro = alunoDAO.buscarPorCodigo(codigo);
			}else{
				alunoCadastro = new Aluno();
			}
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do aluno: " +
					ex.getMessage());
		}
	}
	
	public void limpar() {
		alunoCadastro  = new Aluno();
	}
}

