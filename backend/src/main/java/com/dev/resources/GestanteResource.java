package com.dev.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.entities.Gestante;
import com.dev.service.GestanteService;

@RestController
@RequestMapping(name = "/")
public class GestanteResource {
	
	@Autowired
	private GestanteService service;

	@PostMapping
	public ResponseEntity<Gestante> calcular(@RequestBody CalculoGestacionalDTO calculoGestacional){
		Gestante gestante = service.calcular(calculoGestacional);
	
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().buildAndExpand(gestante).toUri();
		return ResponseEntity.created(uri).body(gestante);		
	}
	
	
}
