package com.dev.tests.Factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.entities.TipoCalculoGestacional;

public class DataValues {
	
	public TipoCalculoGestacional dataProvavelDoParto;
	public TipoCalculoGestacional dataUltimaMenstruacao;
	public TipoCalculoGestacional dataExameAnterior;
	public TipoCalculoGestacional dataGestacionalAtual;
	
	public int dias;
	public int numeroDeDiasNegativos;
	public int numeroDediasMaiorQue7;
	public int semanas;
	public int numeroDeSemanasNegativas;
	public int numeroDeSemanasMaiorQue40;
	
	public String dataAtual;
	public String dataAnteriorA9Meses;
	public String dataPosteriorA9Meses;
	public String dataAtualMenosUmDia;
	public String dataAtualMaisUmDia;
	public CalculoGestacionalDTO calculoDto;	
	
	public DataValues() {		
		dias = 5;
		numeroDeDiasNegativos = -7;
		numeroDediasMaiorQue7 = 10;
		semanas = 15;
		numeroDeSemanasNegativas = -19;
		
		numeroDeSemanasMaiorQue40 = 50;
		
		dataAtual = formatarDataParaString(LocalDate.now());
		dataAtualMenosUmDia = formatarDataParaString(LocalDate.now().minusDays(1));
		dataAtualMaisUmDia = formatarDataParaString(LocalDate.now().plusDays(1));
		dataAnteriorA9Meses = formatarDataParaString(LocalDate.now().minusMonths(9).minusDays(5));		
		dataPosteriorA9Meses = formatarDataParaString(LocalDate.now().plusWeeks(40).plusDays(1));
		
		dataProvavelDoParto = TipoCalculoGestacional.DATA_PROVAVEL_DO_PARTO;
		dataUltimaMenstruacao = TipoCalculoGestacional.DATA_ULTIMA_MENSTRUACAO;
		dataExameAnterior = TipoCalculoGestacional.DATA_EXAME_ANTERIOR;
		dataGestacionalAtual = TipoCalculoGestacional.IDADE_GESTACIONAL_ATUAL;

		calculoDto = new CalculoGestacionalDTO( "15/10/2019", dias, semanas, dataProvavelDoParto);
	}


	private static String formatarDataParaString(LocalDate data) {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataformatada = data.format(formatter);			
		return dataformatada;
	}
	
	public static String formatarIdadeGestacional(LocalDate dataUltimaMentruacao) {
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
	
	public static long diasDesdeUltimaMenstruacao(LocalDate dataUltimaMentruacao) {
		long diffEmDias = ChronoUnit.DAYS.between(dataUltimaMentruacao, LocalDate.now());
		return diffEmDias;
	}
}
