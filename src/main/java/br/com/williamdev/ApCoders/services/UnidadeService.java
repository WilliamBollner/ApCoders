package br.com.williamdev.ApCoders.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.williamdev.ApCoders.entities.Unidade;
import br.com.williamdev.ApCoders.exceptions.DataBaseException;
import br.com.williamdev.ApCoders.exceptions.ResourceNotFoundException;
import br.com.williamdev.ApCoders.repositories.UnidadeRepository;

@Service
public class UnidadeService {
	
	@Autowired
	UnidadeRepository unidadeRepository;
	
	public List<Unidade> getList(){
		return unidadeRepository.findAll();
	}
	
	public Unidade getUnidadeById(Long id) {
		Optional<Unidade> obj = unidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Unidade saveUnidade(Unidade unidade) {
		return unidadeRepository.save(unidade);
	}

	public void delete(Long id) {
		try {
			unidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}	

	public Unidade update(Long id, Unidade unidade) {
		try {		
			Unidade entity = unidadeRepository.getById(id);
			updateData(entity, unidade);
			return unidadeRepository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
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
