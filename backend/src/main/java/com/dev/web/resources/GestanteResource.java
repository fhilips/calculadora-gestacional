package com.dev.web.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.services.GestanteService;
import com.dev.web.dto.request.CalculoGestacionalDTO;
import com.dev.web.dto.request.GestanteDTO;

@RestController
@RequestMapping(name = "/")
public class GestanteResource {
	
	@Autowired
	private GestanteService service;

	@PostMapping
	public ResponseEntity<GestanteDTO> calcular(@RequestBody CalculoGestacionalDTO calculoGestacional){
		GestanteDTO gestante = service.calcular(calculoGestacional);
	
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().buildAndExpand(gestante).toUri();
		return ResponseEntity.created(uri).body(gestante);		
	}
	
	
}
