package br.com.williamdev.apcoders.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.williamdev.apcoders.data.entity.Inquilino;
import br.com.williamdev.apcoders.data.entity.Unidade;
import br.com.williamdev.apcoders.service.InquilinoService;
import br.com.williamdev.apcoders.service.UnidadeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {

	public UnidadeController() {
	}

	@Autowired
	UnidadeService unidadeService;
	
	@Autowired
	InquilinoService inquilinoService;


	@GetMapping
	public ResponseEntity<List<Unidade>> findAll() {
		List<Unidade> list = unidadeService.getList();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Unidade> findById(@PathVariable Long id) {

		Unidade obj = unidadeService.getUnidadeById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Unidade> saveUnidade(@RequestBody Unidade unidade) throws Exception {
		Inquilino inqulinoUnidade = inquilinoService.saveInquilino(unidade.getInquilino());
		unidade.setInquilino(inqulinoUnidade);
		Unidade unidadeResponse = unidadeService.saveUnidade(unidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(unidadeResponse.getIdUnidade()).toUri();
		return ResponseEntity.created(uri).body(unidadeResponse);
	}

}
