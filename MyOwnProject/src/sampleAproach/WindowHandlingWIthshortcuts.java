package sampleAproach;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlingWIthshortcuts {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys(Keys.chord(Keys.ALT , Keys.F4));

//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.ALT).sendKeys(Keys.F4).build().perform();
		
		System.out.println("hello browser you are closed ");
	}

}
