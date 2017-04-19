package Test.LoginTest;

import Pages.HomePage;
import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by liana on 4/7/17.
 */
public class LoginPageTest {
    private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
    private WebDriver webDriver = null;
    private LoginPage loginPage = null;
    private HomePage homePage = null;
    @BeforeTest
    private void start(){
        webDriverBase.start();
    }
    @AfterTest
    private void finish(){
        webDriverBase.close();
    }
    @BeforeClass
    private void initializeMembers(){
        webDriver = webDriverBase.getWebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
    @BeforeMethod
    private void beforeMethod(){
        webDriver.get("http://hbao.codebnb.me");
        Assert.assertTrue(isElementPresent(loginPage.loginButton));
    }
    @Test(dataProvider = "PTData", dataProviderClass = LoginPageData.class)
    public void validateLoginWorks(String username, String password) {
        loginPage.clearFields();
        loginPage.login(username, password);
        Assert.assertTrue(isElementPresent(homePage.logoutButton));
        homePage.logout();
    }
    @Test(dataProvider = "NTData", dataProviderClass = LoginPageData.class)
    private void validateFieldCheckIsDone(String username, String password) {
        loginPage.clearFields();
        loginPage.login(username, password);
        Assert.assertTrue(isElementPresent(loginPage.loginButton));
    }
    private boolean isElementPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver,20);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
