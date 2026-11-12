<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="container-fluid" style="margin-top: 20px;">
    
    <!-- TRATAMENTO DE MENSAGENS (ACTION MESSAGES) -->
    <!-- Inclusão Genérica de Mensagens -->
    <%@ include file="/templates/components/mensagens/mensagensAlerta.jsp" %>

    <!-- FORMULÁRIO / PANEL PRINCIPAL -->
    <div class="row">
        <div class="col-md-offset-2 col-lg-offset-2 col-xs-12 col-sm-12 col-md-8 col-lg-8">
            <html:form action="/restrito/admin/tela" method="post" styleId="formPrincipal">
                <!-- Campos ocultos de controle (ID e Versão para Bloqueio Otimista) -->
                <html:hidden name="telaForm" property="tela.id"/>
                <html:hidden name="telaForm" property="tela.versao"/>
                <!-- Campo oculto para submeter o valor do method do Struts via Modal -->
                <input type="hidden" name="method" id="methodAction" value=""/>

                <div class="panel panel-default sombra" style="border-color: #cbd5e1;">
                    
                   <!-- HEADER DO PANEL -->
                    <div class="panel-heading" style="background-color: #eff6ff; border-bottom: 1px solid #bfdbfe; padding: 15px 20px;">
                        <div style="display: flex; align-items: center; justify-content: space-between; width: 100%;">
                            <div style="display: flex; align-items: center; gap: 10px;">
                                <i class="fa fa-desktop text-blue-600" style="font-size: 18px; color: #1e3a8a;"></i>
                                <h3 class="panel-title fonte-titulo-tela" style="font-weight: bold; color: #1e3a8a; margin: 0;">Cadastro de Tela</h3>
                            </div>
                            <div class="fonte-id-tela" style="font-size: 13px; color: #64748b; font-weight: 600;">
                                <logic:present property="tela.id" name="telaForm">
                                    ID: ${telaForm.tela.id}
                                </logic:present>
                                <logic:notPresent property="tela.id" name="telaForm">
                                    Novo Registro
                                </logic:notPresent>
                            </div>
                        </div>
                    </div>

                    <!-- BODY DO PANEL -->
                    <div class="panel-body" style="padding: 24px;">
                        
                        <!-- BLOCO DE AUDITORIA (Exibido apenas quando existir ID cadastrado) -->
                        <logic:present property="tela.id" name="telaForm">
                            <div class="row" style="margin-bottom: 20px;">
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3" style="padding-right: 0px;">
                                    <div class="alert alert-info fonte-auditoria" role="alert" style="padding-bottom: 5px; padding-top: 5px; margin-bottom: 0px;">
                                        <i class="fa fa-user-plus"></i>
                                        &nbsp;${telaForm.tela.nomeUsuarioCriacao}
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3" style="padding-right: 0px; padding-left: 0px;">
                                    <div class="alert alert-info fonte-auditoria" role="alert" style="padding-bottom: 5px; padding-top: 5px; margin-bottom: 0px;">
                                        <i class="fa fa-calendar-plus-o"></i>
                                        &nbsp;${telaForm.tela.dataOcorrenciaCriacao}
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3" style="padding-right: 0px; padding-left: 0px;">
                                    <div class="alert alert-warning fonte-auditoria" role="alert" style="padding-bottom: 5px; padding-top: 5px; margin-bottom: 0px;">
                                        <i class="fa fa-refresh"></i>
                                        &nbsp;${telaForm.tela.nomeUsuarioAlteracao}
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3" style="padding-left: 0px;">
                                    <div class="alert alert-warning fonte-auditoria" role="alert" style="padding-bottom: 5px; padding-top: 5px; margin-bottom: 0px;">
                                        <i class="fa fa-calendar-o"></i>
                                        &nbsp;${telaForm.tela.dataOcorrenciaAlteracao}
                                    </div>
                                </div>
                            </div>
                        </logic:present>

                        <!-- Campos de Dados da Entidade (In-line responsivo) -->
                        <div class="flex flex-col lg:flex-row lg:space-x-6 space-y-4 lg:space-y-0">
                            <!-- Campo Nome -->
                            <div class="flex flex-col flex-grow fonte-campos">
                                <label class="font-semibold text-gray-800 mb-1" for="nomeTela">
                                    Nome: <span class="text-red-600">*</span>
                                </label>
                                <html:text styleId="nomeTela" property="tela.nome" styleClass="px-3 py-2 border rounded-md focus:outline-none bg-gray-50 form-control input-borda-sistema"/>
                            </div>

                            <!-- Campo Query -->
                            <div class="flex flex-col fonte-campos">
                                <label class="font-semibold text-gray-800 mb-1" for="queryTela">
                                    Query: <span class="text-red-600">*</span>
                                </label>
                                <html:select styleId="queryTela" property="tela.query" styleClass="px-3 py-2 border rounded-md focus:outline-none bg-gray-50 form-control input-borda-sistema">
                                    <html:option value="">Selecione...</html:option>
                                    <html:option value="true">Sim</html:option>
                                    <html:option value="false">Não</html:option>
                                </html:select>
                            </div>
                        </div>
                    </div>

                    <!-- FOOTER DO PANEL -->
                    <div class="panel-footer" style="background-color: #f8fafc; border-top: 1px solid #cbd5e1; padding: 15px 20px; text-align: right;">
                        <div class="flex flex-col lg:flex-row flex-wrap gap-2 justify-end">
                            <button type="button" class="w-full lg:w-auto btn btn-sistema btn-sm fonte-botao" onclick="abrirConfirmacao('Inserir', 'Deseja realmente cadastrar este registro?')">
                                <i class="fa fa-save"></i> Cadastrar
                            </button>
                            <button type="button" class="w-full lg:w-auto btn btn-sistema btn-sm fonte-botao" onclick="abrirConfirmacao('Alterar', 'Deseja realmente alterar este registro?')">
                                <i class="fa fa-edit"></i> Alterar
                            </button>
                            <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/restrito/admin/tela.src?method=Listagem'" class="w-full lg:w-auto btn btn-sistema btn-sm fonte-botao">
                                <i class="fa fa-list"></i> Listagem
                            </button>
                            <button type="button" class="w-full lg:w-auto btn btn-excluir-escuro btn-sm fonte-botao" onclick="abrirConfirmacao('Excluir', 'Deseja realmente excluir este registro?')">
                                <i class="fa fa-trash"></i> Excluir
                            </button>
                            <button type="button" class="w-full lg:w-auto btn btn-sistema btn-sm fonte-botao" onclick="abrirConfirmacao('Limpar', 'Deseja limpar os campos do formulário?')">
                                <i class="fa fa-eraser"></i> Limpar
                            </button>
                            <button type="button" class="w-full lg:w-auto btn btn-sistema btn-sm fonte-botao" onclick="abrirConfirmacao('Cancelar', 'Deseja sair e retornar à tela anterior?')">
							    <i class="fa fa-arrow-left"></i> Sair
							</button>                           
                        </div>
                    </div>

                </div>
            </html:form>
        </div>
    </div>
</div>

<!-- Script Específico e Regras de Validação desta Tela -->
<script>
    $(document).ready(function() {
        // Atributos required específicos desta tela
        $('#nomeTela').attr('required', 'true');
        $('#queryTela').attr('required', 'true');
    });

    // Implementação da função executada ao clicar em "Confirmar" na modal para esta tela
    function executarConfirmacaoAcao() {
        let form = document.getElementById('formPrincipal');

        // Se for Inserir ou Alterar, valida os campos exclusivos desta tela
        if (metodoAcaoAtual === 'Inserir' || metodoAcaoAtual === 'Alterar') {
            let nomeValido = document.getElementById('nomeTela').checkValidity();
            let queryValido = document.getElementById('queryTela').checkValidity();

            if (!nomeValido) {
                bootstrap.Modal.getInstance(document.getElementById('modalConfirmacao')).hide();
                document.getElementById('nomeTela').reportValidity();
                return;
            }
            if (!queryValido) {
                bootstrap.Modal.getInstance(document.getElementById('modalConfirmacao')).hide();
                document.getElementById('queryTela').reportValidity();
                return;
            }
        }

        // Submete o método correspondente para o Struts
        $('#methodAction').val(metodoAcaoAtual);
        form.submit();
    }
</script>