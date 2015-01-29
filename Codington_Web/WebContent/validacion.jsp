<%@page import="es.coritel.codington.festival.domain.Visitor"%>
<%@page import="es.coritel.codington.festival.services.VisitorService"%>
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

<c:set var="nombre" value="${param['txtNombre']}" scope="page"/>
<c:set var="password" value="${param['txtPass']}" scope="page"/>

<jsp:useBean id="visitante" class="com.codignton.servlet.VisitorBean" scope="application" />
<jsp:setProperty property="user" param="txtNombre" name="visitante"/>
<jsp:setProperty property="pass" param="txtPass" name="visitante"/>

<c:set var="v" value="${visitante.buscar }" scope="request"/>

<%-- ${v.firstName } --%>

<c:if test="${(v.userName==nombre) && (v.password==password)}">
	<jsp:forward page="datos.jsp"/>	
</c:if>

<c:if test="${(v.userName!=nombre) || (v.password!=password)}">
	<jsp:forward page="Principal.jsp">
		<jsp:param value="error" name="Error"/>
	</jsp:forward>
</c:if>


</body>
</html>