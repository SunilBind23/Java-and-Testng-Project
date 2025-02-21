package seleniumAutomationTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectclassPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		// script for quick create select option

		WebElement weSelutation = driver.findElement(By.xpath("//select[@id='qccombo']"));
		weSelutation.click();
		// print the all the option in select dropdown menu
		//System.out.println(weSelutation.getText());

		Select Option = new Select(weSelutation);
		WebElement print = Option.getFirstSelectedOption();
		System.out.println(print.getText());
		//driver.quit();
	}

}
