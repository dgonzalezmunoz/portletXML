<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Codington JSP</h1>
   <form action="validacion.jsp">
   Nombre: <input type="text" name= "txtNombre"/> <br/>
   Password: <input type= "text" name= "txtPass"/> <br/>
   <input type="submit" value="Enviar"/>
   </form>
   
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
   <c:if test="${param['Error'] != null }">
		<h3> Usuario o contraseña incorrecta. </h3>
   	</c:if>
</body>
</html>