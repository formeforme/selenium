package Test.CharitiesTest;

import Pages.Categories.CategoriesPage;
import Pages.HBBusiness.AddEditHBBusinessPage;
import Pages.HBBusiness.CategoryPage;
import Pages.HBBusiness.HBBusinessPage;
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
    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoriesPage categoriesPage;
    /*@BeforeTest
    private void start(){
        webDriverBase = WebDriverBase.getDriverInstance();
        webDriverBase.start();
        webDriver = webDriverBase.getWebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        Assert.assertTrue(isElementPresent(loginPage.loginButton));
        loginPage.login("admin","789456");
        Assert.assertTrue(isElementPresent(homePage.logoutButton));
    }
    @AfterTest
    private void finish(){
        webDriverBase.close();
    }
    @BeforeMethod
    private void beforeMethod(){
        Assert.assertTrue(isElementPresent(homePage.appManagementMenuButton));
        homePage.appManagementMenuButton.click();
        Assert.assertTrue(isElementPresent(homePage.appManagementSubButtons.get(0)));
        homePage.appManagementSubButtons.get(0).click();
        Assert.assertTrue(isElementPresent(categoriesPage.createButton));
    }
    @Test
    private void validateCreateWorks(){}
    @Test(priority = 1)
    private void validateSearchWorks(){
        Assert.assertTrue(isElementPresent(charityPage.searchButton));
        charityPage.searchOrganization(org);
        for(int i = 0; i < charityPage.orgList.size(); ++i) {
            Assert.assertTrue(charityPage.orgList.get(i).getText().contains(org));
        }
    }
    private void openPage(){
        Assert.assertTrue(isElementPresent(homePage.organizationsMenuButton));
    }
    private boolean isElementPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
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
    */
}
