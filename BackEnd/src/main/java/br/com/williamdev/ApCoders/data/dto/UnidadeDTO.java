package br.com.williamdev.apcoders.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.williamdev.apcoders.data.entity.DespesaUnidade;
import br.com.williamdev.apcoders.data.entity.Unidade;

public class UnidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idUnidadeDTO;
	private String proprietarioUnidade;
	private String condominioUnidade;
	private String enderecoUnidade;
	private InquilinoDTO inquilino;
	private List<DespesaDTO> despesa;
	
	public List<DespesaUnidade> converterListDespesa(){
		List<DespesaUnidade> despesaU = new ArrayList<>();
		for (DespesaDTO despesas : despesa) {
			despesaU.add(despesas.convertToEntity());
		}
		return despesaU;
	} 

	public Unidade convertToEntity() {
		return new Unidade(getIdUnidadeDTO(),
				getProprietarioUnidade(),
				getCondominioUnidade(),
				getEnderecoUnidade(),
				getInquilino().convertToEntity(),
				converterListDespesa());
	}
	
	public UnidadeDTO() {}
	
	public UnidadeDTO(Long idUnidadeDTO, String proprietarioUnidade, String condominioUnidade, String enderecoUnidade,
			InquilinoDTO inquilino, List<DespesaDTO> despesa) {
		this.idUnidadeDTO = idUnidadeDTO;
		this.proprietarioUnidade = proprietarioUnidade;
		this.condominioUnidade = condominioUnidade;
		this.enderecoUnidade = enderecoUnidade;
		this.inquilino = inquilino;
		this.despesa = despesa;
	}

	public Long getIdUnidadeDTO() {
		return idUnidadeDTO;
	}


	public void setIdUnidadeDTO(Long idUnidadeDTO) {
		this.idUnidadeDTO = idUnidadeDTO;
	}


	public String getProprietarioUnidade() {
		return proprietarioUnidade;
	}


	public void setProprietarioUnidade(String proprietarioUnidade) {
		this.proprietarioUnidade = proprietarioUnidade;
	}


	public String getCondominioUnidade() {
		return condominioUnidade;
	}


	public void setCondominioUnidade(String condominioUnidade) {
		this.condominioUnidade = condominioUnidade;
	}


	public String getEnderecoUnidade() {
		return enderecoUnidade;
	}


	public void setEnderecoUnidade(String enderecoUnidade) {
		this.enderecoUnidade = enderecoUnidade;
	}


	public InquilinoDTO getInquilino() {
		return inquilino;
	}


	public void setInquilino(InquilinoDTO inquilino) {
		this.inquilino = inquilino;
	}


	public List<DespesaDTO> getDespesa() {
		return despesa;
	}


	public void setDespesa(List<DespesaDTO> despesa) {
		this.despesa = despesa;
	}
	

}
