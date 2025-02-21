package exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class Sample {
	public static void multipleTryCatch() {
		try {
			System.out.println("statement 1");
			System.out.println("statement 2");
			System.out.println("statement 3");
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			// System.out.println("may be object is initilized with null");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("statement 4");
		}
		System.out.println("Code is going continue");

	}

	public void m2() {
		int num1 = 1, num2 = 0, num3 = 3;
		try {
			System.out.println("statement 1");
			System.out.println("statement 2");
			System.out.println(num1 / num2);
		} catch (ArithmeticException e) {
			System.out.println(e.toString());

			try {
				System.out.println();
				System.out.println(num1 / num3);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			System.out.println("statement 4");
		}
		System.out.println("statement 5");
	}

	public void finallyBlockStatement() {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("C:/abcd/xyz.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		Sample rn = new Sample();
		//rn.m2();
		rn.finallyBlockStatement();
		// multipleTryCatch();
	}

}
