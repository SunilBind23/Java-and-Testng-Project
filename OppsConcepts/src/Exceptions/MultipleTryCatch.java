package Exceptions;

public class MultipleTryCatch {

	public static void main(String[] args) {
		try {
			int a=args.length;
			System.out.println("a = " + a);
			//int b=10/a;
			int c[]= {1};
			c[10]=100;
			
		

	}catch(ArithmeticException e) {
		System.out.println("divided by zero !");
	}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("arrayIndexOutOfBoundsException !" + e1);
		}
		System.out.println("after try/catch blocks !");

	}
}
