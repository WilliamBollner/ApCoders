package br.com.williamdev.apcoders.data.dto;

import java.util.List;

public class UnidadeDTO {

	private Long idUnidadeDTO;
	private String proprietarioUnidade;
	private String condominioUnidade;
	private String enderecoUnidade;
	private InquilinoDTO inquilino;
	private List<DespesaDTO> despesa;

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
