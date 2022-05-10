package br.com.williamdev.apcoders.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.williamdev.apcoders.data.dto.InquilinoDTO;
import br.com.williamdev.apcoders.service.InquilinoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inquilinos")
public class InquilinoController {

	@Autowired ModelMapper mapper;
	
	@Autowired
	InquilinoService inquilinoService;
	
	@GetMapping
	public ResponseEntity<List<InquilinoDTO>> findAll() {
		List<InquilinoDTO> list = inquilinoService.getList();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<InquilinoDTO> saveUnidade(@RequestBody InquilinoDTO inquilinoDTO){
		InquilinoDTO inquilino = inquilinoService.saveInquilino(inquilinoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(inquilino.getId()).toUri();
		return ResponseEntity.created(uri).body(inquilino);
		
	}


}
