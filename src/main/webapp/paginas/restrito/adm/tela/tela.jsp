<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="container-fluid" style="margin-top: 20px;">
    <!-- TRATAMENTO DE MENSAGENS (ACTION MESSAGES) -->
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <logic:messagesPresent message="false">
                <div class="p-4 mb-4 text-red-700 bg-red-100 rounded-lg alert border border-red-300 fonte-mensagem" role="alert">
                    <html:errors/>
                </div>
            </logic:messagesPresent>

            <logic:messagesPresent message="true">
                <div class="p-4 mb-4 text-green-700 bg-green-100 rounded-lg alert border border-green-300 fonte-mensagem" role="alert">
                    <html:messages id="msg" message="true">
                        <bean:write name="msg"/><br/>
                    </html:messages>
                </div>
            </logic:messagesPresent>
        </div>
    </div>

    <!-- FORMULÁRIO / PANEL PRINCIPAL -->
    <div class="row">
        <div class="col-md-offset-2 col-lg-offset-2 col-xs-12 col-sm-12 col-md-8 col-lg-8">
            <html:form action="/restrito/admin/tela" method="post">
                <!-- Campos ocultos de controle (ID e Versão para Bloqueio Otimista) -->
                <html:hidden name="telaForm" property="tela.id"/>
                <html:hidden name="telaForm" property="tela.versao"/>

                <div class="panel panel-default sombra" style="border-color: #cbd5e1;">
                    
                    <!-- HEADER DO PANEL -->
                    <div class="panel-heading" style="background-color: #eff6ff; border-bottom: 1px solid #bfdbfe; padding: 15px 20px;">
                        <div style="display: flex; align-items: center; gap: 10px;">
                            <i class="fa fa-desktop text-blue-600" style="font-size: 18px; color: #1e3a8a;"></i>
                            <h3 class="panel-title fonte-titulo-tela" style="font-weight: bold; color: #1e3a8a; margin: 0;">Cadastro de Tela</h3>
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
                                <label class="font-semibold text-gray-800 mb-1" for="nomeTela">Nome:</label>
                                <html:text styleId="nomeTela" property="tela.nome" styleClass="px-3 py-2 border rounded-md focus:outline-none bg-gray-50 form-control input-borda-sistema"/>
                            </div>

                            <!-- Campo Query -->
                            <div class="flex flex-col fonte-campos">
                                <label class="font-semibold text-gray-800 mb-1" for="queryTela">Query:</label>
                                <html:select styleId="queryTela" property="tela.query" styleClass="px-3 py-2 border rounded-md focus:outline-none bg-gray-50 form-control input-borda-sistema">
                                    <html:option value="">Selecione...</html:option>
                                    <html:option value="true">Sim</html:option>
                                    <html:option value="false">Não</html:option>
                                </html:select>
                            </div>
                        </div>
                    </div>

                    <!-- FOOTER DO PANEL (Com botões de ação na ordem solicitada e ícones) -->
                    <div class="panel-footer" style="background-color: #f8fafc; border-top: 1px solid #cbd5e1; padding: 15px 20px; text-align: right;">
                        <div style="display: flex; flex-wrap: wrap; gap: 8px; justify-content: flex-end;">
                            <button type="submit" name="method" value="Inserir" class="btn btn-sistema btn-sm fonte-botao">
                                <i class="fa fa-save"></i> Cadastrar
                            </button>
                            <button type="submit" name="method" value="Alterar" class="btn btn-sistema btn-sm fonte-botao">
                                <i class="fa fa-edit"></i> Alterar
                            </button>
                            <button type="submit" name="method" value="Listagem" class="btn btn-sistema btn-sm fonte-botao">
                                <i class="fa fa-search"></i> Listagem
                            </button>
                            <button type="submit" name="method" value="Excluir" class="btn btn-excluir-escuro btn-sm fonte-botao">
                                <i class="fa fa-trash"></i> Excluir
                            </button>
                            <button type="submit" name="method" value="Limpar" class="btn btn-sistema btn-sm fonte-botao">
                                <i class="fa fa-plus"></i> Novo
                            </button>
                            <button type="submit" name="method" value="cancelar" class="btn btn-default btn-sm fonte-botao">
							    <i class="fa fa-arrow-left"></i> Sair
							</button>                           
                        </div>
                    </div>

                </div>
            </html:form>
        </div>
    </div>
</div>