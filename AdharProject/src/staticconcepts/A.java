package staticconcepts;

public class A {

	public static int StNum1;
	
	public static int StNum2;
	
	///  public private default
	
	public static void work1(String b) {
		StNum1=100;
		
	}
    public static double work2() {
		double d=5.5;
		System.out.println(A.StNum1);
		StNum1=5000;
    	return d;
	}
	
//// there is only one loaded copy  of any class	
    /// there is only one copy of static variable
    
    
    
    
    
    
    
	
}
