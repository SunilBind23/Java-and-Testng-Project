package SeleniumByAjeetKumar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFlipcart {

	public static void main(String[] args) {
		
		ChromeDriver Driver =new ChromeDriver();
		
		Driver.get("https://amazon.in/");
		
	WebElement search=	Driver.findElement(By.xpath("//input[@placeholder=\"Search Amazon.in\"]"));

	search.click();
	search.sendKeys("mobile");
	
	Driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	
	
	
	
	for(int i=1;i<=23;i++) {
		String Title =Driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])["+i+"]")).getText();
		
		String moblieprice =Driver.findElement(By.xpath("(//span[@class='a-price-whole'])["+i+"]")).getText();
		System.out.println(Title+"-"+moblieprice);
		
		
		
		
		
	};
	
	}

}
