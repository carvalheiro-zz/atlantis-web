package br.com.srcsoftware.web.utilidades;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * Classe utilitária para padronizar a criação de mensagens de sucesso e erro no Struts 1.3.
 */
public final class MensagensStruts {

    private MensagensStruts() {
        // Construtor privado para evitar instanciação da classe utilitária
    }

    /**
     * Cria um container de mensagens de sucesso com base na chave do ApplicationResources.
     */
    public static ActionMessages criarSucesso(String chaveMensagem) {
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(chaveMensagem));
        return messages;
    }
    
    /**
     * Cria um container de mensagens de sucesso com base na chave do ApplicationResources.
     */
    public static ActionMessages criarSucessoDinamico(String mensagemSucesso) {
        ActionMessages messages = new ActionMessages();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("success.custom", mensagemSucesso));
        return messages;
    }

    /**
     * Cria um container de mensagens de erro customizado utilizando a chave 'error.custom'.
     */
    public static ActionMessages criarErroDinamico(String mensagemErro) {
        ActionMessages errors = new ActionMessages();
        errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.custom", mensagemErro));
        return errors;
    }
    
    /**
     * Cria um container de mensagens de erro customizado utilizando a chave 'error.custom'.
     */
    public static ActionMessages criarErroCamposObrigatorios(String campos) {
        ActionMessages errors = new ActionMessages();
        errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.required", campos));
        return errors;
    }
}