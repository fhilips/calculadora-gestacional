package com.dev.dto;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class GestanteDTO {
	private LocalDateTime dataProvavelDoParto;
	private LocalDateTime dataUltimaMenstruacao;
	private LocalDateTime idadeGestacional;
	private LocalDateTime idadeGestacionalEm;
		
	public GestanteDTO() {	
		
	}
	
	public GestanteDTO(LocalDateTime dataProvavelDoParto, LocalDateTime dataUltimaMenstruacao, LocalDateTime idadeGestacional,
			LocalDateTime idadeGestacionalEm) {
		super();
		this.dataProvavelDoParto = dataProvavelDoParto;
		this.dataUltimaMenstruacao = dataUltimaMenstruacao;
		this.idadeGestacional = idadeGestacional;
		this.idadeGestacionalEm = idadeGestacionalEm;
		
	}
	public LocalDateTime getDataProvavelDoParto() {
		return dataProvavelDoParto;
	}
	public void setDataProvavelDoParto(LocalDateTime dataProvavelDoParto) {
		this.dataProvavelDoParto = dataProvavelDoParto;
	}
	public LocalDateTime getDataUltimaMenstruacao() {
		return dataUltimaMenstruacao;
	}
	public void setDataUltimaMenstruacao(LocalDateTime dataUltimaMenstruacao) {
		this.dataUltimaMenstruacao = dataUltimaMenstruacao;
	}
	public LocalDateTime getIdadeGestacional() {
		return idadeGestacional;
	}
	public void setIdadeGestacional(LocalDateTime idadeGestacional) {
		this.idadeGestacional = idadeGestacional;
	}
	public LocalDateTime getIdadeGestacionalEm() {
		return idadeGestacionalEm;
	}
	public void setIdadeGestacionalEm(LocalDateTime idadeGestacionalEm) {
		this.idadeGestacionalEm = idadeGestacionalEm;
	}
	
	
}
