package com.ait.qa34;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test

    public void createNewAccountPositivTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm("John", "Smith");
        app.getUser().fillRandomRegisterForm("siyabtest1@gmail.com", "Sa12345!");
        app.getUser().clickOnRegisterButton();
        app.getUser().clickOnContinueButton();
        // assert CustomerInfo is present //   так не делать --> //div[@class='header']//a[@href='/customer/info'] <--- так как это абсолютный путь
        Assert.assertTrue(app.getUser().isAccountLinkPresent());
        System.out.println(app.getUser().isAccountLinkPresent());
    }

}
