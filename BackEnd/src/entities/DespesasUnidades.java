package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DespesasUnidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private int idDespesa;
	@Column(nullable = false)
	private String descricao;
	@Column(name = "tipo_despesa", nullable = false, length = 20)
	private String tipoDespesa;
	@Column(length = 16, nullable = false)
	private double valor;
	@Column(length = 16, nullable = false)
	private String statusPagamento;
	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
	
	public DespesasUnidades(String descricao, String tipoDespesa, double valor, String statusPagamento,
			Unidade unidade) {
		this.descricao = descricao;
		this.tipoDespesa = tipoDespesa;
		this.valor = valor;
		this.statusPagamento = statusPagamento;
	}
	
	public int getIdDespesa() {
		return idDespesa;
	}
	public String getDescrica() {
		return descricao;
	}
	public void setDescrica(String descrica) {
		this.descricao = descrica;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	
		
}