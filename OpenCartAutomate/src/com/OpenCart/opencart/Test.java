package com.OpenCart.opencart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.xpath(""));
		WebElement target = driver.findElement(By.xpath(""));
		
		act.dragAndDrop(source, target);
		act.click();
		act.clickAndHold();
		act.moveToElement(target);
		act.contextClick(target);
		act.doubleClick(target);
		act.scrollByAmount(0, 0);
		act.moveToElement(target);
		act.sendKeys("");
		
		
		
	}

}
