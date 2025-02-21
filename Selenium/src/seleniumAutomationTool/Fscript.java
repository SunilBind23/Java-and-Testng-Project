package seleniumAutomationTool;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Fscript {

	public static void main(String[] args) {
		ChromeDriver dr = new ChromeDriver();
	
		dr.get("http://localhost:8888/");
	
		By c = By.name("user_name");
		WebElement we = dr.findElement(c);
		we.sendKeys("admin");

		By wePass = By.name("user_password");
		WebElement ps = dr.findElement(wePass);
		ps.sendKeys("admin");

		By weClickButton = By.id("submitButton");
		WebElement click = dr.findElement(weClickButton);
		click.click();

		By weLeads = By.linkText("Leads");
		WebElement Leads = dr.findElement(weLeads);
		Leads.click();

		By Plusclick = By.xpath("//img[@alt='Create Lead...']");
		WebElement plus = dr.findElement(Plusclick);
		plus.click();

		By Firstname = By.xpath("//input[@name='firstname']");
		WebElement name = dr.findElement(Firstname);
		name.sendKeys("Sunil");

		By select = By.xpath("(//select[@class='small'])[2]");
		WebElement opt = dr.findElement(select);
		opt.sendKeys("Mr.");

		By Lname = By.xpath("//input[@name='lastname']");
		WebElement lastname = dr.findElement(Lname);
		lastname.sendKeys("Bind");

		By company = By.xpath("//input[@name='company']");
		WebElement Comp = dr.findElement(company);
		Comp.sendKeys("Microsoft");

		By title = By.xpath("//input[@name='designation']");
		WebElement Title = dr.findElement(title);
		Title.sendKeys("Important Notice");

		By AnnualRevenue = By.xpath("//input[@name='annualrevenue']");
		WebElement revenue = dr.findElement(AnnualRevenue);
		revenue.sendKeys("12000");

		By NoOfEmployees = By.xpath("//input[@name='noofemployees']");
		WebElement Emp = dr.findElement(NoOfEmployees);
		Emp.sendKeys("100");

		By Email = By.xpath("//input[@name='secondaryemail']");
		WebElement Ema = dr.findElement(Email);
		Ema.sendKeys("bindsunil9336@gmail.com");

		By Phone = By.xpath("//input[@id='phone']");
		WebElement CN = dr.findElement(Phone);
		CN.sendKeys("7991880288");

		By Mobile = By.xpath("//input[@id='mobile']");
		WebElement MobileNo = dr.findElement(Mobile);
		MobileNo.sendKeys("9151147684");

		By Fax = By.xpath("//input[@id='fax']");
		WebElement fax = dr.findElement(Fax);
		fax.sendKeys("Dummy");

		By Email2 = By.xpath("//input[@id='email']");
		WebElement em = dr.findElement(Email2);
		em.sendKeys("abcd@gmail.com");

		By Website = By.xpath("//input[@name='website']");
		
		WebElement web = dr.findElement(Website);
		
		web.sendKeys("SunilKumar.com");

		
		By select2 = By.xpath("//select[@name='leadstatus']");
		WebElement opt2 = dr.findElement(select2);
		opt2.sendKeys("Cold");

		By select3 = By.xpath("//select[@name='rating']");
		WebElement op3 = dr.findElement(select3);
		op3.sendKeys("Active");

		By radioBtn = By.xpath("//input[@value='T']");
		WebElement selectRadio = dr.findElement(radioBtn);
		selectRadio.click();

		By select4 = By.xpath("//select[@name='assigned_group_id']");
		WebElement op4 = dr.findElement(select4);
		op4.sendKeys("Support Group");

		By Street = By.xpath("//textarea[@name='lane']");
		WebElement str = dr.findElement(Street);
		str.sendKeys("Ugai ka pura");

		By PObox = By.xpath("//input[@id='pobox']");
		WebElement box = dr.findElement(PObox);
		box.sendKeys("Manager");

		By PsCode = By.xpath("//input[@name='code']");
		WebElement code = dr.findElement(PsCode);
		code.sendKeys("221406");

		By city = By.xpath("//input[@name='city']");
		WebElement sendCity = dr.findElement(city);
		sendCity.sendKeys("Bhadohi");

		By country = By.xpath("//input[@name='country']");
		WebElement Countryname = dr.findElement(country);
		Countryname.sendKeys("India");

		By state = By.xpath("//input[@name='state']");
		WebElement st = dr.findElement(state);
		st.sendKeys("Utter Pradesh");

		By des = By.xpath("//textarea[@name='description']");
		WebElement writeDesc = dr.findElement(des);
		writeDesc.sendKeys("This is my first script in automation");

		By save = By.xpath("//input[@class='crmbutton small save']");
		WebElement SaveThis = dr.findElement(save);
		SaveThis.click();

		By comment = By.xpath("(//textarea[@class='detailedViewTextBox'])[3]");
		WebElement sendComent = dr.findElement(comment);
		sendComent.sendKeys("this is very nice way to practice for automaton a fresher");

		By savecomment = By.xpath("(//input[@class='crmbutton small save'])[25]");
		WebElement sComment = dr.findElement(savecomment);
		sComment.click();

		By header = By.xpath("//span[@class='dvHeaderText']");
		WebElement headertext = dr.findElement(header);
		String headerFound = headertext.getText();
		System.out.println(headerFound);

		By edit = By.xpath("//[='']");
		WebElement Editbtn = dr.findElement(edit);
		System.out.println(Editbtn);
//		dr.close();

	}

}