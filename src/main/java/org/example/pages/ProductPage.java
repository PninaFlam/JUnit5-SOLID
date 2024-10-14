/**
 * This class represents the Product Page.
 */
package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

    /**
     * Web element representing the 'Add to Cart' button on the page.
     */
    @FindBy(xpath = "//button[@name='add-to-cart']")
    private WebElement buttonAddToCart;

    /**
     * Web element representing the 'View Cart' button on the page.
     */
    @FindBy(xpath = "//a[@href='https://atid.store/cart-2/']")
    private WebElement buttonViewCart;

    /**
     * Clicks on the 'Add to Cart' button.
     */
    public void clickAddToCart() {
        buttonAddToCart.click();
    }

    /**
     * Clicks on the 'View Cart' button.
     *
     * @param driver The WebDriver instance to perform the click action.
     */
    public void clickViewCart(WebDriver driver) {
        buttonViewCart.click();
    }
}
