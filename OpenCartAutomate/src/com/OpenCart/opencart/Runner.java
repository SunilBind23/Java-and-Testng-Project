package com.OpenCart.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.OpenCart.TestScenario.GenericMethodsForAutomation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Runner {
	public static WebDriver driver;

	public static void main(String[] args) {
		// driver=new ChromeDriver();
		
		
	
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter extSparkReport = new ExtentSparkReporter("D:\\OpenCartProject\\demo.html");
		extReport.attachReporter(extSparkReport);
		ExtentTest extTest = extReport.createTest("Demo Test Reports");

		GenericMethodsForAutomation run = new GenericMethodsForAutomation();

	  driver =run.launchBrowser("chrome");

		run.hitURl("http://localhost/Opencart/");
		WebElement el = driver.findElement(By.linkText("Software"));
		System.out.println(el.getTagName());
		// Software
		
		String value="logout";
		run.selectByValue(By.xpath("//span[@class='caret']"), value);
		

		// run.getWebElement(By.name("search"), extTest);

		// run.InputData(By.name("search"), "iphone", "Search Box", extTest);

		// run.Click(By.xpath("//button[@class='btn btn-default btn-lg']"),
		// "SearchButton", extTest);

		// run.getWindowHandle(locator, extTest, "iphone");

		extReport.flush();

	}

}
