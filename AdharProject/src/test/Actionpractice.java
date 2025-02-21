package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Actionpractice {

	
	public Actionpractice x() {
		Actionpractice ac=new Actionpractice();
		return ac;
	}
	public Actionpractice y() {
		Actionpractice ac=new Actionpractice();
		return ac;
	}
	public static void main(String[] args) {
		Actionpractice acp=new Actionpractice();
		acp.x().y();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");

		Actions actionobject=new Actions(driver);
		WebElement weLoginButton=driver.findElement(By.xpath("//input[@id='submitButton']")); 
        actionobject.click(weLoginButton).build().perform();
        
        
		
		WebElement weDrag=driver.findElement(By.xpath("//tr[@id='headerrow_11']/td/b"));
		WebElement weDrop=driver.findElement(By.xpath("//tr[@id='headerrow_1']/td/b"));
		actionobject.dragAndDrop(weDrag, weDrop).build().perform();
		///  clickAndHold, moveToElement, release , build,
		//   dragAndDrop , perform, doubleCLick, contextClick
		///  click , sendKeys
		
		
		actionobject.clickAndHold(weDrag).moveToElement(weDrop).release(weDrop).build().perform();
		
		WebElement moreLink=driver.findElement(By.linkText("More"));
		actionobject.moveToElement(moreLink).build().perform();
    ///  modules   sub module   crosshair
		
		WebElement invoicelink= driver.findElement(By.xpath("//a[@name='Invoice']"));
		actionobject.click(invoicelink).build().perform();

	}

}
