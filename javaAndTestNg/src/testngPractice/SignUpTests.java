package testngPractice;

import org.testng.annotations.Test;

public class SignUpTests {

	// thies all comes in Regression
	@Test(priority = 1, groups = { "regression" })
	void signUpByEmail() {
		System.out.println(" this is signUpByEmail ");
	}

	@Test(priority = 2, groups = { "regression" })
	void signUpByFacebook() {
		System.out.println(" this is signUpByFacebook");
	}

	@Test(priority = 3, groups = { "regression" })
	void signUpByNumber() {
		System.out.println(" this is signUpByNumber");
	}

	@Test(priority = 4, groups = { "regression" })
	void signUpByTwiter() {
		System.out.println(" this is signUpByTwiter");
	}
}
