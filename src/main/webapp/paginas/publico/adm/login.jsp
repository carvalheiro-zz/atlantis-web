<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Login - Gymsolutions</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f6f9; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .login-card { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 320px; }
        h2 { text-align: center; color: #333; margin-bottom: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-size: 14px; color: #555; }
        input[type="text"], input[type="password"] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn-submit { width: 100%; background-color: #0056b3; color: white; border: none; padding: 10px; border-radius: 4px; font-weight: bold; cursor: pointer; }
        .btn-submit:hover { background-color: #003d80; }
        .alerta-aba { display: none; background-color: #f8d7da; color: #721c24; padding: 10px; border-radius: 4px; margin-bottom: 15px; font-size: 13px; border: 1px solid #f5c6cb; }
    </style>
</head>
<body>

    <div class="login-card">
        <h2>Gymsolutions</h2>
        
        <div id="alertaAbaAtiva" class="alerta-aba">
            O sistema já está aberto e logado em outra aba. Feche esta aba e utilize a principal.
        </div>

        <form id="formLogin" action="${pageContext.request.contextPath}/publico/admin/login.src?method=logar" method="post">
            <div class="form-group">
                <label>Usuário:</label>
                <input type="text" name="usuario" required value="admin"/>
            </div>
            
            <div class="form-group">
                <label>Senha:</label>
                <input type="password" name="senha" required value="123"/>
            </div>
            
            <button type="submit" class="btn-submit">Logar</button>
        </form>
    </div>

    <script type="text/javascript">
        // Limpa apenas o ID isolado desta aba
        sessionStorage.removeItem('app_tab_id');

        // Intercepta o envio do formulário independente de quanto tempo a aba ficou parada
        document.getElementById('formLogin').addEventListener('submit', function(event) {
            var activeSystemTab = localStorage.getItem('active_system_tab');
            
            if (activeSystemTab) {
                try {
                    var activeData = JSON.parse(activeSystemTab);
                    // Se existe qualquer aba ativa registrada, bloqueia o submit
                    if (activeData && activeData.tabId) {
                        event.preventDefault();
                        document.getElementById('alertaAbaAtiva').style.display = 'block';
                        return false;
                    }
                } catch (e) {
                    console.error('Erro ao validar aba ativa no login', e);
                }
            }
        });
    </script>

</body>
</html>