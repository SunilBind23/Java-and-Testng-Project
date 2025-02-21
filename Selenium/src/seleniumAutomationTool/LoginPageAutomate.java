package seleniumAutomationTool;

import java.awt.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageAutomate {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");

		// usreName test Script------------
		WebElement UserName = driver.findElement(By.xpath("//div[@class='label']"));

//		String Name = UserName.getText();
//		System.out.println("value of user name=>" + Name);

		System.out.println(UserName.getText());

		System.out.println(UserName.getCssValue("font-weight"));
//		String Attribute = UserName.getAttribute("class");
//		System.out.println("the attribute value of user name=>" + Attribute);

		System.out.println("Attribute =>" + UserName.getAttribute("class"));

//	String TagName=UserName.getTagName();
//	System.out.println(TagName);
		System.out.println("TagName " + UserName.getTagName());

		boolean ActualResult = UserName.isDisplayed();

		boolean ExceptedResult = true;

		if (ExceptedResult == ActualResult) {
			System.out.println("passed =>" + ActualResult);
		} else {
			System.out.println("failed=>" + ActualResult);
		}

		boolean ActuRes = UserName.isEnabled();
		boolean expected = true;
		if (expected == ActuRes) {
			System.out.println("passed=>" + ActuRes);
		} else {
			System.out.println("failed=>" + ActuRes);
		}

		boolean ActualResult2 = UserName.isSelected();
		boolean expRes = false;

		if (expRes == ActualResult2) {
			System.out.println("passed =>" + ActualResult2);
		} else {
			System.out.println("failed =>" + ActualResult2);
		}
		Point Location = UserName.getLocation();
		System.out.println("the x cordinate position is=>" + Location.x);
		System.out.println("the y cordinate position is=>" + Location.y);

		org.openqa.selenium.Dimension size = UserName.getSize();
		int Height = size.height;
		int Width = size.width;
		System.out.println("the height of user name=>" + Height);
		System.out.println("the Width of user name=>" + Width);

		// Input box of useraname-----test script-----

		System.err.println("Input box of useraname");
		WebElement UserNameInputBox = driver.findElement(By.xpath("//input[@name='user_name']"));
		boolean ActualResultOfUserNameInputBox = UserNameInputBox.isDisplayed();
		boolean ExceptedResultOfUserNameInputBox = true;
		if (ExceptedResultOfUserNameInputBox == ActualResultOfUserNameInputBox) {
			System.out.println("passed =" + ActualResultOfUserNameInputBox);
		} else {
			System.out.println("failed = " + ActualResultOfUserNameInputBox);
		}

		boolean EnabledOFuserNameInputBox = UserNameInputBox.isEnabled();
		boolean ExpectedResultofuserNameInputBox = true;
		if (ExpectedResultofuserNameInputBox == EnabledOFuserNameInputBox) {
			System.out.println("passed=> " + ExpectedResultofuserNameInputBox);
		} else {
			System.out.println("failed =" + ExpectedResultofuserNameInputBox);
		}
		boolean ActualValue = UserNameInputBox.isSelected();
		boolean expectedvalue = false;

		if (expectedvalue == ActualValue) {
			System.out.println("Passed ! " + ActualValue);
		} else {
			System.out.println("Failed ! " + ActualValue);
		}

		org.openqa.selenium.Dimension InputBoxSize = UserNameInputBox.getSize();
		System.out.println("size height of userInputBox=>" + InputBoxSize.height);
		System.out.println("size width of userInputBox=>" + InputBoxSize.width);

		int inputSize = 26;
		int InputWidth = 350;
		if (inputSize == InputBoxSize.height) {
			System.out.println("test case passed !");
		} else {
			System.out.println("test case failed !");
		}

		System.out.println("userName input box x point= " + UserNameInputBox.getLocation().x);
		System.out.println("userName input box y point= " + UserNameInputBox.getLocation().y);

		UserNameInputBox.clear();
		UserNameInputBox.sendKeys("admin");
		// System.out.println(UserNameInputBox.getText());
		System.out.println("GotedCss Value padding-block=>" + UserNameInputBox.getCssValue("padding-block"));
		System.out.println("GotedCss Value padding-inline=>" + UserNameInputBox.getCssValue("padding-inline"));

		// Password Element Test case start here ---------
		System.err.println("Password Element Test case start here");
		WebElement Password = driver.findElement(By.xpath("(//div[@class='label'])[2]"));
		System.out.println("InnerText Value= " + Password.getText());
		System.out.println("Tag name of element =" + Password.getTagName());

		org.openqa.selenium.Dimension PsSize = Password.getSize();
		int Height1 = PsSize.height;
		int Width1 = PsSize.width;
		System.out.println("the heigth of password element=" + Height1 + "\n width=" + Width1);

		Point PasswordLocation = Password.getLocation();
		System.out.println("the password element position o x cordinate= " + PasswordLocation.x);
		System.out.println("the password element position on y cordinate = " + PasswordLocation.y);

		boolean PassWordactualresult = Password.isDisplayed();
		boolean passwordexpectedResult = true;
		if (passwordexpectedResult == PassWordactualresult) {
			System.out.println("isDisplayed test case is passed = " + PassWordactualresult);
		} else {
			System.out.println("isDisplayed test case is failed " + PassWordactualresult);
		}

		boolean actual = Password.isEnabled();
		boolean expected1 = true;
		if (expected1 == actual) {
			System.out.println("isEnabled test case is passed =" + actual);
		} else {
			System.out.println("isEnabled test case is failed =" + actual);
		}

		boolean actualSelect = Password.isSelected();
		boolean expectedSelect = false;
		if (expectedSelect == actualSelect) {
			System.out.println("isSelected test case is passed = " + actualSelect);
		} else {
			System.out.println("isSelected test case is failed = " + actualSelect);

		}
		System.out.println(Password.getAttribute("class"));

		String CssValue = Password.getCssValue("font-weight");
		System.out.println("font-weight of password element= " + CssValue);

// password input box test script -------
		System.err.println("password input box test script");
		WebElement PasswordInputBox = driver.findElement(By.xpath("//input[@name='user_password']"));
		PasswordInputBox.clear();
		PasswordInputBox.sendKeys("admin");
		boolean Actualresultforpasswordinput = PasswordInputBox.isDisplayed();
		boolean Expectedresultforpasswordinput = true;
		if (Expectedresultforpasswordinput == Actualresultforpasswordinput) {
			System.out.println("password input isDisplayed= " + Actualresultforpasswordinput);
		} else {
			System.out.println("password input isDisplayed= " + Actualresultforpasswordinput);
		}
		boolean ActualResultOfPasswordboxisEnabled = PasswordInputBox.isEnabled();
		boolean expectedResutofPassword = true;
		if (expectedResutofPassword == ActualResultOfPasswordboxisEnabled) {
			System.out.println("the password input box test case isEnabled =  " + ActualResultOfPasswordboxisEnabled);
		} else {
			System.out.println(
					"the password input box test case  is not Enabled =  " + ActualResultOfPasswordboxisEnabled);

		}

		boolean actualResultOfinput = PasswordInputBox.isSelected();
		boolean expectedResutlisNotSelected = false;
		if (expectedResutlisNotSelected == actualResultOfinput) {
			System.out.println("isSelected test case passed = " + actualResultOfinput);
		} else {
			System.out.println("isSelected test case failed = " + actualResultOfinput);

		}

		System.out.println("Height of input box =" + PasswordInputBox.getSize().height);
		System.out.println("Width of input box =" + PasswordInputBox.getSize().width);

		Point Inputlocation = PasswordInputBox.getLocation();
		System.out.println("input box x cordinate location= " + Inputlocation.x);
		System.out.println("input box y cordinate location= " + Inputlocation.y);
		System.out.println(PasswordInputBox.getCssValue("box-sizing"));

		// login Button test script----
		System.err.println("login Button test script");

		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='submitButton']"));
		org.openqa.selenium.Dimension BtnSize = LoginButton.getSize();
		int btnHeight = BtnSize.height;
		int btnWidth = BtnSize.width;
		System.out.println("LoginButton Height = " + btnHeight + "\n LoginButton width = " + btnWidth);
		System.out.println("Button Located on x cordinate = " + LoginButton.getLocation().x);
		System.out.println("Button Located on y cordinate = " + LoginButton.getLocation().y);

		boolean Actualbtnresult = LoginButton.isDisplayed();
		boolean expectedbtnresult = true;
		if (expectedbtnresult == Actualbtnresult) {
			System.out.println("Login Button isDisplayed = " + Actualbtnresult);
		} else {
			System.out.println("Login Button is not Displayed = " + Actualbtnresult);

		}
		boolean ActualEnabledResult = LoginButton.isEnabled();
		boolean expectedEnabled = true;
		if (expectedEnabled == ActualEnabledResult) {
			System.out.println("Login Button isEnabled = " + ActualEnabledResult);
		} else {
			System.out.println("Login Button is not Enabled = " + ActualEnabledResult);

		}
		boolean ActualisSelected = LoginButton.isSelected();
		boolean expectedisSelected = false;
		if (expectedisSelected == ActualisSelected) {
			System.out.println("Login button is not selecter (passed) = " + ActualisSelected);
		} else {
			System.out.println("Login button is selecter (failed) = " + ActualisSelected);

		}
		System.out.println("getCssValue of button padding-inline= " + LoginButton.getCssValue("padding-inline"));

		System.out.println(LoginButton.getTagName());
		System.out.println(LoginButton.getAttribute("value"));
		LoginButton.click();

		// driver.quit();
	}

}
