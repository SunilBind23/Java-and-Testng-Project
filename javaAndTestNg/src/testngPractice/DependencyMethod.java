package testngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {
	// openapp
	// login
	// search
	// advanceSearch
	// logout
	@Test(priority = 1 )
	void OpenApp() {
		Assert.assertTrue(true);

	}

	@Test(priority = 2, dependsOnMethods= {"OpenApp"})
	void login() {
		Assert.assertTrue(true);

	}

	@Test(priority = 3,dependsOnMethods= {"login"})
	void search() {
		Assert.assertTrue(false);

	}

	@Test(priority = 4,dependsOnMethods= {"login","search"})
	void AdvanceSearch() {
		Assert.assertTrue(true);

	}

	@Test(priority = 5,dependsOnMethods= {"login"})
	void logout() {
		Assert.assertTrue(true);

	}
}
