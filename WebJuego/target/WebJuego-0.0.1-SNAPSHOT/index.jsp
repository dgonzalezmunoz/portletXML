<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web</title>
<IMG SRC=logo.png   WIDTH=100 HEIGHT=100 ALIGN=LEFT >
</IMG>
<SCRIPT type="text/javascript"  src=popup.js>

</SCRIPT>


<SCRIPT type="text/javascript"  src="hola.js">

</SCRIPT>




<NOSCRIPT>


</NOSCRIPT>


</IMG>
</HEAD>
<BODY BGCOLOR="#FFFFFF" TEXT="#00000" LINK="#0000FF" 
VLINK="#0000FF" ALINK="#0000FF">


<H1>Calculadora</H1> 
<BR><FORM > 
Introduzca expresión: 
<INPUT TYPE="text" NAME="expr" SIZE=15> 
<INPUT TYPE="button" VALUE="Calcular" onClick="calcula(this.form)"> 
<BR> 
Resultado: 
<INPUT TYPE="text" NAME="resultado" SIZE=15> 
<BR> 
</FORM>
<SCRIPT type="text/javascript">
  document.write('La fecha de hoy es:'+retornarFecha());
  document.write('<br>');
  document.write('La hora es:'+retornarHora());
</SCRIPT>
</BODY> 

</html>