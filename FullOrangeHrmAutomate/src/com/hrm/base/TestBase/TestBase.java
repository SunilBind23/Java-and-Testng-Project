package com.hrm.base.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class TestBase {

	public static WebDriver driver;
	//protected static String appUrl = Config.getProperty("app.url.local");

	public void initialization() {
		driver=null;
		if (driver == null) {
			driver = new ChromeDriver();
			
			//driver.get(appUrl);
			driver.manage().window().maximize();
			
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	//@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] takeScreenShot(String ScreenShotName) throws IOException {

		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String dest= System.getProperty("user.dir")+ "//Screenshots//"+ScreenShotName+"_"+timestamp+".png";

		FileHandler.copy(source, new File(dest));
		System.out.println("Screenshot Taken");
		return (byte[])ts.getScreenshotAs(OutputType.BYTES);

	}

	public void waitForElementToBeClickable(WebElement ele) {
		//new WebDriverWait(driver, 10)
		//.until(ExpectedConditions.elementToBeClickable(ele));
	}

		//@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] takeScreenShotForFailedTestCase(String ScreenShotName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String dest= System.getProperty("user.dir")+ "//Screenshots//FailedTestCase//"+ScreenShotName+"_"+timestamp+".png";

		FileHandler.copy(source, new File(dest));
		
		return (byte[])ts.getScreenshotAs(OutputType.BYTES);
	}
}