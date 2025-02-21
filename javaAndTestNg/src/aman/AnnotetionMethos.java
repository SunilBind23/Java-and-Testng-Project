package aman;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AnnotetionMethos {
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

	
	

	    @Parameters({"browser"})
	    @BeforeMethod
	    public void login(String browserName) {
	        System.out.println("Logging in using: " + browserName);
	        System.out.println("This is login...");
	    }

	    @Test(priority = 1)
	    public void search() {
	        System.out.println("This is search...");
	    }

	    @Test(priority = 2)
	    public void advanceSearch() {
	        System.out.println("This is advanced search...");
	    }

	    @AfterMethod
	    public void logout() {
	        System.out.println("This is logout method");
	    }
	}
