<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MODAL DE AVISO DE SESSÃO MULTI-ABAS -->
<div class="modal fade" id="modalSessaoExpirada" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalSessaoExpiradaLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content border-0 shadow-lg">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title font-bold" id="modalSessaoExpiradaLabel">
                    <i class="fa fa-exclamation-triangle"></i> Conflito de Abas
                </h5>
            </div>
            <div class="modal-body p-4 text-gray-700" id="mensagemModalSessao">
                <!-- Mensagem dinâmica injetada via JS -->
            </div>
            <div class="modal-footer bg-gray-50 border-t border-gray-200">
                <button type="button" class="btn btn-danger btn-sm" onclick="redirecionarLogin()">
                    Sair
                </button>
            </div>
        </div>
    </div>
</div>

<!-- SCRIPT DE CONTROLE INTELIGENTE DE ABAS -->
<script type="text/javascript">
	function redirecionarLogin() {
	    // Limpa apenas o storage da aba atual, preservando a chave global da aba principal ativa
	    sessionStorage.removeItem('app_tab_id');
	    window.location.href = '${pageContext.request.contextPath}/publico/admin/login.src?method=abrir';
	}

    $(document).ready(function() {
        var currentTabId = sessionStorage.getItem('app_tab_id');
        var activeSystemTab = localStorage.getItem('active_system_tab');

        // CENÁRIO 1: O usuário tentou abrir uma NOVA ABA, mas já existe uma aba ativa rodando
        if (!currentTabId && activeSystemTab) {
            try {
                var activeData = JSON.parse(activeSystemTab);
                
                // Se existe uma aba ativa registrada no sistema, bloqueamos a nova aba imediatamente
                if (activeData && activeData.tabId) {
                    $('#mensagemModalSessao').text('V4 O sistema já está aberto em outra aba do navegador. Por segurança, apenas uma aba ativa é permitida.');
                    var modalExpirada = new bootstrap.Modal(document.getElementById('modalSessaoExpirada'));
                    modalExpirada.show();
                    
                    // Retorna imediatamente sem registrar esta aba nova, mantendo a aba antiga 100% intacta
                    return; 
                }
            } catch (e) {
                console.error('Erro ao validar aba ativa', e);
            }
        }

        // CENÁRIO 2: Inicialização normal (Caso seja a primeira aba ou a aba antiga recuperando o espaço)
        if (!currentTabId) {
            currentTabId = 'tab_' + Date.now() + '_' + Math.random().toString(36).substr(2, 9);
            sessionStorage.setItem('app_tab_id', currentTabId);
        }

        // Registra esta aba como a ativa no localStorage
        localStorage.setItem('active_system_tab', JSON.stringify({
            tabId: currentTabId,
            timestamp: Date.now()
        }));

        // Heartbeat: mantém a aba atual viva no localStorage a cada 3 segundos
        var heartbeatInterval = setInterval(function() {
            if (sessionStorage.getItem('app_tab_id') === currentTabId) {
                localStorage.setItem('active_system_tab', JSON.stringify({
                    tabId: currentTabId,
                    timestamp: Date.now()
                }));
            } else {
                clearInterval(heartbeatInterval);
            }
        }, 3000);

        // CENÁRIO 3: Segurança extra (caso o storage mude externamente)
        window.addEventListener('storage', function(event) {
            if (event.key === 'active_system_tab') {
                try {
                    var activeData = JSON.parse(event.newValue);
                    if (activeData && activeData.tabId !== currentTabId) {
                        console.warn("Tentativa de abertura de aba paralela bloqueada. Esta aba continua ativa.");
                    }
                } catch (e) {
                    console.error('Erro ao processar controle de abas', e);
                }
            }
        });
    });
</script>