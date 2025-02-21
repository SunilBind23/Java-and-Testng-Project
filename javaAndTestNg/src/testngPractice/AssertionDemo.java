package testngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {

	@Test
/*	public void testTitle() {
		String exp_title="Opencart";
		String act_title="Openshop";
		if(exp_title.equals(act_title)) {
			System.out.println("test pass");
			
		}else {
			System.out.println("test failed...");
			
		}
	}
	*/
	
		
		//Assert.assertEquals(exp_title, act_title);
	public void testTitle() {
		String exp_title="Opencart";
		String act_title="Openshop";
		if(exp_title.equals(act_title)) {
			System.out.println("test pass");
			Assert.assertTrue(true);
		}else {
			System.out.println("test failed...");
			Assert.assertTrue(false);
		}
	}
		
	
	
	
	
		
}
