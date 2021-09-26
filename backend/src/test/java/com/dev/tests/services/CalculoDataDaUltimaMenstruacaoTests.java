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
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMaisUmDia, null, null, dataValues.dataUltimaMenstruacao);
			service.calcular(calculoDTO);
		});
	}
	
	@Test
	public void whenDataIsAfterTodayCalcularShouldReturnTheCorrectErrorMessage() {
				
		try {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, null, null, dataValues.dataUltimaMenstruacao);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser anterior a data atual!");
		}
	}
	
	
	@Test
	public void whenDataIsMoreThan9MonthsBeforeTodayCalcularShouldReturnValidationException() {
				
		Assertions.assertThrows(ValidationException.class, () -> {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAnteriorA9Meses, null, null, dataValues.dataUltimaMenstruacao);
			service.calcular(calculoDTO);
		});		
	
	}
	@Test
	public void whenDataIsMoreThan9MonthsBeforeTodayCalcularShouldReturnTheCorrectErrorMessage() {
						
		try {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAnteriorA9Meses, null, null, dataValues.dataUltimaMenstruacao);
			service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser anterior a 9 meses!");
		}
	}
	
	@Test
	public void whenDataIsValidCalcularShouldReturnIdadeGestacional() {
		CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataValues.dataAtualMenosUmDia, null, null, dataValues.dataUltimaMenstruacao);				
		GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		Assertions.assertEquals(DataValues.formatarIdadeGestacional(LocalDate.now().minusDays(1)), dadosGestacionais.getIdadeGestacional());
	}	
	
}
