package br.com.srcsoftware.web.atlantis.actionform.tela;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.srcsoftware.web.atlantis.actionform.abstracts.AbstractCRUDAction;
import br.com.srcsoftware.web.atlantis.exceptions.ApplicationException;
import br.com.srcsoftware.web.utilidades.MensagensStruts;

public class TelaAction extends AbstractCRUDAction<TelaForm> {
	
	@Override
	public ActionForward abrirCadastro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = (TelaForm) form;
		//Limpar formulário para um novo cadastro
		telaForm.reset(mapping, request);
		
		
		telaForm.getTela().setId("100");
		telaForm.getTela().setarDadosAuditoria("gabriel", "01/11/2026");
		telaForm.getTela().setarDadosAuditoria("joao", "02/11/2026");
		return mapping.findForward("telaCadastro");
	}
	
	@Override
	public ActionForward inserir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = getCastingForm(form, request);

		try {
			// TODO: Implementar regra de negócio para Cadastrar (Service / Spring)
			if(telaForm.getTela().getNome().isBlank()) {
				// Erro de negócio tratado externalizado
	            addErrors(request, MensagensStruts.criarErroCamposObrigatorios("Nome"));
				
				return mapping.findForward("telaCadastro");
			}
			
			// Sucesso externalizado
            addMessages(request, MensagensStruts.criarSucesso("mensagem.sucesso.cadastro"));
            
			return mapping.findForward("sucesso");
		} catch (ApplicationException e) {
			
			// Erro de negócio tratado externalizado
            addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));
			
			return mapping.findForward("telaCadastro");
		}
	}
	
	
	

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = (TelaForm) form;
		// TODO: Implementar regra de negócio para Alterar
		return mapping.findForward("sucesso");
	}
	

	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = (TelaForm) form;
		// TODO: Implementar regra de negócio para Excluir
		return mapping.findForward("sucesso");
	}

	// O botão Cancelar aciona o <html:cancel>, que por padrão direciona para o
	// cancel mapping ou método específico se configurado.
	public ActionForward cancelar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		TelaForm telaForm = (TelaForm) form;
		
	    // Limpa o form da sessão/request se necessário
	    if (form != null) {
	        // Exemplo: resetando propriedades se estiver em escopo de sessão
	    	telaForm.reset(mapping, request);
	    }
	    
	    // Redireciona para a página home do sistema (configurada no struts-config.xml)
	    return mapping.findForward("home");
	}

	@Override
	public ActionForward abrirListagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward filtrar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = (TelaForm) form;
		// TODO: Implementar regra de negócio para Pesquisar
		return mapping.findForward("sucesso");
	}

	@Override
	public ActionForward selecionar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return abrirCadastro(mapping, form, request, response);
	}

	@Override
	public ActionForward limparFiltro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
}
