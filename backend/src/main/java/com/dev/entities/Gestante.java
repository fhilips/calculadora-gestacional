package com.dev.entities;

import java.time.LocalDate;
import java.time.LocalDate;

public class Gestante {

	private LocalDate dataProvavelDoParto;
	private LocalDate dataUltimaMenstruacao;	
	private String idadeGestacional;
	
	
	public Gestante(LocalDate dataGes) {
		this.dataProvavelDoParto = dataGes;
	}
	
	public Gestante() {		
	}
	
	public Gestante(LocalDate dataProvavelDoParto, LocalDate dataUltimaMenstruacao, String idadeGestacional) {
		super();
		this.dataProvavelDoParto = dataProvavelDoParto;
		this.dataUltimaMenstruacao = dataUltimaMenstruacao;
		this.idadeGestacional = idadeGestacional;
		
	}
	public LocalDate getDataProvavelDoParto() {
		return dataProvavelDoParto;
	}

	public LocalDate getDataUltimaMenstruacao() {
		return dataUltimaMenstruacao;
	}

	public String getIdadeGestacional() {
		return idadeGestacional;
	}

		
}
