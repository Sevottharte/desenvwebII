package br.com.uab.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_produtos")
@NamedQueries({
	@NamedQuery(name="Produto.listar", query="SELECT produto FROM Produto produto "),
	@NamedQuery(name="Produto.buscarPorCodigo", query="SELECT produto FROM Produto produto "
			+ "WHERE produto.id = :id")
})
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prod_codigo")
	private Long id;
	
	@Column(name = "prod_nome", length = 70, nullable = false)
	private String nome;
	@Column(name = "prod_descricao", length = 70, nullable = false)
	private String descricao;
	
	@Column(name = "prod_preco")
	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}


}
