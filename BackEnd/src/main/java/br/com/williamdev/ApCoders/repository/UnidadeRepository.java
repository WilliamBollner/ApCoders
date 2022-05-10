package br.com.williamdev.apcoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.williamdev.apcoders.data.entity.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Long>{

	public List<Unidade> findByCondominioContaining(String condominio);
}
