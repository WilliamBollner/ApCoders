package br.com.williamdev.apcoders.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.williamdev.apcoders.data.entity.Inquilino;
import br.com.williamdev.apcoders.exception.ControllerNotFoundException;
import br.com.williamdev.apcoders.exception.DataBaseException;
import br.com.williamdev.apcoders.repository.InquilinoRepository;

@Service
public class InquilinoService {

	@Autowired
	InquilinoRepository repository;
	
	public List<Inquilino> getList(){
		return repository.findAll();
	}
	
	public Inquilino getInquilinoById(Long id) {
		Optional<Inquilino> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public Inquilino saveInquilino(Inquilino inquilino) {
		return repository.save(inquilino);
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

	public Inquilino update(Long id, Inquilino inquilino) {
		try {	
			Inquilino entity = repository.getById(id);
			updateData(entity, inquilino);
			return repository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException(id);
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

