package br.com.williamdev.apcoders.data.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InquilinoDTO {

	public Long id;
	public String nomeInquilino;
	public Integer idadeInquilino;
	public String sexoInquilino;
	public String telefoneInquilino;
	public String emailInquilino;
	@JsonIgnore
	public List<UnidadeDTO> unidade;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long idInquilino) {
		this.id = idInquilino;
	}
	public String getNomeInquilino() {
		return nomeInquilino;
	}
	public void setNomeInquilino(String nomeInquilino) {
		this.nomeInquilino = nomeInquilino;
	}
	public Integer getIdadeInquilino() {
		return idadeInquilino;
	}
	public void setIdadeInquilino(Integer idadeInquilino) {
		this.idadeInquilino = idadeInquilino;
	}
	public String getSexoInquilino() {
		return sexoInquilino;
	}
	public void setSexoInquilino(String sexoInquillino) {
		this.sexoInquilino = sexoInquillino;
	}
	public String getTelefoneInquilino() {
		return telefoneInquilino;
	}
	public void setTelefoneInquilino(String telefoneInquilino) {
		this.telefoneInquilino = telefoneInquilino;
	}
	public String getEmailInquilino() {
		return emailInquilino;
	}
	public void setEmailInquilino(String emailInquilino) {
		this.emailInquilino = emailInquilino;
	}
	public List<UnidadeDTO> getUnidade() {
		return unidade;
	}
	public void setUnidade(List<UnidadeDTO> unidade) {
		this.unidade = unidade;
	}
	
	

}
