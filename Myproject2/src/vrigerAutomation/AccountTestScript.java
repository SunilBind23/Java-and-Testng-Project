package vrigerAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountTestScript extends LoginFunctionality {

	public void testcreateAccountFunctionslity() throws InterruptedException {
		login();

		// click on lead text
		driver.findElement(By.linkText("Leads")).click();
		// click on + sysmbol

		driver.findElement(By.xpath("//img[contains(@alt,'Create Lead')]")).click();

		// handling dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select weselect = new Select(dropdown);
		weselect.selectByValue("Mr.");
		// enter the values in input boxes
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ankit");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yadav");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@name='designation']")).sendKeys("HR");

		// handling leadsource

		Select leadsource = new Select(driver.findElement(By.xpath("//select[@name='leadsource']")));
		leadsource.selectByValue("Employee");

		// handling industry dropdown
		Select industry = new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		industry.selectByValue("Construction");

		// entering the values in input boxes
		WebElement revenue = driver.findElement(By.xpath("//input[@name='annualrevenue']"));
		revenue.clear();
		revenue.sendKeys("10000");
		driver.findElement(By.xpath("//input[@name='noofemployees']")).sendKeys("5");

		driver.findElement(By.xpath("//input[@name='secondaryemail']")).sendKeys("sunl1224@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("4750734562");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("7991880288");
		driver.findElement(By.xpath("//input[@name='fax']")).sendKeys("47567934");
		driver.findElement(By.xpath("//input[@type='radio' and @value='T']")).click();

		Select group = new Select(driver.findElement(By.xpath("//select[@name='assigned_group_id']")));
		group.selectByValue("3");

		// click on save button

		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(3000);
		String information = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']")).getText();
		String expextedInformation = "Lead Information";

		if (expextedInformation.equals(information)) {
			System.out.println("employee Added SuccessFully");
		} else {
			System.out.println("Faild to creat Account !");
		}

		closeBrowser();

	}

	public void testEditAccountfunctionality() throws InterruptedException {
		login();
		driver.findElement(By.linkText("Leads")).click();
		// click on user checkbox by id
		driver.findElement(By.xpath("//input[@id='150']")).click();
		// click on edit button
		driver.findElement(By.xpath("(//input[@value='Mass Edit'])[1]")).click();

		driver.findElement(By.name("website")).sendKeys("http:/crazyboy.com/");

		driver.findElement(By.xpath("//input[@accesskey='S']")).click();

		String link = driver.findElement(By.xpath("//a[text()='http:/crazyboy.com/']")).getText();
		String expectedLink = "http:/crazyboy.com/";
		Thread.sleep(3000);
		if (expectedLink.equals(link)) {
			System.out.println("user webSite link updated successFully");
		} else {
			System.out.println("Faild to updated");
		}

		 closeBrowser();
	}

	public void testDeleteAccountFunctionality() {

		login();
		// click on lead option
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.xpath("//input[@id='149']")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		driver.switchTo().alert().accept();

		boolean expectedId = false;
		boolean test = driver.findElement(By.xpath("//td[text()='LEA24 ']")).isSelected();

		if (expectedId == test) {
			System.out.println("failed to delete user !");
		} else {
			System.out.println(" user Deleted Successfully");
		}

		 closeBrowser();
	}
	
	public void searchAccountFunctionality() {
		login();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("sunil");
		
		
		Select searchBy=		new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));
		searchBy.selectByValue("firstname");
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[1]")).click();
		
		if(driver.findElement(By.xpath("//td[contains(text(),'Showing Records ')]")).isDisplayed()) {
			System.out.println("User Found ");
		}else {
			System.out.println("user not found");
		}
		closeBrowser();
	}

}
