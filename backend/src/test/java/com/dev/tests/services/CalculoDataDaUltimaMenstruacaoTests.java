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
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;


@ExtendWith(SpringExtension.class)
public class CalculoDataDaUltimaMenstruacaoTests {
	

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
			CalculoGestacionalDTO calculoDTO = CalculoGestacionalDTO
												.builder()
												.data(dataValues.dataAtualMaisUmDia)
												.criterioCalculo(dataValues.criterioDataUltimaMenstruacao)
												.build();
			service.calcular(calculoDTO);
		});
	}
	
	@Test
	public void whenDataIsAfterTodayCalcularShouldReturnTheCorrectErrorMessage() {
				
		try {		
			CalculoGestacionalDTO calculoDTO = CalculoGestacionalDTO
												.builder()
												.data(dataValues.dataAtualMenosUmDia)
												.criterioCalculo(dataValues.criterioDataUltimaMenstruacao)
												.build();
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser anterior a data atual!");
		}
	}
	
	
	@Test
	public void whenDataIsMoreThan9MonthsBeforeTodayCalcularShouldReturnValidationException() {
				
		Assertions.assertThrows(ValidationException.class, () -> {			
			CalculoGestacionalDTO calculoDTO = CalculoGestacionalDTO
												.builder()
												.data(dataValues.dataAnteriorA9Meses)
												.criterioCalculo(dataValues.criterioDataUltimaMenstruacao)
												.build();
			service.calcular(calculoDTO);
		});		
	
	}
	@Test
	public void whenDataIsMoreThan9MonthsBeforeTodayCalcularShouldReturnTheCorrectErrorMessage() {
						
		try {			
			CalculoGestacionalDTO calculoDTO = CalculoGestacionalDTO
												.builder()
												.data(dataValues.dataAnteriorA9Meses)
												.criterioCalculo(dataValues.criterioDataUltimaMenstruacao)
												.build();
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser anterior a 9 meses!");
		}
	}
	
	@Test
	public void whenDataIsValidCalcularShouldReturnIdadeGestacional() {	
		CalculoGestacionalDTO calculoDTO = CalculoGestacionalDTO
											.builder()
											.data(dataValues.dataAtualMenosUmDia)
											.criterioCalculo(dataValues.criterioDataUltimaMenstruacao)
											.build();
		GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		Assertions.assertEquals(DataValues.formatarIdadeGestacional(LocalDate.now().minusDays(1)),
								dadosGestacionais.getIdadeGestacional());
	}	
	
}
