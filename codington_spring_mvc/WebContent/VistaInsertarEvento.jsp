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

<form action="insert.do">
	<table border=0 style="border:3px solid #04B4AE;">
	
		<tr>
			<td align='center' bgcolor="04B4AE" width="400px;"> <h2>Festival Registration System</h2></td>
		</tr>
			
		<tr><td align='center'> <h3>New Event Registration Page </h3></td></tr>	
		<tr><td>Event Name: <input type="text" name= "eventname" /></td></tr>
		<tr><td>Event Description: <input type="text" name= "eventdescription" /></td></tr>
		<tr><td>Places: <input type="text" name= "places"/> <br/></td></tr>
		<tr><td>Duration: <input type="text" name= "duration" /> </td></tr>
		<tr><td>Event Type: <input type="text" name= "eventtype"/></td></tr>
		<tr><td>Available Tickets: <input type="text" name= "seatsavailable" /> </td></tr>
		<tr><td align='right'><input type="reset" value="Cancel" />
				<input type="submit" value="Update Event"/></td></tr>
		<tr><td></td></tr>

	</table>
   
   
</form>
</body>
</html>