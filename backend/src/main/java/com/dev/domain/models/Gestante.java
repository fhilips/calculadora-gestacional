package com.dev.domain.models;

import java.time.LocalDate;

public class Gestante {

	private LocalDate dataProvavelDoParto;
	private LocalDate dataUltimaMenstruacao;	
	
	public Gestante() {		
	}
	
	public Gestante(LocalDate dataGes) {
		this.dataProvavelDoParto = dataGes;
	}		
	
	public Gestante(LocalDate dataProvavelDoParto, LocalDate dataUltimaMenstruacao) {
		super();
		this.dataProvavelDoParto = dataProvavelDoParto;
		this.dataUltimaMenstruacao = dataUltimaMenstruacao;	
		
	}
	
	public LocalDate getDataProvavelDoParto() {
		return dataProvavelDoParto;
	}

	public LocalDate getDataUltimaMenstruacao() {
		return dataUltimaMenstruacao;
	}

}
