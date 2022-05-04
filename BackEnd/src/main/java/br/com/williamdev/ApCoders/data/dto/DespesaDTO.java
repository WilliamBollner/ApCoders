package br.com.williamdev.apcoders.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DespesaDTO {

	private Long idDespesaDTO;
	private String descricaoDespesa;
	private String tipoDespesa;
	private Double valorDespesa;
	private String statusPagamentoDespesa;
	@JsonIgnore
	private UnidadeDTO unidade;
	
	public Long getIdDespesaDTO() {
		return idDespesaDTO;
	}
	public void setIdDespesaDTO(Long idDespesaDTO) {
		this.idDespesaDTO = idDespesaDTO;
	}
	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}
	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public Double getValorDespesa() {
		return valorDespesa;
	}
	public void setValorDespesa(Double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}
	public String getStatusPagamentoDespesa() {
		return statusPagamentoDespesa;
	}
	public void setStatusPagamentoDespesa(String statusPagamentoDespesa) {
		this.statusPagamentoDespesa = statusPagamentoDespesa;
	}
	public UnidadeDTO getUnidade() {
		return unidade;
	}
	public void setUnidade(UnidadeDTO unidade) {
		this.unidade = unidade;
	}
	
	

}
