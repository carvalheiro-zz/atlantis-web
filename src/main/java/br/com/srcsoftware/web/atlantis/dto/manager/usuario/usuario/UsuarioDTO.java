package br.com.srcsoftware.web.atlantis.dto.manager.usuario.usuario;

import java.util.ArrayList;

import br.com.srcsoftware.web.atlantis.dto.abstracts.AuditoriaAbstractDTOComEmpresa;
import br.com.srcsoftware.web.atlantis.dto.manager.empresa.EmpresaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.permissao.PermissaoDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tipousuario.TipoUsuarioDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends AuditoriaAbstractDTOComEmpresa{

	public static final Boolean STATUS_ATIVO = true;
	public static final Boolean STATUS_INATIVO = false;

	private String id;
	private String login;
	private String senha;
	private String senhaTemporaria;
	private String email;
	private String status;
	private TipoUsuarioDTO tipoUsuario;
	private ArrayList< PermissaoDTO > permissoes;

	public UsuarioDTO(){
		this.setPermissoes( new ArrayList< PermissaoDTO >() );
		this.setEmpresa( new EmpresaDTO() );
		this.setTipoUsuario( new TipoUsuarioDTO() );
	}
	
	public String getStatusToString() {
		return ( "true".equals( this.status ) ? "Ativo" : "Inativo" );
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = ( prime * result ) + ( ( this.login == null ) ? 0 : this.login.hashCode() );
		result = ( prime * result ) + ( ( this.senha == null ) ? 0 : this.senha.hashCode() );
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
		if ( !( obj instanceof UsuarioDTO ) ) {
			return false;
		}
		UsuarioDTO other = (UsuarioDTO) obj;
		if ( this.login == null ) {
			if ( other.login != null ) {
				return false;
			}
		} else if ( !this.login.equals( other.login ) ) {
			return false;
		}
		if ( this.senha == null ) {
			if ( other.senha != null ) {
				return false;
			}
		} else if ( !this.senha.equals( other.senha ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "UsuarioDTO [\n\tid=" );
		builder.append( this.id );
		builder.append( "\n\tlogin=" );
		builder.append( this.login );
		builder.append( "\n\tsenha=" );
		builder.append( this.senha );
		builder.append( "\n\temail=" );
		builder.append( this.email );
		builder.append( "\n\tstatus=" );
		builder.append( this.status );
		builder.append( "\n\ttipoUsuario=" );
		builder.append( this.tipoUsuario );
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
