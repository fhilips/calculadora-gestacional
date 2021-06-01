package com.dev.tests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ValidationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;
import com.dev.entities.TipoCalculoGestacional;
import com.dev.service.GestanteService;

@ExtendWith(SpringExtension.class)
public class GestanteServiceTests {

	@InjectMocks
	private GestanteService service;
	
	private TipoCalculoGestacional dataProvavelDoParto;
	private TipoCalculoGestacional dataUltimaMenstruacao;
	private TipoCalculoGestacional dataExameAnterior;
	private TipoCalculoGestacional dataGestacionalAtual;
	
	private int dias;
	private int numeroDeDiasNegativos;
	private int numeroDediasMaiorQue7;
	private int semanas;
	private int numeroDeSemanasNegativas;
	private int numeroDeSemanasMaiorQue40;
	
	private String dataAtual;
	private String dataAnteriorA9Meses;
	private String dataPosteriorA9Meses;
	private CalculoGestacionalDTO calculoDto;
	
	
	@BeforeEach
	void setUp() throws Exception{	
		dias = 5;
		numeroDeDiasNegativos = -7;
		numeroDediasMaiorQue7 = 10;
		semanas = 15;
		numeroDeSemanasNegativas = -19;
		
		numeroDeSemanasMaiorQue40 = 50;
		
		String dataAtual = formatarDataParaString(LocalDate.now());
		String dataAnteriorA9Meses = formatarDataParaString(LocalDate.now().minusMonths(9).plusDays(1));
		String dataPosteriorA9Meses = formatarDataParaString(LocalDate.now().plusMonths(9).plusDays(1));
		
		dataProvavelDoParto = TipoCalculoGestacional.DATA_PROVAVEL_DO_PARTO;
		dataUltimaMenstruacao = TipoCalculoGestacional.DATA_ULTIMA_MENSTRUACAO;
		dataExameAnterior = TipoCalculoGestacional.DATA_EXAME_ANTERIOR;
		dataGestacionalAtual = TipoCalculoGestacional.IDADE_GESTACIONAL_ATUAL;

		calculoDto = new CalculoGestacionalDTO( "15/10/2019", dias, semanas, dataProvavelDoParto);
	}
	
	@Test
	public void whenTipoCalculoGestacionalIsDataProvavelDoPartoAndDataIsBeforeTodayCalcularShouldReturnValidationException() {
				
		Assertions.assertThrows(ValidationException.class, () -> {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO(dataAnteriorA9Meses, null, null, dataProvavelDoParto);
			GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		});
	}
	@Test
	public void whenTipoCalculoGestacionalIsDataProvavelDoPartoAndDataIsBeforeTodayCalcularShouldReturnTheCorrectMessage() {
				
		try {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO("15/10/2019", null, null, dataProvavelDoParto);
			GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser anterior a data atual!");
		}
	}
	
	
	@Test
	public void whenTipoCalculoGestacionalIsDataProvavelDoPartoAndDataIsMoreThan9MonthsAfterTodayCalcularShouldReturnValidationException() {
				
		Assertions.assertThrows(ValidationException.class, () -> {
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO("15/10/2022", null, null, dataProvavelDoParto);
			GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		});		
	
	}
	@Test
	public void whenTipoCalculoGestacionalIsDataProvavelDoPartoAndDataIsMoreThan9MonthsAfterTodayCalcularShouldReturnTheCorrectErrorMessage() {
						
		try {			
			CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO("15/10/2022", null, null, dataProvavelDoParto);
			GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Data não pode ser mais longe do que 9 meses!");
		}
	}
	
	@Test
	public void whenTipoCalculoGestacionalIsDataProvavelDoPartoAndDataIsValidCalcularShouldReturnIdadeGestacional() {
		CalculoGestacionalDTO calculoDTO = new CalculoGestacionalDTO("15/10/2022", null, null, dataProvavelDoParto);				
		GestanteDTO dadosGestacionais = service.calcular(calculoDTO);
		Assertions.assertEquals("", dadosGestacionais.getDataProvavelDoParto());;
	}	
	
	private String formatarDataParaString(LocalDate data) {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataformatada = data.format(formatter);			
		return dataformatada;
	}
	
	public DateTimeFormatter formatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
}
