package com.dev.service;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.entities.Gestante;

@Service
public class GestanteService {

	public Gestante calcular(CalculoGestacionalDTO calculoGestacional) {	
		
		Gestante gestante = calculoGestacional.getTipoDoCalculo().getCalculoGestacional(calculoGestacional);
		return gestante;	
	}
	
}
