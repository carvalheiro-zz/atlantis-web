<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MODAL ESPECÍFICA PARA SESSÃO EXPIRADA POR OUTRA ABA -->
<div class="modal fade" id="modalSessaoExpirada" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalSessaoExpiradaLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content border-0 shadow-lg">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title font-bold" id="modalSessaoExpiradaLabel">
                    <i class="fa fa-exclamation-triangle"></i> Sessão Encerrada
                </h5>
            </div>
            <div class="modal-body p-4 text-gray-700">
                Esta sessão foi encerrada porque o sistema foi aberto em outra aba.
            </div>
            <div class="modal-footer bg-gray-50 border-t border-gray-200">
                <button type="button" class="btn btn-danger btn-sm" onclick="redirecionarLogin()">
                    Entrar novamente
                </button>
            </div>
        </div>
    </div>
</div>

<!-- SCRIPT ENCAPSULADO DO COMPONENTE -->
<script type="text/javascript">
    function redirecionarLogin() {
        window.location.href = '${pageContext.request.contextPath}/publico/admin/login.src?method=abrir';
    }

    $(document).ready(function() {
        var currentTabId = sessionStorage.getItem('app_tab_id');
        if (!currentTabId) {
            currentTabId = 'tab_' + Date.now() + '_' + Math.random().toString(36).substr(2, 9);
            sessionStorage.setItem('app_tab_id', currentTabId);
        }

        localStorage.setItem('active_system_tab', JSON.stringify({
            tabId: currentTabId,
            timestamp: Date.now()
        }));

        window.addEventListener('storage', function(event) {
            if (event.key === 'active_system_tab') {
                try {
                    var activeData = JSON.parse(event.newValue);
                    if (activeData && activeData.tabId !== currentTabId) {
                        var modalExpirada = new bootstrap.Modal(document.getElementById('modalSessaoExpirada'));
                        modalExpirada.show();
                    }
                } catch (e) {
                    console.error('Erro ao processar controle de abas', e);
                }
            }
        });
    });
</script>