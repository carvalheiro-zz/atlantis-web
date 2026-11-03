package br.com.srcsoftware.web.atlantis.actionform.abstracts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.web.atlantis.exceptions.ApplicationException;

public abstract class AbstractAction<T> extends DispatchAction {
	
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

    /**
     * Realiza o casting seguro do ActionForm para o Form específico da tela.
     */
    @SuppressWarnings("unchecked")
    protected T getCastingForm(ActionForm form, HttpServletRequest request) throws ApplicationException {
        if (form == null) {
            throw new ApplicationException("Objeto ActionForm nulo, por favor verifique o mapeamento no struts-config.xml.");
        }
        return (T) form;
    }

    /**
     * Adiciona mensagens de sucesso/feedback limpando resíduos anteriores da request.
     */
    @Override
    protected void addMessages(HttpServletRequest request, ActionMessages messages) {
        ActionMessages existingMessages = super.getMessages(request);
        if (existingMessages != null) {
            existingMessages.clear();
        }
        if (messages != null && !messages.isEmpty()) {
            super.addMessages(request, messages);
        }
    }

    /**
     * Adiciona mensagens de erro/alerta limpando resíduos anteriores da request.
     */
    @Override
    protected void addErrors(HttpServletRequest request, ActionMessages messages) {
        ActionMessages existingErrors = super.getErrors(request);
        if (existingErrors != null) {
            existingErrors.clear();
        }
        if (messages != null && !messages.isEmpty()) {
            super.addErrors(request, messages);
        }
    }
}