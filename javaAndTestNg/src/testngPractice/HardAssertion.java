package testngPractice;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	void test() {
		
		//Assert is a class and thies all method static
		
		
		//Assert.assertEquals("xyz", "xyz"); pass 
		//all data type can compare with this
		
		//Assert.assertEquals(123, 123); pass 
		
		//Assert.assertEquals("abc", 123); fail
		//Assert.assertEquals("123", 123); fail
		
		//Assert.assertNotEquals(123, 234); // true -pass
		//Assert.assertNotEquals(123, 123); // false fail
		
		//Assert.assertTrue(true); // true--pass
		//Assert.assertTrue(1==2); // false--fail
		//Assert.assertTrue(1==1); // true--pass
		
		//Assert.assertFalse(1==2); // true--pass
		//Assert.assertFalse(1==1); // fail--false
		
		Assert.fail();
		
	}
}
