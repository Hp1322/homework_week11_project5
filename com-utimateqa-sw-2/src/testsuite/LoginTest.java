package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find sign in link and click on it
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        //This is from requirement
        String expectedMessage = "Welcome Back!";

        //Actual message
        WebElement actualmsg = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualmsg.getText();

        //Validate expected message and actual message
        Assert.assertEquals("unable to navigate on welcome page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find sign in link and click on it
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        //Find email element
        WebElement emailField = driver.findElement(By.name("user[email]"));
        //Sending email to email field element
        emailField.sendKeys("kp@gmail.com");

        //Find Password element
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        //Sending password to password field element
        passwordField.sendKeys("123456");

        //Find login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        loginButton.click();

        //This is from requirement
        String expectedMessage = "Invalid email or password.";

        //Actual Message
        WebElement actualmsg = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualmsg.getText();

        Assert.assertEquals("Error message is not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
