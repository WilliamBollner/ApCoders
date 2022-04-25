package br.com.williamdev.apcoders.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.williamdev.apcoders.data.entity.Unidade;
import br.com.williamdev.apcoders.exception.ControllerNotFoundException;
import br.com.williamdev.apcoders.exception.DataBaseException;
import br.com.williamdev.apcoders.repository.UnidadeRepository;

@Service
public class UnidadeService {
	
	@Autowired
	UnidadeRepository repository;
	
	public List<Unidade> getList(){
		return repository.findAll();
	}
	
	public Unidade getUnidadeById(Long id) {
		Optional<Unidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public Unidade saveUnidade(Unidade unidade) {
		return repository.save(unidade);
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

	public Unidade update(Long id, Unidade unidade) {
		try {		
			Unidade entity = repository.getById(id);
			updateData(entity, unidade);
			return repository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException(id);
		}
	}
	
	public void updateData(Unidade entity, Unidade obj) {
		entity.setProprietario(obj.getProprietario());
		entity.setEndereco(obj.getEndereco());
		entity.setCondominio(obj.getCondominio());
		entity.setInquilino(obj.getInquilino());
		entity.setDespesa(obj.getDespesa());
	}
	
}
