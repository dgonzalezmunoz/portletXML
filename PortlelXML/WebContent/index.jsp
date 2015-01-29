<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!--Estilo  !-->
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<!--scripts  !-->
	<script     src="js/readxml.js">
	</script>
	<title>Path xml</title>

</head>
<body>
	
   <h2 class="h2">Esta web  busca información a traves de una XPath</h2>
   <form >
     XML: <input type="text" id="xml"/> 
      <br/>
     Path:<input type="text" id="path"/> 
      <br/>
      <input type="button" value="Buscar" onClick='search()'>
         
   </form>
   <textarea id="resultxml" name="comentarios" rows="10" cols="40">
   
   </textarea>
   
   
   <div id='resultpath'>
   </div>


</body>
</html>