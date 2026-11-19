package br.com.srcsoftware.web.atlantis.actionform;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.srcsoftware.web.atlantis.actionform.abstracts.AbstractUsuarioAction;
import br.com.srcsoftware.web.atlantis.exceptions.ApplicationException;
import br.com.srcsoftware.web.utilidades.MensagensStruts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeAction extends AbstractUsuarioAction< HomeForm >{

	public ActionForward abrir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			HomeForm meuForm = this.getCastingForm( form, request );
			log.info("Inicializando o Desktop...");
			
		} catch (ApplicationException e) {
			// Erro de negócio tratado externalizado
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));
		}
		return mapping.findForward("home");
	}
}
