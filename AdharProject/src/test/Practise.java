package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise {
	/*
	 * Shubham project
	 */
	
public static void main(String[] args) {
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	
	By input=By.xpath("//input[@name='user_name']");
	WebElement we=driver.findElement(input);
	we.sendKeys("admin");
	Point Location=we.getLocation();
	int X=Location.x;
	int Y=Location.y;
	System.out.println(X); 
	System.out.println(Y);
	
	boolean expectedDisplayStatus=true;
	boolean actualDisplayStatus=we.isDisplayed();
	
	boolean expectedStatus=true;
	boolean actualStatus=we.isDisplayed();
	if(actualStatus==expectedStatus) {
		System.out.println("Passed.  username is enable");
	}else {
		System.out.println("Failed. username is disable");
	}
	
	int expectedHeight=18;
	int expectedWeidth=70;
	
	Dimension dim=we.getSize();
	int actualHeight=dim.getHeight();
	System.out.println("actualHeight is-"+actualHeight);
	int actualWeidth=dim.getWidth();
	System.out.println("actualWeidth is-"+actualWeidth);
	
	if(expectedHeight==actualHeight){
		System.out.println("passed. user name Height is correct. actualHeight is-"+actualHeight+", ecpectedHeight is-"+expectedHeight);
	}else {
		System.out.println("Failed. user name height is not correct.actualHeight is-"+actualHeight+", expectedHeight is-"+expectedHeight);
	}
	
	if(expectedWeidth==actualWeidth){
		System.out.println("passed. user name Weidth is correct");
	}else {
		System.out.println("Failed.  user name weidth is not correct");
		
	} 
	By sb=By.xpath("//input[@name='user_password']");  
	WebElement we2=driver.findElement(sb);
	we2.sendKeys("admin");
	
	//find the Location of the element. 
	Point leadlocation=we2.getLocation();
	int x2=Location.x;
	int y2=Location.y;
	System.out.println("let the location of lead x2 is"+x2);
	System.out.println("let the location of lead y2 is"+y2);
	
	
	By sa=By.xpath("//input[@id='submitButton']");
	WebElement we3=driver.findElement(sa);
	we3.click();
	
	
	By lead=By.linkText("Leads");
	WebElement ld=driver.findElement(lead);
	ld.click();
	
	//verify first checkbox in table is unchecked.
	By chk=By.xpath("(//input[@name='selected_id'])[1]");
	WebElement wechkBox=driver.findElement(chk);
	 
	boolean expectedCheckboxStatus=false;
	boolean actualCheckBoxStatus=wechkBox.isSelected();
	if(actualCheckBoxStatus==expectedCheckboxStatus) {
		System.out.println("Passed.");
	}
	else {
		System.out.println("Failed.");
	}
	//do check on first checkbox.
	wechkBox.click();
	// varify that first checkbox is checked or not.

  


}
}
