package com.dev.services.exceptions;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
		
}
