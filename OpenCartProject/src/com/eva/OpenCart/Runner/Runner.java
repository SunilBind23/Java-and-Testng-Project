package com.eva.OpenCart.Runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eva.OpenCart.TestCases.ValidateRegisterAccount;

public class Runner {

	public static void main(String[] args) {
		ExtentReports extRepo = new ExtentReports();
		ExtentSparkReporter extSpark = new ExtentSparkReporter("D:\\OpenCartProject\\RegisterWithAllFields.html");
		extRepo.attachReporter(extSpark);
		ExtentTest extTest = null;

		extTest = extRepo.createTest("ValidateRegisterAccount");

		ValidateRegisterAccount run = null;
		
//		run = new ValidateRegisterAccount(extTest);
//		run.VerifyRegisterWithAllFields();
//		extRepo.flush();
//
//		extTest = extRepo.createTest("VerifyRegisterDuplicateUser");
//		run = new ValidateRegisterAccount(extTest);
//		run.VerifyRegisterDuplicateEmail();
//		extRepo.flush();
		
		
//		extTest = extRepo.createTest("verifyWithNoEnterAntDetaInFields");
//		run = new ValidateRegisterAccount(extTest);
//		run.verifyWithNoEnterAntDetaInFields();
//		extRepo.flush();
		
		extTest = extRepo.createTest("ValidateRegisteringanAccountwhenNoOptionisSelected");
		run = new ValidateRegisterAccount(extTest);
		run.ValidateRegisteringanAccountwhenNoOptionisSelected();
		extRepo.flush();

	}

}
