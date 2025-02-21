package priceCompare;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebElement searchbox = driver
				.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));

		String search = "FingerSleep";
		int charCount = search.length();
		for (int i = 0; i <= charCount - 1; i++) {
			char ch = search.charAt(i);
			String chr = ch + "";
			searchbox.sendKeys(chr);
			// Thread.sleep(1000);
		}
		searchbox.sendKeys(Keys.ENTER);

		List<WebElement> titles = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		for (int i = 0; i <= titles.size() - 29; i++) {

			System.out.println(titles.get(i).getText());
			titles.get(i).click();
			System.out.println("\n");

		}

		Set<String> allwindows = driver.getWindowHandles();
		for (String handels : allwindows) {
			System.out.println(handels);
			driver.switchTo().window(handels);
			String title = driver.getTitle();
			String exTitle="Battlestar tech Sleep-proof Screen Thumbs Finger Sleeve for PUBG Mobile Game(2ps) Gaming Finger Sleeve Price in India - Buy Battlestar tech Sleep-proof Screen Thumbs Finger Sleeve for PUBG Mobile Game(2ps) Gaming Finger Sleeve online at Flipkart.com";
			String ExpecetdTitle = "Creeknest tech Sleep-proof Screen Thumbs Finger Sleeve for PUBG Mobile Game(2ps) Gaming Finger Sleeve Price in India - Buy Creeknest tech Sleep-proof Screen Thumbs Finger Sleeve for PUBG Mobile Game(2ps) Gaming Finger Sleeve online at Flipkart.com";
			System.out.println(driver.getTitle());
			if (title.equals(ExpecetdTitle)) {
				//driver.switchTo().window(handels);
			WebElement price=	driver.findElement(By.xpath("//div[text()='₹235']"));
			System.out.println(price.getText());
				//driver.close();
			}else if(title.equals(exTitle)) {
				System.out.println("window 2 is opened !");
			}else {
				driver.close();
			}
		}
	}
}
