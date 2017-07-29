package br.com.javaweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_usuarios")
@NamedQueries({
	@NamedQuery(name="Usuario.listar", query="SELECT usuario FROM Usuario usuario "),
	@NamedQuery(name="Usuario.buscarPorCodigo", query="SELECT usuario FROM Usuario usuario "
			+ "WHERE usuario.codigo = :codigo")
})
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usu_codigo")
	private Long codigo;

	@Column(name = "usu_nome", length = 70, nullable = false)
	private String nome;

	//cpf sem a pontuação
	@Column(name = "usu_cpf", length = 15, nullable = false)
	private String cpf;

	@Column(name = "usu_senha", length = 16, nullable = false)
	private String senha;

	@Column(name = "usu_funcao", length = 16, nullable = false)
	private String funcao;

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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
