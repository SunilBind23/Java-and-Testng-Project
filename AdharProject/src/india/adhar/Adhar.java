package india.adhar;

import java.util.Random;

public class Adhar {
///  create Adhar
/// adhar adreess
	
//  In a class one non static method can call
	///static and non-static methods and variables both	
	
//  In a class one static method can call
	///static  methods and variables only	
	public static String country="Bharat";
	
	public  String adharNumber;  
	
	public  String mobile="9876543210";  
	public  void m1() {
		createAdhar("");
	}
	
	public static void a1() {
		
		a2();
	}
	
	public static void a2() {
		
	}
	public  void m2() {
		createAdhar("");
	}
	public  void createAdhar(String name) {
		//  code -
		
		int a=100;
		///  static method anbd variable + nonstatic METHOD & VARIABLE
		System.out.println(country);
		Random rnd=new Random();
		adharNumber =""+rnd.nextInt(100000, 999999);
		//  adharNumber -  local variable - createAdhar method
		System.out.println("Creating Adhar-"+adharNumber);
	}
   
	public  void getAdharMobileNumber() {
    	///  code
		
		System.out.println("get Adhar Mobile detail for "+adharNumber);

    }
	
	public  void getAdharAddress() {
		///  code
		System.out.println("get Adhar Address detail"+adharNumber);
	}
	


    public  void getAdharDOB() {
		System.out.println("get Adhar DOB detail "+adharNumber+20);

	}
    
    public  void updateAdharMobileNumber() {
		System.out.println("update Adhar Mobile Number"+adharNumber);

    }
    
    
    
}
