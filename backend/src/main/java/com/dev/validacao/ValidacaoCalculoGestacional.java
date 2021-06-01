package com.dev.validacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.validation.ValidationException;

import com.dev.dto.CalculoGestacionalDTO;

public enum ValidacaoCalculoGestacional {	
	
	DATA_PROVAVEL_DO_PARTO {
		@Override
		public Boolean validarCalculoGestacional(CalculoGestacionalDTO calculoGestacional) {			
				LocalDate dataProvavelParto = LocalDate.parse(calculoGestacional.getData(), formatter());
			
				if (isBeforeToday(dataProvavelParto)) {
					throw new ValidationException("Data não pode ser anterior a data atual!");
				}				
				if (isMoreThan9monthsAfterToday(dataProvavelParto)) {
					throw new ValidationException("Data não pode ser mais longe do que 9 meses!");
				}
				return true;	
		}
	},
	DATA_ULTIMA_MENSTRUACAO {
		@Override
		public Boolean validarCalculoGestacional(CalculoGestacionalDTO calculoGestacional) {
			LocalDate dataUltimaMentruacao = LocalDate.parse(calculoGestacional.getData(), formatter());
			
			if (!isBeforeToday(dataUltimaMentruacao)) {
				throw new ValidationException("Data deve ser anterior a data atual!");
			}
			if (isMoreThan9monthsBeforeToday(dataUltimaMentruacao)) {
				throw new ValidationException("Data não pode ser mais antiga do que 9 meses!");
			}						
			return true;
		}
	}, 
	DATA_EXAME_ANTERIOR {
		@Override
		public Boolean validarCalculoGestacional(CalculoGestacionalDTO calculoGestacional) {
			LocalDate dataGestacionalEM = LocalDate.parse(calculoGestacional.getData(), formatter());
			
			if (!isBeforeToday(dataGestacionalEM)) {
				throw new ValidationException("Data deve ser anterior a data atual!");
			}
			if (isDaysMoreThan6(calculoGestacional.getDias())) {
				throw new ValidationException("Número de dias devem ser menores do que 7!");
			}			
			if (isWeeksMoreThan40(calculoGestacional.getSemanas())) {
				throw new ValidationException("Número de semanas devem ser menores do que 40!");
			}		
			return true;
		}		

	},
	IDADE_GESTACIONAL_ATUAL {
		@Override
		public Boolean validarCalculoGestacional(CalculoGestacionalDTO calculoGestacional ) {
			
			if (isDaysMoreThan6(calculoGestacional.getDias())) {
				throw new ValidationException("Número de dias devem ser menores do que 7!");
			}			
			if (isWeeksMoreThan40(calculoGestacional.getSemanas())) {
				throw new ValidationException("Número de semanas devem ser menores do que 40!");
			}		
			return true;
		}
	};	
	
	public abstract Boolean validarCalculoGestacional(CalculoGestacionalDTO calculoGestacional);
		
	public String formatarIdadeGestacional(long diff) {
		String idadeGestacional = (diff / 7) + " semana(s) e " + (diff % 7) + " dia(s)";
		return idadeGestacional;
	}	

	public DateTimeFormatter formatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	public boolean isBeforeToday(LocalDate data) {
		return data.isBefore(LocalDate.now());
	}
	
	public boolean isMoreThan9monthsAfterToday(LocalDate data) {
		return data.isAfter(LocalDate.now().plusWeeks(40));
	}
	
	public boolean isMoreThan9monthsBeforeToday(LocalDate data) {
		return data.isBefore(LocalDate.now().minusWeeks(40));
	}
	
	public boolean isDaysMoreThan6(Integer dias) {
		return dias > 6;
	}
	
	public boolean isWeeksMoreThan40(Integer semanas) {		
		return semanas > 39;
	}
	
}