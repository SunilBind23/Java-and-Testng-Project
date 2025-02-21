package Exceptions;

public class SimpleTryCatchExample {

	public static void main(String[] args) {
		int a, d;
		try {
			a = 0;
			d = 10 / 0;
			System.out.println("this will not be printed");
		} catch (Exception e) {
			System.out.println("division by zero ArithmeticException");
		} finally {
			System.out.println("finally block statement");
		}
		System.out.println("after catch statement");
	}

}
