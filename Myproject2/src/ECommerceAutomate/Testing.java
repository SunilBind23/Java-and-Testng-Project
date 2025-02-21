package ECommerceAutomate;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("phone");
		searchBox.sendKeys(Keys.ENTER);

		List<WebElement> allProductList = driver
				.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));

		for (int i = 0; i <= allProductList.size() - 20; i++) {
			WebElement product = allProductList.get(i);
			product.click();
		}

		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {

			driver.switchTo().window(h);
			String title = driver.getTitle();
			System.out.println(title);
			String expectedTitle = "POCO C61 Ethereal Blue 4GB RAM 64GB ROM";
			if (title.contains(expectedTitle)) {
				System.out.println("title mathced" + title);
				driver.findElement(By.xpath("(//input[@value='Add to Cart'])[2]")).click();
			} else {
				driver.close();
			}
		}

	}
}
