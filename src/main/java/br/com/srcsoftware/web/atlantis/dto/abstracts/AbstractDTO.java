package br.com.srcsoftware.web.atlantis.dto.abstracts;

import java.io.Serializable;

import br.com.srcsoftware.web.utilidades.ObjectUtils;
import br.com.srcsoftware.web.utilidades.Utilidades;


public abstract class AbstractDTO implements Serializable{

	private static final long serialVersionUID = 8192715932900166541L;
	
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
