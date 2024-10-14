/**
 * This class represents the Cart Page.
 */
package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

    /**
     * Web element representing the 'Proceed to Checkout' button on the page.
     */
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement buttonCheckout;

    /**
     * Clicks on the 'Proceed to Checkout' button after scrolling to the element.
     *
     * @param driver The WebDriver instance to perform the click action and scrolling.
     */
    public void clickCheckout(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + 0 + "," + 500 + ")");
        buttonCheckout.click();
    }
}
