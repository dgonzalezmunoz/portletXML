<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Barcino</title>
<script type='text/javascript' src='js/openpopup.js'>
</script>




</head>
<body>
 <form name='formulario' action='loginUser.do' method='post'>

<p>Nombre: </p> <input type="text"  name="user"/> <BR>

<p>Contraseña: </p> <input type="text" name="password"/><BR>

<input type="submit"  name="login" value='Log in'/>

</form>


<c:if test="${validation==false}"> 
<script>

	function alertpassuser(){
	alert("El usuario i/o la contraseña son incorrectas");
	}
    alertpassuser();

</script> 

</c:if>
<button onClick='register()'>Register</button>

</body>
</html>