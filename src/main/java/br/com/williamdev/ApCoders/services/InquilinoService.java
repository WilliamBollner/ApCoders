package br.com.williamdev.ApCoders.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.williamdev.ApCoders.entities.Inquilino;
import br.com.williamdev.ApCoders.exceptions.DataBaseException;
import br.com.williamdev.ApCoders.exceptions.ResourceNotFoundException;
import br.com.williamdev.ApCoders.repositories.InquilinoRepository;

@Service
public class InquilinoService {

	@Autowired
	InquilinoRepository repository;
	
	public List<Inquilino> getList(){
		return repository.findAll();
	}
	
	public Inquilino getInquilinoById(Long id) {
		Optional<Inquilino> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Inquilino saveInquilino(Inquilino inquilino) {
		return repository.save(inquilino);
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

	public Inquilino update(Long id, Inquilino inquilino) {
		try {	
			Inquilino entity = repository.getById(id);
			updateData(entity, inquilino);
			return repository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Inquilino entity, Inquilino obj) {
		entity.setEmail(obj.getEmail());
		entity.setIdade(obj.getIdade());
		entity.setNome(obj.getNome());
		entity.setSexo(obj.getSexo());
		entity.setTelefone(obj.getSexo());
	}
	
}

