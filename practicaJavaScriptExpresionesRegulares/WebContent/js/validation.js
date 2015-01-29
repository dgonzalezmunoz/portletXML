/**
 * 
 */
function validacion()
{
	
	var array=["Por favor introduce correctamentes los siguientes campos:"];
	var iscorrect=true;
	if(document.getElementById('user').value=="" )
		{
		array.push(" nombre de usuario");
	    iscorrect=false;
		}
	//|| ! (/e/.test(document.getElementById('user').value)
	if(document.getElementById('password').value==""  )
	   {
		
		array.push(" contrase\u00f1a");
		iscorrect=false;
	   }
	if(document.getElementById('confpassword').value=="" )
	   {
		array.push(" confirmar contrase\u00f1a ");
		iscorrect=false;
	   }
	if(document.getElementById('name').value=="" )
	   {
		array.push(" nombre");
		iscorrect=false;
	   }
	if(document.getElementById('lastname').value=="" )
	   {
		array.push(" apellido");
		iscorrect=false;
	   }
	if(document.getElementById('telephone').value=="" || /[a-z]+/.test(document.getElementById('telephone').value))
	   {
		array.push(" tel\u00e9fono");
		iscorrect=false;
	   }
	if(document.getElementById('city').value=="" )
	   {
		array.push(" ciudad");
		iscorrect=false;
	   }
	if(document.getElementById('password').value!=document.getElementById('confpassword').value)
		{
		array.push('\n Los campos contrase\u00f1a y confirmar contrase\u00f1a deben de ser id\u00e9nticos');
		iscorrect=false;
		}
	if(!(/[a-z0-9.*+%&/?^${}!()|[\]\\]+/.test(document.getElementById('password').value)) || document.getElementById('password').value.length<8)
		{
		array.push('\n La contrase\u00f1a deber contener almenos 8 car\u00e1cteres, n\u00fameros, letras y alg\u00fan car\u00e1cter especial ');
		iscorrect=false;
		}
	 if(iscorrect==false){
	   alert(array.toString().replace(",",""));//con esto me cargo la primera coma y lo paso a String
	 }
	 return iscorrect;
	
	
	
	
	
}

