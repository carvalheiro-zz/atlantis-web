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
        // Limpa APENAS o sessionStorage desta aba bloqueada, mantendo a aba principal intacta
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
                
                // Bloqueia imediatamente independente do tempo decorrido
                if (activeData && activeData.tabId) {
                    $('#mensagemModalSessao').text('O sistema já está aberto em outra aba do navegador. Por segurança, apenas uma aba ativa é permitida.');
                    var modalExpirada = new bootstrap.Modal(document.getElementById('modalSessaoExpirada'));
                    modalExpirada.show();
                    return; 
                }
            } catch (e) {
                console.error('Erro ao validar aba ativa', e);
            }
        }

        // CENÁRIO 2: Inicialização da aba principal (antiga)
        if (!currentTabId) {
            currentTabId = 'tab_' + Date.now() + '_' + Math.random().toString(36).substr(2, 9);
            sessionStorage.setItem('app_tab_id', currentTabId);
        }

        localStorage.setItem('active_system_tab', JSON.stringify({
            tabId: currentTabId,
            timestamp: Date.now()
        }));

        // Heartbeat mantido a cada 3 segundos
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

     	// Apenas limpa a chave local ao descarregar a aba principal, sem disparar logout forçado no servidor
        window.addEventListener('beforeunload', function() {
            if (sessionStorage.getItem('app_tab_id') === currentTabId) {
                localStorage.removeItem('active_system_tab');
            }
        });

        // CENÁRIO 3: Proteção contra alterações externas
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