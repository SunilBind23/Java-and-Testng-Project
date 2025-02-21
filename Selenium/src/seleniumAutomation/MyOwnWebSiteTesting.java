package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyOwnWebSiteTesting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/HP/Desktop/allMethodsPracticePage.html");

		// print the current url of our webpage
		//System.out.println(driver.getCurrentUrl());

		// print the title of our webPage
		System.out.println(driver.getTitle());

		// print the page source code in our console
		//System.out.println(driver.getPageSource());

		WebElement PrintTag = driver.findElement(By.tagName("h1"));
		System.out.println(PrintTag.getText());

		driver.quit();

	}

}
