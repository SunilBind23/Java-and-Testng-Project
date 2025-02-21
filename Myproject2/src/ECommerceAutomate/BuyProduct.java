package ECommerceAutomate;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BuyProduct {

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter extSpark = new ExtentSparkReporter("D:\\Automation Test cases reports//AmazonProduct.html");
		extReport.attachReporter(extSpark);
		ExtentTest extTest = extReport.createTest("Automate ExtentReport");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String url = "https://www.amazon.in";
		driver.get(url);
		extTest.log(Status.INFO, url + "hitted succesfull");
		driver.manage().window().maximize();

		// navigate the search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		String product = "finger slips";
		searchBox.sendKeys(product);
		searchBox.sendKeys(Keys.ENTER);
		extTest.log(Status.INFO, "searchBox navigated and product search successfull" + product);

		driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			driver.switchTo().window(h);
			// String Title = driver.getTitle();
			String URL = driver.getCurrentUrl();
			// System.out.println(URL);
			if (URL.contains("SpinBot-Finger-Sleeve-Freefire-Box-Pack")) {
				System.out.println("CurrentUrl    " + URL);
				driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
				Thread.sleep(1000);

				WebElement phone = driver.findElement(By.xpath("//input[@id='ap_email']"));

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value=7991880288", phone);

				driver.findElement(By.xpath("//input[@type='submit']")).click();
				// enter password
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("sunil@572005");
				// clicking on sign button
				driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
				// click on use this address
				driver.findElement(By.xpath("(//span[text()='Use this paymentmethod'])[1]")).click();
				System.out.println("product orderd successfull");
			}
//			
		}
	}

}
