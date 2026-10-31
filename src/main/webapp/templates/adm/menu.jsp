<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="flex flex-col h-full">
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
        <li>
            <details class="group">
                <summary class="flex items-center justify-between px-3 py-2 text-gray-700 rounded-md hover:bg-gray-100 hover:text-blue-600 cursor-pointer list-none transition-colors">
                    <span class="flex items-center">
                        <i class="fa-solid fa-user-shield w-6 text-gray-500"></i> Administração
                    </span>
                    <i class="fa-solid fa-chevron-down text-xs text-gray-400 group-open:rotate-180 transition-transform"></i>
                </summary>
                
                <ul class="pl-6 pt-1 space-y-1 list-unstyled">
                    <!-- Submenu 1: Tela -->
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/tela.do" class="flex items-center px-3 py-1.5 text-sm text-gray-600 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
                            <i class="fa-solid fa-desktop w-5 text-gray-400"></i> Tela
                        </a>
                    </li>
                    
                    <!-- Submenu 2: Subadministração -->
                    <li>
                        <details class="group/sub">
                            <summary class="flex items-center justify-between px-3 py-1.5 text-sm text-gray-600 rounded-md hover:bg-gray-100 hover:text-blue-600 cursor-pointer list-none transition-colors">
                                <span class="flex items-center">
                                    <i class="fa-solid fa-sitemap w-5 text-gray-400"></i> Subadministração
                                </span>
                                <i class="fa-solid fa-chevron-down text-xs text-gray-400 group-open/sub:rotate-180 transition-transform"></i>
                            </summary>
                            
                            <!-- Submenu de Subadministração: Senha -->
                            <ul class="pl-5 pt-1 space-y-1 list-unstyled">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/senha.do" class="flex items-center px-3 py-1.5 text-xs text-gray-500 rounded-md hover:bg-gray-100 hover:text-blue-600 text-decoration-none transition-colors">
                                        <i class="fa-solid fa-key w-4 text-gray-400"></i> Senha
                                    </a>
                                </li>
                            </ul>
                        </details>
                    </li>
                </ul>
            </details>
        </li>

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