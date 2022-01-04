package com.dev.services.calculos;

import com.dev.web.dto.request.CalculoGestacionalDTO;
import com.dev.web.dto.request.GestanteDTO;

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
	IDADE_GESTACIONAL_ATUAL {
		@Override
		public GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional ) {
			
			return new CalculoPorIdadeGestacionalAtual().calculoGestacional(calculoGestacional);
		}
	};	
	
	public abstract GestanteDTO getCalculoGestacional(CalculoGestacionalDTO calculoGestacional);		

}