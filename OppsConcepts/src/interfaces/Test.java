package interfaces;

public class Test implements MultipleInheritance ,StudentDetails,Animal {

	public static void main(String[] args) {
		Test rn=	new Test();
		rn.calData();
		rn.showData();
		rn.getData();
		rn.color();
		rn.voice();
		rn.m1();
		rn.m2();
		
	}

	@Override
	public void getData() {
		System.out.println("i am get data method");
		
	}

	@Override
	public void calData() {
		System.out.println("i am  caldata method");
	}

	@Override
	public void showData() {
		System.out.println("i am show data method ");
		
	}

	@Override
	public void m1() {
		System.out.println("i am method 1");
	}

	@Override
	public void m2() {
			System.out.println("i am method 2");
	}

	@Override
	public void voice() {
			System.out.println("i am animal interface method");
	}

	@Override
	public void color() {
		System.out.println("alse i am animal interface color method");
	}

}
