package com.OpenCart.TestScenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OpenCart.opencart.GenericMethodsForAutomation;
import com.aventstack.extentreports.ExtentTest;

public class ValidateTheworkingofRegisterAccountfunctionality extends CommonMethods {

	public static WebDriver driver;

	 public static GenericMethodsForAutomation run;

	public void ValidateRegisteringAnAccountbyprovidingonlytheMandatoryfields(String FirstName, String LastName,
			String EMail, String Telephone, String Password, String PasswordConfirm, ExtentTest extTest) {
		GenericMethodsForAutomation run = new GenericMethodsForAutomation();

		run.setExtentest(extTest);
		run.launchBrowser("chrome");
		run.hitURl("http://localhost/Opencart");
		// run.Click(By.className("caret"), "on Arrow ");
		// run.Click(By.linkText("Register"), "Register");

		run.InputData(By.name("firstname"), FirstName, "Firstname");
		run.InputData(By.name("lastname"), LastName, "Lastname");
		run.InputData(By.name("email"), EMail, "Email");
		run.InputData(By.name("telephone"), Telephone, "Telephone");
		run.InputData(By.name("password"), Password, "Password");
		run.InputData(By.name("confirm"), PasswordConfirm, "Confirm PassWord");
		// run.Click(By.name("agree"), "agree checkbox");
		// run.Click(By.xpath("//input[@value='Continue']"), "Continue button");
		WebElement weText = run.getWebElement(By.tagName("h1"));
		run.verifyInnerText(weText, "Your Account Has Been Created!");
		run.closeBrowser();

	}

	public void validateErrorMessagesForEmptyMandatoryFields() {
		 run = new GenericMethodsForAutomation();
		
//		run.setExtentest(extTest);
		run. 
		run.launchBrowser("chrome");

		CommonMethods Cmethod=	new CommonMethods();

		Cmethod.openApplicationRegisterFunctionality();
//		run.hitURl("http://localhost/Opencart");
//
//		run.Click(run.getWebElement(By.className("caret")), "on Arrow ");
//
//		run.Click(run.getWebElement(By.linkText("Register")), "Register");
//		
		
		WebElement element = run.getWebElement(By.name("agree"));
		run.Click(element, "agree checkbox");
		
		WebElement WeElement = run.getWebElement(By.xpath("//input[@value='Continue']"));
		run.Click(WeElement, "Continue button");
		 List<WebElement> el =
		 run.getWebElements(By.xpath("//div[@class='text-danger']"));

	}

}
