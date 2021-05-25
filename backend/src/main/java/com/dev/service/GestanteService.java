package com.dev.service;

import org.springframework.stereotype.Service;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;
import com.dev.validacao.ValidacaoCalculoGestacional;

@Service
public class GestanteService {

	public GestanteDTO calcular(CalculoGestacionalDTO calculoGestacional)  {		
		String criterio = calculoGestacional.getCriterioCalculo().toString();	
		ValidacaoCalculoGestacional.valueOf(criterio).validarCalculoGestacional(calculoGestacional);

		GestanteDTO gestante = calculoGestacional.getCriterioCalculo().getCalculoGestacional(calculoGestacional);
		return gestante;	
	}
	
}
