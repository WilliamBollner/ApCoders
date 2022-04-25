package br.com.williamdev.apcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.williamdev.apcoders.data.entity.DespesaUnidade;

public interface DespesaRepository extends JpaRepository<DespesaUnidade, Long>{

}
