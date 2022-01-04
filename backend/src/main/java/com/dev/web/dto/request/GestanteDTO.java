package com.dev.web.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GestanteDTO {
	
	private LocalDate dataProvavelDoParto;
	private LocalDate dataUltimaMenstruacao;	
	private String idadeGestacional;
	private String dataMorfoPrimeiroTri;
	private String dataMorfoSegundoTri;
	

}
