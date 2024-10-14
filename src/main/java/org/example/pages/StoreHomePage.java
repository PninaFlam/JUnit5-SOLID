/**
 * This class represents the Store Home Page.
 */
package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreHomePage {

    /**
     * Web element representing the accessories button on the page.
     */
    @FindBy(id = "menu-item-671")
    private WebElement accessoriesButton;

    /**
     * Web element representing the count of products in the cart on the page.
     */
    @FindBy(xpath = "//div[@id='ast-site-header-cart']//span[@class='count']")
    private WebElement countProductsInCart;

    /**
     * Clicks on the accessories button.
     */
    public void clickAccessories() {
        accessoriesButton.click();
    }

    /**
     * Gets the count of products in the cart.
     *
     * @return The count of products in the cart as an integer.
     */
    public int getCountProductsInCart() {
        return Integer.parseInt(countProductsInCart.getText());
    }
}
