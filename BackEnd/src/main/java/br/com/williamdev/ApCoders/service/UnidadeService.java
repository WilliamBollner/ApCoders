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

import br.com.williamdev.apcoders.data.dto.UnidadeDTO;
import br.com.williamdev.apcoders.data.entity.Unidade;
import br.com.williamdev.apcoders.exception.ControllerNotFoundException;
import br.com.williamdev.apcoders.exception.DataBaseException;
import br.com.williamdev.apcoders.repository.UnidadeRepository;

@Service
public class UnidadeService {
	
	
	private final UnidadeRepository unidadeRepository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public UnidadeService(UnidadeRepository unidadeRepository, ModelMapper mapper) {
		this.unidadeRepository = unidadeRepository;
		this.mapper = mapper;
	}
	
	public List<UnidadeDTO> getList(){
		return unidadeRepository.findAll().stream().map(unidade -> mapper.map(unidade, UnidadeDTO.class)).collect(Collectors.toList());
	}

	public Unidade getUnidadeById(Long id) {
		Optional<Unidade> obj = unidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public List<Unidade> getUnidadeByCondominio(String condominio){
		return unidadeRepository.findByCondominioContaining(condominio);
	}
	
	public Unidade saveUnidade(Unidade unidade) {
		return unidadeRepository.save(unidade);
	}

	public void delete(Long id) {
		try {
			unidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
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
