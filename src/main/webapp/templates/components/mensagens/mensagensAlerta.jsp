<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!-- TRATAMENTO GENÉRICO DE MENSAGENS (ACTION MESSAGES) COM TIMEOUT DE 5s -->
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <logic:messagesPresent message="false">
            <div id="alertaErro" class="p-4 mb-4 text-red-700 bg-red-100 rounded-lg alert border border-red-300 fonte-mensagem transition-opacity duration-500" role="alert">
                <html:errors/>
            </div>
        </logic:messagesPresent>

        <logic:messagesPresent message="true">
            <div id="alertaSucesso" class="p-4 mb-4 text-green-700 bg-green-100 rounded-lg alert border border-green-300 fonte-mensagem transition-opacity duration-500" role="alert">
                <html:messages id="msg" message="true">
                    <bean:write name="msg"/><br/>
                </html:messages>
            </div>
        </logic:messagesPresent>
    </div>
</div>

<script>
    $(document).ready(function() {
        // Aguarda 5 segundos e esmaece/remove os alertas automaticamente
        setTimeout(function() {
            $('#alertaErro, #alertaSucesso').fadeOut(500, function() {
                $(this).remove();
            });
        }, 5000);
    });
</script>