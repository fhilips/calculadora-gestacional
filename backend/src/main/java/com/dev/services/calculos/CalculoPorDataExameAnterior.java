package com.dev.services.calculos;

import java.time.LocalDate;

import com.dev.web.dto.request.CalculoGestacionalDTO;
import com.dev.web.dto.request.GestanteDTO;

public class CalculoPorDataExameAnterior extends CalculoGestacional {

	@Override
	public GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
		LocalDate dataGestacionalEm = LocalDate.parse(calculoGestacional.getData(), formatter());
		
		LocalDate dataUltimaMentruacao = 
				dataGestacionalEm.minusWeeks(calculoGestacional.getSemanas())
							   .minusDays(calculoGestacional.getDias());
		
		LocalDate dataProvavelParto = dataUltimaMentruacao.plusDays(280);			
		String idadeGestacional = formatarIdadeGestacional(dataUltimaMentruacao);
		String dataMorfoPrimeiroTri = calcularDataMorfoPrimeiroTri(dataUltimaMentruacao);
		String dataMorfoSegundoTri = calcularDataMorfoSegundoTri(dataUltimaMentruacao);
		
		return new GestanteDTO(dataProvavelParto, dataUltimaMentruacao, idadeGestacional, dataMorfoPrimeiroTri, dataMorfoSegundoTri);					
	}

}
