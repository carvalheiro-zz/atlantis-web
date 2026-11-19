package br.com.srcsoftware.web.atlantis.dto.manager.usuario.tipousuario;

import java.util.ArrayList;

import br.com.srcsoftware.web.atlantis.dto.abstracts.AuditoriaAbstractDTOComEmpresa;
import br.com.srcsoftware.web.atlantis.dto.manager.empresa.EmpresaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.permissao.PermissaoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioDTO extends AuditoriaAbstractDTOComEmpresa{

	private String id;
	private String nome;
	private ArrayList< PermissaoDTO > permissoes;

	public TipoUsuarioDTO(){
		this.setPermissoes( new ArrayList< PermissaoDTO >() );
		this.setEmpresa( new EmpresaDTO() );
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = ( prime * result ) + ( ( getEmpresa() == null ) ? 0 : this.getEmpresa().hashCode() );
		result = ( prime * result ) + ( ( this.nome == null ) ? 0 : this.nome.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( !( obj instanceof TipoUsuarioDTO ) ) {
			return false;
		}
		TipoUsuarioDTO other = (TipoUsuarioDTO) obj;
		if ( this.getEmpresa() == null ) {
			if ( other.getEmpresa() != null ) {
				return false;
			}
		} else if ( !this.getEmpresa().equals( other.getEmpresa() ) ) {
			return false;
		}
		if ( this.nome == null ) {
			if ( other.nome != null ) {
				return false;
			}
		} else if ( !this.nome.equals( other.nome ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "TipoUsuarioDTO [\n\tid=" );
		builder.append( this.id );
		builder.append( "\n\tnome=" );
		builder.append( this.nome );
		builder.append( "\n\tpermissoes=" );
		builder.append( this.permissoes );
		builder.append( "\n\tempresa=" );
		builder.append( this.getEmpresa() );
		builder.append( "\n\ttoString()=" );
		builder.append( super.toString() );
		builder.append( "]" );
		return builder.toString();
	}

}
