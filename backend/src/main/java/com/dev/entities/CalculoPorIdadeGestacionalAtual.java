package com.dev.entities;

import java.time.LocalDate;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;

public class CalculoPorIdadeGestacionalAtual extends CalculoGestacional {

	@Override
	public GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
		LocalDate dataUltimaMentruacao = 
				LocalDate.now().minusWeeks(calculoGestacional.getSemanas())
							   .minusDays(calculoGestacional.getDias());			
		dataUltimaMentruacao.format(formatter());	
		System.out.println(dataUltimaMentruacao);
		LocalDate dataProvavelParto = dataUltimaMentruacao.plusMonths(9);
		dataProvavelParto.format(formatter());
		long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);
		String idadeGestacional = formatarIdadeGestacional(diffEmDias);				
		String dataMorfoPrimeiroTri = calcularDataMorfoPrimeiroTri(dataUltimaMentruacao);
		return new GestanteDTO(dataProvavelParto, dataUltimaMentruacao, idadeGestacional, dataMorfoPrimeiroTri, dataMorfoPrimeiroTri);
	}

}
