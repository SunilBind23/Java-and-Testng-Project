package vrigerAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeadTestScript2 {
	//public static ChromeDriver driver; static don't use because 
	//there are only one copy of that static variable
public  ChromeDriver driver; // non static because you can make more then one copy

public void login() {
	driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='submit']"));
	
	// lead creation code here !
	
	
}
public void closeBrowser() {
	driver.close();
	driver.quit();
}
	public void testcreateLeadFunctionslity() {
		login();
		
		closeBrowser();
	}
	
	public void testDeleteLeadFunctionality() {
		
		login();
		
		closeBrowser();
	}
	
	
	public void testEditLeadfunctionality() {
		
		login();
		
		closeBrowser();
	}
	
	
	
	public static void main(String[] args) {
		LeadTestScript2 run=	new LeadTestScript2();
		run.testcreateLeadFunctionslity();
		
	}

}
