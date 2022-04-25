package br.com.williamdev.apcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.williamdev.apcoders.data.entity.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
	
}
