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

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;
import com.dev.service.GestanteService;
import com.dev.tests.Factory.DataValues;

@ExtendWith(SpringExtension.class)
public class CalculoDataProvavelDoPartoTests {

	@InjectMocks
	private GestanteService service;

	private DataValues dataValues;

	@BeforeEach
	void setUp() throws Exception {
		dataValues = new DataValues();
	}

	@Test
	public void whenDataIsBeforeTodayCalcularShouldReturnValidationException() {

		Assertions.assertThrows(ValidationException.class, () -> {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, null, null,
					dataValues.dataProvavelDoParto);
			service.calcular(calculoDTO);
		});
	}

	@Test
	public void whenDataIsBeforeTodayCalcularShouldReturnTheCorrectErrorMessage() {

		try {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, null, null,
					dataValues.dataProvavelDoParto);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser anterior a data atual!");
		}
	}

	@Test
	public void whenDataIsMoreThan9MonthsAfterTodayCalcularShouldReturnValidationException() {

		Assertions.assertThrows(ValidationException.class, () -> {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataPosteriorA9Meses, null, null,
					dataValues.dataProvavelDoParto);
			service.calcular(calculoDTO);
		});

	}

	@Test
	public void whenDataIsMoreThan9MonthsAfterTodayCalcularShouldReturnTheCorrectErrorMessage() {

		try {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataPosteriorA9Meses, null, null,
					dataValues.dataProvavelDoParto);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser posterior a 9 meses da data atual!");
		}
	}

	@Test
	public void whenDataIsValidCalcularShouldReturnIdadeGestacional() {
		CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMaisUmDia, null, null,
				dataValues.dataProvavelDoParto);
		GestanteDTO dadosGestacionais = service.calcular(calculoDTO);

		Assertions.assertEquals(DataValues.formatarIdadeGestacional(LocalDate.now().minusDays(279)),
				dadosGestacionais.getIdadeGestacional());
	}

}
