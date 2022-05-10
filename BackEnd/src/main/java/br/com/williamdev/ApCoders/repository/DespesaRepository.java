package br.com.williamdev.apcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.williamdev.apcoders.data.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
}
