package exceptionHandling;

public class MultipleTryCatch {

	public static void main(String[] args) {
		// main try block
		try {
			System.out.println("statement 1");
			System.out.println(5/0);
			System.out.println("statement 3");

			// try catch block within another try block
			try {
				System.out.println("statement 4");
				System.out.println(5 / 0);
				System.out.println("statement 6");

				// try catch block within nested try block
				try {
					System.out.println("statement 7");
					System.out.println(1/0);
				} 
				
				
				catch (ArithmeticException e2) {
					System.out.println("exception handled ! third inner block");
				} finally {
					System.out.println("finally block of 3rd inner catch block");
				}

			}
			
			catch (Exception e1) {
				System.out.println("inner  try ka catch block");
			} finally {
				System.out.println("finally block");
			}
		}
		
		
		
		// catch block of parent (outer) try block
		catch (NullPointerException e3) {

			System.out.println("first try ka catch block");
		} 
		
		finally {
			System.out.println(" block of first try finally ");
		}
	}
}
