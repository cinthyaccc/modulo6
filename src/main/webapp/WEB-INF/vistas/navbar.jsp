<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Encabezado y enlaces CSS aquí -->
</head>
<body>
    <div class="navbar-container">
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <div class="container">
                <a class="navbar-brand" href="#" style="color: white;">Prevención</a>

                <div class="navbar-nav ml-auto" id="navbar-list">
                    <a class="nav-link" href="/modulo6/" style="color: white;">Inicio</a>
                    <%-- Verificar si el usuario NO está autenticado --%>
                    <% if (request.getRemoteUser() == null) { %>
                        <a class="nav-link" href="Contacto" style="color: white;">Contacto</a>
                        <a class="nav-link" href="login" style="color: white;">Login</a>
                    <% } %>
                    <%-- Verificar si el usuario tiene el rol "cliente" --%>
                    <% if (request.isUserInRole("cliente")) { %>
                        <a class="nav-link" href="CrearCapacitacion" style="color: white;">Crear Capacitación</a>
                        <a class="nav-link" href="ListarUsuarios" style="color: white;">Listar Usuarios</a>
                    <% } %>
                    <%-- Verificar si el usuario tiene el rol "administrativo" --%>
                    <% if (request.isUserInRole("administrativo")) { %>
                        <a class="nav-link" href="ListarCapacitaciones" style="color: white;">Listar Capacitaciones</a>
                    <% } %>
                    <%-- Verificar si el usuario está autenticado --%>
                    <% if (request.getRemoteUser() != null) { %>
                        <h3>Este contenido solo se mostrará a usuarios autenticados.</h3>
                    <% } %>
                </div>
            </div>
        </nav>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
