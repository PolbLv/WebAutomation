package com.valentine.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import ru.yandex.qatools.allure.annotations.Step;

public class FakerData {
	
	Faker faker = new Faker();
	
	@Step("getFieldName")
	public String getName() {
		String name = faker.name().fullName();
		return name;
		
	}
	@Step("getEmailField")
	public String getEmail() {
		 String email = faker.internet().emailAddress();
		 return email;
		
	}
	@Step("getWebSite")
	public String getWebSite () {
		String webSite =  faker.internet().url();
		return webSite;
	
	}
	@Step ("getCatchPhrasse")
	public String getComment() {
		String comment = faker.company().catchPhrase();
		return comment;	
	}
	
}

