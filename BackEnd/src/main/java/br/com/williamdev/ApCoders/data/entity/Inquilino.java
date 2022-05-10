package br.com.williamdev.apcoders.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inquilino")
	private Long idInquilino;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 3, nullable = true)
	private Integer idade;
	@Column(length = 9, nullable = false)
	private String sexo;
	@Column(length = 16, nullable = false)
	private String telefone;
	@Column(length = 60, nullable = true)
	private String email;
	@OneToMany(mappedBy = "inquilino")
	private List<Unidade> unidade = new ArrayList<>();

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

	public void setIdade(Integer idade) {
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
	public int hashCode() {
		return Objects.hash(email, idInquilino, idade, nome, sexo, telefone, unidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inquilino other = (Inquilino) obj;
		return Objects.equals(email, other.email) && Objects.equals(idInquilino, other.idInquilino)
				&& idade == other.idade && Objects.equals(nome, other.nome) && Objects.equals(sexo, other.sexo)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(unidade, other.unidade);
	}


}
