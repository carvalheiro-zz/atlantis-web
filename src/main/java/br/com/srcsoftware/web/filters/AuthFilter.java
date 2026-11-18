package br.com.srcsoftware.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização do filtro (se necessário)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession(false);
        boolean logado = (session != null && session.getAttribute("usuarioLogado") != null);
        
        if (logado) {
            // Usuário autenticado, prossegue com a requisição
            chain.doFilter(request, response);
        } else {
            // Usuário não autenticado, redireciona para a tela de login
            String contextPath = httpRequest.getContextPath();
            httpResponse.sendRedirect(contextPath + "/publico/admin/login.src?method=abrir");
        }
        
    }

    @Override
    public void destroy() {
        // Limpeza de recursos (se necessário)
    }
}