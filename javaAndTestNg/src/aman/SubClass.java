package aman;

public class SubClass extends SuperClass {

	 void m1() {
		 
		 super.m1();
		
		System.out.println("child class method");
		
	}

	public static void main(String[] args) {
		SuperClass p = new SuperClass();
		p.m1(); // parant class method
		 
		SubClass p2 = new SubClass();
		p2.m1();
		// child class method

		SuperClass p1 = new SubClass();
		p1.m1();
		// parent class method

	}
}