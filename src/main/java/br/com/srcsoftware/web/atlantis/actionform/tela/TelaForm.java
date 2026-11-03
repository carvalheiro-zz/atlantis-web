package br.com.srcsoftware.web.atlantis.actionform.tela;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import br.com.srcsoftware.web.atlantis.actionform.abstracts.AbstractCRUDForm;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaFiltroDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelaForm extends AbstractCRUDForm{

	// Inicializando as instâncias para evitar NullPointerException no Struts
    private TelaDTO tela = new TelaDTO();
    private TelaFiltroDTO filtro = new TelaFiltroDTO();
    private ArrayList<TelaDTO> lista = new ArrayList<>();

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
    	setTela(new TelaDTO());
    	setFiltro(new TelaFiltroDTO());
    }

	@Override
	public void limparCamposCadastro(HttpServletRequest request) {
		setTela(new TelaDTO());
	}

	@Override
	public void limparCamposConsulta(HttpServletRequest request) {
		setFiltro(new TelaFiltroDTO());
	}

	@Override
	public void limparLista() {
		setLista(new ArrayList<>());
	}
}
