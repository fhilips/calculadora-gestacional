package com.dev.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gestante {

	private LocalDate dataProvavelDoParto;
	private LocalDate dataUltimaMenstruacao;		
	
}
