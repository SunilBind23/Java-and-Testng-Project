package OopsByRinkuSir;

public class polymorphism {

	public static void roundoff(int num) {
		System.out.println("i am int type");
	}

	public static void roundoff(float num) {
		System.out.println("i am float type");
	}

	public static void roundoff(long num) {
		System.out.println("i am long type");
	}

	public static void roundoff() {
		System.out.println("i am no args method");

	}

//	public static void roundoff(int num1, int num2) {
//		System.out.println("i am int int method");
//	}

	public static void roundoff(String str) {
		System.out.println("string");
	}

	public static void roundoff(Object ob) {

	}

	// same lavel===string and string buffer is the same label class
	// in this case we will get cimpile time error

	public static void roundoff(StringBuffer str) {
		System.out.println(" string buffer method");
	}

	public static void roundoff(byte bt) {
		System.out.println("127 range!");
	}

	public static void roundoff(int str, float flt) {
		System.out.println("int float");
	}

	public static void roundoff(float flt, int i) {
		System.out.println("float int");
	}

	public static void main(String[] args) {
		// polymorphism.roundoff();
		polymorphism run = new polymorphism();
		polymorphism.roundoff(run);
		// polymorphism.roundoff(null);

//		byte b=5;
//		polymorphism.roundoff(b);
		// polymorphism.roundoff(1,1);// no same match so that this line give the
		// cimpile time error
		polymorphism.roundoff(1,1.1f);
		polymorphism.roundoff(1.1f,1);
	}
}
