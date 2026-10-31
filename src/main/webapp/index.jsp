<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Redireciona no lado do servidor de forma limpa e imediata
    response.sendRedirect(request.getContextPath() + "/publico/admin/login.src?method=abrir");
%>