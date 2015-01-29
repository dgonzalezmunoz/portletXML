<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Festival Event Registration System</title>
</head>
<body> 

<form action="buscarUsuario.do">
  <table border=0 style="border:3px solid #04B4AE;">
	
		<tr>
			<td align='center' bgcolor="04B4AE" width="400px;"> <h2>Festival Event Registration System</h2></td>
		</tr>
		
		<tr><td align='center'><h3>Portal Login Page</h3>  </td></tr>
	
		<tr><td align='center'>Usuario: <input type="text" name= "user"/> </td></tr>
		<tr><td align='center'>Password: <input name= "pwd" type="PASSWORD" /> </td></tr>
		<tr><td align='right'>  <input type="submit" value="Enviar"/> </td></tr>
		
		<tr><td> </td></tr>
		<tr><td> </td></tr>
		<tr><td> </td></tr>
		
		<tr><td>New Visitor </td></tr>
		<tr><td> <a href="" > Register here </a></td></tr>
   
   </table>
</form>

   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
   <c:if test="${error== 'error' }">
		<h3> Usuario o contraseña incorrecta. </h3>
   	</c:if>

</body>
</html> 