package ECommerceAutomate;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomateAmzone {

	public static void main(String[] args) {
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter extSpark = new ExtentSparkReporter("D:\\Automation Test cases reports//AmazonProduct.html");
		extReport.attachReporter(extSpark);
		ExtentTest extTest = extReport.createTest("Automate ExtentReport");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String url = "https://www.amazon.in";
		driver.get(url);
		extTest.log(Status.INFO, url + "hitted succesfull");
		driver.manage().window().maximize();

		// navigate the search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		String product = "phone";
		searchBox.sendKeys(product);
		searchBox.sendKeys(Keys.ENTER);
		extTest.log(Status.INFO, "searchBox navigated and product search successfull" + product);

		List<WebElement> AllElement = driver

				.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		for (int i = 0; i <= AllElement.size() - 20; i++) {
			WebElement el = AllElement.get(i);
			extTest.log(Status.INFO, el.getText());

			el.click();
		}

		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			// System.out.println(h);
			driver.switchTo().window(h);
			String Title = driver.getTitle();
			String ExpectedTitle = "realme NARZO N61 (Voyage Blue,6GB RAM+128GB Storage) 90Hz Eye Comfort Display | IP54 Dust & Water Resistance | 48-Month Fluency | Charger in The Box : Amazon.in: Electronics";
			if (Title.equals(ExpectedTitle)) {

				extTest.log(Status.INFO, "this is page title:- " + Title);
				//driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
				driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
				extTest.log(Status.INFO, "product added to cart");

			} else {
				driver.close();
			}
		}
		extReport.flush();
	}
}
