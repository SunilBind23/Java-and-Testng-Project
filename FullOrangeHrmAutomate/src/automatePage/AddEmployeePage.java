
package automatePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.base.TestBase.*;

import utils.WebUtil;

public class AddEmployeePage{
	private WebUtil wt;

	public AddEmployeePage(WebUtil wbt) {
		wt = wbt;
		PageFactory.initElements(wt.getDriver(), this);
	}

	// Page Elements

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement FistName;

	@FindBy(xpath = "//input[@id='middleName']")
	private WebElement MiddleName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement Lastname;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement Photograph;

	@FindBy(xpath = "//input[@id='chkLogin']")
	private WebElement LoginCheckBox;

	@FindBy(xpath = "//input[@id='user_name']")
	private WebElement UserName;

	@FindBy(xpath = "//input[@id='user_password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='re_password']")
	private WebElement ConfirmPassword;

	@FindBy(xpath = "//select[@id='status']")
	private WebElement StatusDropDown;

	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement SaveButton;

	public void EnterFirstName(String firstName) {
		wt.type(FistName, firstName, "FistName");
	}

	public void EnterMiddleName(String middleName) {
		wt.type(MiddleName, middleName, "MiddleName");
	}

	public void EnterLastName(String LastName) {
		wt.type(this.Lastname, LastName, "Lastname");
	}

	public void UploadImage(String ImgPath) {
		wt.type(Photograph, ImgPath, "Photograph Uploaded");
	}
}
