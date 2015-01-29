package prueba;



public class Calculadora {
	
	
	
	 int num=3;
	 Sumar sumar=new Sumar();
	 Restar restar= new Restar();
	 Multiplicar multiplicar =new Multiplicar();
	 Dividir dividir =new Dividir();
    
    		public int operacion(Metodo metodo , int a , int b){
    			short c =4;
    			return c;
    			
    			
    			//return  metodo.operacion(a , b);
    		}
    		public void  setNum(int nu){
    			num=nu;
    		
    		}
    		public int getNum(){
    			return num;
    		}
    		

    public static void main(String... args) {
        Calculadora calculadora = new Calculadora();
        int suma=calculadora.operacion(calculadora.sumar , 2, 3);
        int resta=calculadora.operacion(calculadora.restar, 4, 5);
        int multiplicacion = calculadora.operacion(calculadora.multiplicar, 3 ,4);
        int dividir = calculadora.operacion(calculadora.dividir,7,7);
        double m=multiplicacion;
        
        String a="hola"; 
        String  b="casa";
        a=a.replace('a','b');
       
        Object f ="3";
        boolean e = f instanceof String;
        System.out.println(e);
        /*String c="     CA BA   ";
        System.out.print(" : ");
        
        System.out.print(c);
        System.out.print(" : ");
        System.out.println("");
        System.out.print(" : ");
        System.out.print(c.trim());
        System.out.print(" : ");
        //System.out.println("suma: " + suma + " resta: " + resta + " multiplicacion:"+ multiplicacion + "  division:"+dividir);
         */
    }
}
	   

	


