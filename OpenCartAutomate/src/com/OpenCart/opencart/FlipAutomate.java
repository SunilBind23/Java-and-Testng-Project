package com.OpenCart.opencart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FlipAutomate {

	public static void main(String[] args) {
		//
		ExtentReports extRepo = new ExtentReports();
		ExtentSparkReporter extLocation = new ExtentSparkReporter("D:\\OpenCartProject\\Flipcart.html");
		extRepo.attachReporter(extLocation);

		ExtentTest extTest = extRepo.createTest("FlipAutomate");
		ChromeDriver driver= new ChromeDriver();
		GenericMethodsForAutomation run = new GenericMethodsForAutomation();
		run.setExtentest(extTest);
		run.launchBrowser("chrome");

		run.hitURl("https://www.flipkart.com/");

		run.InputData(By.xpath("//input[@title='Search for Products, Brands and More']"), "hp laptop", "searchbox");

		run.getWebElements(By.xpath("//div[@class='KzDlHZ']"));

		List<WebElement> priceElements = run.getWebElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		run.Click(By.xpath("//button[@class='_2iLD__']"), "searchbox");
		priceElements.sort(Comparator.comparing(WebElement::getText));
		
		run.Click(By.xpath("//div[text()='Price -- Low to High']"), "Low to high");
		List<Integer> prices = new ArrayList<>();
		for (WebElement priceElement : priceElements) {
			
			String priceText = priceElement.getText().replaceAll("[^0-9]", ""); // Remove any currency symbols or commas
			prices.add(Integer.parseInt(priceText));
		}

		List<Integer> sortedPrices = new ArrayList<>(prices); // Create a copy of the prices list
		Collections.sort(sortedPrices);

		for (WebElement element : priceElements) {
			System.out.println(element.getText());
		}

		if (prices.equals(sortedPrices)) {
			System.out.println("Prices are sorted from low to high.");
		} else {
			System.out.println("Prices are NOT sorted from low to high.");
		}

		System.out.println(sortedPrices);

		extRepo.flush();
	}

}
