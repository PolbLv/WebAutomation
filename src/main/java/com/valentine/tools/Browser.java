package com.valentine.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

	public static WebDriver open() {
		//System.setProperty("browser", "safari");
		System.setProperty("webdriver.chrome.driver", "//Users//Serhiy//SeleniumWebDrivers//chromedriver");
//		System.setProperty("webdriver.firefox.driver", "//Users//Serhiy//SeleniumWebDrivers//geckodriver");
		
		String browserName = System.getProperty("browser");
		
		if (browserName == null || "chrome".equals(browserName))
			return startChromeDriver();
		else if ("firefox".equals(browserName))
			return startFirefoxDriver();
		else if ("safari".equals(browserName))
			return startSafariDriver();

		throw new RuntimeException("Unsupported browser: " + browserName);
	}

	private static WebDriver startSafariDriver() {
		return new SafariDriver();
	}

	private static WebDriver startChromeDriver() {
		return new ChromeDriver();
	}

	private static WebDriver startFirefoxDriver() {
		return new FirefoxDriver();
	}

}
