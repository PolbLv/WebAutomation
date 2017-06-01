package com.valentine.test;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import com.valentine.data.FakerData;

public class FourthTCVersion2TypeCommentTest {
	private HomePage onHomePage;
	
	private WebDriver driver;
	private FakerData faker;
	@Test
	public void testClickMoreInfoAndOpensItemsPage() {
		onHomePage = AwfulValentine.openHomePage();
		onHomePage.clickMoreInfoOnSpecialOffer(5);
	}
	
	@Test(dependsOnMethods = "testClickMoreInfoAndOpensItemsPage")
	public void testFillFields() {
		waitFor(2000);
//		faker.fillNameField();
//		driver.findElement(By.id("author")).sendKeys("Fadad");
		faker.fillEmailField("");
		faker.fillWebSiteField("");
		faker.clickToRatingStars();
		faker.fillCommentField();
		onHomePage.clickSubmitButton();
	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
	  private void waitFor(int milliseconds) {
	        try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {

		}
	}

}
