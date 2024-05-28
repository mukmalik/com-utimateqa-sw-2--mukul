package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest
{
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //Enter “standard_user” username.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click on login
        driver.findElement(By.id("login-button")).click();

        //Verify the text ‘PRODUCTS’
        String expectedText = "Products";
        WebElement productElement = driver.findElement(By.className("title"));
        String actualText = productElement.getText();
        Assert.assertEquals("", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click on login
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on page
        int expectedText = 6;
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item"));
        int actualText = productList.size();
        Assert.assertEquals("six products are displayed on page ", expectedText, actualText);

    }

    //Annotation
    @After
    public void tearDown() {
        driver.close();
    }

}
