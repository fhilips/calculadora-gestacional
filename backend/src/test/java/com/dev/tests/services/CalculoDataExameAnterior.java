package com.dev.tests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.validation.ValidationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dev.services.GestanteService;
import com.dev.tests.Factory.DataValues;
import com.dev.web.dto.request.CalculoGestacionalDTO;
import com.dev.web.dto.request.GestanteDTO;

@ExtendWith(SpringExtension.class)
public class CalculoDataExameAnterior {

	@InjectMocks
	private GestanteService service;

	private DataValues dataValues;

	@BeforeEach
	void setUp() throws Exception {
		dataValues = new DataValues();
	}

	@Test
	public void whenDataIsAfterTodayCalcularShouldReturnValidationException() {
				
		Assertions.assertThrows(ValidationException.class, () -> {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMaisUmDia, null, null, dataValues.dataExameAnterior);
			service.calcular(calculoDTO);
		});
	}

	@Test
	public void whenDataIsAfterTodayCalcularShouldReturnTheCorrectErrorMessage() {
				
		try {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMaisUmDia, null, null, dataValues.dataExameAnterior);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data deve ser anterior a data atual!");
		}
	}

	@Test
	public void whenDaysIsMoreThan7ShouldReturnValidationException() {

		Assertions.assertThrows(ValidationException.class, () -> {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, dataValues.semanas, dataValues.numeroDediasMaiorQue7,
					dataValues.dataExameAnterior);
			service.calcular(calculoDTO);
		});

	}

	@Test
	public void whenDaysIsMoreThan7ReturnTheCorrectErrorMessage() {

		try {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, dataValues.semanas, dataValues.numeroDediasMaiorQue7,
					dataValues.dataExameAnterior);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Número de dias devem ser menores do que 7!");
		}
	}
	
	@Test
	public void whenWeeksIsMoreThan40ReturnValidationException() {

		Assertions.assertThrows(ValidationException.class, () -> {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, dataValues.numeroDeSemanasMaiorQue40, dataValues.dias,
					dataValues.dataExameAnterior);
			service.calcular(calculoDTO);
		});

	}	
	
	@Test
	public void whenWeeksIsMoreThan40ReturnTheCorrectErrorMessage() {

		try {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, dataValues.numeroDeSemanasMaiorQue40, dataValues.dias,
					dataValues.dataExameAnterior);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Número de semanas devem ser menores do que 40!");
		}
	}

	@Test
	public void whenDataIsValidCalcularShouldReturnIdadeGestacional() {
		CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, dataValues.semanas, dataValues.dias,
				dataValues.dataExameAnterior);
		GestanteDTO dadosGestacionais = service.calcular(calculoDTO);

		Assertions.assertEquals(DataValues.formatarIdadeGestacional(LocalDate.now().minusDays(111)),
				dadosGestacionais.getIdadeGestacional());
	}

}
