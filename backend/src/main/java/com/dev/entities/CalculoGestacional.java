package com.dev.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.dev.dto.CalculoGestacionalDTO;

public enum CalculoGestacional {	
	
	DATA_PROVAVEL_DO_PARTO {
		@Override
		public Gestante calculoGestacional(CalculoGestacionalDTO calculoGestacional) {				
			LocalDate dataProvavelParto = LocalDate.parse(calculoGestacional.getData(), formatter());
	
			LocalDate dataUltimaMentruacao = dataProvavelParto.minusMonths(9);			
			long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);	;		
			String idadeGestacional = formatarIdadeGestacional(diffEmDias);
			
			return new Gestante(dataProvavelParto, dataUltimaMentruacao, idadeGestacional);
		}
	},
	DATA_ULTIMA_MENSTRUACAO {
		@Override
		public Gestante calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
			LocalDate dataUltimaMentruacao = LocalDate.parse(calculoGestacional.getData(), formatter());
			
			LocalDate dataProvavelParto = dataUltimaMentruacao.plusMonths(9);
			long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);				
			String idadeGestacional = formatarIdadeGestacional(diffEmDias);	
			
			return new Gestante(dataProvavelParto, dataUltimaMentruacao, idadeGestacional);
		}		
	}, 
	DATA_EXAME_ANTERIOR {
		@Override
		public Gestante calculoGestacional(CalculoGestacionalDTO calculoGestacional) {
			LocalDate dataGestacionalEM = LocalDate.parse(calculoGestacional.getData(), formatter());
			
			LocalDate dataUltimaMentruacao = 
					dataGestacionalEM.minusWeeks(calculoGestacional.getSemanas())
								   .minusDays(calculoGestacional.getDias());
			LocalDate dataProvavelParto = dataUltimaMentruacao.plusMonths(9);			
			long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);		
			String idadeGestacional = formatarIdadeGestacional(diffEmDias);
			
			return new Gestante(dataProvavelParto, dataUltimaMentruacao, idadeGestacional);
		}
	},
	DATA_GESTACIONAL_ATUAL {
		@Override
		public Gestante calculoGestacional(CalculoGestacionalDTO calculoGestacional ) {
			LocalDate dataUltimaMentruacao = 
					LocalDate.now().minusWeeks(calculoGestacional.getSemanas())
								   .minusDays(calculoGestacional.getDias());	
			
			LocalDate dataProvavelParto = dataUltimaMentruacao.plusMonths(9);			
			long diffEmDias = diasDesdeUltimaMenstruacao(dataUltimaMentruacao);
			String idadeGestacional = formatarIdadeGestacional(diffEmDias);				
			
			return new Gestante(dataProvavelParto, dataUltimaMentruacao, idadeGestacional);
		}
	};	
	
	public abstract Gestante calculoGestacional(CalculoGestacionalDTO calculoGestacional);
		
	public String formatarIdadeGestacional(long diff) {
		String idadeGestacional = (diff / 7) + " semana(s) e " + (diff % 7) + " dia(s)";
		return idadeGestacional;
	}

	public DateTimeFormatter formatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	long diasDesdeUltimaMenstruacao(LocalDate dataUltimaMentruacao) {
		long diffEmDias = ChronoUnit.DAYS.between(dataUltimaMentruacao, LocalDate.now());
		return diffEmDias;
	}

}