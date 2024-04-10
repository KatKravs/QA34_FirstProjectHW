package com.ait.qa34;

import com.project.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToShoppingCartTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("1730siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addItemToShoppingCartPositiveTest(){
        app.getCartHelper().clickOnShoppingCartLink();
        String addedBefore = app.getCartHelper().getNameAndSizeOfItemInShoppingCart();
        app.getUser().clickOnHeaderLogo();
        System.out.println("Before adding: " + addedBefore);
        app.getCartHelper().clickOn2ndOf6AddToCartButton();
        app.getCartHelper().clickOnShoppingCartLink();
        // Get the information about the item in the cart after adding
        String addedAfter = app.getCartHelper().getNameAndSizeOfItemInShoppingCart();
        System.out.println("After adding: " + addedAfter);
        // Assert that the item was added to the shopping cart
        //Assert.assertTrue(addedAfter.contains(addedBefore), "Item was not added to the shopping cart");
        Assert.assertTrue(app.getCartHelper().isProductAdded("14.1-inch Laptop"));
    }

}

