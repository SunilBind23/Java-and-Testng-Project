package aman;

import org.testng.annotations.*;

public class AllAnnotation {

	@BeforeSuite
	void bs() {
		System.out.println("this is before suite method...");

	}

	@AfterSuite
	void as() {
		System.out.println("this is after suite method ....");
	}

	@BeforeTest
	void bt() {
		System.out.println("this is  before test method...");
	}

	@AfterTest
	void at() {
		System.out.println("this is after test method...");
	}

	@Test(priority = 1)
	void tm1() {
		System.out.println("this is test1 method...");
	}

	@Test(priority = 2)
	void tm2() {
		System.out.println("this is test 2 method");

	}
	@AfterClass
	void ac() {
		System.out.println("this is after class method");
		
	}
	@BeforeClass
	void bc() {
		System.out.println("this is before class  method");
		
	}
	

}
