package aman;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotetionMethos2 {
	/*1). login --@BeforeMethod
	 * 2). search @Test
	 * 3). logout @AfterMethod
	 * 4). Login
	 * 5). Advance search
	 * 6). Logout
	 */
	
	
	
	//========================Annotetions==================
	/*@Test
	 *@ BeforeMethod
	 *@ AfterMethod
	 *
	 *@ BeforeClass
	 *@ AfterClass
	 *
	 *@ BeforeTest
	 *@ AfterTest
	 *
	 *@BeforeSuit
	 *@AfterSuit
	 */

	
	/*==========xml formate===========
	 * <suit name="mysuit">
	 * 	<test name="mytest1">
	 * 		<classes>
	 * 			<class name="xyz">
	 * 		</classes>
	 * </test>
	 * <test name="mytest2">
	 * 		<classes>
	 * 			<class name="abc">
	 * 		</classes>
	 * </test>
	 * </suit>
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	public static void main(String[] args) {
			System.out.println("hello");
	}
	@BeforeClass
	void login() {
		System.out.println("this is login...");
	}
	@Test(priority=1)
	void search() {
		System.out.println("this is search...");
	}
	@AfterClass
	void logout() {
		System.out.println("this is logout method");
	}
	@Test(priority=2)
	void advanceSearch() {
		System.out.println("this is advance search...");
	}
	
	
}
