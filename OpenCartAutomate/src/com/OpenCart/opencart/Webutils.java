package com.OpenCart.opencart;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class Webutils {
	// private WebDriver driver;

	private WebDriver driver;

	private static ExtentTest et;

	public static void setExtentest(ExtentTest extenTestVariable) { // This is a setter method to set the value to the
																	// et variabloe of ExtentTest

		et = extenTestVariable;
	}

// method 1
	public WebDriver launchBrowser(String nameOFbrowser) {

		switch (nameOFbrowser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();

			break;
		case "edge":

			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();

			break;
		default:
			et.log(Status.INFO, "Ivalid browser name");
		}
		et.log(Status.INFO, nameOFbrowser + " launch successfully");

		return driver;
	}

	// method 2
	public void hitURl(String url) {
		try {
			// launchBrowser(driver, browserName, et);
			driver.get(url);
			et.log(Status.INFO, url + " hit successfully");
		} catch (NullPointerException e) {
			et.log(Status.INFO, url + " please provide a url" + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, url + " invalid  url" + e.getMessage());
		}
	}

	// method 3
	public WebElement getWebElement(By locator) {
		WebElement weElement = null;
		try {
			weElement = driver.findElement(locator);

		} catch (NullPointerException e) {
			launchBrowser("chrome");
			et.log(Status.INFO, "Your driver is null " + e.getMessage());

		} catch (NoSuchElementException e) {

			new WebDriverWait(driver, Duration.ofSeconds(10));

			weElement = driver.findElement(locator);
			et.log(Status.INFO, " element not found on the UI page");
		} catch (InvalidSelectorException e) {
			// weElement = driver.findElement(locator);
			throw e;
			// et.log(Status.INFO, " Please write a valid locator with rule");
		} catch (Exception e) {
			et.log(Status.INFO, " exception found" + e.getMessage());
		}

		return weElement;
	}

	public List<WebElement> getWebElements(By locator) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(locator);
			for (int i = 0; i <= elements.size() - 1; i++) {

				et.log(Status.INFO, elements.get(i).getText() + " element");
			}
		} catch (Exception e) {
			et.log(Status.INFO, "exception raised" + e.getMessage());
		}
		return elements;

	}

	// method 4
	public void InputData(By locator, String data, String tblbox) {
		WebElement weElement = null;
		try {
			weElement = getWebElement(locator);
			weElement.sendKeys(data);

			et.log(Status.INFO, data + " send successfully in " + tblbox);

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InvalidElementStateException e) {
			// Trying to Interact with a Disabled Element
			if (weElement.isEnabled()) {
				weElement.sendKeys(data);
			} else {
				et.log(Status.INFO, "Element is not in a writable state.");

			}

		} catch (StaleElementReferenceException e) {
			weElement = getWebElement(locator);
			weElement.sendKeys(data);
		} catch (InvalidArgumentException e) { /// Raised if the argument passed to sendKeys() is invalid, such as
			/// trying to pass

			if (data != null) {
				weElement.sendKeys(data);
			} else {
				et.log(Status.INFO, "Cannot send null to sendKeys.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method 5
	public void Click(WebElement element, String data) {
		
		try {
			element.click();
			et.log(Status.INFO, data + " Clicked successfully");
		} catch (ElementNotInteractableException e) {
			// Cause: The element is visible but not in a state that can be interacted with
			// (e.g., it might be disabled).
			if (element.isDisplayed()) {
				jsClick(element);
			} else {
				et.log(Status.INFO, "element no Interactable" + e.getMessage());
			}

		} catch (StaleElementReferenceException e) {
			// Cause: The element is no longer attached to the DOM (e.g., the page has been
			// refreshed or updated or change).
			
			element.click();

		} catch (InvalidElementStateException e) {
			// The element is present but in an invalid state (e.g., disabled).

			if (element.isEnabled()) {
				element.click();
				et.log(Status.PASS, "Element is  clickable state.");
			} else {
				et.log(Status.FAIL, "Element is not in a clickable state.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method 6
	public void getSize(WebElement element) {
		try {
			
			int height = element.getSize().height;
			int width = element.getSize().width;

			et.log(Status.INFO, height + " height " + width + "width ");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	// method 7
	public Set<String> getWindowHandles(String Expected) {

		// find elements no throw any exception its returns only empty list

		// getWebElements(locator);

//		for (int i = 0; i <= product.size() - 1; i++) {
//			product.get(i).click();
//			et.log(Status.INFO, product.get(i).getText() + "found successfull");

		// }

		Set<String> handles = driver.getWindowHandles();

		for (String hvalue : handles) {
			driver.switchTo().window(hvalue);
			// System.out.println(driver.getTitle());
			String ActualTitle = driver.getTitle();

			if (Expected.contains(ActualTitle)) {

				et.log(Status.INFO, driver.getTitle() + "title found successfull ");

			} else {

				et.log(Status.INFO, driver.getTitle() + "title not found");
				driver.close();
			}
		}
		return handles;

	}

	// method 8
	public void getText(By locator) {
		try {
			WebElement element = getWebElement(locator);
			et.log(Status.INFO, element.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method 9
	public void getTagName(By locator) {
		try {
			WebElement element = getWebElement(locator);
			et.log(Status.INFO, element.getTagName() + " Found successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method 10
	public String getWindowHandle() {
		String handle = null;
		try {
			handle = driver.getWindowHandle();
			driver.switchTo().window(handle);
			et.log(Status.INFO, driver.getWindowHandle());

		} catch (NoSuchWindowException e) {
			et.log(Status.INFO, driver.getWindowHandle());

		} catch (WebDriverException e) {

			et.log(Status.INFO, driver.getWindowHandle());
		} catch (IllegalStateException e) {
			if (driver != null) {

				et.log(Status.INFO, driver.getWindowHandle());
			} else {

				et.log(Status.INFO, "WebDriver is not initialized.");
			}
		}
		return handle;
	}

	// select class generic method
	// method 11
	public Select select(By locator) {
		WebElement element = getWebElement(locator);
		Select weSelect = new Select(element);

		return weSelect;
	}

	// method 12
	public void selectByValue(By locator, String value) {
		try {
			select(locator).selectByValue(value);
			et.log(Status.INFO, value + " selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method 13
	public void selectByVisibleText(By locator, String text) {
		try {
			select(locator).selectByVisibleText(text);
			et.log(Status.INFO, text + " selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method 14
	public void selectByIndex(By locator, int value) {
		try {
			select(locator).selectByIndex(value);
			// Select select = new Select(WeSelect);

			et.log(Status.INFO, value + " selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method 15
	public void getFirstSelectedText(By locator) {
		try {
			WebElement element = select(locator).getFirstSelectedOption();
			et.log(Status.INFO, element.getText());
		} catch (Exception e) {
			et.log(Status.INFO, "Exception " + e.getMessage().toString());
		}
	}

	// method 16
	public void verifySelectedText(By locator, String ExceptecdText) {
		try {
			String ActualText = select(locator).getFirstSelectedOption().getText();
			if (ActualText.equals(ExceptecdText)) {
				et.log(Status.PASS, "Text verification successful " + ActualText);
			} else {
				et.log(Status.FAIL, "Text verification failde " + ExceptecdText + "but got " + ActualText);
			}
		} catch (Exception e) {
			et.log(Status.INFO, "Exception " + e.getMessage().toString());
		}
	}
	// method 17

	public void getOptionsCount(By locator) {
		List<WebElement> optionCount = null;
		try {
			optionCount = select(locator).getOptions();

			for (int i = 0; i <= optionCount.size() - 1; i++) {
				et.log(Status.INFO, optionCount.get(i).getText());
			}
		} catch (Exception e) {
			et.log(Status.INFO, "exception " + e.getMessage().toString());
		}
	}

	// method 18
	public void deselectByIndex(By locator, int value) {
		try {
			select(locator).deselectByIndex(value);
			// Select select = new Select(WeSelect);

			et.log(Status.INFO, value + " selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method 19
	public void deselectByValue(By locator, String value) {
		try {
			select(locator).deselectByValue(value);
			// Select select = new Select(WeSelect);

			et.log(Status.INFO, value + " selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method 20
	public void deselectByVisibleText(By locator, String text) {
		try {
			select(locator).deselectByVisibleText(text);
			// Select select = new Select(WeSelect);

			et.log(Status.INFO, text + " selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method 21
	public void deselectAll(By locator) {
		try {
			select(locator).deselectAll();
			// Select select = new Select(WeSelect);

			et.log(Status.INFO, "all Deselected successful");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// mouse hover action
	// method 22
	public Actions MouseAction() {
		Actions act = null;
		try {
			act = new Actions(driver);

		} catch (NullPointerException e) {
			act = new Actions(driver);
			et.log(Status.INFO, "NullPointerException :- " + e.getMessage().toString());
		}

		catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}

		return act;

	}

	// method 23
	public void ActionsDragAndDrop(WebElement source, WebElement target) {

		try {
			MouseAction().dragAndDrop(source, target).build().perform();
			et.log(Status.INFO, "Element draged and drop successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "Element is not workig :- " + e.getMessage().toString());
		}
	}

	// method 24
	public void ActionsclickAndHold(WebElement target) {
		try {
			MouseAction().clickAndHold(target).build().perform();
			et.log(Status.INFO, "clickAndHold successfull");

		} catch (Exception e) {
			et.log(Status.INFO, "Exception " + e.getMessage().toString());
		}
	}

	// method 25
	public void ActionsRightClick(WebElement target) {
		try {
			MouseAction().contextClick(target).build().perform();
			et.log(Status.INFO, "rightClick successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "Raised Exception :-" + e.getMessage().toString());
		}
	}

	// method 26
	public void ActionsDoubleClick(WebElement target) {
		try {
			MouseAction().doubleClick(target).build().perform();
			et.log(Status.INFO, "double click successfull");
		} catch (Exception e) {
			et.log(Status.INFO, " exception raised :-" + e.getMessage().toString());
		}
	}

	// method 27
	public void ActionsmoveToElement(WebElement target) {
		try {
			MouseAction().moveToElement(target).build().perform();
			et.log(Status.INFO, "element moved");
		} catch (Exception e) {
			et.log(Status.INFO, "Exception raised :- " + e.getMessage().toString());
		}
	}

	// method 28
	public void ActionsScrollToElement(WebElement element) {
		try {
			MouseAction().scrollToElement(element).build().perform();
			et.log(Status.INFO, "mouse  scrollto element successfull ");
		} catch (Exception e) {
			et.log(Status.INFO, "exception raised :-" + e.getMessage().toString());
		}
	}

	// method 29
	public void ActionsScrollByAmount(int x, int y) {
		try {
			MouseAction().scrollByAmount(x, y).build().perform();
			et.log(Status.INFO, "Element scrol successfull by amount");
		} catch (Exception e) {
			et.log(Status.INFO, "exception raised :- " + e.getMessage().toString());
		}
	}

	// method 30
	public void ActionsScrollFromOrigin(ScrollOrigin scrollOrigin, int deltaX, int deltaY) {
		try {
			MouseAction().scrollFromOrigin(scrollOrigin, deltaX, deltaY).build().perform();
			et.log(Status.INFO, "element scrollFromOrigin");
		} catch (Exception e) {
			et.log(Status.INFO, "Exception raised :- " + e.getMessage().toString());
		}
	}

	// method 31
	public void ActionsClickAction(WebElement target) {
		try {
			MouseAction().click(target).build().perform();
			et.log(Status.INFO, "Action clicked successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "Not clickable");
		}
	}

	// method 32
	public void ActionsSendkeysActionClass(String value, String elementName, WebDriver driver) {
		try {
			MouseAction().sendKeys(value).build().perform();
			et.log(Status.INFO, "Value send successfull in " + elementName);
		} catch (Exception e) {
			et.log(Status.INFO, " " + elementName);
		}
	}

	// method 33
	public void ActionMoveToLocationOfElement(int Xcordinate, int Ycordinate) {
		try {
			MouseAction().moveToLocation(Xcordinate, Ycordinate).build().perform();
			et.log(Status.INFO, "Element move on the location");
		} catch (Exception e) {
			et.log(Status.INFO, "Element not move on the location");
		}
	}

	// method 34
	public void UploadFile(By locator, String imgPath, String tablebox) {
		try {
			// xpath===By.xpath("//input[@type='file'] formate xapth same
			// getWebElement( locator);
			// el.sendKeys(imgPath);
			InputData(locator, imgPath, tablebox);
			et.log(Status.INFO, imgPath + "send successfull in " + tablebox);

		} catch (Exception e) {
			et.log(Status.INFO, imgPath + "send not send in  " + tablebox);
		}
	}

	// method 35
	public void switchMyFrameBIndex(int enterIndexNumber) {
		try {
			driver.switchTo().frame(enterIndexNumber);
			et.log(Status.INFO, " switch on frame successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "no switch on frame");
		}

	}

	// method 38
	public void switchMyFrameById(String enterName_Id) {
		try {
			driver.switchTo().frame(enterName_Id);
			et.log(Status.INFO, " switch on frame successfull by id");
		} catch (Exception e) {
			et.log(Status.INFO, "no switch on frame");
		}
	}

	// method 37
	public void switchMyFrame(WebElement we) {
		try {
			driver.switchTo().frame(we);
			et.log(Status.INFO, " switch on frame successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "no switch on frame");
		}
	}

	// method 38
	public void switchMyFrameToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			et.log(Status.INFO, " switch on default frame successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "no switch on frame");
		}
	}

	// method 39
	public void switchMyFrameToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			et.log(Status.INFO, " switch on parent frame successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "no switch on frame");
		}
	}

	// method 40
	public void takeSnapShot(String ImgPathWithExtention) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File img = ts.getScreenshotAs(OutputType.FILE);

			File location = new File(ImgPathWithExtention);
			try {
				Files.copy(img, location);
			} catch (IOException e) {
				et.log(Status.INFO, "not found:- " + e.getMessage().toString());

			}
		} catch (Exception e) {
			et.log(Status.INFO, "not able to capture snapshot an exception is:- " + e.getMessage().toString());
		}

	}

	// method 41
	public ChromeOptions ChromeOptionsObjcets() {
		ChromeOptions co = null;
		try {
			co = new ChromeOptions();
			et.log(Status.INFO, "chrome Option created successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "chrome option is not created and exception is:- " + e.getMessage().toString());
		}

		return co;
	}
	// method 42

	public void myHeadlessBrowser() {

		try {
			ChromeOptionsObjcets().addArguments("--headless");
			et.log(Status.INFO, "browser is opened in headless mode");
		} catch (Exception e) {
			et.log(Status.INFO,
					"browser is not opened is headless mode an exception is :- " + e.getMessage().toString());
		}

	}

//method 43
	public void myIncognitoMode() {

		try {
			ChromeOptionsObjcets().addArguments("--incognito");
			et.log(Status.INFO, "browser is opened in incognito mode");
		} catch (Exception e) {
			et.log(Status.INFO,
					"browser is not opened in incognito mode an exception is :- " + e.getMessage().toString());
		}

	}

//	method 44
	public JavascriptExecutor javaScriptObj() {
		JavascriptExecutor jse = null;
		try {
			jse = (JavascriptExecutor) driver;
			et.log(Status.INFO, "javascript Executer onject created ");
		} catch (NullPointerException e) {
			et.log(Status.INFO, " null pointer exception :- " + e.getMessage().toString());
		} catch (Exception e) {
			et.log(Status.INFO, "exception is :- " + e.getMessage().toString());
		}
		return jse;
	}

//	method 45
	public void JavaScriptScrollIntoView(WebElement we) {

		try {
			javaScriptObj().executeScript("arguments[0].scrollIntoView();", we);
			et.log(Status.INFO, "element scroll successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "element not scrolled by scrollIntoView exception :- " + e.getMessage().toString());
		}
	}

//	method 46
	public void getAlertText(String ExpectedText) {
		try {
			String ActualText = driver.switchTo().alert().getText();
			if (ActualText.equals(ExpectedText)) {
				et.log(Status.PASS, ActualText + "we got successfully");
			} else {
				et.log(Status.FAIL, ExpectedText + "but got " + ActualText);
			}
		} catch (Exception e) {
			et.log(Status.INFO, " Exception raised " + e.getMessage().toString());
		}
	}

//	method 47
	public void AcceptAlert() {
		try {
			driver.switchTo().alert().accept();
			et.log(Status.INFO, "popup accepted");
		} catch (Exception e) {
			et.log(Status.INFO, "exception Raised " + e.getMessage().toString());
		}
	}

//	method 48
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			et.log(Status.INFO, "popup accepted");
		} catch (Exception e) {
			et.log(Status.INFO, "exception Raised " + e.getMessage().toString());
		}
	}

//	method 49
	public void switchTOWindowByTitle(String expectedTitle) {
		try {
			String MainWindow = driver.getWindowHandle();

			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
				String ActualTitle = driver.getTitle();
				// Check if the window title matches the expected title
				if (ActualTitle.equals(expectedTitle)) {
					et.log(Status.PASS, "Switched to window with title: " + expectedTitle);
					return; // Exit the method after switching to the correct window
				}
			}
			// If no window with the expected title was found, log failure
			et.log(Status.FAIL, "No window found with title: " + expectedTitle);
			// Optionally, switch back to the original window
			driver.switchTo().window(MainWindow);
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to switch to window with title: " + expectedTitle);
		}
	}

//	method 50
	public void switchToWindowByTitleContains(String partialTitle) {
		try {
			// Get the current window handle to return later if needed
			String originalWindow = driver.getWindowHandle();

			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);

				// Check if the window title contains the partial title
				if (driver.getTitle().contains(partialTitle)) {
					et.log(Status.PASS, "Switched to window with title containing: " + partialTitle);
					return; // Exit the method after switching to the correct window
				}
			}

			// If no window with the partial title was found, log failure
			et.log(Status.FAIL, "No window found with title containing: " + partialTitle);
			// Optionally, switch back to the original window
			driver.switchTo().window(originalWindow);
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to switch to window with title containing: " + partialTitle);
		}
	}

//	method 51
	public void switchToWindowByUrl(String expectedUrl) {
		try {
			// Get the current window handle to return later if needed
			String originalWindow = driver.getWindowHandle();

			// Iterate through open windows
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);

				// Check if the window URL matches the expected URL
				if (driver.getCurrentUrl().equals(expectedUrl)) {
					et.log(Status.PASS, "Switched to window with URL: " + expectedUrl);
					return; // Exit the method after switching to the correct window
				}
			}

			// If no window with the expected URL was found, log failure
			et.log(Status.FAIL, "No window found with URL: " + expectedUrl);
			// Optionally, switch back to the original window
			driver.switchTo().window(originalWindow);
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to switch to window with URL: " + expectedUrl);
		}
	}

//	method 52
	public void switchToWindowByUrlContains(String partialUrl) {
		try {
			// Get the current window handle to return later if needed
			String originalWindow = driver.getWindowHandle();

			// Iterate through open windows
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);

				// Check if the window URL contains the partial URL
				if (driver.getCurrentUrl().contains(partialUrl)) {
					et.log(Status.PASS, "Switched to window with URL containing: " + partialUrl);
					return; // Exit the method after switching to the correct window
				}
			}

			// If no window with the partial URL was found, log failure
			et.log(Status.FAIL, "No window found with URL containing: " + partialUrl);
			// Optionally, switch back to the original window
			driver.switchTo().window(originalWindow);
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to switch to window with URL containing: " + partialUrl);
		}
	}

//	method 53
	public void jsClick(WebElement element) {
		try {
			javaScriptObj().executeScript("arguments[0].click();", element);
			et.log(Status.INFO, "javaScript click successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "javaScript not work");
		}
	}

//	method 54
	public void jsScrollToElement(WebElement element) {
		try {
			javaScriptObj().executeScript("arguments[0].ScrollToElement();", element);
			et.log(Status.INFO, "javaScript ScrollToElement successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "javaScript not work");
		}
	}

//	method 55
	public void jsScrollToBottom(WebElement element) {
		try {
			// Scroll the element into view if it exists
			javaScriptObj().executeScript("arguments[0].scrollIntoView();", element);
			// Alternatively, to scroll the entire page to the bottom:
			// myjavaScriptObj(driver, et).executeScript("window.scrollTo(0,
			// document.body.scrollHeight);");

			et.log(Status.INFO, "JavaScript scroll to bottom successful");
		} catch (Exception e) {
			et.log(Status.INFO, "JavaScript scroll did not work");
		}
	}

//	method 56
	public void jsScrollDown() {
		try {
			// Scrolls down by 500 pixels
			javaScriptObj().executeScript("window.scrollBy(0, 500);");
			et.log(Status.INFO, "JavaScript scroll down by 500 pixels successful");
		} catch (Exception e) {
			et.log(Status.INFO, "JavaScript scroll down failed");
		}
	}

//	method 57
	public void closeBrowser() {
		try {
			driver.close();
			et.log(Status.INFO, "browser close successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "browser did not close an exception :-" + e.getMessage().toString());
		}

	}

//	method 58
	public void closeAllBrowser() {
		try {
			driver.quit();

			et.log(Status.INFO, "All browser close successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "browsers did not close an exception :-" + e.getMessage().toString());
		}

	}

//	method 59
	public void RefreshPage() {
		try {
			driver.navigate().refresh();
			et.log(Status.INFO, "page refresh successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "page did not refresh " + e.getMessage().toString());
		}

	}

//	method 60
	public void goBack() {
		try {
			driver.navigate().back();
			et.log(Status.INFO, "page back successfull");
		} catch (Exception e) {
			et.log(Status.INFO, "page did not back " + e.getMessage().toString());
		}
	}

//	method 61
	public void verifyInnerText(WebElement element, String expectedText) {
		try {
			String ActualText = element.getText();
			if (ActualText.equals(expectedText)) {
				et.log(Status.PASS, ActualText + " Text verification successful");
			} else {
				et.log(Status.FAIL, " Text verification failed. Expected ");
			}
		} catch (Exception e) {
			et.log(Status.INFO, " Failed to retrieve text from the element ");
		}

	}

//	method 62
	public void verifyAttributeValue(WebElement element, String AttributeName, String ExpectedValue) {
		try {
			String ActulAttributeValue = element.getAttribute(AttributeName);
			if (ActulAttributeValue != null && ActulAttributeValue.equals(ExpectedValue)) {
				et.log(Status.PASS,
						"Attribute verification successful: " + AttributeName + " = " + ActulAttributeValue);
			} else {
				et.log(Status.FAIL, "Attribute verification failed. Expected: " + ExpectedValue + ", but got: "
						+ ActulAttributeValue);
			}
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to retrieve attribute value for " + AttributeName);
		}
	}

//	method 63
	public void verifyPageTitle(WebElement element, String ExpectedTitle) {
		try {
			String ActualTitle = driver.getTitle();
			if (ActualTitle.equals(ExpectedTitle)) {
				et.log(Status.PASS, "Title verification successful:");
			} else {
				et.log(Status.FAIL,
						"Title verification failed. Expected: " + ExpectedTitle + ", but got: " + ActualTitle);
			}
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to retrieve title ");
		}
	}

//	method 64
	public void verifyEnabled(WebElement element) {
		try {
			if (element.isEnabled()) {
				et.log(Status.PASS, "Element is enabled.");
			} else {
				et.log(Status.FAIL, "Element is not enabled.");
			}

		} catch (Exception e) {
			et.log(Status.INFO, "Failed to determine if element is enabled.");
		}
	}

//	method 65
	public void verifyVisible(WebElement element) {
		try {
			if (element.isDisplayed()) {
				et.log(Status.PASS, "Element is Displayed");
			} else {
				et.log(Status.FAIL, "Element is not Displayed");
			}
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to determine if element is Displayed.");
		}
	}

//	method 66
	public void verifyElementCount(By locator, int expectedCount) {
		try {
			// Find all elements matching the given locator
			List<WebElement> elements = getWebElements(locator);

			// Get the actual count of elements found
			int actualCount = elements.size();

			// Compare the actual count with the expected count
			if (actualCount == expectedCount) {
				et.log(Status.PASS,
						"Element count verification successful. Found " + actualCount + " elements as expected.");
			} else {
				et.log(Status.FAIL, "Element count verification failed. Expected " + expectedCount
						+ " elements, but found " + actualCount);
			}
		} catch (Exception e) {
			et.log(Status.INFO, "Failed to verify element count.");
		}
	}

	// synchronization
	// wait- static wait - thread.sleep
	// dynamic wait
	// implicit wait-1 condition - presence of elements in html
	/// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	// explicit wait
	// 1) explicitly add
	// you can mention your condition for which you want to wait
	// prasenese in html visibility invisibility enabled enabled disabled

	// fluent wait

//	method 67
	public void waitForElementForVisibility(WebElement weElement, int maxTimeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(maxTimeouts));
		wt.until(ExpectedConditions.visibilityOf(weElement));
	}

//	method 68
	public void WaitForElementEnabled(WebElement weElement, int maxtTimeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(maxtTimeouts));
		wt.until(ExpectedConditions.elementToBeClickable(weElement));
	}

//	method 69
	public void waitforInvisiblity(WebElement weElement, int maxtTimeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(maxtTimeouts));
		wt.until(ExpectedConditions.invisibilityOf(weElement));
	}

//	method 70
	public void waitForTextInElement(WebElement weElement, int maxtTimeouts, String text) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(maxtTimeouts));
		wt.until(ExpectedConditions.textToBePresentInElement(weElement, text));
	}

//	method 71
	public void waitForElementDisbled(WebElement weElement, int maxtTimeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(maxtTimeouts));
		wt.until(ExpectedConditions.elementToBeClickable(weElement));
	}

	// method 72
	public void fluentWait(int timeouts) {
		FluentWait ftw = new FluentWait<WebDriver>(driver);
		ftw.pollingEvery(Duration.ofMillis(100));
		ftw.withTimeout(Duration.ofSeconds(timeouts));
		ftw.ignoring(NoSuchElementException.class);

	}

}
