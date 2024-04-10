package com.project.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartHelper extends BaseHelper {

    public ShoppingCartHelper(WebDriver driver) {
        super(driver);
    }

    public int sizeOfItemInShoppinCart() {
        if (isElementPresent(By.cssSelector(".product-name"))) {
            return ApplicationManager.driver.findElements(By.cssSelector(".product-name")).size();
        }
        return 0;
    }


    public void clickOnUpdateShoppingCartButton() {
        click(By.cssSelector("[name='updatecart']"));
    }

    public void clickOn2ndOf6AddToCartButton() {
        //  .item-box:nth-child(3) .buttons  или // div[data-productid='31'] input
        click(By.cssSelector(".item-box:nth-child(3) .buttons"));
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("#topcartlink"));
    }

    public String getNameAndSizeOfItemInShoppingCart() {
        String nameAndSize = "";
        if (isElementPresent(By.cssSelector(".product-name"))) {
            String quantityString = ApplicationManager.driver.findElement(By.cssSelector(".qty-input")).getAttribute("value");
            String productName = ApplicationManager.driver.findElement(By.cssSelector(".product-name")).getText();
            nameAndSize = productName + " (Quantity: " + quantityString + ")";
        }
        return nameAndSize;
    }
}

