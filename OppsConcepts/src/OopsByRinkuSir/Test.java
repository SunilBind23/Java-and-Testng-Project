package OopsByRinkuSir;

public class Test {
	public void method1(Animal a) {
		System.out.println("Animal version method !");
	}
	public void method1(Monkey a) {
		System.out.println("monkey version method !");
	}

	public static void main(String[] args) {
		Test ts =new Test();
		ts.method1(null);
		Animal a = new Animal();
		ts.method1(a);
		Monkey m = new Monkey();
		ts.method1(m);

		Animal am = new Monkey();
		ts.method1(am);
	}
}
