package priceCompare;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AllclassPractice {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/orangehrm-5.7");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		String windowId = driver.getWindowHandle();
		System.out.println("getWindowHandle method :" + windowId);

		// Actions action= new Actions(driver);
		WebElement newWindow = driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']"));

//	 	action.click(newWindow);
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", newWindow);

		Set<String> handels = driver.getWindowHandles();
		
		for (String allhandel : handels) {
			System.out.println(allhandel);
			driver.switchTo().window(allhandel);
			System.out.println(driver.getTitle());
		}

		WebElement name = driver.findElement(By.xpath("//INPUT[@NAME='username']"));
		name.sendKeys("Admin");

		driver.findElement(By.xpath("//INPUT[@NAME='password']")).sendKeys("Sunil@572005");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		// js.executeScript("arguments[0].value='Admin", name);

	}

}
