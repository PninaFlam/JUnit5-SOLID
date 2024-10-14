/**
 * This interface provides basic browser operations using WebDriver.
 */
package org.example.utils;

import org.openqa.selenium.WebDriver;

public interface BasicBrowser {

    /**
     * Navigates to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    void navigateTo(String url);

    /**
     * Retrieves the title of the current page.
     *
     * @return The title of the current page.
     */
    String getPageTitle();

    /**
     * Retrieves the current URL of the page.
     *
     * @return The URL of the current page.
     */
    String getUrl();

    /**
     * Clicks on an element using its ID.
     *
     * @param locator The ID of the element to click.
     */
    void clickElementById(String locator);

    /**
     * Clicks on an element using its XPath.
     *
     * @param locator The XPath of the element to click.
     */
    void clickElementByXpath(String locator);

    /**
     * Sends keys to an element identified by the locator.
     *
     * @param locator The locator of the element.
     * @param input   The input to send to the element.
     */
    void sendKeysToElement(String locator, String input);

    /**
     * Refreshes the current page.
     */
    void refreshPage();

    /**
     * Closes the browser.
     */
    void closeBrowser();

    /**
     * Waits for a certain condition to be met before proceeding.
     */
    void waiting();

    /**
     * Retrieves the WebDriver instance associated with the browser.
     *
     * @return The WebDriver instance.
     */
    WebDriver getDriver();

}
