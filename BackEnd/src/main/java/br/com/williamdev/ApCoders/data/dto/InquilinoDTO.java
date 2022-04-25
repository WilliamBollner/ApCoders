package br.com.williamdev.apcoders.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.williamdev.apcoders.data.entity.Inquilino;
import br.com.williamdev.apcoders.data.entity.Unidade;

public class InquilinoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long idInquilinoDTO;
	public String nomeInquilino;
	public int idadeInquilino;
	public String sexoInquillino;
	public String telefoneInquilino;
	public String emailInquilino;
	public List<UnidadeDTO> listaUnidades = new ArrayList<>();
	
	public List<Unidade> unidadeEntity(){
		List<Unidade> unidade = new ArrayList<>();
		for (UnidadeDTO unidades : listaUnidades) {
			unidade.add(unidades.convertToEntity());
		}
		return unidade;
	}
	
	public Inquilino convertToEntity() {
		return new Inquilino(getIdInquilinoDTO(),
							 getNomeInquilino(),
							 getIdadeInquilino(),
							 getSexoInquillino(),
							 getTelefoneInquilino(),
							 getEmailInquilino(),
							 unidadeEntity());
	}
	
	public InquilinoDTO() {}

	public InquilinoDTO(Long idInquilinoDTO, String nomeInquilino, int idadeInquilino, String sexoInquillino,
			String telefoneInquilino, String emailInquilino, List<UnidadeDTO> listaUnidades) {
		super();
		this.idInquilinoDTO = idInquilinoDTO;
		this.nomeInquilino = nomeInquilino;
		this.idadeInquilino = idadeInquilino;
		this.sexoInquillino = sexoInquillino;
		this.telefoneInquilino = telefoneInquilino;
		this.emailInquilino = emailInquilino;
		this.listaUnidades = listaUnidades;
	}

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

	public void setIdadeInquilino(int idadeInquilino) {
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
