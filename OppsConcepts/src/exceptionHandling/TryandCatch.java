package exceptionHandling;

public class TryandCatch {
	public static void main(String[] args) {
		int a, d;
		try {
			d = 0;
			a = 10 / d;
			System.out.println("this will not be printed");
		} catch (Exception e) {
			System.out.println("devide by zero. airthmetical exception"+ e.getMessage());
		}
		System.out.println("afer cathc statement");
		
		TryandCatch.subroutine();
	}
	
	
	static void subroutine() {
		int d=0;
		int a=20/0;
		
	}
}
