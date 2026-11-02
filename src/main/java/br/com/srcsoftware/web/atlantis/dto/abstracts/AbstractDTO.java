package br.com.srcsoftware.web.atlantis.dto.abstracts;

import br.com.srcsoftware.web.utilidades.ObjectUtils;
import br.com.srcsoftware.web.utilidades.Utilidades;


public abstract class AbstractDTO{
	
	private String idTemp;

	public String getIdTemp() {
		if ( ObjectUtils.isNuloOuVazio( this.idTemp ) ) {
			this.idTemp = Utilidades.gerarIdentificadorTemporalUploads() + Utilidades.generateCodigoGrande();
		}
		return this.idTemp;
	}

	public void setIdTemp( String idTemp ) {
		this.idTemp = Utilidades.removerEspacosExcedentes( idTemp );
	}
		
}
