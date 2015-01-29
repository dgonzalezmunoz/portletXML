/**
 * 
 */

function outputvalue(input, output)//Retrieves information of and input in some div
{
	
	
    var hf=document.getElementById(input) || 'error' 
    
	
	if(hf=='error')
	{
		alert('Don,t exists the name of the input: '+input);
	}	
	else
		{
		hf=hf.value;
		document.getElementById(output).innerHTML=hf ;
		}
	return hf
	
}