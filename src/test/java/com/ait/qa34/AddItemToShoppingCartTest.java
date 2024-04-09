package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToShoppingCartTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        clickOnLoginLink();
        // enter email
        type(By.cssSelector("#Email"),"1730siyabtest1@gmail.com");
        // enter password
        type(By.id("Password"), "Sa12345!");
        clickOnLoginButton();
    }

    @Test
    public void addItemToShoppingCartPositiveTest(){

        String addedBefore = getNameAndSizeOfItemInShoppingCart();
        System.out.println("Before adding: " + addedBefore);
        clickOn2ndOf6AddToCartButton();
        clickOnShoppingCartLink();
        clickOnUpdateShoppingCartButton();
        // Get the information about the item in the cart after adding
        String addedAfter = getNameAndSizeOfItemInShoppingCart();
        System.out.println("After adding: " + addedAfter);
        // Assert that the item was added to the shopping cart
        Assert.assertTrue(addedAfter.contains(addedBefore), "Item was not added to the shopping cart");
    }

}

