package Test;

import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by aca on 4/8/17.
 */
public class FirstPageTest {
    private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
    private WebDriver webDriver = null;
    private LoginPage loginPage = null;

    @BeforeTest
    private void start(){
        webDriverBase.start();
    }
    @AfterTest
    private void finish(){
        webDriverBase.close();
    }
    @BeforeClass
    public void initializeMembers(){
        webDriver = WebDriverBase.getDriverInstance().getWebDriver();
        loginPage = new LoginPage(webDriver);
        System.out.println("beforeclass");
    }
    @BeforeMethod
    private void beforeMethod(){
        webDriver.get("http://hbao.codebnb.me");
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
