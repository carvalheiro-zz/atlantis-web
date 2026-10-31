<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-dark bg-dark px-4 py-2 w-100 flex justify-between items-center">
    <!-- Esquerda: Logo e Nome do Sistema -->
    <div class="flex items-center space-x-3">
        <a class="navbar-brand flex items-center text-decoration-none text-white font-bold text-lg" href="#">
            <img src="${pageContext.request.contextPath}/assets/logos/logo.png" alt="Logo" class="h-8 w-auto mr-2 inline-block object-contain" />
            Atlantis Web
        </a>
    </div>

    <!-- Centro: Relógio Digital -->
    <div class="flex items-center space-x-2 text-white bg-gray-800 px-3 py-1.5 rounded-md border border-gray-700 shadow-inner">
        <i class="fa-regular fa-clock text-gray-400"></i>
        <span id="digital-clock" class="text-sm font-mono tracking-wider text-gray-200">00:00:00</span>
    </div>

    <!-- Direita: Usuário e Botão Sair -->
    <div class="flex items-center space-x-4 text-sm text-white">
        <span class="text-gray-300">
            <i class="fa-solid fa-user mr-1"></i> Usuário Simulado (Admin)
        </span>        
        <a href="${pageContext.request.contextPath}/publico/admin/login.src?method=sair" class="btn btn-outline-light btn-sm">
            <i class="fa-solid fa-right-from-bracket mr-1"></i> Sair
        </a>
    </div>
</nav>

<!-- Script para atualizar o relógio digital em tempo real -->
<script>
    function updateClock() {
        const now = new Date();
        
        const hours = String(now.getHours()).padStart(2, '0');
        const minutes = String(now.getMinutes()).padStart(2, '0');
        const seconds = String(now.getSeconds()).padStart(2, '0');

        const digitalClock = document.getElementById('digital-clock');
        if (digitalClock) {
            digitalClock.innerText = hours + ':' + minutes + ':' + seconds;
        }
    }

    setInterval(updateClock, 1000);
    updateClock();
</script>