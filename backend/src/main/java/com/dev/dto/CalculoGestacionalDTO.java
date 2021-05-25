package com.dev.dto;

import com.dev.entities.CalculoGestacional;
import com.dev.entities.TipoCalculoGestacional;

public class CalculoGestacionalDTO {

	private String data;	
	private Integer semanas;	
	private Integer dias;	
	private TipoCalculoGestacional criterioCalculo;
	
	public CalculoGestacionalDTO() {
		
	}		

	public CalculoGestacionalDTO(String data, Integer semanas, Integer dias, TipoCalculoGestacional criterioCalculo) {
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

	public TipoCalculoGestacional getCriterioCalculo() {
		return criterioCalculo;
	}

	public void setCriterioCalculo(TipoCalculoGestacional criterioCalculo) {
		this.criterioCalculo = criterioCalculo;
	}
	
	
}
