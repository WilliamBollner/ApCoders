package br.com.williamdev.apcoders.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Long idUnidade;
	@Column(length = 40, nullable = false)
	private String proprietario;
	@Column(length = 50, nullable = false)
	private String condominio;
	@Column(length = 70, nullable = false)
	private String endereco;
	@ManyToOne
	@JoinColumn(name = "id_inquilino")
	private Inquilino inquilino;
	@OneToMany(mappedBy = "unidade")
	private List<Despesa> despesa = new ArrayList<>();
	
	public Long getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
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

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public List<Despesa> getDespesa() {
		return despesa;
	}

	public void setDespesa(List<Despesa> despesa) {
		this.despesa = despesa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(condominio, despesa, endereco, idUnidade, inquilino, proprietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		return Objects.equals(condominio, other.condominio) && Objects.equals(despesa, other.despesa)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(idUnidade, other.idUnidade)
				&& Objects.equals(inquilino, other.inquilino) && Objects.equals(proprietario, other.proprietario);
	}
	
	

}
