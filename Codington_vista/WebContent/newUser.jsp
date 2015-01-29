<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:set var= "v" value= "${ sessionScope.visitante}" scope="page" /> --%>
<form action="actualizarDatos.do">
	<table border=0 style="border:3px solid #04B4AE;">
	
		<tr>
			<td align='center' bgcolor="04B4AE" width="400px;"> <h2>Festival Registration System</h2></td>
		</tr>
	
		<tr><td align='right'> <a href="" >Logout </a><a href="" >About </a></td> <tr>
		
		<tr><td>First Name: <input type="text" name= "firstname" /></td></tr>
		<tr><td>Last Name: <input type="text" name= "lastname" /></td></tr>
		<tr><td>User Name: <input type="text" name= "user" /> <br/></td></tr>
		<tr><td>*Password: <input name= "pwd" type="PASSWORD" /></td></tr>
		<tr><td>*Confirm Password: <input name= "cpwd" type="PASSWORD" /></td></tr>
		<tr><td>Email: <input type="text" name= "email" /> </td></tr>
		<tr><td>Phone No: <input type="text" name= "phone" /></td></tr>
		<tr><td>Address: <input type="text" name= "address"/> </td></tr>
		<tr><td align='right'><input type="reset" value="Cancel" />
				<input type="submit" value="Update"/></td></tr>
		<tr><td></td></tr>

	</table>
   
   
</form>
</body>
</html>