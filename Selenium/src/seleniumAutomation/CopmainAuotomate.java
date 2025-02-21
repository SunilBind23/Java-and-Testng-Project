package seleniumAutomation;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CopmainAuotomate {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		Actions weActions = new Actions(driver);
		WebElement hoverOnElement = driver.findElement(By.linkText("More"));
		weActions.moveToElement(hoverOnElement).build().perform();

		// weActions.scrollFromOrigin(null, 0, 0)

		WebElement ClickonCampaigns = driver.findElement(By.linkText("Campaigns"));
		// System.out.println(ClickonCampaigns.getText());

		weActions.click(ClickonCampaigns).build().perform();

		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		WebElement sendValue = driver.findElement(By.xpath("//input[@name='campaignname']"));
		weActions.sendKeys(sendValue, "EVS").build().perform();

		WebElement weradionButton = driver.findElement(By.xpath("(//input[@name='assigntype'])[1]"));

		boolean ActualRadioButtonResult = weradionButton.isSelected();

		boolean ExceptedResult = true;
		if (ExceptedResult == ActualRadioButtonResult) {
			System.out.println("Test case Pass !");
		} else {
			System.out.println("Test case Failed !");
		}
		WebElement weselect = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));

		Select weSelect = new Select(weselect);
		String actualRes = weSelect.getFirstSelectedOption().getText();
		String ExceptedResOfSelect = "Administrator";

		if (ExceptedResOfSelect.equals(actualRes)) {
			System.out.println("test case pass ! ");
		} else {
			System.out.println("tase case fail !");
		}

		WebElement Campaign_Type = driver.findElement(By.xpath("//select[@name='campaigntype']"));
		Select selectOnCampaign_Type = new Select(Campaign_Type);
		selectOnCampaign_Type.selectByValue("Email");

		driver.findElement(By.xpath("//input[@name='targetaudience']")).sendKeys("It Student");
		// new Actions(driver);
		driver.findElement(By.xpath("//input[@name='sponsor']")).sendKeys("sunil");
		driver.findElement(By.xpath("//input[@name='numsent']")).sendKeys("85%");

		WebElement weselect2 = driver.findElement(By.xpath("//select[@name='campaignstatus']"));
		Select weSelecter = new Select(weselect2);
		System.out.println(weSelecter.getFirstSelectedOption().getText());
		weSelecter.selectByValue("Inactive");

		driver.findElement(By.xpath("//input[@id='targetsize']")).sendKeys("50");

		Actions wescroll = new Actions(driver);
		WebElement scrolling = driver.findElement(By.linkText("vtiger.com"));
		wescroll.scrollToElement(scrolling).build().perform();

	}

}
