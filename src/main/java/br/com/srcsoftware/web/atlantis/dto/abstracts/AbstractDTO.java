package br.com.srcsoftware.web.atlantis.dto.abstracts;

import br.com.srcsoftware.web.utilidades.ObjectUtils;
import br.com.srcsoftware.web.utilidades.Utilidades;
import lombok.Data;


public abstract class AbstractDTO{

	private String versao;
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

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}	
	
	
}
