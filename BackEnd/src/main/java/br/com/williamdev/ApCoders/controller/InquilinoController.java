package br.com.williamdev.apcoders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.williamdev.apcoders.data.entity.Inquilino;
import br.com.williamdev.apcoders.service.InquilinoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inquilinos")
public class InquilinoController {

	@Autowired
	InquilinoService inquilinoService;
	
	@GetMapping
	public ResponseEntity<List<Inquilino>> findAll() {
		List<Inquilino> list = inquilinoService.getList();
		return ResponseEntity.ok().body(list);
	}

}
