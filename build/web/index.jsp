<%-- 
    Document   : index
    Created on : 22-nov-2017, 10:37:19
    Author     : alejandroquiros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Inicio</title>
</head>
<body>
<h1>Player. Obtiene todos los Player con EJB </h1>
<form  action="Servlet"  method="POST">Presiona  el botón para obtener los datos.
<input  type="submit"  name="enviar"  value="Enviar" />
</form>


<form  action="Insertar" method="POST">
<input type="text" name="insert">
<input  type="submit"  name="enviar"  value="Enviar" />
</form>
</body>
</html>
