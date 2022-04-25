package br.com.williamdev.apcoders.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.williamdev.apcoders.data.entity.DespesaUnidade;
import br.com.williamdev.apcoders.exception.ControllerNotFoundException;
import br.com.williamdev.apcoders.exception.DataBaseException;
import br.com.williamdev.apcoders.repository.DespesaRepository;

public class DespesaUnidadeService {

	@Autowired
	DespesaRepository repository;
	
	public List<DespesaUnidade> getList(){
		return repository.findAll();
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

