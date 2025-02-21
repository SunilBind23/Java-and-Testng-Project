package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practise2 {
public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	
	WebElement a=driver.findElement(By.xpath("//input[@name='user_name']"));
	 
	// This is for heiht & width of user name.
	int expectedHeight=18;
	int expectedwidth=70;
	Dimension dim=a.getSize();
	int actualheight=dim.getHeight();
	int actualwidth=dim.getWidth();
	if(expectedHeight==actualheight) {
		System.out.println("Passed:username height is correct."+"actualheigth-"+actualheight+", expectedHeight-" +expectedHeight);
	}else {
		System.out.println("Failed: username height is not correct");
	}
	if(expectedwidth==actualwidth){
		System.out.println("Passed: username width is correct");
		System.out.println("actualwidth is="+actualwidth+",expectedHeight=" +expectedHeight);
	}else {
		System.out.println("Failed: username width is not corect."+actualwidth);
		
	}
	
	// this is used to find the location of the element.
	Point locationOfusername=a.getLocation();
	int x=locationOfusername.x;
	int y=locationOfusername.y;
	System.out.println("let the location of the x username is:"+x);
	System.out.println("let the location of the y username is:"+y);
	a.sendKeys("admin");
	
	String usernamecolor=a.getCssValue("color");
	System.out.println( "the colour of the username is:"+usernamecolor);
	
	WebElement wePassword=driver.findElement(By.xpath("//input[@name='user_password']"));
	wePassword.sendKeys("admin");
	

	WebElement weSubmit=driver.findElement(By.xpath("//input[@id='submitButton']"));
	weSubmit.click(); 
	
	By lead=By.linkText("Leads");
	WebElement ld=driver.findElement(lead);
	ld.click();
	
	By clickimg=By.xpath("//img[@alt='Create Lead...']");
	WebElement we4=driver.findElement(clickimg);
	we4.click();
	
	WebElement weSalutation=driver.findElement(By.xpath("//select[@name='salutationtype']"));
     Select selectSalutation = new Select(weSalutation);
     selectSalutation.selectByVisibleText("Prof.");
     
     WebElement weLeadsource=driver.findElement(By.xpath("//select[@name='leadsource']"));
     Select selectLeadsource=new Select(weLeadsource);
     selectLeadsource.selectByVisibleText("Employee");
     WebElement allsalutation=selectLeadsource.getFirstSelectedOption();
     String printsalutation=allsalutation.getText();
     System.out.println(printsalutation);
     
     
     WebElement weSelection=driver.findElement(By.xpath("//select[@name='salutationtype']"));
     
     
}
}


