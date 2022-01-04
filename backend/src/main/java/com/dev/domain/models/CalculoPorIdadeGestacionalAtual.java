package com.dev.domain.models;

import java.time.LocalDate;

import com.dev.web.dto.request.CalculoGestacionalDTO;
import com.dev.web.dto.request.GestanteDTO;

public class CalculoPorIdadeGestacionalAtual extends CalculoGestacional {

	@Override
	public GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
		LocalDate dataUltimaMentruacao = 
				LocalDate.now().minusWeeks(calculoGestacional.getSemanas())
							   .minusDays(calculoGestacional.getDias());			
		dataUltimaMentruacao.format(formatter());	
		
		LocalDate dataProvavelParto = dataUltimaMentruacao.plusDays(280);
		dataProvavelParto.format(formatter());	
		String idadeGestacional = formatarIdadeGestacional(dataUltimaMentruacao);				
		String dataMorfoPrimeiroTri = calcularDataMorfoPrimeiroTri(dataUltimaMentruacao);
		String dataMorfoSegundoTri = calcularDataMorfoSegundoTri(dataUltimaMentruacao);
		
		return new GestanteDTO(dataProvavelParto, dataUltimaMentruacao, idadeGestacional, dataMorfoPrimeiroTri, dataMorfoSegundoTri);
	}

}
