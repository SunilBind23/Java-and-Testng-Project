package priceCompare;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FramePractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm1']")));

		WebElement weselect = driver.findElement(By.xpath("//select[@class='selectnav' and @id='selectnav1']"));
		Select se = new Select(weselect);
		WebElement el = se.getFirstSelectedOption();
		System.out.println(el.getText());
		List<WebElement> opt = se.getOptions();
		for (int i = 0; i <= opt.size() - 1; i++) {
			System.out.println(opt.get(i).getText());
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_1']")));
		driver.findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Hello Frame");
	}

}
