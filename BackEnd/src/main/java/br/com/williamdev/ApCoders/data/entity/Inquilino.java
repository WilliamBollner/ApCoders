package br.com.williamdev.apcoders.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.williamdev.apcoders.data.dto.InquilinoDTO;
import br.com.williamdev.apcoders.data.dto.UnidadeDTO;

@Entity
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inquilino")
	private Long idInquilino;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 3, nullable = true)
	private int idade;
	@Column(length = 9, nullable = false)
	private String sexo;
	@Column(length = 16, nullable = false)
	private String telefone;
	@Column(length = 60, nullable = true)
	private String email;
	@OneToMany(mappedBy = "inquilino", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
	private List<Unidade> unidade = new ArrayList<>();
	
	public List<UnidadeDTO> getUnidadeDTO(){
		List<UnidadeDTO> unidadeDTO = new ArrayList<>();
		for (Unidade unidades : getUnidade()) {
			UnidadeDTO u = unidades.convertToDTO();
			unidadeDTO.add(u);
		}
		return unidadeDTO;
	}
	
	public InquilinoDTO convertToDTO(){
		return new InquilinoDTO(getIdInquilino(),
				getNome(),
				getIdade(),
				getSexo(),
				getTelefone(),
				getEmail(),
				getUnidadeDTO());
	}

	public Inquilino() {}
	
	public Inquilino(Long idInquilino, String nome, int idade, String sexo, String telefone, String email,
			List<Unidade> unidade) {
		super();
		this.idInquilino = idInquilino;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.unidade = unidade;
	}

	public Long getIdInquilino() {
		return idInquilino;
	}

	public void setIdInquilino(Long idInquilino) {
		this.idInquilino = idInquilino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Unidade> getUnidade() {
		return unidade;
	}

	public void setUnidade(List<Unidade> unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Id inquilino: " + idInquilino + "\nNome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo
				+ "\nTelefone: " + telefone + "\nEmail: " + email;
	}
	
	

}
