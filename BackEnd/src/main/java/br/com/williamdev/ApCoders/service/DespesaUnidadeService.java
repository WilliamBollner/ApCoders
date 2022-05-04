package br.com.williamdev.apcoders.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.williamdev.apcoders.data.dto.DespesaDTO;
import br.com.williamdev.apcoders.data.entity.DespesaUnidade;
import br.com.williamdev.apcoders.exception.ControllerNotFoundException;
import br.com.williamdev.apcoders.exception.DataBaseException;
import br.com.williamdev.apcoders.repository.DespesaRepository;

@Service
public class DespesaUnidadeService {

	
	private final DespesaRepository repository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public DespesaUnidadeService(DespesaRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<DespesaDTO> getList(){
		return repository.findAll().stream().map
				(despesa -> mapper.map(despesa, DespesaDTO.class))
				.collect(Collectors.toList());
	}
	
	public DespesaUnidade getUnidadeById(Long id) {
		Optional<DespesaUnidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public DespesaUnidade saveUnidade(DespesaUnidade despesaUnidade) {
		return repository.save(despesaUnidade);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}	

	public DespesaUnidade update(Long id, DespesaUnidade despesaUnidade) {
		try {	
			DespesaUnidade entity = repository.getById(id);
			updateData(entity, despesaUnidade);
			return repository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException(id);
		}
	}
	
	public void updateData(DespesaUnidade entity, DespesaUnidade obj) {
		
		entity.setDescricao(obj.getDescricao());
		entity.setStatusPagamento(obj.getStatusPagamento());
		entity.setTipoDespesa(obj.getTipoDespesa());
		entity.setValor(obj.getValor());
	}
	
}

