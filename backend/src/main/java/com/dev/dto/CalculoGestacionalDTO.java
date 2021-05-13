package com.dev.dto;

import com.dev.entities.CalculoGestacional;


public class CalculoGestacionalDTO {

	private String data;
	private Integer semanas;
	private Integer dias;
	private CalculoGestacional tipoDoCalculo;
	
	public CalculoGestacionalDTO() {
		
	}		

	public CalculoGestacionalDTO(String data, Integer semanas, Integer dias, CalculoGestacional tipoDoCalculo) {
		super();
		this.data = data;
		this.semanas = semanas;
		this.dias = dias;
		this.tipoDoCalculo = tipoDoCalculo;
	}


	public Integer getSemanas() {
		return semanas;
	}

	public void setSemanas(Integer semanas) {
		this.semanas = semanas;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public CalculoGestacional getTipoDoCalculo() {
		return tipoDoCalculo;
	}

	public void setTipoDoCalculo(CalculoGestacional tipoDoCalculo) {
		this.tipoDoCalculo = tipoDoCalculo;
	}
	
	
}
