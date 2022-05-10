package br.com.williamdev.apcoders.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.williamdev.apcoders.data.dto.DespesaDTO;
import br.com.williamdev.apcoders.repository.DespesaRepository;

@Service
public class DespesaService {

	
	private final DespesaRepository repository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public DespesaService(DespesaRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public List<DespesaDTO> getAll(){
		return repository.findAll().stream().map(despesa -> mapper.map(despesa, DespesaDTO.class)).collect(Collectors.toList());
	}
	
	
	
	
	
}
