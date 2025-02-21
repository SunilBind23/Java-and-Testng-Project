package com.eva.OpenCart.TestCases;

import com.aventstack.extentreports.ExtentTest;
import com.eva.OpenCart.Webutils.Webutils;
import com.eva.OpenCart.pages.OpenApplication;
import com.eva.OpenCart.pages.RegisterAccountPage;
import com.eva.OpenCart.pages.SuccessRegisterPage;

public class ValidateRegisterAccount {

	private ExtentTest extTest;

	public ValidateRegisterAccount(ExtentTest extTestreport) {
		extTest = extTestreport;
	}

	public void VerifyRegisterWithAllFields() {

		Webutils wt = new Webutils();
		wt.setExtentest(extTest);
		OpenApplication opA = new OpenApplication(wt);
		opA.OpenApp();
		opA.ClickOnRegisterAccount();
		RegisterAccountPage validFiels = new RegisterAccountPage(wt);
		validFiels.EnterFirstName("ajeet");
		validFiels.EnterLasttName("bind");
		validFiels.EnterEmail("sunilrahul@gmail.com");

		validFiels.EnterTelephone("6675765787");
		String Password = "ajeet@123";
		validFiels.EnterPassword(Password);
		validFiels.EnterConfirmPassword(Password);
		validFiels.SubscribeYes();
		validFiels.PrivencyPolicyCkeck();
		validFiels.Continue();

		wt.closeAllBrowser();

	}

	public void VerifyRegisterDuplicateEmail() {
		Webutils wt = new Webutils();
		wt.setExtentest(extTest);
		OpenApplication opA = new OpenApplication(wt);
		opA.OpenApp();
		opA.ClickOnRegisterAccount();
		RegisterAccountPage validFiels = new RegisterAccountPage(wt);
		validFiels.EnterFirstName("rahul");
		validFiels.EnterLasttName("bind");
		validFiels.EnterEmail("ajeetkumar@gmail.com");

		validFiels.EnterTelephone("6675765787");

		String Password = "ajeet@123";
		validFiels.EnterPassword(Password);
		validFiels.EnterConfirmPassword(Password);
		validFiels.SubscribeYes();
		validFiels.PrivencyPolicyCkeck();
		validFiels.Continue();
		validFiels.warningMsg("Warning: E-Mail Address is already registered!");
		
		wt.closeAllBrowser();

		
		
	}
	
	
	
	
	
	
	/*Validate proper notification messages are displayed for
	 *  the mandatory fields, when you don't provide any 
	 *  fields in the 'Register Account' page and submit
	 */
	public void verifyWithNoEnterAntDetaInFields() {
		Webutils wt = new Webutils();
		wt.setExtentest(extTest);
		OpenApplication opA = new OpenApplication(wt);
		opA.OpenApp();
		opA.ClickOnRegisterAccount();
		RegisterAccountPage validFiels = new RegisterAccountPage(wt);
		validFiels.Continue();
		validFiels.allRequiredMsg();
		validFiels.warningMsg("Warning: You must agree to the Privacy Policy!");
		wt.closeAllBrowser();
		
		
	}
	
	/*Validate Registering an Account 
	 * when 'No' option is selected for Newsletter field
	 */
	public void ValidateRegisteringanAccountwhenNoOptionisSelected() {
		Webutils wt = new Webutils();
		wt.setExtentest(extTest);
		
		RegisterAccountPage validFiels = new RegisterAccountPage(wt);
		validFiels.EnterFirstName("rahul");
		validFiels.EnterLasttName("bind");
		validFiels.EnterEmail("avdfgjhk@gmail.com");

		validFiels.EnterTelephone("6675765787");

		String Password = "ajeet@123";
		validFiels.EnterPassword(Password);
		validFiels.EnterConfirmPassword(Password);
		
		validFiels.PrivencyPolicyCkeck();
		validFiels.Continue();
		
		SuccessRegisterPage  use=	new SuccessRegisterPage(wt);
		use.checkSuccessMassage("");
		use.clickOnCOntinue();
		
		wt.closeAllBrowser();

		
	
	}
	
	

}
