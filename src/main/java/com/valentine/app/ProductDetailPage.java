//package com.valentine.app;
//
//import ru.yandex.qatools.allure.annotations.Step;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//
//public class ProductDetailPage {
//
//	private WebDriver driver;
//
//	@Step("fillNameField")
//	public ProductDetailPage fillNameField(String name) {
//		driver.findElement(By.id("author")).sendKeys(name);
//		return this;
//	}
//
//	@Step("fillEmailField")
//	public ProductDetailPage fillEmailField(String email) {
//		driver.findElement(By.id("email")).sendKeys(email);
//		return this;
//	}
//
//	@Step("fillWebSiteField")
//	public ProductDetailPage fillWebSiteField(String webSite) {
//		driver.findElement(By.id("url")).sendKeys(webSite);
//		return this;
//	}
//
//	@Step("clickToRatingStars")
//	public ProductDetailPage clickToRatingStars() {
//		driver.findElement((By.xpath("//*[@id='et-rating']/div/span/div[3]"))).click();
//		return this;
//	}
//
//	@Step("fillCommentsField")
//	public ProductDetailPage fillCommentsField(String comment) {
//		driver.findElement((By.id("comment"))).sendKeys(comment);
//		return this;
//	}
//
//	@Step("clickButtonSubmit")
//	public ProductDetailPage clickButtonSubmit() {
//		driver.findElement(By.id("submit")).click();
//		return this;
//	}
//}
