package com.eva.vtiger.testScripts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginSetup {

	public static WebDriver driver;

	public void login(ExtentTest extTest) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		String url = "http://localhost:8888/";
		driver.get(url);

		extTest.log(Status.INFO, url + "opned and UserLogin SuccessFully ");

		String name = "admin";

		for (int i = 0; i <= 3; i++) {
			try {

				driver.findElement(By.name("user_name")).sendKeys(name);

				extTest.log(Status.INFO, name + " entered in username textbox");

				driver.findElement(By.name("user_password")).sendKeys("admin");

				extTest.log(Status.INFO, name + " entered in password textbox");

				driver.findElement(By.id("submitButton")).click();
				extTest.log(Status.INFO, "login button clicked successfully");

				if (driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).isDisplayed()) {
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

//		driver.findElement(By.linkText("Products")).click();
//		extTest.log(Status.INFO, "Products tab clicked");
//		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//		extTest.log(Status.INFO, "Clicked on create Products successfully");

	}

}
