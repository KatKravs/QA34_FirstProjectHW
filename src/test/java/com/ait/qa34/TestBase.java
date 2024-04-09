package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        // Максимизируем окно браузера
        driver.manage().window().maximize();
        // Ожидаем загрузки всех элементов на сайте перед началом теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        // Завершаем работу драйвера после выполнения теста
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }

//    public int sizeOfItemInShoppinCart() {
//        if (isElementPresent(By.cssSelector("[name='itemquantity4151119']"))) {
//            return driver.findElements(By.cssSelector("[name='itemquantity4151119']")).size();
//        }
//        return 0;
//    }

    public String getNameAndSizeOfItemInShoppingCart() {
        String nameAndSize = "";
        if (isElementPresent(By.cssSelector(".product-name"))) {
            String quantityString = driver.findElement(By.cssSelector(".qty-input")).getAttribute("value");
            String productName = driver.findElement(By.cssSelector(".product-name")).getText();
            nameAndSize = productName + " (Quantity: " + quantityString + ")";
        }
        return nameAndSize;
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnUpdateShoppingCartButton() {
        click(By.cssSelector("[name='updatecart']"));
    }

    public void clickOn2ndOf6AddToCartButton() {
        //  .item-box:nth-child(3) .buttons // div[data-productid='31'] input
        click(By.cssSelector("div[data-productid='31'] input"));
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("#topcartlink"));
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
}
