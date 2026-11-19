<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MODAL UNIFICADA DE CONFIRMAÇÃO (Bootstrap 5) -->
<div class="modal fade" id="modalConfirmacao" tabindex="-1" aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title font-bold text-blue-900" id="modalConfirmacaoLabel">
                    <i class="fa fa-question-circle text-blue-600"></i> Confirmação de Ação
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
            </div>
            <div class="modal-body text-gray-700" id="modalMensagemTexto">
                Deseja realmente executar esta ação?
            </div>
            <div class="modal-footer bg-light">
                <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">
                    <i class="fa fa-times"></i> Cancelar
                </button>
                <!-- O botão de confirmação dispara uma função global que a tela específica implementará -->
                <button type="button" class="btn btn-primary btn-sm" id="btnConfirmarModal" style="background-color: #1e3a8a; border-color: #1e3a8a;" onclick="executarConfirmacaoAcao()">
                    <i class="fa fa-check"></i> Confirmar
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    let metodoAcaoAtual = '';

    // Função universal apenas para abrir a modal e armazenar a intenção do botão
    function abrirConfirmacao(method, mensagem) {
        metodoAcaoAtual = method;
        $('#modalMensagemTexto').text(mensagem);
        
        let myModal = new bootstrap.Modal(document.getElementById('modalConfirmacao'));
        myModal.show();
    }
</script>