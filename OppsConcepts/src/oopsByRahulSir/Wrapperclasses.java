package oopsByRahulSir;

public class Wrapperclasses {
	static Integer it1;

	public static void main(String[] args) {
		System.out.println(it1);
		int num = 100; // 4 byte
		String str = "sunil";
		Integer num2 = 12345; // 8 byte because it is class
		double db = num2.doubleValue();
		System.out.println(db);
		int intval = num2.intValue();
		System.out.println(intval);

		String x = "100";
		System.out.println("i am string " +  x);
		
	int vl=	Integer.parseInt(x);
	System.out.println(vl*5);
	
	
	
	}
	
		
	
	
}
