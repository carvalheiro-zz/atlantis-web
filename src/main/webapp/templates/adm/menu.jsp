<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<div class="flex flex-col h-full fonte-menu">
    <h6 class="text-xs font-semibold text-gray-400 uppercase tracking-wider mb-3">Navegação</h6>
    <ul class="space-y-1 list-unstyled m-0 p-0">
        <li>
            <a href="${pageContext.request.contextPath}/home.do" class="flex items-center px-3 py-2 text-gray-700 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
                <i class="fa-solid fa-house w-6 text-gray-500"></i> Início
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/cadastros.do" class="flex items-center px-3 py-2 text-gray-700 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
                <i class="fa-solid fa-folder-open w-6 text-gray-500"></i> Cadastros
            </a>
        </li>

        <!-- Menu Administração -->
        <logic:equal name="loginForm" value="true" property="exibirGrupoMenu()">
	        <li>
	            <!-- Adicionado um ID para facilitar a referência no script -->
	            <details id="menu-administracao" class="group">
	                <summary class="flex items-center justify-between px-3 py-2 text-gray-700 rounded-md hover:bg-gray-100 hover:text-blue-600 cursor-pointer list-none transition-colors">
	                    <span class="flex items-center">
	                        <i class="fa-solid fa-user-shield w-6 text-gray-500"></i> Administração
	                    </span>
	                    <i class="fa-solid fa-chevron-down text-xs text-gray-400 group-open:rotate-180 transition-transform"></i>
	                </summary>
	                
	                <ul class="pl-6 pt-1 space-y-1 list-unstyled fonte-submenu">
	                    <!-- Submenu 1: Tela -->
	                    <logic:equal name="loginForm" value="true" property="acessoPermitido()">
		                    <li>
		                        <a href="${pageContext.request.contextPath}/restrito/admin/tela.src?method=novo" class="flex items-center px-3 py-1.5 text-gray-600 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
		                            <i class="fa-solid fa-desktop w-5 text-gray-400"></i> Tela
		                        </a>
		                    </li>
	                    </logic:equal>
	                    
	                    <!-- Submenu 2: Subadministração -->
	                    <li>
	                        <!-- Adicionado um ID caso queira controlar sub-níveis futuramente -->
	                        <details id="menu-subadministracao" class="group/sub">
	                            <summary class="flex items-center justify-between px-3 py-1.5 text-gray-600 rounded-md hover:bg-gray-100 hover:text-blue-600 cursor-pointer list-none transition-colors">
	                                <span class="flex items-center">
	                                    <i class="fa-solid fa-sitemap w-5 text-gray-400"></i> Subadministração
	                                </span>
	                                <i class="fa-solid fa-chevron-down text-xs text-gray-400 group-open/sub:rotate-180 transition-transform"></i>
	                            </summary>
	                            
	                            <!-- Submenu de Subadministração: Senha -->
	                            <ul class="pl-5 pt-1 space-y-1 list-unstyled">
	                                <li>
	                                    <a href="${pageContext.request.contextPath}/admin/senha.do" class="flex items-center px-3 py-1.5 text-gray-500 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
	                                        <i class="fa-solid fa-key w-4 text-gray-400"></i> Senha
	                                    </a>
	                                </li>
	                            </ul>
	                        </details>
	                    </li>
	                </ul>
	            </details>
	        </li>
        </logic:equal>

        <li>
            <a href="${pageContext.request.contextPath}/relatorios.do" class="flex items-center px-3 py-2 text-gray-700 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
                <i class="fa-solid fa-chart-line w-6 text-gray-500"></i> Relatórios
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/configuracoes.do" class="flex items-center px-3 py-2 text-gray-700 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
                <i class="fa-solid fa-gear w-6 text-gray-500"></i> Configurações
            </a>
        </li>
    </ul>
</div>

<!-- Script para manter o menu e submenus expandidos automaticamente com base na página ativa -->
<script>
    document.addEventListener("DOMContentLoaded", function() {
        const currentPath = window.location.pathname;

        // Procura todos os links de submenus dentro da navegação
        const submenuLinks = document.querySelectorAll("aside ul ul a");

        submenuLinks.forEach(link => {
            // Extrai o caminho do link (ignorando o contextPath se necessário)
            const linkPath = new URL(link.href, window.location.origin).pathname;

            // Se a URL atual corresponder ao link do submenu
            if (currentPath === linkPath) {
                // Marca o link atual visualmente como ativo (opcional, ex: cor azul forte)
                link.classList.add("text-blue-600", "font-semibold");

                // Sobe na árvore do DOM e abre todos os <details> ancestrais
                let parentDetails = link.closest("details");
                while (parentDetails) {
                    parentDetails.open = true;
                    // Sobe para ver se há outro <details> pai (para submenus aninhados)
                    parentDetails = parentDetails.parentElement.closest("details");
                }
            }
        });
    });
</script>