package br.com.williamdev.apcoders.data.dto;

import java.io.Serializable;

import br.com.williamdev.apcoders.data.entity.DespesaUnidade;

public class DespesaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idDespesaDTO;
	private String descricaoDespesa;
	private String tipoDespesa;
	private double valorDespesa;
	private String statusPagamentoDespesa;
	private UnidadeDTO unidade;
	
	
	public DespesaUnidade convertToEntity() {
		return new DespesaUnidade(getIdDespesaDTO(),
				getDescricaoDespesa(),
				getTipoDespesa(),
				getValorDespesa(),
				getStatusPagamentoDespesa(),
				getUnidade().convertToEntity());
	}
	
	
	
	public DespesaDTO() {}

	public DespesaDTO(Long idDespesaDTO, String descricaoDespesa, String tipoDespesa, double valorDespesa,
			String statusPagamentoDespesa, UnidadeDTO unidade) {
		this.idDespesaDTO = idDespesaDTO;
		this.descricaoDespesa = descricaoDespesa;
		this.tipoDespesa = tipoDespesa;
		this.valorDespesa = valorDespesa;
		this.statusPagamentoDespesa = statusPagamentoDespesa;
		this.unidade = unidade;
	}

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

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
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
