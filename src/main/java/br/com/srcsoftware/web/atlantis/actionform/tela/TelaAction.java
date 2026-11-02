package br.com.srcsoftware.web.atlantis.actionform.tela;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;

public class TelaAction extends DispatchAction {

	/**
	 * Sobrescreve a lógica do DispatchAction para converter o nome do método em
	 * lowercase, fazendo com que o botão "Cadastrar" chame o método "cadastrar",
	 * etc.
	 * 
	 * @throws Exception
	 */
	@Override
	protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
		String methodName = super.getMethodName(mapping, form, request, response, parameter);
		return (methodName != null) ? methodName.toLowerCase() : null;
	}

	public ActionForward novo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TelaForm telaForm = (TelaForm) form;
		//Limpar formulário para um novo cadastro
		telaForm.reset(mapping, request);
		
		
		telaForm.getTela().setId("100");
		telaForm.getTela().setarDadosAuditoria("gabriel", "01/11/2026");
		telaForm.getTela().setarDadosAuditoria("joao", "02/11/2026");
		return mapping.findForward("telaCadastro");
	}

	public ActionForward cadastrar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TelaForm telaForm = (TelaForm) form;
		// TODO: Implementar regra de negócio para Cadastrar (Service / Spring)
		return mapping.findForward("sucesso");
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TelaForm telaForm = (TelaForm) form;
		// TODO: Implementar regra de negócio para Alterar
		return mapping.findForward("sucesso");
	}

	public ActionForward pesquisar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TelaForm telaForm = (TelaForm) form;
		// TODO: Implementar regra de negócio para Pesquisar
		return mapping.findForward("sucesso");
	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
}
