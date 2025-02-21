package exceptionHandling;

public class Child extends parent {
	public  void method1() {
		System.out.println("child method");
	}

	public static void main(String[] args) {

		Child ch = new Child();
		parent p = new Child();
		p.method1(); // output: parent method //
		ch.method1(); // output: child method
	}
}
