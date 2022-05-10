package br.com.williamdev.apcoders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.williamdev.apcoders.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	UnidadeRepository repository;

}
