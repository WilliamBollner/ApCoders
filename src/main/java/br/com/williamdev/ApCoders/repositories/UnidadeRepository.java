package br.com.williamdev.ApCoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.williamdev.ApCoders.entities.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
	
}
