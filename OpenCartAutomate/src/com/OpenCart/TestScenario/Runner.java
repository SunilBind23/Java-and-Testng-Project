package com.OpenCart.TestScenario;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Runner {

	public static void main(String[] args) {

		//WebDriver driver = null;

		
//		ExtentTest extTest = extRepo.createTest("ValidateTheworkingofRegisterAccountfunctionality");

		ValidateTheworkingofRegisterAccountfunctionality run = new ValidateTheworkingofRegisterAccountfunctionality();
//		run.ValidateRegisteringAnAccountbyprovidingonlytheMandatoryfields("sujit", "yadav",
//				"sujeet@gamil.com", "9151146554", "sujeet@123", "sujeet@123");
//		
//		extRepo.flush();
		
		
//		extTest = extRepo.createTest("validateErrorMessagesForEmptyMandatoryFields");
		
		//run.ValidateRegisteringAnAccountbyprovidingonlytheMandatoryfields("Rahul", "yadav", "abc@gmail.com", "3764293874", "sunil123", "sunil123", extTest);
		run.validateErrorMessagesForEmptyMandatoryFields();
		
	}
}
