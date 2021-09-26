package com.dev.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;

public abstract class CalculoGestacional {
	
	public abstract GestanteDTO calculoGestacional(CalculoGestacionalDTO calculoGestacional);
			
	public String formatarIdadeGestacional(LocalDate dataUltimaMentruacao) {
		long diff = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);
		String semana;
		String dia;
		if(diff / 7 == 1 || diff / 7 == 0) {
			semana = (diff / 7) + " semana e ";
		} else {
			semana = (diff / 7) + " semanas e ";
		}
		
		if(diff % 7 == 1 || diff % 7 == 0) {
			dia = (diff % 7) + " dia";
		} else {
			dia = (diff % 7) + " dias";
		}
			
		String idadeGestacional = semana + dia;
		return idadeGestacional;
	}
	
	public long diasDesdeUltimaMenstruacao(LocalDate dataUltimaMentruacao) {
		long diffEmDias = ChronoUnit.DAYS.between(dataUltimaMentruacao, LocalDate.now());
		return diffEmDias;
	}
	
	public DateTimeFormatter formatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	public String calcularDataMorfoPrimeiroTri(LocalDate dataUltimaMentruacao) {
		LocalDate dataInicioPrimeiroTri = dataUltimaMentruacao.plusWeeks(10);			
		LocalDate dataFimPrimeiroTri = dataInicioPrimeiroTri.plusWeeks(4);		
		String dataFormatada = "De " + dataFormatada(dataInicioPrimeiroTri) + " até " + dataFormatada(dataFimPrimeiroTri);
		
		return dataFormatada;
	}
	
	public String calcularDataMorfoSegundoTri(LocalDate dataUltimaMentruacao) {
		LocalDate dataInicioSegundoTri = dataUltimaMentruacao.plusWeeks(20);
		LocalDate dataFimSegundoTri = dataInicioSegundoTri.plusWeeks(4);
		String dataFormatada = "De " + dataFormatada(dataInicioSegundoTri) + " até " + dataFormatada(dataFimSegundoTri);		
		
		return dataFormatada;
	}
	
	public String dataFormatada(LocalDate data) {
		return data.format(formatter());
	}
}
