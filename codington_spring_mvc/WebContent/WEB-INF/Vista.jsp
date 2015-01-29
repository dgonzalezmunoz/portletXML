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
<table border=2,  bordercolor=D8D8D8>
		<tr bgcolor=#04B45F ><td><h4>Event id</h4></td><td><h4>Event name</h4></td><td><h4> Description</h4> </td>
			<td><h4>Places</h4></td><td><h4>Duration</h4></td><td><h4>Event Type</h4></td>
			<td><h4>Available Tickets</h4></td>
		</tr>
	<c:forEach var="event" items="${requestScope.list}"> 
		<tr><td>${event.eventId}</td><td>${event.name}</td><td> ${event.description} </td>
			<td>${event.place}</td><td>${event.duration}</td><td>${event.eventType}</td>
			<td>${event.seatsAEvent} seats left.  </td>
		</tr>
 	</c:forEach>
 </table> 
</body>
</html>