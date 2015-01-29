


/**
 * 
 */
function search(){
	var xml= document.getElementById('xml').value;
	var path=document.getElementById('path').value;
	var nodestr=readxml(xml,path);
	document.getElementById("resultpath").innerHtml=nodestr;
	
}

function readxml(xml,path){

	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.open("GET",xml,true);
	xmlhttp.send();
	
	
	try {xhttp.responseType="msxml-document"} catch(err) {} 
	xm=xmlhttp.responseXML;
	var strxml=xmlhttp.responseText;
	document.getElementById("resultxml").textContent=strxml;
	
	if (window.ActiveXObject || xmlhttp.responseType=="msxml-document")
	{
		
		xm.setProperty("SelectionLanguage","XPath");
		nodes=xm.selectNodes(path);
		var stringnodes="";
		for (i=0;i<nodes.length;i++)
		  {
		  var stringnodes=nodes[i].childNodes[0].nodeValue+stringnodes;
		  var stringnodes="<br>"+stringnodes;
		  }
		


	}
	else if(document.implementation && document.implementation.createDocument){
		
	    nodes=xm.evaluate(path, xm,function(prefix) {  return "http://www.w3schools.com"; },  XPathResult.ANY_TYPE, null);
	    var result=nodes.iterateNext();

	    while (result)
	      {
	     var stringnodes=result.childNodes[0].nodeValue;
	      var stringnodes=stringnodes+"<br>";
	      result=nodes.iterateNext();
	      }
	return stringnodes;
	}
}	
	



