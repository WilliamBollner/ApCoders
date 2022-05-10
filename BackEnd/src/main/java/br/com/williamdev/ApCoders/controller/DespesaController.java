package br.com.williamdev.apcoders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.williamdev.apcoders.data.dto.DespesaDTO;
import br.com.williamdev.apcoders.services.DespesaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

	@Autowired
	DespesaService service;
	
	@GetMapping
	public List<DespesaDTO> getAll(){
		return service.getAll();
	}

}
