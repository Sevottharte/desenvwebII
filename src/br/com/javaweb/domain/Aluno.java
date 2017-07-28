package br.com.javaweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_alunos")
@NamedQueries({
	@NamedQuery(name="Aluno.listar", query="SELECT aluno FROM Aluno aluno "),
	@NamedQuery(name="Aluno.buscarPorCodigo", query="SELECT aluno FROM Aluno aluno "
			+ "WHERE aluno.codigo = :codigo")
})
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alu_codigo")
	private Long codigo;
	
	@Column(name = "alu_nome", length = 70, nullable = false)
	private String nome;
			
	/*
	 * Adicionando novos campos para atender às necessidades da quarta semana
	 * */
	//cpf sem a pontuação
	@Column(name = "alu_cpf", length = 14, nullable = false)
	private String cpf;
	
	@Column(name = "data_matricula", length = 15, nullable = false)
	private String dataMatricula;
	
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
	
	@Column(name = "modalidade", length = 15, nullable = false)
	private String modalidade;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
}
