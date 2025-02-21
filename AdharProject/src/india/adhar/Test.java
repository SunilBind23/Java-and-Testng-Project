package india.adhar;

public class Test {

	
	public static void main(String[] args) {
		
	///  with a class you can call static methods and variables only
	
		///  with an object you can call 
	//	nonstatic and static methods and variables both	
		///  country - static var- default - "Bharat"
		Adhar a1=new Adhar();
		Adhar a2=new Adhar();
		a1.country="abcd";
		a1.adharNumber="2345";
		System.out.println(a2.country);
		System.out.println(a2.adharNumber);
		
		
		m1();
		System.out.println("hi");
	}

	public static Adhar ad1=new Adhar(); 
	public static void m1() {
		ad1=new Adhar();  //  8 byte  ram - nonstatic members
		 int x=100;
	}
	
	
	///  static variable + static method = class
	
	
	
}
