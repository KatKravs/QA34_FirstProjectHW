package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTest extends TestBase {


    @Test
    public void createNewAccountPositivTest() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
//        type(By.name("email"), + i + "siyabtest1@gmail.com"); .button-1 register-button
        // click on login link
        click(By.cssSelector("[href='/register']"));
        // enter FirstName
        type(By.id("FirstName"), "John");
        // enter LastName
        type(By.id("LastName"),  "Smith");
        // enter email
        type(By.id("Email"), + i + "siyabtest1@gmail.com");
        // enter password
        type(By.id("Password"), "Sa12345!");
        // enter ConfirmPassword
        type(By.id("ConfirmPassword"), "Sa12345!");
        // click on Registration button
        click(By.id("register-button"));
        // assert CustomerInfo is present //   ->так не делать,абсолютный путь //div[@class='header']//a[@href='/customer/info']
        Assert.assertTrue(isElementPresent(By.cssSelector("ul:nth-child(1) .account")));
        System.out.println(isElementPresent(By.cssSelector("ul:nth-child(1) .account")));
    }
}
