package priceCompare;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mobilesPriceCompaire {

	public static void main(String[] args) {
		ChromeDriver driver=	new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
        int minPrice = Integer.MAX_VALUE;
        int minIndex=-1;
		List<WebElement> MobilesPrice=	driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
	for(int i=0;i<MobilesPrice.size();i++) {
		
		String priceText = MobilesPrice.get(i).getText().replace("₹", "").replace(",", "").trim();
        int price = Integer.parseInt(priceText);
        System.out.println(price);
        if(price<minPrice) {
        	 minPrice = price;
//             minIndex = i;
        }
        
		//System.out.println(MobilesPrice.get(i).getText());
	}
	System.out.println("Lowest Price: ₹" + minPrice);
	
//	for(WebElement price:MobilesPrice) {
//		System.out.println(price.getText());
//	}
	
	}

}
