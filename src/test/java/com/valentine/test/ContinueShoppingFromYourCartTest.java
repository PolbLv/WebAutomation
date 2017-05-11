package com.valentine.test;

import com.valentine.app.AwfulValentine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContinueShoppingFromYourCartTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "//home//likewise-open//LVIVSOFT//spolyakov//chromedriver");
        //driver = new ChromeDriver();
        //driver = Browser.open();
        //driver.get("http://awful-valentine.com/");

         AwfulValentine.openHomePage();

        driver.findElement(By.cssSelector("[href='#et-offer-post-30']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        waitFor(1000);
        driver.findElement(By.id("addToCart_6_2")).click();
        waitFor(3000);
    }

    @Test
    public void testContinueShoppingButtonRedirectsToHomePage() {
        driver.findElement(By.id("continueShopping")).click();
        waitFor(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/");
    }

    @Test(dependsOnMethods = "testContinueShoppingButtonRedirectsToHomePage")
    public void testAddingSecondItemToShoppingCart() {
        waitFor(2000);
        WebElement cartButton = driver.findElement(By.cssSelector("[href='#et-entry-post-21']"));
        JavascriptExecutor.class.cast(driver).executeScript("arguments[0].scrollIntoView(true)", cartButton);
        waitFor(2000);
        cartButton.click();

        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        waitFor(1000);
        driver.findElement(By.id("addToCart_3_2")).click();
        waitFor(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
                "Incorrect URL after adding second item");

        String shoppingCartSummary = driver.findElement(By.id("Cart66WidgetCartEmptyAdvanced")).getText();

        Assert.assertTrue(shoppingCartSummary.startsWith("You have 2 items"), "\nShopping \n");
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
