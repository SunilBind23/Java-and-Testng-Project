package com.eva.vtiger.testScripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class VerifyProductsScripts extends LoginSetup {

	public void VT001VerifyCreateProductAllFields(ExtentTest extTest) {

//		ExtentReports extReport = new ExtentReports();
//		extReport.createTest("");
//		

		login(extTest);

		String prName = "Dairy Milk";
		try {
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prName);
			extTest.log(Status.INFO, prName + " Product name entered");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			Select opt = new Select(driver.findElement(By.xpath("//select[@name='productcategory']")));

			opt.selectByValue("Hardware");
			extTest.log(Status.INFO, " Product category Selected");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Select weselect = new Select(driver.findElement(By.xpath("//select[@name='glacct']")));
			weselect.selectByValue("302-Rental-Income");
			extTest.log(Status.INFO, "GL Acct selected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Select selectOpt = new Select(driver.findElement(By.xpath("//select[@name='manufacturer']")));
			selectOpt.selectByValue("MetBeat Corp");
			extTest.log(Status.INFO, " Manufacturer selected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			driver.findElement(By.xpath("//input[@name='button']")).click();
			extTest.log(Status.INFO, "Product Saved successfully");

			String expectedProductName = "Dairy Milk";
			String actualProductName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

			if (expectedProductName.equals(actualProductName)) {
				extTest.log(Status.PASS, "Product name is Correct as actual" + actualProductName
						+ ", expectedProductName" + expectedProductName);

			} else {
				extTest.log(Status.PASS, "Product name is Incorrect actualProductName " + actualProductName
						+ ", expectedProductName " + expectedProductName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

	public void VT002VerifyCreateProductRequiredFields(ExtentTest extTest) {
		login(extTest);
		String prName = "Dairy Milk";
		try {
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prName);
			extTest.log(Status.INFO, prName + " Product name entered");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//input[@name='button']")).click();
			extTest.log(Status.INFO, "Product Saved successfully");

			String expectedProductName = "Dairy Milk";
			String actualProductName = "";
			try {
				actualProductName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (expectedProductName.equals(actualProductName)) {
				extTest.log(Status.PASS, "Product name is Correct as actual" + actualProductName
						+ ", expectedProductName" + expectedProductName);

			} else {
				extTest.log(Status.PASS, "Product name is Incorrect actualProductName " + actualProductName
						+ ", expectedProductName " + expectedProductName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

	public void VT003VerifyCreateProductWithoutRequiredFields(ExtentTest extTest) throws InterruptedException {

		login(extTest);
		String prName = " ";

		try {
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prName);
			extTest.log(Status.INFO, " Product name is empty");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Select opt = new Select(driver.findElement(By.xpath("//select[@name='productcategory']")));

			opt.selectByValue("Hardware");
			extTest.log(Status.INFO, " Product category Selected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Select weselect = new Select(driver.findElement(By.xpath("//select[@name='glacct']")));
			weselect.selectByValue("302-Rental-Income");
			extTest.log(Status.INFO, "GL Acct selected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Select selectOpt = new Select(driver.findElement(By.xpath("//select[@name='manufacturer']")));
			selectOpt.selectByValue("MetBeat Corp");
			extTest.log(Status.INFO, " Manufacturer selected");

			driver.findElement(By.xpath("//input[@name='button']")).click();
			Thread.sleep(3000);

			String alertText = driver.switchTo().alert().getText();

			extTest.log(Status.INFO, alertText + " alert massage ");
			driver.switchTo().alert().accept();
			extTest.log(Status.FAIL, "Product Saved unSuccessful");

		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File tsLocation = ts.getScreenshotAs(OutputType.FILE);
			File img = new File("D:\\Automation Test cases reports\\screenshots\\emptyProductName.jpg");
			Files.copy(tsLocation, img);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

	public void VT004VerifyCancleProduct(ExtentTest extTest) {
		login(extTest);
		String prName = "Dairy Milk";
		try {
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prName);
			extTest.log(Status.INFO, prName + " Product name entered");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (InvalidSelectorException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//input[@title='Cancel [Alt+X]']")).click();
			extTest.log(Status.INFO, "redirect to Products page");
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

	public void VT005VerifyEditCreatedProductFromDetailsPage(ExtentTest extTest) throws InterruptedException {
		login(extTest);
		String prName = "Dairy Milk";
		
		
		try {
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prName);
			extTest.log(Status.INFO, prName + " Product name entered");
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Select opt = new Select(driver.findElement(By.xpath("//select[@name='productcategory']")));
			opt.selectByValue("Hardware");

		} catch (InvalidSelectorException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		extTest.log(Status.INFO, " Product category Selected");
		try {
			driver.findElement(By.xpath("//input[@name='button']")).click();
			extTest.log(Status.INFO, "Product Saved successfully");

			String expectedProductName = "Dairy Milk";
			String actualProductName = "";
			try {
				actualProductName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
			} catch (NoSuchElementException e1) {
				e1.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if (expectedProductName.equals(actualProductName)) {
				extTest.log(Status.PASS, "Product name is Correct as actual" + actualProductName
						+ ", expectedProductName" + expectedProductName);

			} else {
				extTest.log(Status.PASS, "Product name is Incorrect actualProductName " + actualProductName
						+ ", expectedProductName " + expectedProductName);
			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement weEl = null;
		try {
			driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
			weEl = driver.findElement(By.xpath("//input[@value='Dairy Milk']"));
			weEl.clear();
			Thread.sleep(1000);

			extTest.log(Status.INFO, "Product name is Edited");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (InvalidSelectorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String EditedProductName = "5 Star";
		weEl.sendKeys(EditedProductName);

		try {
			driver.findElement(By.xpath("//input[@name='button']")).click();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		extTest.log(Status.INFO, "edited product saved successfully ");

		String expectedEditedProduct = EditedProductName;
		String actualEditedProductName = "";
		try {
			actualEditedProductName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (expectedEditedProduct.equals(actualEditedProductName)) {
			extTest.log(Status.PASS, "Product Name is Matched as expectedEditedProduct," + expectedEditedProduct
					+ ",Actual name," + actualEditedProductName);
		} else {
			extTest.log(Status.FAIL, "Product Name is missMatched as expectedEditedProduct," + expectedEditedProduct
					+ ",Actual name," + actualEditedProductName);
		}
	}

	public void VT006VerifyCreateProductByDuplicateProduct(ExtentTest extTest) throws InterruptedException {
		login(extTest);
		try {
			driver.findElement(By.name("productname")).sendKeys("iphone 15");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (InvalidSelectorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (InvalidSelectorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);
		try {
			driver.findElement(By.name("Duplicate")).click();

		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (InvalidSelectorException e) {
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// driver.findElement(By.xpath("")).sendKeys("");
		Thread.sleep(2000);
		WebElement weElement = driver.findElement(By.className("detailedViewTextBox"));
		weElement.clear();
		Thread.sleep(2000);
		String duplicateProduct = "Mobile";
		weElement.sendKeys(duplicateProduct);

		try {
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		} catch (InvalidSelectorException e) {
			e.printStackTrace();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		extTest.log(Status.INFO, "product duplicate created successfully");
		String ecpectedDuplicate = duplicateProduct;
		String actualDuplocate = driver.findElement(By.id("dtlview_Product Name")).getText();
		if (ecpectedDuplicate.equals(actualDuplocate)) {
			extTest.log(Status.PASS,
					"Duplicate Product Matched as expected" + ecpectedDuplicate + ", actual" + actualDuplocate);
		} else {
			extTest.log(Status.FAIL,
					"Duplicate Product did'nt Matche as expected" + ecpectedDuplicate + ", actual" + actualDuplocate);
		}
		driver.quit();
	}

	public void VT007VerifyDeleteProduct(ExtentTest extTest) {
		login(extTest);
	}

	public void VT008VerifyEditProductFromSearchResult(ExtentTest extTest) {
		login(extTest);
	}

	public void VT009VerifyDeleteProductFromSearchResult(ExtentTest extTest) {
		login(extTest);
	}

	public void VT0010VerifySearchProductByName(ExtentTest extTest) {
		login(extTest);

	}

}
