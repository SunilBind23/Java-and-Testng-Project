package india.adhar;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto {

 public static int x=100;

	public static void main(String[] args) throws InterruptedException {
		 
    	System.out.println("start");

		ChromeDriver driver=new ChromeDriver();
    	driver.get("http://localhost:8888/");
    	/////
    	//  1 Search or find element 
    	//  type - username
    	///   tag 
    	By c=By.name("user_name"); 	
    	WebElement we=driver.findElement(c);
    	we.sendKeys("admin");
    	///  datatype
    	///  class 
    	
    	By byPassword=By.name("user_password");
    	WebElement wePassword=driver.findElement(byPassword);	
    	wePassword.sendKeys("admin");
    	
//    	
//    	By byLoginButton=By.id("submitButton");
//    	WebElement weLogin=driver.findElement(byLoginButton);
//    	weLogin.click();
 
    	
    	Dimension aa=driver.findElement(By.name("user_password")).getSize();
    	 int Hight=aa.getHeight();
    	 int width=aa.getWidth();
    	 System.out.println(Hight);
    	 System.out.println(width);
    	
//    	////   Link
//    	
//    	By byLeads=By.linkText("Leads");
//    	WebElement weLeads=driver.findElement(byLeads);
//    	weLeads.click();
//    	
//    	////      //tagname[@attributeName='attributevalue']
//    	By byPlusButton=By.xpath("//img[@alt='Create Lead...']");
//    	WebElement wePlusButton=driver.findElement(byPlusButton);
//    	wePlusButton.click();
//    	
//    	System.out.println("end");
    	
    	

	}
	
	
	///    java - jar
	
	///  c# .net - dll

	///  chrome , firefox , opera, safari , edge, 
	///  cross browser testing 
	
	/////  ///   programming language - +  HTML
	
	 //  client      server
	 //  frontend  backend
	
	
	
	
	
}
