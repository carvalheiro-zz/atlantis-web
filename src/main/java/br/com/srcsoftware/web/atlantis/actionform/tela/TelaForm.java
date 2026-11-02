package br.com.srcsoftware.web.atlantis.actionform.tela;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaFiltroDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelaForm extends ActionForm{

	// Inicializando as instâncias para evitar NullPointerException no Struts
    private TelaDTO tela = new TelaDTO();
    private TelaFiltroDTO filtro = new TelaFiltroDTO();

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
    	setTela(new TelaDTO());
    	setFiltro(new TelaFiltroDTO());
    }
}
