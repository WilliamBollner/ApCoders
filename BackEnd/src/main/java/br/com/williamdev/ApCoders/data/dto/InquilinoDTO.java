package br.com.williamdev.apcoders.data.dto;

import java.util.List;

public class InquilinoDTO {

	public Long idInquilinoDTO;
	public String nomeInquilino;
	public Integer idadeInquilino;
	public String sexoInquillino;
	public String telefoneInquilino;
	public String emailInquilino;
	public List<UnidadeDTO> listaUnidades;
	

	public Long getIdInquilinoDTO() {
		return idInquilinoDTO;
	}

	public void setIdInquilinoDTO(Long idInquilinoDTO) {
		this.idInquilinoDTO = idInquilinoDTO;
	}

	public String getNomeInquilino() {
		return nomeInquilino;
	}

	public void setNomeInquilino(String nomeInquilino) {
		this.nomeInquilino = nomeInquilino;
	}

	public int getIdadeInquilino() {
		return idadeInquilino;
	}

	public void setIdadeInquilino(Integer idadeInquilino) {
		this.idadeInquilino = idadeInquilino;
	}

	public String getSexoInquillino() {
		return sexoInquillino;
	}

	public void setSexoInquillino(String sexoInquillino) {
		this.sexoInquillino = sexoInquillino;
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

	public List<UnidadeDTO> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(List<UnidadeDTO> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}
	
	
	
	

}
