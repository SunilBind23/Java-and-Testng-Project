package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTestingv {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://localhost/orangehrm-5.7");
		//// form[@class='oxd-form']//div//label[text()='Username']/parent::div//following-sibling::div//input
		driver.findElement(By.xpath(
				"//form[@class='oxd-form']//div//label[text()='Username']/parent::div//following-sibling::div//input"))
				.sendKeys("Admin");
		driver.findElement(By.xpath("//label[text()='Password']/parent::div//following-sibling::div//input"))
				.sendKeys("Sunil@572005");
		driver.findElement(By.xpath("//form[@class='oxd-form']//div//button")).click();

		List<WebElement> tabLinks = driver
				.findElements(By.xpath("//nav[@role='navigation']//a[contains(@href,'index.php')]"));
		
		for(WebElement val:tabLinks) {
			System.out.println(val.getText());
		}
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
	}
}
