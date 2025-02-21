package seleniumAutomationTool;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		Actions actionObject = new Actions(driver);
		WebElement Drag = driver.findElement(By.xpath("//tr[@id='headerrow_11']/td/b"));
		WebElement Drop = driver.findElement(By.xpath("//tr[@id='headerrow_3']/td[1]/b"));

		actionObject.dragAndDrop(Drag, Drop).build().perform();
		//actionObject.clickAndHold(Drag).clickAndHold(Drop).build().perform();
		actionObject.
		
	}

}
