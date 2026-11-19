package br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelaFiltroDTO implements Serializable{

	private static final long serialVersionUID = 3554112491924643135L;

	private TelaDTO criterios;
	
	private int pagina; // Spring usa base 0
    private int tamanho;	
}