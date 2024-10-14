import org.example.lifeCycle.ExtensionAtidStore;
import org.example.lifeCycle.TestWatcherAtidStore;
import org.example.pages.*;
import org.example.utils.DriverChrome;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * This class represents automated tests for the Atid Store website.
 * It includes test methods to interact with different pages of the website.
 */
@ExtendWith({TestWatcherAtidStore.class, ExtensionAtidStore.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AtidAutomationTest extends DriverChrome {

    static DriverChrome cDriver;
    static WebDriver driver;
    static StoreHomePage storeHomePage;
    static AccessoriesPage accessoriesPage;
    static ProductPage productPage;
    static CartPage cartPage;
    static CheckoutPage checkoutPage;

    /**
     * Initializes the test session by opening the browser and initializing page objects.
     */
    @BeforeAll
    @DisplayName("Start Session Atid Test")
    static void start() {
        cDriver = new DriverChrome("https://atid.store/");
        driver = cDriver.getDriver();
        storeHomePage = PageFactory.initElements(driver, StoreHomePage.class);
        accessoriesPage = PageFactory.initElements(driver, AccessoriesPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }

    /**
     * Closes the browser and ends the test session.
     */
    @AfterAll
    @DisplayName("Close Session Atid Test")
    static void close() {
        cDriver.closeBrowser();
    }

    /**
     * Test method to interact with the Atid Store website by adding products to the cart, filling the form, and placing an order.
     */
    @Test
    @DisplayName("Test The Atid Store")
    void TestAccessories() {
        for (int i = 0; i < 2; i++) {
            int count = storeHomePage.getCountProductsInCart();
            storeHomePage.clickAccessories();
            accessoriesPage.getProd(new Random().nextInt(accessoriesPage.size() - 1)).click();
            productPage.clickAddToCart();
            assertEquals(count + 1, storeHomePage.getCountProductsInCart());
        }
        productPage.clickViewCart(driver);
        cartPage.clickCheckout(driver);

        FillFormFromCSV();
        checkoutPage.sendToSelect("Israel");

        checkoutPage.clickPlaceOrder(driver);
        assertTrue(checkoutPage.isError(driver));
    }

    /**
     * A method that fills the form with data from a CSV file.
     */
    public void FillFormFromCSV() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/data.csv")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String key = data[1];
                driver.findElement(By.id(id)).sendKeys(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
