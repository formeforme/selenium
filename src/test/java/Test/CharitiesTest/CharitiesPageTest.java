package Test.CharitiesTest;

import Pages.JoinUs.JoinUs;
import Pages.JoinUs.JoinUsPage;
import Pages.HomePage;
import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liana on 4/10/17.
 */
public class CharitiesPageTest {
    private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
    //private WebDriverWait wait = WebDriverBase.getWaitDriver();
    private WebDriver webDriver = null;
    private JoinUsPage charityPage = null;
    private HomePage homePage = null;
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
    private void initializeMembers(){
        webDriver = webDriverBase.getWebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        charityPage = new JoinUsPage(webDriver);
    }
    @BeforeMethod
    private void beforeMethod(){
        loginPage.login("admin","789456");
        Assert.assertTrue(homePage.isVisible());
        openPage();
    }
    @Test
    private void validateCreateWorks(){

    }
    @Test(priority = 1)
    private void validateSearchWorks(){
        String org = "o";
        Assert.assertTrue(isElementPresent(charityPage.searchButton));
        charityPage.searchOrganization(org);
        for(int i = 0; i < charityPage.orgList.size(); ++i) {
            Assert.assertTrue(charityPage.orgList.get(i).getText().contains(org));
        }
    }
    private void openPage(){
        Assert.assertTrue(isElementClickable(homePage.organizationsMenuButton));
    }
    private boolean isElementPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        try{
            element.isDisplayed();
            //wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private boolean isElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private JoinUs getCharity(){
        String name = "sel_test";
        List<String> images = new LinkedList<String>();
        images.add("./image/coffee.jpeg");
        JoinUs charity = new JoinUs();
        charity.setName(name);
        charity.setMainImage(images.get(0));
        charity.setSliderImages(images);
        return charity;
    }
}
