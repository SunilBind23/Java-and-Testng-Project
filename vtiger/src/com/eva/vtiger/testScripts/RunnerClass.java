package com.eva.vtiger.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RunnerClass {
	

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter reportLocation = new ExtentSparkReporter(
				"D:\\Automation Test cases reports\\\\ProductsReport.html");
		extReport.attachReporter(reportLocation);

		ExtentTest extTest = extReport.createTest("VT001VerifyCreateProductAllFields");
		ChromeDriver	driver = new ChromeDriver();
		VerifyProductsScripts run = new VerifyProductsScripts();
		run.login(extTest);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.linkText("Create Filter")).click();

		// first test case start for execution extTest.log(Status.INFO, "UserLogin
		// Successfully");
		run.VT001VerifyCreateProductAllFields(extTest);

		// second test case start for execution
//		extTest = extReport.createTest("VT002VerifyCreateProductRequiredFields");
//		run.VT002VerifyCreateProductRequiredFields(extTest);
//		// third test case start for execution
//		extTest = extReport.createTest("VT003VerifyCreateProductWithoutRequiredFields");
		// run.VT003VerifyCreateProductWithoutRequiredFields(extTest);
//		// fourth test case start for execution
//		extTest = extReport.createTest("VT004VerifyCancleProduct");
//		run.VT004VerifyCancleProduct(extTest);
//		// fifth test case start for execution
//		extTest = extReport.createTest("VT005VerifyEditCreatedProductFromDetailsPage");
//		run.VT005VerifyEditCreatedProductFromDetailsPage(extTest);
//		
//		 extTest = extReport.createTest("VT006VerifyCreateProductByDuplicateProduct");
//		run.VT006VerifyCreateProductByDuplicateProduct(extTest);
		extReport.flush();

	}
}
