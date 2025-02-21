package testngPractice;

import org.testng.annotations.Test;

public class PaymentTests {
	// This all comes under sanity and regression(functional)
	@Test(priority = 2, groups = { "sanity", "regression","functional" })
	
	void PaymentInRupees()
	{
		System.out.println("payment in rupees....");
	}

	@Test(priority = 2, groups = { "sanity", "regression" ,"functional"})
	
	void PaymentInDollers()
	{
		System.out.println("payment in dollers...");
	}
}
