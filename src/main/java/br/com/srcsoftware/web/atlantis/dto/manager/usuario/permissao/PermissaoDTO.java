package br.com.srcsoftware.web.atlantis.dto.manager.usuario.permissao;

import java.util.ArrayList;

import br.com.srcsoftware.web.atlantis.dto.abstracts.AbstractDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissaoDTO extends AbstractDTO implements Comparable< PermissaoDTO >{

	private String id;
	private String acao;
	private TelaDTO tela;

	public PermissaoDTO(){
		this.setTela( new TelaDTO() );
	}

	public PermissaoDTO( String acao, TelaDTO tela ){
		this.setAcao( acao );
		this.setTela( tela );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = ( prime * result ) + ( ( this.acao == null ) ? 0 : this.acao.hashCode() );
		result = ( prime * result ) + ( ( this.tela == null ) ? 0 : this.tela.hashCode() );
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
		if ( !( obj instanceof PermissaoDTO ) ) {
			return false;
		}
		PermissaoDTO other = (PermissaoDTO) obj;
		if ( this.acao == null ) {
			if ( other.acao != null ) {
				return false;
			}
		} else if ( !this.acao.equals( other.acao ) ) {
			return false;
		}
		if ( this.tela == null ) {
			if ( other.tela != null ) {
				return false;
			}
		} else if ( !this.tela.equals( other.tela ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "PermissaoDTO [\n\tid=" );
		builder.append( this.id );
		builder.append( "\n\tacao=" );
		builder.append( this.acao );
		builder.append( "\n\ttela=" );
		builder.append( this.tela );
		builder.append( "]" );
		return builder.toString();
	}

	@Override
	public int compareTo( PermissaoDTO o ) {
		return this.getAcao().compareTo( o.getAcao() );
	}

}
