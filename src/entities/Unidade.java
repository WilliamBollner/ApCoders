package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidade")
	private int idUnidade;
	@Column(length = 40, nullable = false)
	private String proprietario;
	@Column(length = 50, nullable = false)
	private String condominio;
	@Column(length = 70, nullable = false)
	private String endereco;
	@ManyToOne
	@JoinColumn(name = "id_inquilino")
	private Inquilino inquilino;
	@OneToMany(mappedBy = "unidade", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
	private List<DespesasUnidades> despesa = new ArrayList<>();
	
	public Unidade() {
		
	}
	
	public Unidade(int idUnidade, String proprietario, String condominio, String endereco, Inquilino inquilino) {
		this.idUnidade = idUnidade;
		this.proprietario = proprietario;
		this.condominio = condominio;
		this.endereco = endereco;
		this.inquilino = inquilino;
	}

	public Unidade(int idUnidade, String proprietario, String condominio, String endereco) {
		this.proprietario = proprietario;
		this.condominio = condominio;
		this.endereco = endereco;
		this.idUnidade = idUnidade;
	}
	
	public Unidade(String proprietario, String condominio, String endereco) {
		this.proprietario = proprietario;
		this.condominio = condominio;
		this.endereco = endereco;
	}
	
	

	public int getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Id unidade: " + idUnidade + "\n  Proprietário: " + proprietario + "\nCondomínio: " + condominio
				+ "\nEndereço: " + endereco + "\n";
	}
	
	

}
