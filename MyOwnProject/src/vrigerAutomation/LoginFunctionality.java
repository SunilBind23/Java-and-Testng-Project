package vrigerAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunctionality {
	// public static ChromeDriver driver; static don't use because
	// there are only one copy of that static variable

	// when we extends= ant class in to any other class this class will give it's
	// methods and variable to other class

	// if you are createing object of any class then it will show all it's methods
	// and
	// methods of that class also which is extends into it

	// non static because you can make more then one copy
	public ChromeDriver driver;

	public void login() {
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		// http://localhost:8888/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// lead creation code here !

	}

	public void closeBrowser() {
		driver.close();
		driver.quit();

	}


	}

