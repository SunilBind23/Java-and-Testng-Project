package myHRMproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class OrangeHRM {
	public static WebDriver driver;
	// = new ChromeDriver();

	public static void openHRM() {
		// Initialize the ChromeDriver
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Open the OrangeHRM application
		driver.get("http://localhost/orangehrm-5.7");

		// Set an implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void login() {
		openHRM();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sunil@572005");

		// Locate the submit button and click it
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// log-out

	}

	public static void loginWithvalidCradiantionl() {
		// openHRM();
		// Locate the username field and enter "admin"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sunil@572005");

		// Locate the submit button and click it
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualtitle = driver.getTitle();
		String expectedtitle = "OrangeHRM";
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("Login SuccessFull");
		} else {
			System.out.println("Login Failed");
		}
		logout();
	}

	public static void logout() {
		// performing the log-out functionality
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		// driver.close();

	}

	public static void dologinwithIvalidCredialtials() {
		// openHRM();
		// enter the valid username="Admin;
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		// enter the invalid password "sunil1234";
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sunil1234");

		// Locate the submit button and click it
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String msgExpexted = "Invalid credentials";
		String actualMsg = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))
				.getText();
		System.out.println(actualMsg);
		if (actualMsg.equals(msgExpexted)) {
			System.out.println("Login Failed");
		} else {
			System.out.println("Login successfull");
		}
		// driver.close();
		// log-out
		// logout();
	}

	public static void addEmployee() {
		// login the orange HRM method use
		login();

		// find PIM and click on PIM menu

		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		// Find the PIM menu and click on "Add Employee" option;
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		// enter the employee first name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Sunil");
		// enter the middle name
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Kumar");
		// enter the last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Bind");
		// click on save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// verify if the employee is successfully added by checking the employee list
		// personal details
		String confitmationMassage = driver.findElement(By.xpath("//h6[text()='Personal Details']")).getText();
		if (confitmationMassage.contains("Personal Details")) {
			System.out.println("Empleyee Added SuccessFuly");
		} else {
			System.out.println("Failed to add employee");
		}
		logout();
	}

	public static void SearchEmployeeByName() {
		login();
		// find PIM and click on PIM menu

		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		// enter the employee name
		driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("ajeet");
		// driver.findElement(By.xpath("//input[@class='oxd-input
		// oxd-input--active']")).sendKeys("0005");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//String ActualMassage = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]")).getText();
		List<WebElement> element = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));
	String actualmsg=	element.get(0).getText();
		System.out.println(actualmsg);

	}

	public static void main(String[] args) {

		// OrangeHRM perform= new OrangeHRM();
		// login();
		// loginWithvalidCradiantionl();
		// Login with valid credentials
		// openHRM();
		// login("Admin", "Sunil@572005");
		// logout();
		// // Login with invalid credentials
		// dologinwithIvalidCredialtials();
		// // login("admin", "Sunil@1123");
	 dologinwithIvalidCredialtials();
		// addEmployee();
		SearchEmployeeByName();
		System.out.println("no records");
	}
}
