package com.dev.entities;

import java.time.LocalDate;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;

public class CalculoPorDataExameAnterior extends CalculoGestacional {

	@Override
	public GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
		LocalDate dataGestacionalEM = LocalDate.parse(calculoGestacional.getData(), formatter());
		
		LocalDate dataUltimaMentruacao = 
				dataGestacionalEM.minusWeeks(calculoGestacional.getSemanas())
							   .minusDays(calculoGestacional.getDias());
		
		LocalDate dataProvavelParto = dataUltimaMentruacao.plusDays(280);			
		long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);		
		String idadeGestacional = formatarIdadeGestacional(diffEmDias);
		String dataMorfoPrimeiroTri = calcularDataMorfoPrimeiroTri(dataUltimaMentruacao);
		String dataMorfoSegundoTri = calcularDataMorfoSegundoTri(dataUltimaMentruacao);
		
		return new GestanteDTO(dataProvavelParto, dataUltimaMentruacao, idadeGestacional, dataMorfoPrimeiroTri, dataMorfoSegundoTri);					
	}

}
