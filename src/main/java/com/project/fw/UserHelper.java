package com.project.fw;

import com.project.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnHeaderLogo() {
        click(By.cssSelector(".header-logo"));
    }

    public void clickOnContinueButton() {
        click(By.cssSelector(".button-1.register-continue-button"));
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public boolean isAccountLinkPresent() {
        return isElementPresent(By.cssSelector("ul:nth-child(1) .account"));
    }

    public void fillRandomRegisterForm(String mail, String password) {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        type(By.id("Email"), +i + mail);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
    }

    public void fillRegisterForm(String FirstName, String LastName) {
        type(By.id("FirstName"), FirstName);
        type(By.id("LastName"), LastName);
    }

    public boolean isValidationSummaryErrorsPresent() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }

    public void clickOnLogOutLink() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
}
