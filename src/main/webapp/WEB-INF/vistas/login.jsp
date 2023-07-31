<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/modulo6/css/styles.css">
<title>Login</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
body {
    background-image: url("/modulo6/img/imagen1.jpeg");
    background-repeat: no-repeat;
    background-size: cover;
}
</style>
</head>
<header><img class="imagen-zoom" src="/modulo6/resources/logoGrupo5.jpg" alt="Logo de la empresa"></header>
<body>
<section class="form-login">
<h5>Login</h5>
<form action="modulo6/login" method="post"> <!-- Utilizamos la sintaxis de Thymeleaf para el atributo 'action' -->
  <label for="nombre">Usuario:</label><br>
  <input class="caja" type="text" name="username" placeholder="Introduce nombre"><br><br> <!-- Corregimos el nombre del campo a 'username' -->

  <label for="pwd">Clave de acceso:</label><br>
  <input class="caja" type="password" name="password" placeholder="Introduce contraseña"><br><br>
  
  <div style="display: flex; justify-content: center;">
    <input type="submit" value="Ingresar" class="boton-enviar">
  </div>
</form>
</section>


</div>

</body>
</html>
