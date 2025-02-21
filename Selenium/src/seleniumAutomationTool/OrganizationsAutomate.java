package seleniumAutomationTool;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsAutomate {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		String text = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(text);

		String text2 = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']")).getText();
		System.out.println(text2);

		WebElement s1 = driver.findElement(By.xpath("//input[@class='crmbutton small save']"));
		// System.out.println(SaveBtn);

		Dimension size = s1.getSize();
		System.out.println("Save Button size" + size);

		WebElement s2 = driver.findElement(By.xpath("//input[@name='accountname']"));
		s2.sendKeys("HelloSir");
		Dimension size2 = s2.getSize();
		System.out.println("input size=" + size2);

		WebElement s3 = driver.findElement(By.xpath("//input[@name='website']"));
		s3.sendKeys("www.sunilKumar.com");
		Dimension size3 = s3.getSize();
		System.out.println(size3);

		// driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("Parilyament");

		WebElement s4 = driver.findElement(By.xpath("//input[@name='tickersymbol']"));
		s4.sendKeys("$23");
		Dimension size4 = s4.getSize();
		driver.findElement(By.xpath("//input[@name='employees']")).sendKeys("Anupam");

		driver.findElement(By.xpath("//input[@id='email2']")).sendKeys("a2withskraj@gmail.com");

		By selectSalution = By.xpath("//select[@name='industry']");
		WebElement seSalution = driver.findElement(selectSalution);

		boolean Actual = seSalution.isDisplayed();
		// System.out.println(check);
		boolean expectedResult = true;

		if (Actual == expectedResult) {
			System.out.println("Industry selecter Displayed !");
		} else {
			System.out.println("Industry selecter is not Displayed");
		}

		boolean actualResult = seSalution.isEnabled();
		boolean exPectedResult = true;
		if (exPectedResult == actualResult) {
			System.out.println("Industry  selecter isEnabled !");
		} else {
			System.out.println("Industry selecter not Enabled ! ");
		}

		By selectSalution2 = By.xpath("//select[@name='industry']");
		WebElement seSalution2 = driver.findElement(selectSalution2);
		Select Salutation = new Select(seSalution2);
		// Salutation.selectByIndex(3);
		// Salutation.selectByValue("Banking"); // value of value attribute
		Salutation.selectByVisibleText(" Banking "); // value of inner text
		boolean sedropDown = Salutation.isMultiple();
		System.out.println(sedropDown);
		boolean ExpSel = false;
		if (sedropDown == ExpSel) {
			System.out.println("it's not multiple selecter !");
		} else {
			System.out.println("it's a multiple selecter !");
		}

		WebElement Type = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select Setype = new Select(Type);

		// Setype.selectByIndex(4);
		// Setype.selectBValue("Analyst");
		Setype.selectByVisibleText(" Competitor ");

//		WebElement CheckBox = driver.findElement(By.xpath("//input[@name='emailoptout'])"));
//		CheckBox.click();

		WebElement cl = driver.findElement(By.xpath("//input[@name='emailoptout']"));
		boolean actualRes = cl.isSelected();
		boolean ExpectedRes = false;

		if (ExpectedRes == actualRes) {
			System.out.println("Checkbox is not checked without click ! ");
		} else {
			System.out.println("checkBox is checked !");
		}
		cl.click();

		if (ExpectedRes == actualRes) {
			System.out.println("checked after click !");
		} else {
			System.out.println("not checked !");
		}

		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		phone.clear();
		phone.sendKeys("9151147684");
//	boolean ys=phone.isEnabled();
//	Point location=phone.getLocation();
//	

		driver.findElement(By.xpath("//input[@id='fax']")).sendKeys("234324");
		driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys("8115187331");
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("abcd@gamil.com");
		driver.findElement(By.xpath("//input[@id='ownership']")).sendKeys("Sunil Kumar");

		WebElement Salutationdropdown = driver.findElement(By.xpath("//select[@name='rating']"));
		Select drop = new Select(Salutationdropdown);
		drop.selectByValue("Active");
		WebElement selectedOption = drop.getFirstSelectedOption();
		System.out.println(selectedOption.getText());

		drop.
		
		driver.findElement(By.xpath("//input[@id='siccode']")).sendKeys("SUN123");
		driver.findElement(By.xpath("//INPUT[@name='annual_revenue']")).sendKeys("1 crore");
		WebElement CheckBoxVerify = driver.findElement(By.xpath("//input[@name='notify_owner']"));
		CheckBoxVerify.click();
		boolean Actualresult = CheckBoxVerify.isSelected();
		boolean ExpectedResult = true;
		if (ExpectedResult == Actualresult) {
			System.out.println("Test Case Passed  " + ExpectedResult);
		} else {
			System.out.println("Test Case Faild  " + Actualresult);
		}

	}

}
