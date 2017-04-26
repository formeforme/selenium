package Test.FirstPage;

import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by aca on 4/8/17.
 */
public class FirstPageTest {
    private WebDriverBase webDriverBase;
    private WebDriver webDriver;
    private LoginPage loginPage;

    @BeforeMethod
    private void beforeMethod(){
        initializeMembers();
    }
    @AfterMethod
    private void cleanUp(){
        webDriver.manage().deleteAllCookies();
    }
    @AfterTest
    private void finish(){
        webDriverBase.close();
    }

    public void initializeMembers(){
        webDriverBase = WebDriverBase.getDriverInstance();
        webDriverBase.start();
        webDriver = webDriverBase.getWebDriver();
        loginPage = new LoginPage(webDriver);
    }

    @Test
    void checkTitle(){
        Assert.assertEquals("Hong Bao",webDriver.getTitle());
    }
    @Test
    void validateCorrectPage(){
        Assert.assertTrue(loginPage.isVisible());
    }
}
