package com.dev.web.dto.request;

import com.dev.domain.models.TipoCalculoGestacional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculoGestacionalDTO {

	private String data;	
	private Integer semanas;	
	private Integer dias;	
	private TipoCalculoGestacional criterioCalculo;
	
}
