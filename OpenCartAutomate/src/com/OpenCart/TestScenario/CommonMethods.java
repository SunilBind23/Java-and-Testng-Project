package com.OpenCart.TestScenario;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

public class CommonMethods {
	 

	public void openApplicationRegisterFunctionality() {
		GenericMethodsForAutomation	run = new GenericMethodsForAutomation();

		
		
		run.hitURl("http://localhost/Opencart");

		run.Click(By.className("caret"), "on Arrow ");
		run.Click(By.linkText("Register"), "Register");
	}

}
