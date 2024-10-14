/**
 * This class represents the Checkout Page.
 */
package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    /**
     * Web element representing the 'Place Order' button on the page.
     */
    @FindBy(id = "place_order")
    private WebElement buttonPlaceOrder;

    /**
     * Web element representing the select item on the page.
     */
    @FindBy(id = "billing_country")
    private WebElement selectItem;

    /**
     * Web element representing the error message element on the page.
     */
    @FindBy(xpath = "//li[contains(text(),'Invalid payment method.')]")
    private WebElement messageError;

    /**
     * Clicks on the 'Place Order' button after waiting for an element to become invisible.
     *
     * @param driver The WebDriver instance to perform the click action.
     */
    public void clickPlaceOrder(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement init = driver.findElement(By.id("jquery-blockui-js"));
        wait.until(ExpectedConditions.invisibilityOf(init));
        buttonPlaceOrder.click();
    }

    /**
     * Checks if the error message is displayed on the page.
     *
     * @param driver The WebDriver instance to check for the error message.
     * @return True if the error message is displayed, false otherwise.
     */
    public boolean isError(WebDriver driver) {
        return messageError.isDisplayed();
    }

    /**
     * Selects an item from the dropdown list.
     *
     * @param choose The item to select from the dropdown list.
     */
    public void sendToSelect(String choose) {
        Select selectElement = new Select(selectItem);
        selectElement.selectByVisibleText(choose);
    }
}
