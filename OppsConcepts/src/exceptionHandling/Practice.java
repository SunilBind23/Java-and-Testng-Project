package exceptionHandling;

public class Practice {

	public static void main(String[] args) {
		System.out.println("statemetn 1");
		
		try {
			String name="";
			System.out.println("statement 2");
			System.out.println(name);
		}catch(NullPointerException e) {
			System.out.println(e.getStackTrace());
			System.out.println("statment3");
			System.out.println(1/0);
			System.out.println("statemnt 4");
		}
		System.out.println("main method");
	}
	
}
