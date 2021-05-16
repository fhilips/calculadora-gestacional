package com.dev.service;

import org.springframework.stereotype.Service;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.entities.CalculoGestacional;
import com.dev.entities.Gestante;
import com.dev.entities.ValidacaoCalculoGestacional;

@Service
public class GestanteService {

	public Gestante calcular(CalculoGestacionalDTO calculoGestacional) {
		String criterio = calculoGestacional.getCriterioCalculo().toString();
		
		ValidacaoCalculoGestacional.valueOf(criterio).validarCalculoGestacional(calculoGestacional);
		Gestante gestante = calculoGestacional.getCriterioCalculo().calculoGestacional(calculoGestacional);
		return gestante;	
	}
	
}
