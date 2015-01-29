<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type='text/javascript' src='js/validation.js'> </script>
<%String res=request.getParameter("user"); %>
<form name='formulario' action='registerUser.do'  onsubmit='return validacion()'method='POST'>

Usuario:  <input type="text" name="user" id="user"/> <BR>

Contraseña:  <input type="text" name='password' id="password"/><BR>

Confirmar contraseña:  <input type="text" name='confpassword' id='confpassword'/> <BR>

Nombre:<input type="text" name='name' id='name'/> <BR>

Apellido:  <input type="text" name="lastname" id="lastname"/> <BR>

Telefono: <input type="text" name="telephone" id="telephone"/> <BR>

Ciudad:  <input type="text" name="city" id="city"/> <BR>

<input type="submit"  name="register" value='Register'/>
</form>



</body>
</html>