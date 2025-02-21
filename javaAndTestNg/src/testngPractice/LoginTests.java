package testngPractice;

import org.testng.annotations.Test;

public class LoginTests {
	// thies all comes in sanity testing
	@Test(priority = 1, groups = { "sanity" })
	void LoginByEmail() {
		System.out.println("this is login by email");
	}

	@Test(invocationCount = 5,priority = 2, groups = { "sanity" })
	void LoginByFacebook() {
		System.out.println("this is login by facebook");
	}

	@Test(priority = 3, groups = { "sanity" })
	void LoginByPhoneNumber() {
		System.out.println("this is login by phonenumber");
	}

	@Test(priority = 4, groups = { "sanity" })
	void LoginByTwiter() {
		System.out.println("this is login by twiter");
	}
}
