package com.dev.services;

import org.springframework.stereotype.Service;

import com.dev.services.validacao.ValidacaoCalculoGestacional;
import com.dev.web.dto.request.CalculoGestacionalDTO;
import com.dev.web.dto.request.GestanteDTO;

@Service
public class GestanteService {

	public GestanteDTO calcular(CalculoGestacionalDTO calculoGestacional)  {	
		
		String criterio = calculoGestacional.getCriterioCalculo().toString();
		
		ValidacaoCalculoGestacional.valueOf(criterio).validarCalculoGestacional(calculoGestacional);		
				
		GestanteDTO gestante = calculoGestacional.getCriterioCalculo().getCalculoGestacional(calculoGestacional);
				
		return gestante;	
	}
	
}
