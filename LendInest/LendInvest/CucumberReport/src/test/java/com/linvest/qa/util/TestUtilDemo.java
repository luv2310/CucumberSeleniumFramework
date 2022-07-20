package com.linvest.qa.util;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linvest.qa.base.TestBase;
import com.linvest.qa.config.LoggerHelper;


public class TestUtilDemo extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	private static Actions actions;
	public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);


	public static boolean isElementPresent(By locator) {
		try {
			getWebElement(locator).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			log.error(e.getMessage());
			return false;
		}
	}

	public static boolean isElementsPresent(By locator) {
		Boolean isPresent = driver.findElements(locator).size() > 0;
		return isPresent;
	}

	public static void doSendKeysIntiger(By locator, int value) {
		try {
			getWebElement(locator).sendKeys(String.valueOf(value));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static void doSendKeys(By locator, String value) {
		try {

			getWebElement(locator).sendKeys(value);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static void doSendKeysExecuter(By locator, String value) {
		try {

			WebElement wb = driver.findElement(locator);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='';", wb);
			getWebElement(locator).sendKeys(value);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static void clearAnddoSendKeys(By locator, String value) {
		try {
			getWebElement(locator).clear();
			getWebElement(locator).sendKeys(value);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static String getTex(By locator) {

		WebElement element = driver.findElement(locator);
		String text = element.getText();
		return text;
	}

	public static void focusOnElement() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('x').focus()");
	}

	public static void clickWithJS(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}


	public static void clickWithAction(WebElement element) {

		Actions object = new Actions(driver);
		object.click(element).build().perform();
	}

	public static void clickWithAction(By locator) throws RuntimeException {
		try {
			WebElement element = getWebElement(locator);
			if (element.isEnabled()) {
				Actions object = new Actions(driver);
				object.click(element).build().perform();
			} 
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * Method to click on an element
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param time :             int   : time for wair
	 */
	public static void waitTillVisibility(By locator, int time) throws RuntimeException {
		try {

			WebElement element = driver.findElement(locator);
			WebDriverWait wait = new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}



	/**
	 * Method to click on an element
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void clickElement(By locator) throws RuntimeException {
		try {

			WebElement element = getWebElement(locator);
			element.click();
		}catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static boolean clickElements(By locator) throws RuntimeException {
		try {
			WebElement element = getWebElement(locator);
			element.click();
			log.info("clicked succesfully");
			return true;
		}

		catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	public static WebElement getWebElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return element;
	}

	public static List<WebElement> getWebElements(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return element;
	}

	public static boolean isEnabled(By locator, String elementName) {
		try {
			getWebElement(locator).isEnabled();
			return true;
		} catch (NoSuchElementException e) {
			log.error(e.getMessage());
			return false;
		}
	}

	/**
	 * Method of dropDownSelect
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void dropDownSelectbyVisibleText(By locator, String val) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		Select drp = new Select(element);
		drp.selectByVisibleText(val);
	}

	/**
	 * Method of dropDownSelect byIndex
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void dropDownSelectByIndex(By locator, int val) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		Select drp = new Select(element);
		drp.selectByIndex(val);
	}

	/**
	 * Method of dropDownSelect byValue
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void dropDownSelectByText(By locator, String val) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		Select drp = new Select(element);
		drp.selectByValue(val);

	}

	public static void scrollDownForLogPage() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200000)");

	}

	public static void scrollDownKey(By locator) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		element.sendKeys(Keys.PAGE_DOWN);

	}

	public static void scrollDown() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,70000)");

	}

	public static void scrollDownForShort() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}

	public static void scrollDownTillBottum() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollDownToElementPresent(By locator) throws RuntimeException {
		WebElement Element = driver.findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// This will scroll the page till the element is found
		jse.executeScript("arguments[0].scrollIntoView(true);", Element);
	}

	public static void scrollUpTop() throws RuntimeException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		jse.executeScript("window.scrollBy(0,-1000)", ")");
	}

	public static void scrollUP() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -700000)");
	}

	public static void scrollUpToElementPresent(By locator) throws RuntimeException {

		WebElement element = driver.findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void scrolltoponly() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, 0);");
	}

	public static void scrollUp() throws RuntimeException, Throwable {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	}

	public static void mouseHover(By locator) throws RuntimeException {
		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	public static void mouseHoverAndClick(By locator) throws RuntimeException {
		WebElement ele = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.click().build().perform();
	}
}
