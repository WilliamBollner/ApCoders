package br.com.williamdev.apcoders.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.williamdev.apcoders.data.dto.UnidadeDTO;
import br.com.williamdev.apcoders.service.UnidadeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {

	public UnidadeController() {
	}

	@Autowired
	UnidadeService service;


	@GetMapping
	public ResponseEntity<List<UnidadeDTO>> findAll() {
		List<UnidadeDTO> list = service.getList();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UnidadeDTO> findById(@PathVariable Long id) {

		UnidadeDTO obj = service.getUnidadeById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/filter/{condominio}")
	public ResponseEntity<List<UnidadeDTO>> findByCondominio(@PathVariable String condominio) {
		List<UnidadeDTO> list = service.getUnidadeByCondominio(condominio);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<UnidadeDTO> saveUnidade(@RequestBody UnidadeDTO unidade) throws Exception {
		UnidadeDTO unidadeResponse = service.saveUnidade(unidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unidadeResponse.getId())
				.toUri();
		return ResponseEntity.created(uri).body(unidadeResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteById(@PathVariable Long id) {
		if (service.getUnidadeById(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.delete(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
