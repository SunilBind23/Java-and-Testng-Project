package orangeHrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTestScript {

	static WebDriver driver;

	public static void OpenOrangeHRM() {
		driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to the OrangeHRM login page
		driver.get("http://localhost/orangehrm-5.7");
		// Set an implicit wait of 30 seconds for elements to be found
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void LoginWithValidCrediantial() {

//		1. Test Case: Login with Valid Credentials
//		.		Open the OrangeHRM login page.
//		.		Enter valid credentials (e.g., correct username and password).
//		.		Click the login button.
//		.		Verify that the user is successfully logged in by checking the presence of the dashboard  .		Log out of the application.
//		.		Verify that the user is redirected to the login page after logging out.
		OpenOrangeHRM();

		// Enter the username into the username field
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		// Enter the password into the password field
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sunil@572005");
		// Click the submit button to log in
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Capture the text of the element that indicates a successful login (Dashboard
		// header)
		String ActualMessage = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();

		// Define the expected text that should be present upon successful login
		String ExpectedMessage = "Dashboard";

		// Compare the actual text with the expected text to verify the login success
		if (ExpectedMessage.contains(ActualMessage)) {
			// If the text matches, print a success message
			System.out.println("User login successful!");
		} else {
			// If the text does not match, print a failure message
			System.out.println("Failed: User not logged in");
		}
		logout();

		WebElement loginPage = driver.findElement(By.xpath("//input[@name='username']"));
		if (loginPage.isDisplayed()) {
			System.out.println("User Log-out successfully");
		} else {
			System.out.println("Usre not log-out !");
		}
		driver.close();
	}

	public static void logout() {

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	
	public static void main(String[] args) {

		LoginWithValidCrediantial();
		
	}
}
