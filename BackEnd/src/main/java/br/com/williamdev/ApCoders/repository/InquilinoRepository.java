package br.com.williamdev.apcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.williamdev.apcoders.data.entity.Inquilino;

public interface InquilinoRepository extends JpaRepository<Inquilino, Long>{

}
