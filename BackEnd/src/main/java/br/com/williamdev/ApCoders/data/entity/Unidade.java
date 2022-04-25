package br.com.williamdev.apcoders.data.entity;

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

import br.com.williamdev.apcoders.data.dto.DespesaDTO;
import br.com.williamdev.apcoders.data.dto.UnidadeDTO;

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
	@OneToMany(mappedBy = "unidade", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
	private List<DespesaUnidade> despesa = new ArrayList<>();
	
	public List<DespesaDTO> converterListDespesa(){
		List<DespesaDTO> despesasU = new ArrayList<>();
		for (DespesaUnidade despesas : getDespesa()) {	
			despesasU.add(despesas.convertToDTO());
		}
		return despesasU;
	}
	

	public UnidadeDTO convertToDTO() {
		return new UnidadeDTO(getIdUnidade(),
				getProprietario(),
				getCondominio(),
				getEndereco(),
				getInquilino().convertToDTO(),
				converterListDespesa());
	}
	
	public Unidade() {}

	public Unidade(Long idUnidade, String proprietario, String condominio, String endereco, Inquilino inquilino,
			List<DespesaUnidade> despesa) {
		this.idUnidade = idUnidade;
		this.proprietario = proprietario;
		this.condominio = condominio;
		this.endereco = endereco;
		this.inquilino = inquilino;
		this.despesa = despesa;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public List<DespesaUnidade> getDespesa() {
		return despesa;
	}

	public void setDespesa(List<DespesaUnidade> despesa) {
		this.despesa = despesa;
	}

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
	

}
