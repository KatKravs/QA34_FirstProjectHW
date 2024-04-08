package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToShoppingCartTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        // click on login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.cssSelector("#Email"),"1730siyabtest1@gmail.com");
        // enter password
        type(By.id("Password"), "Sa12345!");
        // click on login button
        click(By.cssSelector(".button-1.login-button"));
    }

    @Test
    public void AddItemToShoppingCartPositiveTest(){
        int sizeBefore = sizeOfItemInShoppinCart();
        // click on add to cart button
        click(By.cssSelector("div[data-productid='31'] input"));
        // click Shopping Cart link on header
        click(By.cssSelector("#topcartlink a"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/141-inch-laptop']")));
        int sizeAfter = sizeOfItemInShoppinCart();
        Assert.assertEquals(sizeAfter,sizeBefore + 1);
    }
}

