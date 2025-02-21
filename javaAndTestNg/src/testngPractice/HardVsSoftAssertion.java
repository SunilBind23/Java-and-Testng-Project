package testngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {

//	@Test
//	void test_hardAssertion() {
//		System.out.println("testing.....");
//		System.out.println("testing.....");
//
//		Assert.assertEquals(1, 2); // hard assertion
//
//		System.out.println("testing.....");
//		System.out.println("testing.....");
//	}

	@Test
	void test_softAssertion() {

		System.out.println("testing.....");
		System.out.println("testing.....");

		SoftAssert sa = new SoftAssert(); //// soft assertion

		sa.assertEquals(1, 2);

		System.out.println("testing.....");
		System.out.println("testing.....");
		sa.assertAll(); /// mandatory
	}
}
