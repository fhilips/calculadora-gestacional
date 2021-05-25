package com.dev.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;

public abstract class CalculoGestacional {
	public abstract GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional);
		
	
	public String formatarIdadeGestacional(long diff) {
		String idadeGestacional = (diff / 7) + " semana(s) e " + (diff % 7) + " dia(s)";
		return idadeGestacional;
	}
	
	public DateTimeFormatter formatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	public long diasDesdeUltimaMenstruacao(LocalDate dataUltimaMentruacao) {
		long diffEmDias = ChronoUnit.DAYS.between(dataUltimaMentruacao, LocalDate.now());
		return diffEmDias;
	}
	
	public String calcularDataMorfoPrimeiroTri(LocalDate dataUltimaMentruacao) {
		LocalDate dataInicioPrimeiroTri = dataUltimaMentruacao.plusWeeks(10);
		LocalDate dataFimPrimeiroTri = dataInicioPrimeiroTri.plusWeeks(4);
		String dataFormatada = "De " + dataInicioPrimeiroTri.toString() + " até " + dataFimPrimeiroTri.toString();
		return dataFormatada;
	}
}
