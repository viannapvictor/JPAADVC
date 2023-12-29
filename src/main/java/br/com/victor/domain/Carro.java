/**
 * 
 */
package br.com.victor.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author victor.vianna
 *
 */
@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_marca_fk",
			foreignKey = @ForeignKey(name = "fk_marca_carro"),
			referencedColumnName = "id", nullable = false
	)
	private Marca marca;
	@OneToMany(mappedBy = "carro")
	private List<Acessorio> acessorios;

	public Carro() {
		this.acessorios = new ArrayList<Acessorio>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public void add(Acessorio acessorio) {
		this.acessorios.add(acessorio);
	}
}
