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
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var= "v" value= "${ sessionScope.visitante}" scope="page" />
<c:set var= "er" value= "${ sessionScope.eventosRegistrados[1]}" scope="page" />
<c:set var= "e" value= "${ sessionScope.eventos[1]}" scope="page" />



<table border=0 style="border:3px solid #D8D8D8;">
	
	<tr>
		<td align='center' bgcolor="04B4AE" width="400px;"> <h2>Festival Registration System</h2></td>
	</tr>
	
	<tr>
		<td align='right'> <a href="" >Logout </a>
							<a href="" >Event_Catalog </a>
							<a href="" >About </a>
		</td> 

	<tr>
		<td> <h3>Festival Portal Page: Welcome ${v.userName} to your portal page... </h3> </td>
	</tr>	
	<tr><td> Your personal information is below. To change your information <a href="actualizarUser.jsp" >click:here </a>.</td></tr>
	<tr><td> Username: ${v.userName} </td></tr>
	<tr><td> Visitor ID: </td></tr>
	<tr><td> Email: ${v.email}</td></tr>
	<tr><td> Phone No: ${v.phoneNumber} </td></tr>
	<tr><td> Address: ${v.address} </td></tr>

	
<!-- 	<td> <hr bgcolor="04B4AE"></td> </tr> -->
	
</table>  

<h3>To release a ticket you have for an up-coming attraction, please find the attraction below, 
	and click the Release link. </h3>
<table border=2,  bordercolor=D8D8D8>
		<tr bgcolor=#04B45F ><td><h4>Confirmation</h4></td><td><h4>Event id</h4></td><td><h4>Event name</h4></td>
		<td><h4> Description</h4> </td><td><h4>Places</h4></td><td><h4>Duration</h4>
		</td><td><h4>Event type</h4></td><td><h4>Action</h4></td>
		</tr>
	<c:forEach var="event" items="${sessionScope.eventosRegistrados}"> 
		<tr><td>Confirmation</td><td>${event.eventId}</td><td>${event.name}</td><td> ${event.description} </td>
			<td>${event.place}</td><td>${event.duration}</td><td>${event.eventType}</td>
			<td><a href="principal.jsp" > Release </a> </td>
		</tr>
 	</c:forEach>
 </table> 

<h3>To get a ticket for an up-coming attraction, please find the attraction below, 
    and click the Register link. </h3>

<table border=2,  bordercolor=D8D8D8>
		<tr bgcolor=#04B45F ><td><h4>Event id</h4></td><td><h4>Event name</h4></td><td><h4> Description</h4> </td>
			<td><h4>Places</h4></td><td><h4>Duration</h4></td><td><h4>Event Type</h4></td>
			<td><h4>Available Tickets</h4></td>
		</tr>
	<c:forEach var="event" items="${sessionScope.eventos}"> 
		<tr><td>${event.eventId}</td><td>${event.name}</td><td> ${event.description} </td>
			<td>${event.place}</td><td>${event.duration}</td><td>${event.eventType}</td>
			<td>${event.seatsAEvent} seats left. <a href='registrarEventos.do?Evento=${event.eventId }' > Register </a> </td>
		</tr>
 	</c:forEach>
 </table> 


 
<%-- ${er.description} --%>

<%-- ${e.description } --%>

</body>
</html>