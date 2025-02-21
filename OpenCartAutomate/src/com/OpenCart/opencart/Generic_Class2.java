package com.OpenCart.opencart;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class Generic_Class2 {

	private WebDriver driver;

	private static ExtentTest et;

	public static void setExtentest(ExtentTest extenTestVariable) { // This is a setter method to set the value to the
																	// et variabloe of ExtentTest

		et = extenTestVariable;
	}

//1.) ++++++++++++++++++++This is the method of Launch browser++++++++++++++++

	public WebDriver mylaunchBrowserWithoutChromeOptions(String brwoserName, int enterWaitTimeInSecond) {
		try {
			switch (brwoserName.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				et.log(Status.INFO, brwoserName + " browser launched successfully ");
				break;
			case "firefox":
				driver = new FirefoxDriver();
				et.log(Status.INFO, brwoserName + "browser launched successfully ");
				break;
			case "edge":
				driver = new EdgeDriver();
				et.log(Status.INFO, brwoserName + " browser launched successfully ");
				break;
			case "safari":
				driver = new SafariDriver();
				et.log(Status.INFO, brwoserName + " browser launched successfully ");
				break;
			default:
				et.log(Status.FAIL,
						brwoserName + " -  This is not a valid browser name please enter valid browser name ");
			}
		} catch (SessionNotCreatedException e) {
			et.log(Status.INFO, "this is a exception which name is -  " + e.getMessage());

		} catch (NullPointerException e) {
			et.log(Status.INFO, "this is a null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "this is a exception which name is -  " + e.getMessage());
		}

		myDynamicWait(enterWaitTimeInSecond);
		return driver;
	}

	// 2.) ++++++++++++++++This is the method of Open URL++++++++++++++++++++++++

	public void myopenURL(String url) {
		try {
			driver.get(url);
			et.log(Status.INFO, " URL hitted successfully here URL is - " + url);
		} catch (InvalidArgumentException e) {
			et.log(Status.INFO, "please enter valid URL and your URL is - " + url);
		} catch (Exception e) {
			et.log(Status.INFO, "URL is not hitted so first check URL here your exception is - " + e.getMessage());
		}
	}

	// 3.) ++++++++++++++This is the mothod of Close Browser+++++++++++++++++++++++

	public void myCloseBrowser() throws SocketException {
		try {
			driver.close();
			et.log(Status.INFO, "Browser is closed successfully ");
		} catch (Exception e) {
			et.log(Status.FAIL, "Browser not closed and exception is - " + e.getMessage());
		}

	}

	// 4.) ++++++++++++This is the method of Quit Browser+++++++++++++++++++++++=++

	public void myquitBrowser() {
		try {
			driver.quit();
			et.log(Status.INFO, "Browser is Quited successfully ");
		} catch (Exception e) {
			et.log(Status.FAIL, "Browser not Quited and exception is - " + e.getMessage());
		}
	}

	// 5.) ++++++++++++This is the method of getCurrentURL+++++++++++++++++++++++

	public String mycurrentURL() {
		String currentURL = null;
		try {
			currentURL = driver.getCurrentUrl();
			et.log(Status.INFO, "my current URL is - " + currentURL);
		} catch (NullPointerException e) {
			et.log(Status.INFO, "this is a null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "this is exception " + e.getMessage());
		}
		return currentURL;
	}

	// 6.) +++++++++++++This is the mehtod of getTitle+++++++++++++++++++++++++++++

	public String myTitle() {
		String title = null;
		try {
			title = driver.getTitle();
			et.log(Status.INFO, "my current title is - " + title);
		} catch (NullPointerException e) {
			et.log(Status.INFO, "this is a null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "this is exception " + e.getMessage());
		}
		return title;
	}

	// 7.) ++++++++++++This is the method of getWindowHandle++++++++++++++++++++++++

	public String getmyMainWindowHandleValue() {
		String windowHandle = null;
		try {
			windowHandle = driver.getWindowHandle();
			et.log(Status.INFO, "this is my main window handle value");
		} catch (NoSuchWindowException e) {
			et.log(Status.INFO, "no such window exception");
		} catch (Exception e) {
			et.log(Status.INFO, "exceptin is - " + e.getMessage());
		}
		return windowHandle;
	}

	// 8.) +++This is the method of getWindowHandles without closing all tab+++++

	public void mySwitchToWindow_WithoutcloseRemainingTab(String enterTitlwOrURLhere) {
		try {
			Set<String> whs = driver.getWindowHandles();
			for (String wh : whs) {
				driver.switchTo().window(wh);
				if (enterTitlwOrURLhere.equalsIgnoreCase(myTitle())) {
					et.log(Status.INFO, "Window focus is switched successfully on this Title - " + enterTitlwOrURLhere);
					break;
				} else if (enterTitlwOrURLhere.equalsIgnoreCase(mycurrentURL())) {
					et.log(Status.INFO, "Window focus is switched successfully on this URL - " + enterTitlwOrURLhere);
					break;
				}

			}
		} catch (NoSuchWindowException e) {
			et.log(Status.INFO, "no such window exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, " for the window the exception is - " + e.getMessage());
		}
	}

	// 9.) ++This is the method of getWindowHandles with close all tab except one++

	public void mySwitchToWindow_WithCloseAllRemainingTab(String enterTitlwOrURLhere) throws SocketException {
		try {
			Set<String> whs = driver.getWindowHandles();
			for (String wh : whs) {
				driver.switchTo().window(wh);
				if (enterTitlwOrURLhere.equalsIgnoreCase(myTitle())) {
					et.log(Status.INFO,
							"Window focused is changed successfully on this titel - " + enterTitlwOrURLhere);
					continue;
				} else if (enterTitlwOrURLhere.equalsIgnoreCase(mycurrentURL())) {
					et.log(Status.INFO, "Window focused is changed successfully on this URL - " + enterTitlwOrURLhere);
					continue;
				} else {
					myCloseBrowser();
					et.log(Status.INFO, "remaing window is closed successfully");
				}

			}
		} catch (NoSuchWindowException e) {
			et.log(Status.INFO, "no such window exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, " for the window the exception is - " + e.getMessage());
		}
	}

	// 10.) +++++++++++ This is the method of navigate to forword+++++++++++++++++++

	public void mynavigateToForword() {
		try {
			driver.navigate().forward();
			et.log(Status.INFO, "Clicked on forword option successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "Forword Option is not pressed and exception is - " + e.getMessage());
		}
	}

	// 11.) ++++++++ This is the method of navigate to backword++++++++++++

	public void mynavigateToBack() {
		try {
			driver.navigate().back();
			et.log(Status.INFO, "Clicked on Back Option successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "Back Option is not pressed and exception is - " + e.getMessage());
		}
	}

	// 12.) ++++++ This is the method of navigate to Refresh the page++++++++

	public void mynavigateToRefreshPage() {
		try {
			driver.navigate().refresh();
			et.log(Status.INFO, "Page is refreshed successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "Page is not refreshed and exception is - " + e.getMessage());
		}
	}

	// 13.) ++++++++ This is the method of navigate to backword+++++++++++

	public void mynavigateToURL(String urlValue) {
		try {
			driver.navigate().to(urlValue);
			et.log(Status.INFO, "page is navigated to new url value successfully and url is - " + urlValue);
		} catch (Exception e) {
			et.log(Status.INFO, " URL is not navigated and exception is - " + e.getMessage());
		}
	}

	// 14.) ++++++ This is the mehod of implicity wait+++++++++++++++++

	public void myDynamicWait(int enterWaitTimeInSecond) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(enterWaitTimeInSecond));
		} catch (Exception e) {
			et.log(Status.INFO, "implicity wait is not working properly and here Exception is - " + e.getMessage());
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////

	// 15.) ++++++++++++++This is the method of findElement+++++++++++

	public WebElement getmyWebElement(By locator, String elementName) {
		WebElement we = null;
		try {
			we = driver.findElement(locator);
			et.log(Status.INFO, "found " + elementName + " Element successfully");

		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
			
		} catch (NoSuchElementException e) {
			et.log(Status.INFO, "This is the NoSuchelement Exception " + e.getMessage());

		} catch (InvalidSelectorException e) {
			et.log(Status.INFO,
					"This is your wrong xpath syntax please check it again and correct it " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is Exception occured " + e.getMessage());

		}
		return we;
	}

	// 16.) +++++++++++++++This is the method of Click++++++++++++++++++

	public void myClick(WebElement we, String elementName) {
		try {
			we.click();
			////// String elementName= we.getAccessibleName();

			et.log(Status.INFO, elementName + " is clicked successfully");
		} catch (ElementClickInterceptedException e) {
			// here i am going to perform javaScript Click
			myJavaScriptClick(we, elementName);
		} catch (ElementNotInteractableException e) {
			// here i am going to perform javaScript Click
			myJavaScriptClick(we, elementName);
		} catch (Exception e) {
			et.log(Status.INFO, "unknown exception " + e.getMessage());
		}

	}

	// 17.) ++++++++++++This is the method of Clear++++++++++++++++++++++++++++++

	public void clear(WebElement we, String elementName) {
		try {
			we.clear();
			et.log(Status.INFO, elementName + " is Cleared Sussessfully");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, elementName + " Element not found");
		} catch (Exception e) {
			et.log(Status.INFO, elementName + " unknown exception " + e.getMessage());
		}

	}

	// 18.) ++++++++++++This is the method of SendKeys+++++++++++++

	public void mySendKeys(WebElement we, String sendValue, String elementName) {
		try {
			we.sendKeys(sendValue);
			et.log(Status.INFO, "Data entered successfuly in " + elementName + " here Data is - " + sendValue);

		} catch (ElementNotInteractableException e) {

			myJavaScriptSendKeys(we, sendValue, elementName);

		} catch (StaleElementReferenceException e) {
			we.sendKeys(sendValue);
			et.log(Status.INFO, "This is StaleElementReferenceException");

		} catch (InvalidElementStateException e) {
			et.log(Status.INFO, "This is InvalidElementStateException");

		} catch (InvalidArgumentException e) {
			et.log(Status.INFO, "This is InvalidArgumentException");

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 19.) +++++++++ This is the method of findElements+++++++++++++++++++++

	public List<WebElement> myFindAllElements(By locator, String elementsName) {

		List<WebElement> a = null;
		try {
			a = driver.findElements(locator);
			et.log(Status.INFO, "found all" + elementsName + " Elements successfully ");
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (NoSuchElementException e) {
			et.log(Status.INFO, "This is the NoSuchelement Exception " + e.getMessage());

		} catch (InvalidSelectorException e) {
			et.log(Status.INFO,
					"This is your wrong xpath syntax please check it again and correct it " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is Exception occured " + e.getMessage());
		}
		return a;
	}

	// 20.) ++++++++++++ This is the method of getText+++++++++++++++++++++++++

	public String mygetInnerText(WebElement we, String elementName) {
		String innerT = null;
		try {
			innerT = we.getText();
			et.log(Status.INFO, elementName + " innter text is founded which is - " + innerT);
		} catch (NullPointerException e) {
			innerT = we.getText();
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (ElementNotInteractableException e) {

			et.log(Status.INFO, "This is element not interactable exception");

		} catch (StaleElementReferenceException e) {

			et.log(Status.INFO, "This is StaleElementReferenceException");

		} catch (InvalidElementStateException e) {
			et.log(Status.INFO, "This is InvalidElementStateException");

		} catch (InvalidArgumentException e) {
			et.log(Status.INFO, "This is InvalidArgumentException");

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return innerT;

	}

	// 21.) +++++++++++++++This is the mehtod of isDisplayed+++++++++++++++

	public boolean myCheckElementisDisplayed(WebElement we, String elementName) {
		boolean b = false;
		try {
			b = we.isDisplayed();
			if (b == true) {
				et.log(Status.PASS, elementName + " is visible on webPage");
			} else {
				et.log(Status.FAIL, elementName + " is Not visible on webPage so element is hidden ");
			}
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, elementName + " is Not visible and exception is - " + e.getMessage());
		}
		return b;

	}

	// 22.) +++++++++++++++This is the mehtod of isEnabled+++++++++++++++

	public boolean myCheckElementisEnable(WebElement we, String elementName) {
		boolean b = false;
		try {
			b = we.isEnabled();
			if (b == true) {
				et.log(Status.PASS, elementName + " is Enabled ");
			} else {
				et.log(Status.FAIL, elementName + " is Not Enable ");
			}

		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, elementName + " is Not Enable and exception is - " + e.getMessage());
		}
		return b;

	}

	// 23.) +++++++++++++++This is the mehtod of isSelected+++++++++++++++

	public boolean myCheckElementisSelected(WebElement we, String elementName) {
		boolean b = false;
		try {
			b = we.isDisplayed();
			if (b == true) {
				et.log(Status.PASS, elementName + " is selected already ");
			} else {
				et.log(Status.FAIL, elementName + " is Not selected ");
			}
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, elementName + " is Not selected and exception is - " + e.getMessage());
		}
		return b;

	}

	// 24.) +++++++++++++++This is the method of getAttribute+++++++++++++++

	public String mygetAttributeValueByAttrubuteName(WebElement we, String attributeName, String elementName) {

		String attValue = null;
		try {
			attValue = we.getAttribute(attributeName);
			et.log(Status.INFO, elementName + " name/attribute_Value is " + attValue);
		} catch (NullPointerException e) {
			attValue = we.getAttribute(attributeName);
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (ElementNotInteractableException e) {

			et.log(Status.INFO, "This is element not interactable exception");

		} catch (StaleElementReferenceException e) {

			et.log(Status.INFO, "This is StaleElementReferenceException");

		} catch (InvalidElementStateException e) {
			et.log(Status.INFO, "This is InvalidElementStateException");

		} catch (InvalidArgumentException e) {
			et.log(Status.INFO, "This is InvalidArgumentException");

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return attValue;

	}

	// 25.)+++++++++++++++++++This is the method of gettagName++++++++++++++++++

	public String myfindTagName(WebElement we, String elementName) {
		String tagName = null;
		try {
			tagName = we.getTagName();
			et.log(Status.INFO, "Tag name is founded successfully so here my Tag Name is - " + tagName);
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return tagName;

	}

	// 26.)++++++++++++This is the method of getSize+++++++++++++++++++++++++++

	public Dimension mygetSizeOfElementWithoutHeightAndWidth(WebElement we, String elementName) {
		Dimension dimension = null;
		try {
			dimension = we.getSize();
			et.log(Status.INFO, elementName + " size is found successfully ");
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return dimension;
	}

	// 27.) ++++++++++++++This is the method of getHeight++++++++++++++++++

	public int mygetHeightOfTheElement(WebElement we, String elementName) {
		int heightOfElement = 0;
		try {
			heightOfElement = mygetSizeOfElementWithoutHeightAndWidth(we, elementName).getHeight();
			et.log(Status.INFO, elementName + " Height is found successfully so that height is - " + heightOfElement);
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return heightOfElement;

	}

	// 28.) ++++++++++++++This is the method of getWidth++++++++++++++++++

	public int mygetWidthOfTheElement(WebElement we, String elementName) {
		int widthOfElement = 0;
		try {
			widthOfElement = mygetSizeOfElementWithoutHeightAndWidth(we, elementName).getWidth();
			et.log(Status.INFO, elementName + " width is found successfully so that width is - " + widthOfElement);
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return widthOfElement;

	}

	// 29.) ++++++++++This is the method of submit+++++++++++++++++++++++++++

	public void mySubmitButton(WebElement we, String elementName) {
		try {

			we.submit();
			et.log(Status.INFO, elementName + " Submitted successfully");
		} catch (ElementClickInterceptedException e) {
			et.log(Status.INFO, "Element not found due to page not alighn properly");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, "Element not found");
		} catch (Exception e) {
			et.log(Status.INFO, "unknown exception " + e.getMessage());
		}

	}

	// 30.) +++++++++++++++This is the method of getLocation+++++++++++++++++++++

	public void getMyLocationOfElement(WebElement we, String elementName) {
		try {
			Point location = we.getLocation();
			et.log(Status.INFO, "Location of " + elementName + "on X-axis is - " + location.getX());

			et.log(Status.INFO, "Location of " + elementName + "on Y-axis is -  " + location.getY());
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
	}

	// 31.) +++++++++++++++This is the method of getSize of elemeny++++++++++++++++

	public void mygetSizeOfElementGet_Hight_Width(WebElement we, String elementName) {

		try {
			Dimension size = we.getSize();
			et.log(Status.INFO, "The Element " + elementName + " Hight is - " + size.getHeight());
			et.log(Status.INFO, "The Element " + elementName + " Width is - " + size.getWidth());
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 32.) ++++++++++This is the method for switch window through
	// handlevalue+++++++

	public void mySwitchWindowThroughHandleValue(String enterHandleValue) {

		try {
			driver.switchTo().window(enterHandleValue);
			et.log(Status.INFO,
					"my driver focus is now switched to main window through this handle value - " + enterHandleValue);
		} catch (NoSuchWindowException e) {
			et.log(Status.INFO, "no such window exception");
		} catch (Exception e) {
			et.log(Status.INFO, "exceptin is - " + e.getMessage());
		}

	}

	// 33.) ++++++++This is the method of getCssValue+++++++++++++++++++++

	public String getMyCssData(WebElement we, String propertyName, String elementName) {
		String property = null;
		try {
			property = we.getCssValue(propertyName);
			et.log(Status.INFO,
					elementName + " CSS value is found successfully here " + propertyName + " is - " + property);
		} catch (NullPointerException e) {

			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return property;
	}

///////////////////////////////////////////////////////////////////////////

	// 34.) ++++++++++This is the method of Select class++++++++++++++
	public Select mySelectClassElementObjcetCreate(WebElement we, String elementName) {

		Select select = null;
		try {
			select = new Select(we);
			et.log(Status.INFO, "Select class Object is created successfully for the element - " + elementName);
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return select;

	}

	// 35.) +++++++This is the method of getfirstSelectedOption+++++++++

	public String myGetFirstSelectedOptionInElement(WebElement we, String elementName) {
		String firstOption = null;
		try {
			firstOption = mySelectClassElementObjcetCreate(we, elementName).getFirstSelectedOption().getText();
			et.log(Status.INFO, "For " + elementName + " Now Current Selected Optins is - " + firstOption);
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}
		return firstOption;
	}

	// 36.) +++++++++This is the method of selctByIndex+++++++++++++++++

	public void mySelectByIndexNumber(WebElement we, String elementName, int enterIndexNumber) {
		try {
			mySelectClassElementObjcetCreate(we, elementName).selectByIndex(enterIndexNumber);
			et.log(Status.INFO,
					myGetFirstSelectedOptionInElement(we, elementName) + " this Opetion is selected successfully ");

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 37.)++++++++++++ This is the method for selectByvisibleText+++++++++

	public void mySelectByVisibleTextInOption(WebElement we, String elementName, String enterVisibleText) {

		try {
			mySelectClassElementObjcetCreate(we, elementName).selectByVisibleText(enterVisibleText);
			et.log(Status.INFO,
					myGetFirstSelectedOptionInElement(we, elementName) + " this Opetion is selected successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 38.)++++++++++++ This is the method for selectByValue+++++++++

	public void mySelectByValueAttribute(WebElement we, String elementName, String enterValueAttributeValue) {

		try {
			mySelectClassElementObjcetCreate(we, elementName).selectByValue(enterValueAttributeValue);
			et.log(Status.INFO,
					myGetFirstSelectedOptionInElement(we, elementName) + " this Opetion is selected successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 39.) +++++++++++ This is the method for isMultiple+++++++++++++++++

	public void myCheckDropDownisMultiple(WebElement we, String elementName) {
		try {
			boolean b = mySelectClassElementObjcetCreate(we, elementName).isMultiple();
			if (b) {
				et.log(Status.INFO, "This is a multi select DropDown ");
			} else {
				et.log(Status.INFO, "This is a single select DropDown");
			}
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 40.)+++++++++++ This is the mehtod for deSelectByIndiex++++++++++++++

	public void myDeSelectByIndexNumber(WebElement we, String elementName, int enterIndexNumber) {

		try {
			mySelectClassElementObjcetCreate(we, elementName).deselectByIndex(enterIndexNumber);
			et.log(Status.INFO,
					myGetFirstSelectedOptionInElement(we, elementName) + " this Opetion is Deselected successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 41.)+++++++++++ This is the method for deSelectByvisibleText+++++++++

	public void myDeSelectByVisibleTextInOption(WebElement we, String elementName, String enterVisibleText) {

		try {
			mySelectClassElementObjcetCreate(we, elementName).deselectByVisibleText(enterVisibleText);
			et.log(Status.INFO,
					myGetFirstSelectedOptionInElement(we, elementName) + " this Opetion is Deselected successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 42.)+++++++++++ This is the method for deSelectByValue+++++++++++++++

	public void myDeSelectByValueAttribute(WebElement we, String elementName, String enterValueAttributeValue) {

		try {
			mySelectClassElementObjcetCreate(we, elementName).deselectByValue(enterValueAttributeValue);
			et.log(Status.INFO,
					myGetFirstSelectedOptionInElement(we, elementName) + " this Opetion is Deselected successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 43.)+++++++++++ This is the method for deSelectAll+++++++++++++++++++

	public void myDeSelectAllOption(WebElement we, String elementName) {

		try {
			mySelectClassElementObjcetCreate(we, elementName).deselectAll();
			;
			et.log(Status.INFO, "so here all Option is Unselected successfully");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 44.)+++++++++++ This is the mehtod for getOptions++++++++++++++++++++++

	public List<WebElement> mygetAllOptionsOfDropDown(WebElement we, String elementName) {
		List<WebElement> allOption = null;
		try {
			allOption = mySelectClassElementObjcetCreate(we, elementName).getOptions();
			et.log(Status.INFO, "For " + elementName + " found all element Successfully and total element is - "
					+ allOption.size());
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, elementName + " not found and this is a Exception " + e.getMessage());
		}
		return allOption;
	}

	// 45.) +++++++++ This is the mthod for getAllSelectedOptins+++++++++++++++

	public List<WebElement> mygetAllSelectOptionsOfDropDownInMutiSelect(WebElement we, String elementName) {
		List<WebElement> allOption = null;
		try {
			allOption = mySelectClassElementObjcetCreate(we, elementName).getAllSelectedOptions();
			et.log(Status.INFO, "For " + elementName
					+ " found all selected element Successfully and total selected element is - " + allOption.size());
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, elementName + " not found and this is a Exception " + e.getMessage());
		}
		return allOption;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////

	// 46.) +++++++ This is the mehtod for creatin Action Class+++++++++

	public Actions myCreateActionsObject() {
		Actions ac = null;
		try {
			ac = new Actions(driver);
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
		return ac;

	}

	// 47.) ++++++++++++ This is the mehtod for moveToElement+++++++++++++++++++++

	public void myMoveToElementActions(WebElement we, String elementName) {
		try {
			myCreateActionsObject().moveToElement(we).build().perform();
			et.log(Status.INFO, elementName + " is moved successfully");
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}

	}

	// 48.) ++++++++++++ This is the mehtod for ContexClick +++++++++++++++++++++

	public void myRightClick(WebElement we, String elementName) {

		try {
			myCreateActionsObject().contextClick(we).build().perform();
			et.log(Status.INFO, "Right clicked successfully on - " + elementName);
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

	// 49.) +++++++++++++ This is the method for doubleClick+++++++++++++++++++++++

	public void myDoubleClick(WebElement we, String elementName) {

		try {
			myCreateActionsObject().doubleClick(we).build().perform();
			et.log(Status.INFO, "Double clicked successfully on - " + elementName);
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

	// 50.) +++++++++++++ This is the method for clickAndHold+++++++++++++++++++++++

	public void myClickAndHoldElement(WebElement we, String elementName) {

		try {
			myCreateActionsObject().clickAndHold(we).build().perform();
			et.log(Status.INFO, " The element - " + elementName + " is clicked and Hold Successfullly");
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}

	}

	// 51.) +++++++++++++++ This is the method for dragAndDrop++++++++++++++++++++++

	public void myDragAndDropElement(WebElement weSource, WebElement weTarget, String elementName) {

		try {
			myCreateActionsObject().dragAndDrop(weSource, weTarget).release().build().perform();
			et.log(Status.INFO, "For the element " + elementName + " Drag and Drop done Successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}

	}

	// 52.) +++++++++++ This is the method for Click of Actions Class+++++++++++++++

	public void myActionsClick(WebElement we, String elementName) {
		try {
			myCreateActionsObject().click(we).build().perform();
			;
			et.log(Status.INFO, " The element - " + elementName + " is Clicked Successfullly");
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

	// 53.) ++++++++ This is the method for sendkeys of Actions Class+++++++

	public void myActionsSendKeysInput(WebElement we, String enterDataInTextBox, String elementName) {
		try {
			myCreateActionsObject().sendKeys(we, enterDataInTextBox).build().perform();
			;
			et.log(Status.INFO, "  In The element - " + elementName + " Data is sended Successfullly and data is - "
					+ enterDataInTextBox);
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

	// 54.) ++++++++++++ This ii the method for moveToLocation +++++++++++++++

	public void myMoveToLocationOfElementActions(int enter_X_Cordinate, int enter_Y_Cordinate) {
		try {
			myCreateActionsObject().moveToLocation(enter_X_Cordinate, enter_Y_Cordinate).build().perform();
			et.log(Status.INFO, " This mouse focus is on this cordinate wehre (X,Y) - "
					+ (enter_X_Cordinate + " , " + enter_Y_Cordinate));
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

	// 55.) +++++++++ This is the mthod for moveToElement++++++++++++++

	public void myMoveToElementActions(WebElement we, String elementName, int enter_X_Cordinate,
			int enter_Y_Cordinate) {
		try {
			myCreateActionsObject().moveToElement(we, enter_X_Cordinate, enter_Y_Cordinate).build().perform();
			;
			et.log(Status.INFO, " This mouse focus is conciderd origin to the element which name is - " + elementName
					+ " frome this element my (X,Y) - " + (enter_X_Cordinate + " , " + enter_Y_Cordinate));
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

	// 56.) +++++++++ This is the mthod for scrollToElement ++++++++++++

	public void myScrollToElement(WebElement we, String elementName) {
		try {
			myCreateActionsObject().scrollToElement(we).build().perform();
			et.log(Status.INFO, "Scrolled successfully till the elemetnd - " + elementName);
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}

	}

	// 57.) +++++++++ This is the method for scrollByAmmount++++++++++++

	public void myScrollByAmount(int enter_X_Cordinate, int enter_Y_Cordinate) {
		try {
			myCreateActionsObject().scrollByAmount(enter_X_Cordinate, enter_Y_Cordinate).build().perform();
			et.log(Status.INFO,
					"Scrolled successfully till the cordinate - " + (enter_X_Cordinate + " , " + enter_Y_Cordinate));
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}

	}

	// 58.) +++++++++ This is the mthod for scrollFromOrighn +++++++++++++

	public void myScrollFromOrigin(int enterXOrign, int enterYOrigin, int enter_X_Cordinate, int enter_Y_Cordinate) {
		try {
			myCreateActionsObject().scrollFromOrigin(ScrollOrigin.fromViewport(enterXOrign, enterYOrigin),
					enter_X_Cordinate, enter_Y_Cordinate);
			et.log(Status.INFO, "Scrolled from origin (" + enterXOrign + " , " + enterYOrigin + ") And Scrolled till ("
					+ enterXOrign + " , " + enterYOrigin + ")");
		} catch (Exception e) {
			et.log(Status.INFO, " this is a Exception " + e.getMessage());
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////

	// 59.) +++++++++ This is the method of Alert+++++++++++++++++++++++++++

	public Alert alertClassObj() {
		Alert al = null;
		try {
			al = driver.switchTo().alert();
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, " Exceptin while creating Alert class object and exception is - " + e.getMessage());
		}
		return al;
	}

	// 60.)+++++++++ This is the mthod for accept Alert+++++++++++++++

	public void myacceptAlert() {
		try {
			alertClassObj().accept();
			et.log(Status.INFO, "Alert is accepted Successfully");
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while accepting alert and exception is - " + e.getMessage());
		}
	}

	// 61.)+++++++++ This is the mthod for Dismiss Alert+++++++++++++++

	public void mydismissAlert() {
		try {
			alertClassObj().dismiss();
			et.log(Status.INFO, "Alert is Dismissed successfully");
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while Dismissing alert and exception is - " + e.getMessage());
		}
	}

	// 62.)+++++++++ This is the mthod for getAlertText+++++++++++++++

	public void getmyAlertText() {
		try {
			String alertMessage = alertClassObj().getText();
			et.log(Status.INFO, "Alert message is found successfully here the alert message is - " + alertMessage);
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while getting Text of alert and exception is - " + e.getMessage());
		}
	}

	// 63.)++++++++++ This is the method for sendKeysInAlertPopup++++++++++

	public void mySendDataToAlert(String enterAlertData) {
		try {
			alertClassObj().sendKeys(enterAlertData);
			et.log(Status.INFO, "Data is entered in Alert TextBox and the Data is - " + enterAlertData);
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while sending data in alert TB and exception is - " + e.getMessage());
		}
	}

	// 64.) ++++++++++ This is the method for Upload Popup +++++++++++++++

	public void myUploadFilePopup(WebElement we, String fileName, String filePath) {
		try {
			mySendKeys(we, filePath, fileName);
			et.log(Status.INFO, "File uploaded successfully and file name is - " + fileName);
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while uploading File and exception is - " + e.getMessage());
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////

	// 65.) ++++++++ This is the mthod for ifram with index number+++++++++

	public void switchMyFrame(int enterIndexNumber) {
		try {
			driver.switchTo().frame(enterIndexNumber);
			et.log(Status.INFO, "Frame is switched successfully");
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while Switching the frame and exception is - " + e.getMessage());
		}
	}

	// 66.) +++++++ This is the mthod for ifram with Name or Id++++++++++++

	public void switchMyFrame(String enterName_Id) {

		try {
			driver.switchTo().frame(enterName_Id);
			et.log(Status.INFO, "Frame is switched successfully");
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while Switching the frame and exception is - " + e.getMessage());
		}
	}

	// 67.) +++++++ This is the mthod for ifram with WebElement+++++++++++++

	public void switchMyFrame(WebElement we, String frameName) {
		try {
			driver.switchTo().frame(we);
			et.log(Status.INFO, "Frame is switched successfully and frame name is - " + frameName);
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while Switching the frame and exception is - " + e.getMessage());
		}

	}

	// 68.) ++++++++ this is the method for defaultContent of ifram+++++++++

	public void switchMyFrameToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			et.log(Status.INFO, "Frame is switched on default successfully");
		} catch (Exception e) {
			et.log(Status.INFO,
					" Exception while Switching the frame as a default and exception is - " + e.getMessage());
		}
	}

	// 69.) ++++++++ this is the method for parentFram of ifram+++++++++

	public void switchMyFrameToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			et.log(Status.INFO, "Frame is switched on Parent frame successfully");
		} catch (Exception e) {
			et.log(Status.INFO, " Exception while Switching the parent frame and exception is - " + e.getMessage());
		}
	}

	// 70.) ++++++++++ This is the method for TakingScreenShot+++++++++

	public void mytakeScreenShot() {
		try {
			String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			TakesScreenshot tss = (TakesScreenshot) driver;
			File mySS = tss.getScreenshotAs(OutputType.FILE);
			File locationOFSS = new File(
					"C:\\Users\\HP\\Desktop\\New folder\\FrameWorkScreenShot\\" + fileName + ".png");
			try {
				Files.copy(mySS, locationOFSS);
				et.log(Status.INFO, "Screenshot is taken successfully ");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			et.log(Status.INFO, "Screenshot was not taken and Exception is - " + e.getMessage());
		}
	}

	///////////////////////////////////////////////////////////////////////////////

	// 71.) +++++++++ This is the method for create object of ChromeOptions ++++++++

	public ChromeOptions myChromeOptionsObjcets() {
		ChromeOptions co = null;
		try {
			co = new ChromeOptions();
			et.log(Status.INFO, "Chrome Option is created successfully ");
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "ChromeOptions is not created and exception is - " + e.getMessage());
		}
		return co;

	}

	// 72.) ++++++++++ This is the method for make a headless mode through
	// ChcomeOptions +++++++++++

	public ChromeOptions myHeadlessBrowser() {
		ChromeOptions co = null;
		try {
			co = myChromeOptionsObjcets().addArguments("--headless");
			et.log(Status.INFO, "Browser started run on Headless mode successfully");
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "Browser is not get started run on Headless mode and exception is - " + e.getMessage());
		}
		return co;

	}

	// 73.) +++++++++++ This is the method for windowmaximized++++++++++++

	public ChromeOptions myWindowMaximized() {
		ChromeOptions co = null;
		try {
			co = myChromeOptionsObjcets().addArguments("--start-maximized");
			et.log(Status.INFO, "Browser is fully maximized successfully");
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "Browser is not maximized and exception is - " + e.getMessage());
		}
		return co;

	}

	///////////////////////////////////////////////////////////////////////////////////

	// 74.) ++++++ This is the method for create JavaScript Object++++++++++++

	public JavascriptExecutor myjavaScriptObj() {
		JavascriptExecutor jse = null;
		try {
			jse = (JavascriptExecutor) driver;
		} catch (NullPointerException e) {
			et.log(Status.INFO, "This is null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, " exception is - " + e.getMessage());
		}
		return jse;

	}

	// 75.) ++++++++ This is the method for JavaScript click ++++++++++++

	public void myJavaScriptClick(WebElement we, String elementName) {
		try {
			myjavaScriptObj().executeScript("arguments[0].click();", we);
			et.log(Status.INFO, "Clicked through javaSecript on " + elementName + " Successfully");
		} catch (ElementClickInterceptedException e) {
			et.log(Status.INFO, "Element not found due to page not alighn properly");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, "Element not found");
		} catch (Exception e) {
			et.log(Status.INFO, "unknown exception " + e.getMessage());
		}

	}

	// 76.) +++++++ This is the method for JavaScript Sendkey ++++++++++++

	public void myJavaScriptSendKeys(WebElement we, String sendValue, String elementName) {

		try {
			myjavaScriptObj().executeScript("arguments[0].value=" + sendValue + ";", we);
			et.log(Status.INFO,
					"Throung JavaScript Data entered successfuly in " + elementName + " here Data is - " + sendValue);

		} catch (ElementNotInteractableException e) {

			et.log(Status.INFO, "This is element not interactable exception");

		} catch (StaleElementReferenceException e) {

			et.log(Status.INFO, "This is StaleElementReferenceException");

		} catch (InvalidElementStateException e) {
			et.log(Status.INFO, "This is InvalidElementStateException");

		} catch (InvalidArgumentException e) {
			et.log(Status.INFO, "This is InvalidArgumentException");

		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 77.) ++++++++ this is the method for ScrollBy Throug JavaScript ++++++++++

	public void myScrollByJavaScript(int Xaxis, int Yaxis) {

		JavascriptExecutor jse = myjavaScriptObj();
		try {
			jse.executeScript("window.scrollBy(" + Xaxis + "," + Yaxis + ")");
			et.log(Status.INFO, "window is scrolled successfully through JS");
		} catch (Exception e) {
			et.log(Status.INFO, "window is not scrolled and exception is - " + e.getMessage());
		}
	}

	// 78.) ++++ This is the method for scrollToBottom through JavaScript +++++++

	public void myJavaScriptScrollToBottom() {

		try {
			myjavaScriptObj().executeScript("window.scrollBy(0,document.body.scrollHeight)");
			et.log(Status.INFO, "Window scrolled to bottom successfully ");
		} catch (Exception e) {
			et.log(Status.INFO, "Scroll to bottom is not performed and this is a Exception " + e.getMessage());
		}

	}

	// 79.) ++++++ This is the method for scrollIntoView ++++++++++++

	public void myJavaScriptScrollIntoView(WebElement we, String elementName) {

		try {
			myjavaScriptObj().executeScript("arguments[0].scrollIntoView();", we);
			et.log(Status.INFO, "Window scrolled to " + elementName + " successfully ");
		} catch (Exception e) {
			et.log(Status.INFO,
					"Scroll to " + elementName + " is not performed and this is a Exception " + e.getMessage());
		}

	}

	// 80.) +++++++++This is the mthod for Keys ++++++++++++++++

	public void myKeysSendThroughSendKeys(WebElement we, String enterKeyword) {
		try {
			we.sendKeys(Keys.CONTROL + enterKeyword);
			et.log(Status.INFO, enterKeyword
					+ " <- key is entered successfully and action is going to perform according to keyword");
		} catch (Exception e) {
			et.log(Status.INFO, "This is a Exception " + e.getMessage());
		}

	}

	// 81.) ++++++++ This is the method for thred sleep++++++++++++++

	public void myThreadSleep(int enterSleepTimeInMiliSecond) {

		try {
			Thread.sleep(enterSleepTimeInMiliSecond);
			et.log(Status.INFO, "Thred sleep is performed successfully");
		} catch (InterruptedException e) {
			et.log(Status.INFO, "Thread sleep is not performed and exception is - " + e.getMessage());
		}

	}

	// 82.) ++++ This is the method for click on all element by using findElements++

	public void clickOnAllElement(By locator, String actionNamelikeClickOrGetText, String elementName) {

		List<WebElement> lw = myFindAllElements(locator, elementName);

		switch (actionNamelikeClickOrGetText.toLowerCase()) {
		case "click":
			for (int i = 0; i <= lw.size() - 1; i++) {
				try {
					lw.get(i).click();
				} catch (Exception e) {
					et.log(Status.INFO, "Element is not clicked properly and exception is - " + e.getMessage());
				}
			}
			et.log(Status.INFO,
					"All " + lw.size() + " elemement is clicked successfully and no of element is - " + lw.size());

		case "gettext":
			for (int i = 0; i <= lw.size() - 1; i++) {
				try {
					System.out.println(lw.get(i).getText());
				} catch (Exception e) {
					et.log(Status.INFO, "Element text is not printed properly and exception is - " + e.getMessage());
				}
			}
			et.log(Status.INFO,
					"All " + lw.size() + " elemement text is printed successfully and no of element is - " + lw.size());

		case "isselected":
			for (int i = 0; i <= lw.size() - 1; i++) {
				try {
					lw.get(i).isSelected();
				} catch (Exception e) {
					et.log(Status.INFO, "Exception is - " + e.getMessage());
				}
			}
			et.log(Status.INFO, "All " + lw.size()
					+ " elemement is selected printed successfully and no of element is - " + lw.size());

		default:
			et.log(Status.FAIL,
					"Action name is not matched with given Option so it is incorrect so Please enter valid action name");
		}

	}

	// 83.)+++++++++++ This is the method for incognito through
	// ChrmomeOptions+++++++++++

	public ChromeOptions myIncognitoMode() {
		ChromeOptions co = null;
		try {
			co = myChromeOptionsObjcets();
			co.addArguments("incognito");
			et.log(Status.INFO, "Browser is going to run on incognito mode successfully");
		} catch (Exception e) {
			et.log(Status.INFO, "Browser is not able to run on incognito mode and exception is - " + e.getMessage());
		}
		return co;
	}

	// 84.) ++++++++ This is the method of launch browser with Chrome Options+++++++

	public WebDriver mylaunchBrowserWithChromeOptions(String brwoserName, int enterWaitTimeInSecond, ChromeOptions co) {
		try {
			switch (brwoserName.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver(co);
				et.log(Status.INFO, brwoserName + " browser launched successfully ");
				break;
			case "firefox":
				driver = new FirefoxDriver();
				et.log(Status.INFO, brwoserName + "browser launched successfully ");
				break;
			case "edge":
				driver = new EdgeDriver();
				et.log(Status.INFO, brwoserName + " browser launched successfully ");
				break;
			case "safari":
				driver = new SafariDriver();
				et.log(Status.INFO, brwoserName + " browser launched successfully ");
				break;
			default:
				et.log(Status.FAIL,
						brwoserName + " -  This is not a valid browser name please enter valid browser name ");
			}
		} catch (SessionNotCreatedException e) {
			et.log(Status.INFO, "this is a exception which name is -  " + e.getMessage());

		} catch (NullPointerException e) {
			et.log(Status.INFO, "this is a null pointer exception " + e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, "this is a exception which name is -  " + e.getMessage());
		}

		myDynamicWait(enterWaitTimeInSecond);
		return driver;
	}
	
	//85.) ++++++++ This is the method for open new tab+++++++++++++
	
	public void myNewWindow_TabOpenWithFocus() {
		try {
		driver.switchTo().newWindow(WindowType.TAB);
		et.log(Status.INFO, "New window with the foucus is opened successfully ");
		}catch (Exception e) {
			et.log(Status.INFO, "New window is not opend and exception is - "+e.getMessage());
		}
	}
	
	//86.) +++++++ This is the method for open new tab without focus using JavaScript++++++
	
	public void myNewWindow_TabOpenWithoutFocus() {
		try {
		myjavaScriptObj().executeScript("window.open();");
		et.log(Status.INFO, "New window is opened successfully ");
		}catch (Exception e) {
			et.log(Status.INFO, "New window is not opend and exception is - "+e.getMessage());
		}
	}
	
	//jtgujsdfrd fds rr hrgry
	

}