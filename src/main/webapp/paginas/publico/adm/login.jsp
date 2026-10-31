<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    </style>
</head>
<body>

    <div class="login-card">
        <h2>Gymsolutions</h2>
        
        <!-- O action aponta para a rota .src da nossa Action -->
        <form action="${pageContext.request.contextPath}/publico/admin/login.src?method=logar" method="post">
            
            <div class="form-group">
                <label>Usuário:</label>
                <input type="text" name="usuario" required />
            </div>
            
            <div class="form-group">
                <label>Senha:</label>
                <input type="password" name="senha" required />
            </div>
            
            <button type="submit" class="btn-submit">Logar</button>
            
        </form>
    </div>

</body>
</html>