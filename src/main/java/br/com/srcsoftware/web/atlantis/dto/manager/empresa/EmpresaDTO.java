package br.com.srcsoftware.web.atlantis.dto.manager.empresa;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import br.com.srcsoftware.web.atlantis.dto.abstracts.AuditoriaAbstractDTO;
import br.com.srcsoftware.web.utilidades.Utilidades;

@JsonIgnoreType( value = true )
public class EmpresaDTO extends AuditoriaAbstractDTO{

	private String id;
	/** Parte Pessoa */
	private String razaoSocial;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String email;
	private String imagem;
	private EmpresaDTO empresa;

	/** Parte Endere�o */
	private String logradouro;
	private String numeroEndereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String complemento;

	/** Parte Pessoa Juridica */
	private String cnpj;
	private String nomeFantasia;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String nomeResponsavel;
	private String cargoResponsavel;
	private String emailResponsavel;

	/** Parte Empresa */
	private String codigo;
	private String ativo;
	private String nomeSistema;
	private String versaoSistema;
	private String horaFechamento;
	private String horaAbertura;

	public String getPrefixoImagem() {
		if ( this.imagem == null ) {
			return "";
		}
		String[ ] prefixo = this.imagem.split( "-" );

		return prefixo.length > 1 ? prefixo[ 0 ] : "";
	}

	public String getEnderecoCompletoToString() {
		StringBuilder texto = new StringBuilder();
		texto.append( getLogradouro() );
		texto.append( "," );
		texto.append( getNumeroEndereco() );
		texto.append( " - " );
		texto.append( getBairro() );
		texto.append( " " );
		texto.append( getCidade() );
		texto.append( "/" );
		texto.append( getEstado() );
		texto.append( " " );
		texto.append( getCep() );

		return texto.toString();
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = Utilidades.removerEspacosExcedentes( id );
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro( String logradouro ) {
		this.logradouro = Utilidades.removerEspacosExcedentes( logradouro );
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco( String numeroEndereco ) {
		this.numeroEndereco = Utilidades.removerEspacosExcedentes( numeroEndereco );
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro( String bairro ) {
		this.bairro = Utilidades.removerEspacosExcedentes( bairro );
	}

	public String getCep() {
		return cep;
	}

	public void setCep( String cep ) {
		this.cep = Utilidades.removerEspacosExcedentes( cep );
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade( String cidade ) {
		this.cidade = Utilidades.removerEspacosExcedentes( cidade );
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado( String estado ) {
		this.estado = Utilidades.removerEspacosExcedentes( estado );
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento( String complemento ) {
		this.complemento = Utilidades.removerEspacosExcedentes( complemento );
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial( String razaoSocial ) {
		this.razaoSocial = Utilidades.removerEspacosExcedentes( razaoSocial );
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1( String telefone1 ) {
		this.telefone1 = Utilidades.removerEspacosExcedentes( telefone1 );
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2( String telefone2 ) {
		this.telefone2 = Utilidades.removerEspacosExcedentes( telefone2 );
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3( String telefone3 ) {
		this.telefone3 = Utilidades.removerEspacosExcedentes( telefone3 );
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = Utilidades.removerEspacosExcedentes( email );
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem( String imagem ) {
		this.imagem = Utilidades.removerEspacosExcedentes( imagem );
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = Utilidades.removerEspacosExcedentes( cnpj );
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia( String nomeFantasia ) {
		this.nomeFantasia = Utilidades.removerEspacosExcedentes( nomeFantasia );
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual( String inscricaoEstadual ) {
		this.inscricaoEstadual = Utilidades.removerEspacosExcedentes( inscricaoEstadual );
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal( String inscricaoMunicipal ) {
		this.inscricaoMunicipal = Utilidades.removerEspacosExcedentes( inscricaoMunicipal );
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel( String nomeResponsavel ) {
		this.nomeResponsavel = Utilidades.removerEspacosExcedentes( nomeResponsavel );
	}

	public String getCargoResponsavel() {
		return cargoResponsavel;
	}

	public void setCargoResponsavel( String cargoResponsavel ) {
		this.cargoResponsavel = Utilidades.removerEspacosExcedentes( cargoResponsavel );
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel( String emailResponsavel ) {
		this.emailResponsavel = Utilidades.removerEspacosExcedentes( emailResponsavel );
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo( String codigo ) {
		this.codigo = Utilidades.removerEspacosExcedentes( codigo );
	}

	public String getAtivoToString() {
		return ( "true".equals( this.ativo ) ? "Ativo" : "Inativo" );
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo( String ativo ) {
		this.ativo = Utilidades.removerEspacosExcedentes( ativo );
	}

	public String getNomeSistema() {
		return nomeSistema;
	}

	public void setNomeSistema( String nomeSistema ) {
		this.nomeSistema = Utilidades.removerEspacosExcedentes( nomeSistema );
	}

	public String getVersaoSistema() {
		return versaoSistema;
	}

	public void setVersaoSistema( String versaoSistema ) {
		this.versaoSistema = Utilidades.removerEspacosExcedentes( versaoSistema );
	}

	public EmpresaDTO getEmpresa() {
		if ( empresa == null ) {
			empresa = new EmpresaDTO();
		}
		return empresa;
	}

	public void setEmpresa( EmpresaDTO empresa ) {
		this.empresa = empresa;
	}

	public String getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento( String horaFechamento ) {
		this.horaFechamento = Utilidades.removerEspacosExcedentes( horaFechamento );
	}

	public String getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura( String horaAbertura ) {
		this.horaAbertura = Utilidades.removerEspacosExcedentes( horaAbertura );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( cnpj == null ) ? 0 : cnpj.hashCode() );
		result = prime * result + ( ( empresa == null ) ? 0 : empresa.hashCode() );
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
		if ( !( obj instanceof EmpresaDTO ) ) {
			return false;
		}
		EmpresaDTO other = (EmpresaDTO) obj;
		if ( cnpj == null ) {
			if ( other.cnpj != null ) {
				return false;
			}
		} else if ( !cnpj.equals( other.cnpj ) ) {
			return false;
		}
		if ( empresa == null ) {
			if ( other.empresa != null ) {
				return false;
			}
		} else if ( !empresa.equals( other.empresa ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "EmpresaDTO [id=" );
		builder.append( id );
		builder.append( ", razaoSocial=" );
		builder.append( razaoSocial );
		builder.append( ", telefone1=" );
		builder.append( telefone1 );
		builder.append( ", telefone2=" );
		builder.append( telefone2 );
		builder.append( ", telefone3=" );
		builder.append( telefone3 );
		builder.append( ", email=" );
		builder.append( email );
		builder.append( ", imagem=" );
		builder.append( imagem );
		builder.append( ", empresa=" );
		builder.append( empresa );
		builder.append( ", logradouro=" );
		builder.append( logradouro );
		builder.append( ", numeroEndereco=" );
		builder.append( numeroEndereco );
		builder.append( ", bairro=" );
		builder.append( bairro );
		builder.append( ", cep=" );
		builder.append( cep );
		builder.append( ", cidade=" );
		builder.append( cidade );
		builder.append( ", estado=" );
		builder.append( estado );
		builder.append( ", complemento=" );
		builder.append( complemento );
		builder.append( ", cnpj=" );
		builder.append( cnpj );
		builder.append( ", nomeFantasia=" );
		builder.append( nomeFantasia );
		builder.append( ", inscricaoEstadual=" );
		builder.append( inscricaoEstadual );
		builder.append( ", inscricaoMunicipal=" );
		builder.append( inscricaoMunicipal );
		builder.append( ", nomeResponsavel=" );
		builder.append( nomeResponsavel );
		builder.append( ", cargoResponsavel=" );
		builder.append( cargoResponsavel );
		builder.append( ", emailResponsavel=" );
		builder.append( emailResponsavel );
		builder.append( ", codigo=" );
		builder.append( codigo );
		builder.append( ", ativo=" );
		builder.append( ativo );
		builder.append( ", nomeSistema=" );
		builder.append( nomeSistema );
		builder.append( ", versaoSistema=" );
		builder.append( versaoSistema );
		builder.append( ", horaFechamento=" );
		builder.append( horaFechamento );
		builder.append( ", horaAbertura=" );
		builder.append( horaAbertura );
		builder.append( ", toString()=" );
		builder.append( super.toString() );
		builder.append( "]" );
		return builder.toString();
	}

}
