/**
 * This class represents the Accessories Page.
 */
package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccessoriesPage {

    /**
     * List of web elements representing the products on the page.
     */
    @FindBy(className = "woocommerce-loop-product__title")
    private List<WebElement> products;

    /**
     * Get the number of products on the page.
     *
     * @return The number of products on the page.
     */
    public int size() {
        return products.size();
    }

    /**
     * Get the product at a specific index from the list of products.
     *
     * @param index The index of the product to retrieve.
     * @return The WebElement representing the product at the specified index.
     */
    public WebElement getProd(int index) {
        return products.get(index);
    }
}
