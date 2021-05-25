package com.dev.dto;

import java.time.LocalDate;


public class GestanteDTO {
	private LocalDate dataProvavelDoParto;
	private LocalDate dataUltimaMenstruacao;	
	private String idadeGestacional;
	private String dataMorfoPrimeiroTri;
	private String dataMorfoSegundoTri;
	
	public GestanteDTO() {	
		
	}	
	
	public GestanteDTO(LocalDate dataProvavelDoParto, LocalDate dataUltimaMenstruacao, String idadeGestacional,
			String dataMorfoPrimeiroTri, String dataMorfoSegundoTri) {
		super();
		this.dataProvavelDoParto = dataProvavelDoParto;
		this.dataUltimaMenstruacao = dataUltimaMenstruacao;
		this.idadeGestacional = idadeGestacional;
		this.dataMorfoPrimeiroTri = dataMorfoPrimeiroTri;
		this.dataMorfoSegundoTri = dataMorfoSegundoTri;
	}

	public LocalDate getDataProvavelDoParto() {
		return dataProvavelDoParto;
	}
	
	public void setDataProvavelDoParto(LocalDate dataProvavelDoParto) {
		this.dataProvavelDoParto = dataProvavelDoParto;
	}
	
	public LocalDate getDataUltimaMenstruacao() {
		return dataUltimaMenstruacao;
	}
	public void setDataUltimaMenstruacao(LocalDate dataUltimaMenstruacao) {
		this.dataUltimaMenstruacao = dataUltimaMenstruacao;
	}

	public String getIdadeGestacional() {
		return idadeGestacional;
	}

	public void setIdadeGestacional(String idadeGestacional) {
		this.idadeGestacional = idadeGestacional;
	}

	public String getDataMorfoPrimeiroTri() {
		return dataMorfoPrimeiroTri;
	}

	public void setDataMorfoPrimeiroTri(String dataMorfoPrimeiroTri) {
		this.dataMorfoPrimeiroTri = dataMorfoPrimeiroTri;
	}

	public String getDataMorfoSegundoTri() {
		return dataMorfoSegundoTri;
	}

	public void setDataMorfoSegundoTri(String dataMorfoSegundoTri) {
		this.dataMorfoSegundoTri = dataMorfoSegundoTri;
	}	
	
}
