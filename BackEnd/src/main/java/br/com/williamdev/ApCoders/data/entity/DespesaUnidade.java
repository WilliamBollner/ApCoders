package br.com.williamdev.apcoders.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DespesaUnidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private Long idDespesa;
	@Column(nullable = false)
	private String descricao;
	@Column(name = "tipo_despesa", nullable = false, length = 20)
	private String tipoDespesa;
	@Column(length = 16, nullable = false)
	private Double valor;
	@Column(length = 16, nullable = false)
	private String statusPagamento;
	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
	
	public DespesaUnidade() {}
	
	public Long getIdDespesa() {
		return idDespesa;
	}
	
	public void setIdDespesa(Long idDespesa) {
		this.idDespesa = idDespesa;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getStatusPagamento() {
		return statusPagamento;
	}
	
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
}