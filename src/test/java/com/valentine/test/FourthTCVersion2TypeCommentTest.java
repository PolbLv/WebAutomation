package com.valentine.test;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;

import com.valentine.data.FakerData;

public class FourthTCVersion2TypeCommentTest {
	private HomePage onHomePage;
//	private ProductDetailPage onProductPage;
	private WebDriver driver;
	private FakerData faker = new FakerData();

	@Test
	public void testClickMoreInfoAndOpensItemsPage() {
		onHomePage = AwfulValentine.openHomePage();
		onHomePage.clickMoreInfoOnSpecialOffer(5);
	}

	@Test(dependsOnMethods = "testClickMoreInfoAndOpensItemsPage")
	public void testFillFields() {
		
		String name = faker.getName();
		onHomePage.fillNameField(name);
		
		String email = faker.getEmail();
		onHomePage.fillEmailField(email);
		
		String webSite = faker.getWebSite();
		onHomePage.fillWebSiteField(webSite);
		
		onHomePage.clickRandomToRatingStars();
		
		String comment = faker.getComment();
		onHomePage.fillCommentsField(comment);			
	}
	
	@Test(dependsOnMethods = "testFillFields")
	public void addSecondCommentWithoutInfo() {
		
		onHomePage.clickButtonSubmit();
		
	}
	
	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
}
