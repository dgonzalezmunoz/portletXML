/**
 * 
 */



questions=['Cual es la cima mas alta del continente europeo?'
           ,'Como se llamaban los reyes catolicos?',
           'Como se llamaba la primera maquina programable?',
           'Cual es el SI de medida del peso?'];

posanswers=[['Elbrus','Montblanc','Aneto', 'Teide']
          ,['Juana I y Felipe I ','Isabel y Fernando V','Carlos I e Isabel de Portugal', 'Isabel y Fernando IV']
          ,['ENIAC','Z1','Z3','Colossus']
          ,['Kg','g','mg','Newton']];     

resans=['Elbrus','Isabel y Fernando V','Z1','Newton'];

         
          


cont=4;
rand=0;
punt=0;

function randquest()
{
	
	
	//rand=parseInt(Math.random()*i);
	
	if(rand<4)
	{
		document.getElementById('question').innerHTML= questions[rand];
		document.master.answers.options[0]=new Option(posanswers[rand][0]);
		document.master.answers.options[1]=new Option(posanswers[rand][1]);
		document.master.answers.options[2]=new Option(posanswers[rand][2]);
		document.master.answers.options[3]=new Option(posanswers[rand][3]);



		  
			
	}
	else
	{
		document.location.href="index.html" 

	}
}

function puntuacion(x)
{

 var select=document.master.answers;
 var answeruser=select.options[select.selectedIndex].value;
 if(answeruser==resans[x-1])
	
     {
	 document.getElementById('corrincorr').innerHTML='CORRECTO'
	 punt=punt+1;
	 }
 else
	 {
	 document.getElementById('corrincorr').innerHTML='INCORRECTO'
	 }

		
   
 document.getElementById('puntuacion').innerHTML='La puntuacion es '+ punt;

}	
    



function contador()
{
	rand=rand+1;
	return rand;
	
}







