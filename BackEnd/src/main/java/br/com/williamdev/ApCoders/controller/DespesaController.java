package br.com.williamdev.apcoders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.williamdev.apcoders.data.dto.DespesaDTO;
import br.com.williamdev.apcoders.service.DespesaUnidadeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

	@Autowired
	DespesaUnidadeService service;
	
	@GetMapping
	public ResponseEntity<List<DespesaDTO>> despesa(){
		List<DespesaDTO> getAll = service.getList();
		return ResponseEntity.ok().body(getAll);
	}

}
