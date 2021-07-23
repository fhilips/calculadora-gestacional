package com.dev.entities;

import java.time.LocalDate;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;

public class CalculoPorDataProvavelDoParto extends CalculoGestacional {

	@Override
	public GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
		LocalDate dataProvavelParto = LocalDate.parse(calculoGestacional.getData(), formatter());
		
		LocalDate dataUltimaMentruacao = dataProvavelParto.minusMonths(9);
		
		dataUltimaMentruacao.format(formatter());
		dataProvavelParto.format(formatter());
		long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);			
		String idadeGestacional = formatarIdadeGestacional(diffEmDias);
		String dataMorfoPrimeiroTri = calcularDataMorfoPrimeiroTri(dataUltimaMentruacao);
		String dataMorfoSegundoTri = calcularDataMorfoSegundoTri(dataUltimaMentruacao);
		
		return new GestanteDTO(dataProvavelParto, dataUltimaMentruacao, idadeGestacional, dataMorfoPrimeiroTri, dataMorfoSegundoTri);
	}

}
