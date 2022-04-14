package br.com.williamdev.ApCoders.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.williamdev.ApCoders.entities.DespesaUnidade;
import br.com.williamdev.ApCoders.exceptions.DataBaseException;
import br.com.williamdev.ApCoders.exceptions.ResourceNotFoundException;
import br.com.williamdev.ApCoders.repositories.DespesaRepository;

public class DespesaUnidadeService {

	@Autowired
	DespesaRepository repository;
	
	public List<DespesaUnidade> getList(){
		return repository.findAll();
	}
	
	public DespesaUnidade getUnidadeById(Long id) {
		Optional<DespesaUnidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public DespesaUnidade saveUnidade(DespesaUnidade despesaUnidade) {
		return repository.save(despesaUnidade);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
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
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(DespesaUnidade entity, DespesaUnidade obj) {
		
		entity.setDescricao(obj.getDescricao());
		entity.setStatusPagamento(obj.getStatusPagamento());
		entity.setTipoDespesa(obj.getTipoDespesa());
		entity.setValor(obj.getValor());
	}
	
}

