<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Atlantis Web</title>

    <!-- Bootstrap 5 CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Tailwind CSS Play CDN -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-100 min-h-screen flex flex-col m-0 p-0 overflow-x-hidden">

    <!-- 1. HEADER (De ponta a ponta na parte superior) -->
    <header class="w-full bg-dark text-white shadow-md z-50">
        <tiles:insert name="header" />
    </header>

    <!-- 2. CONTAINER CENTRAL (Menu na esquerda e Body na direita) -->
    <div class="flex flex-1 w-full relative min-h-[calc(100vh-120px)]">
        
        <!-- MENU (Lateral Esquerda) -->
        <aside class="w-64 bg-white border-r border-gray-200 shadow-sm flex-shrink-0 p-4">
            <tiles:insert name="menu" />
        </aside>

        <!-- BODY (Conteúdo Principal à direita do menu) -->
        <main class="flex-1 p-6 bg-gray-50 overflow-y-auto">
            <div class="container-fluid">
                <tiles:insert name="body" />
            </div>
        </main>
    </div>

    <!-- 3. FOOTER (De ponta a ponta na parte inferior) -->
    <footer class="w-full bg-dark text-white text-center py-3 shadow-inner z-50 mt-auto">
        <tiles:insert name="footer" />
    </footer>

    <!-- Bootstrap 5 Bundle JS (Inclui Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html:html>