package com.dev.dto;

import javax.validation.constraints.Max;


import com.dev.entities.CalculoGestacional;


public class CalculoGestacionalDTO {

	private String data;
	@Max(value = 42)
	private Integer semanas;
	@Max(value = 6)
	private Integer dias;
	private CalculoGestacional criterioCalculo;
	
	public CalculoGestacionalDTO() {
		
	}		

	public CalculoGestacionalDTO(String data, Integer semanas, Integer dias, CalculoGestacional criterioCalculo) {
		super();
		this.data = data;
		this.semanas = semanas;
		this.dias = dias;
		this.criterioCalculo = criterioCalculo;
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

	public CalculoGestacional getCriterioCalculo() {
		return criterioCalculo;
	}

	public void setCriterioCalculo(CalculoGestacional criterioCalculo) {
		this.criterioCalculo = criterioCalculo;
	}
	
	
}
