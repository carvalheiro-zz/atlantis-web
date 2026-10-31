package br.com.srcsoftware.web.atlantis.dto.abstracts;

import br.com.srcsoftware.web.utilidades.ObjectUtils;
import br.com.srcsoftware.web.utilidades.Utilidades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class AuditoriaAbstractDTO extends AbstractDTO{

	private String nomeUsuarioCriacao;
	private String nomeUsuarioAlteracao;
	private String dataOcorrenciaCriacao;
	private String dataOcorrenciaAlteracao;

	public void setarDadosAuditoria( String nomeUsuario, String dataOcorrencia ) {
		if ( ObjectUtils.isNuloOuVazio( this.getDataOcorrenciaCriacao() ) ) {
			this.setNomeUsuarioCriacao( Utilidades.removerEspacosExcedentes( nomeUsuario ) );
			this.setDataOcorrenciaCriacao( Utilidades.removerEspacosExcedentes( dataOcorrencia ) );
		} else {
			this.setNomeUsuarioAlteracao( Utilidades.removerEspacosExcedentes( nomeUsuario ) );
			this.setDataOcorrenciaAlteracao( Utilidades.removerEspacosExcedentes( dataOcorrencia ) );
		}
	}

}
