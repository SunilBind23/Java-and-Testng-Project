package testngPractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
 @Test
	void pqr() {
		System.out.println("this is xyz frome method c3...");
	}
 
 
 
 @AfterSuite
	void as() {
		System.out.println("this is after suite method...");
	}
 @BeforeSuite
 void bs() {
	 System.out.println("this is before suite method...");
 }
}
