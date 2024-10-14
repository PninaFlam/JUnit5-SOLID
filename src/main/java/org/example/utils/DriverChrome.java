/**
 * This class implements the BasicBrowser and WindowManagement interfaces using ChromeDriver for Selenium automation.
 */
package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DriverChrome implements BasicBrowser, WindowManagement {

    private WebDriver driver;

    /**
     * Empty constructor.
     */
    public DriverChrome() {
    }

    /**
     * Constructs a new DriverChrome instance with the provided URL.
     *
     * @param url The URL to navigate to upon initialization.
     */
    public DriverChrome(String url) {
        this.driver = new ChromeDriver();
        maximizeWindow();
        navigateTo(url);
        waiting();
    }

    /**
     * Navigates to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    @Override
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Retrieves the title of the current page.
     *
     * @return The title of the current page.
     */
    @Override
    public String getPageTitle() {
        return driver.getTitle();

    }

    /**
     * Retrieves the current URL of the page.
     *
     * @return The current URL of the page.
     */
    @Override
    public String getUrl() {

        return driver.getCurrentUrl();

    }

    /**
     * Clicks on an element using its ID.
     *
     * @param locator The ID of the element to click.
     */
    @Override
    public void clickElementById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    /**
     * Clicks on an element using its XPath.
     *
     * @param locator The XPath of the element to click.
     */
    @Override
    public void clickElementByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * Sends keys to an element identified by its ID.
     *
     * @param locator The ID of the element.
     * @param input   The text to input.
     */
    @Override
    public void sendKeysToElement(String locator, String input) {
        driver.findElement(By.id(locator)).sendKeys(input);
    }

    /**
     * Refreshes the current page.
     */
    @Override
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Closes the browser.
     */
    @Override
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * Sets an implicit wait time for the driver.
     */
    @Override
    public void waiting() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Retrieves the WebDriver instance.
     *
     * @return The WebDriver instance.
     */
    @Override
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Maximizes the browser window.
     */
    @Override
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * Minimizes the browser window.
     */
    @Override
    public void minimizeWindow() {
        driver.manage().window().minimize();
    }
}
