package oopsByRahulSir;

public class Work {

	int x;

	public Work() {
		this.x = 200;
		System.out.println("after class loading value="+x);
	}

	public static void main(String[] args) {
		
		Work rn2 = new Work();
		
		
		rn2.x=100;
		System.out.println("before class loaded value="+rn2.x);
		
	
	}
}
