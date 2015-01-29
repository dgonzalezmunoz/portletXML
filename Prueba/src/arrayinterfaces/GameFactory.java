package arrayinterfaces;

public class GameFactory {

	public GameFactory() {
		
		// TODO Auto-generated constructor stub
	}
    public static void main(String ... args){
    	Movable [] a=new Movable[]{new Dog(), new Person() , new Rock() };
    
    	for(int i=0; i<a.length; i++){
    		System.out.println(a[i].isMovable());
    		
    		
    	}
    }

}
