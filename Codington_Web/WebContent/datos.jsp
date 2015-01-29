<%@page import="es.coritel.codington.festival.services.VisitorService"%>
<%@page import="es.coritel.codington.festival.domain.Visitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


${requestScope.v.firstName } <br/>
${requestScope.v.lastName }  <br/>
${requestScope.v.dni }  <br/>
${requestScope.v.email } <br/>
${requestScope.v.phoneNumber }  <br/>
${requestScope.v.address }  <br/>
${requestScope.v.userName }  <br/>

</body>
</html>