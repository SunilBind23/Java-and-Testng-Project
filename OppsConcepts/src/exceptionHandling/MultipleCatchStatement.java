package exceptionHandling;

public class MultipleCatchStatement {

	public static void main(String[] args) {
		try {
			int a = args.length;
			System.out.println("a = " + a);
			int b = 10 / a;
			int c[] = { 1 };
			c[10]=10;
		}
		catch (ArithmeticException e) {
			System.out.println("divide by zero!" + e);
	}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("array index bound of " + e);
		}
		System.out.println("after try/catch blocks.");
	}

}
