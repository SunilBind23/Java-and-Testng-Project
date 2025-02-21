package com.OpenCart.opencart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FlipCartAddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter extLocation = new ExtentSparkReporter("D:\\\\OpenCartProject\\FlipcartAddToCart.html");
		extReport.attachReporter(extLocation);

		ExtentTest extTest = extReport.createTest("FlipCartAddToCart");

		GenericMethodsForAutomation run = new GenericMethodsForAutomation();

		run.setExtentest(extTest);
		WebDriver driver = run.launchBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		run.hitURl("https://www.flipkart.com");
		run.InputData(By.className("Pke_EE"), "iphone", "search box");
		run.Click(By.xpath("//button[@type='submit']"), "search button");
		run.Click(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']"), "on product");

		run.getWindowHandle();
		String title = "Iphone- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		run.getWindowHandles(title);
		WebElement element = run.getWebElement(By.xpath("(//div[text()='₹58,999'])[1]"));
		run.verifyInnerText(element, "₹58,999");
		// run.Click(By.xpath("(//div[@class='XqNaEv'])[3]"), "CheckBox");

		run.Click(By.xpath("//button[@class='QqFHMw cNEU5Q J9Kkbj _7Pd1Fp']"), "Add to cart");
		run.Click(By.xpath("//span[text()='Place Order']"), "Place Order");
		extReport.flush();

	}

}
