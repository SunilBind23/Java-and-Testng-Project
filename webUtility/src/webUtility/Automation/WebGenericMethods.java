package webUtility.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebGenericMethods {
	public WebDriver driver;

	public void launchBrowser(String browserName, ExtentTest extTest) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			extTest.log(Status.INFO, browserName + "browser Launch Successfully");
			break;
		case "edge":
			driver = new EdgeDriver();
			extTest.log(Status.INFO, browserName + "browser Launch Successfully");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			extTest.log(Status.INFO, browserName + "browser Launch Successfully");
			break;
		default:
			extTest.log(Status.INFO, "NO browser matched please check once");

		}
	}

	public void sendUrl(String url, ExtentTest extTest) {
		try {
			driver.get(url);
			extTest.log(Status.INFO, url + " url hit successfully");
		} catch (NullPointerException e) {

			extTest.log(Status.INFO, url + " url please provide valid url " + e.getMessage());
		}
	}

	public WebElement getWebElement(By locator, ExtentTest extTest, String value) {
		WebElement weElement = null;
		try {
			driver.findElement(locator);
			extTest.log(Status.INFO, value + " found successfully");
		} catch (NoSuchElementException e) {

			extTest.log(Status.INFO, value + " element not found on the UI page");

		} catch (NullPointerException e) {
			extTest.log(Status.INFO, value + " driver is null please check that once !");
		} catch (InvalidSelectorException e) {
			extTest.log(Status.INFO, value + " invalid selector" + e.getMessage());
		} catch (Exception e) {
			extTest.log(Status.INFO, value + e.getMessage() + "solve that exception");
		}
		return weElement;
	}

	public void InputData(By locator, ExtentTest extTest, String Data, String userNameTB) {
		WebElement send = getWebElement(locator, extTest, Data);
		try {
			send.sendKeys("admin");
			extTest.log(Status.INFO, Data + "send successfully in" + userNameTB);
		} catch (NullPointerException e) {
			e.getMessage();
		}

	}

}
