package br.com.williamdev.apcoders.data.dto;

import java.util.ArrayList;
import java.util.List;

public class UnidadeDTO {

	private Long id;
	private String proprietarioUnidade;
	private String condominioUnidade;
	private String enderecoUnidade;
	private InquilinoDTO inquilino;
	private List<DespesaDTO> despesa = new ArrayList<DespesaDTO>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long idUnidadeDTO) {
		this.id = idUnidadeDTO;
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
