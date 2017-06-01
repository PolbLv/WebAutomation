package com.valentine.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import ru.yandex.qatools.allure.annotations.Step;

public class FakerData {
	
	
	private WebDriver driver; 
	Faker faker = new Faker();
	
//	public static void main(String[] args) {
//		Faker faker = new Faker();
//		String  name = faker.name().fullName();
//		System.out.println(name);
//	}
	
	@Step("fill name field")
	public void fillNameField() {
		String name = faker.name().fullName();
		driver.findElement(By.id("author")).sendKeys(name);
		
	}
	@Step("fillEmailField")
	public void fillEmailField(String text) {
		String email = faker.internet().emailAddress();
		driver.findElement(By.id("email")).sendKeys(email);

	}
	@Step("fillWebSiteField")
	public void fillWebSiteField(String text) {
		String webSite =  faker.internet().url();
		driver.findElement(By.id("url")).sendKeys(webSite);

	}
	@Step("clickToRatingStars")
	public void clickToRatingStars() {
		driver.findElement((By.xpath("//*[@id='et-rating']/div/span/div[3]"))).click();
		
	}

	public void fillCommentField() {
		String comment = faker.company().catchPhrase();
		driver.findElement((By.id("comment"))).sendKeys(comment);		
	}
	
}
