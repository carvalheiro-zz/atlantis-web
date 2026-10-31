<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro Interno - Gymsolutions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .error-container {
            text-align: center;
            background: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            max-width: 480px;
            width: 90%;
        }
        h1 {
            font-size: 72px;
            margin: 0;
            color: #f39c12;
        }
        h2 {
            margin-top: 10px;
            font-size: 22px;
        }
        p {
            color: #666;
            font-size: 14px;
            line-height: 1.5;
            margin-bottom: 25px;
        }
        .btn-home {
            display: inline-block;
            background-color: #0056b3;
            color: #ffffff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
            transition: background 0.2s ease-in-out;
        }
        .btn-home:hover {
            background-color: #003d80; 
        }
    </style>
</head>
<body>

    <div class="error-container">
        <h1>500</h1>
        <h2>Erro Interno do Servidor</h2>
        <p>Ocorreu uma falha inesperada no processamento da sua requisição. Por favor, tente novamente em instantes.</p>
        <a href="${pageContext.request.contextPath}/home.src" class="btn-home">Voltar ao Início</a>
    </div>

</body>
</html>