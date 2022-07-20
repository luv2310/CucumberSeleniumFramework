package com.linvest.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.linvest.qa.config.LoggerHelper;
import com.linvest.qa.util.TestUtilDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);

	public TestBase() {
		try {
			log.info("Base class");
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/test/java/com/linvest/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public static WebDriver initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		} 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilDemo.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilDemo.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		log.info("chrome browser started succesfully");
		return driver;
	}

}
