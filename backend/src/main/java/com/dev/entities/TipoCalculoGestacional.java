package com.dev.entities;

import com.dev.dto.CalculoGestacionalDTO;
import com.dev.dto.GestanteDTO;

public enum TipoCalculoGestacional {	
	
	DATA_PROVAVEL_DO_PARTO {
		@Override
		public GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional) {				
			
			return new CalculoPorDataProvavelDoParto().calculoGestacional(calculoGestacional);			
		}		
	},
	DATA_ULTIMA_MENSTRUACAO {
		@Override
		public GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional) {
			
			return new CalculoPorDataUltimaMenstruacao().calculoGestacional(calculoGestacional); 					
		}		
	}, 
	DATA_EXAME_ANTERIOR {
		@Override
		public GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional) {
			
			return new CalculoPorDataExameAnterior().calculoGestacional(calculoGestacional);
		}
	},
	DATA_GESTACIONAL_ATUAL {
		@Override
		public GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional ) {
			
			return new CalculoPorDataGestacionalAtual().calculoGestacional(calculoGestacional);
		}
	};	
	
	public abstract GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional);		

}