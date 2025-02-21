package webUtility.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginVerification {
	
	
	public WebElement searchTB;

	public void Login(String browserName,By locator, ExtentTest extTest,String InputBoxName) {
		WebGenericMethods dr = new WebGenericMethods();
		dr.launchBrowser(browserName, extTest);
		dr.sendUrl("http:/localhost:8888", extTest);
		dr.getWebElement(locator, extTest, "UserName");
		dr.InputData(locator, extTest, browserName, InputBoxName);
	}
	

	public static void main(String[] args) {
		ExtentReports extRepo = new ExtentReports();
		ExtentSparkReporter extSpark = new ExtentSparkReporter("D:\\Automation Test cases reports\\LoginVtiger.html");
		extRepo.attachReporter(extSpark);

		ExtentTest extTest = extRepo.createTest("Login Functionality with valid Credintial");

		LoginVerification lg = new LoginVerification();
		lg.Login("chrome",By.name("user_name"), extTest,"UserNameTB");
		extRepo.flush();
	}
}
