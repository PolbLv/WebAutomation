package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FourthTCTypeCommentTest {

	String homePage = "http://awful-valentine.com/";
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "//Users//Serhiy//SeleniumWebDrivers//chromedriver");
		driver = new ChromeDriver();
		driver.get(homePage);
		wait = new WebDriverWait(driver, 8);
	}

	@Test
	public void openItemAndFillFields() {
		

		driver.findElement(By.cssSelector("#slides > div:nth-child(2) > div.featured-image")).click();

		driver.findElement(By.id("author")).sendKeys("Fadad");

		driver.findElement(By.id("email")).sendKeys("dasqA@gmail.com");

		driver.findElement(By.id("url")).sendKeys("www.commasdentdqdqd.com");

		driver.findElement((By.xpath("//*[@id='et-rating']/div/span/div[3]"))).click();

		driver.findElement((By.id("comment"))).sendKeys("This)))");

		driver.findElement(By.id("submit")).click();

	}

	@Test(dependsOnMethods = "openItemAndFillFields")
	public void ifUserDuplicatesInfo() {
		String errorMessageAboutTheSameUser = driver.findElement(By.id("error-page")).getText();
		Assert.assertEquals(errorMessageAboutTheSameUser,
				"Duplicate comment detected; it looks as though you’ve already said that!", "IncorrectMessage");
	}

	@Test(dependsOnMethods = "openItemAndFillFields")
	public void addSecondCommentWithoutInfo() {

		driver.findElement(By.id("submit")).click();

		String errorMessage = driver.findElement(By.id("error-page")).getText();

		System.out.println(errorMessage);

		Assert.assertEquals(errorMessage, "ERROR: please type a comment.", "Incorrect message or Another Error");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	private void waitFor(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {

		}
	}
}
