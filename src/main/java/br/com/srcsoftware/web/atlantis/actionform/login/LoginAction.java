package br.com.srcsoftware.web.atlantis.actionform.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginAction extends DispatchAction {

    public ActionForward abrir(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        log.info("Abrindo a tela de login.");
        return mapping.findForward("telaLogin");
    }

    public ActionForward logar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String usuario = request.getParameter("usuario");
        log.info("Tentativa de login realizada para o usuário: {}", usuario);
        
        if ("admin".equals(usuario)) {
            log.info("Login bem-sucedido para o usuário: {}", usuario);
            request.getSession().setAttribute("usuarioLogado", usuario);
            return mapping.findForward("homeGlobalForwards");
        } else {
            log.warn("Falha de autenticação para o usuário: {}", usuario);
            return mapping.findForward("telaLogin");
        }
    }

    public ActionForward sair(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.info("Encerrando sessão para o usuário.");
            session.invalidate();
        }
        
        return mapping.findForward("telaLogin");
    }
}