package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDrag {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		WebElement a=driver.findElement(By.xpath("//input[@name='user_name']"));
		a.sendKeys("admin");
		
		WebElement wePassword=driver.findElement(By.xpath("//input[@name='user_password']"));
		wePassword.sendKeys("admin");
		
		WebElement weSubmit=driver.findElement(By.xpath("//input[@id='submitButton']"));
		weSubmit.click(); 
		
		 Actions actionobject=new Actions(driver);
	}

}
