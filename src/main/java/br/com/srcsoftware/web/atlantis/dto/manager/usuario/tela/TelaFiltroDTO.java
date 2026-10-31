package br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelaFiltroDTO {
	
	private TelaDTO criterios;
	
	private int pagina; // Spring usa base 0
    private int tamanho;	
}