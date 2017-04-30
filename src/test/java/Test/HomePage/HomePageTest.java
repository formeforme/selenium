package Test.HomePage;

import Pages.BasePage;
import Pages.Categories.CategoriesPage;
import Pages.HBBusiness.AddEditHBBusinessPage;
import Pages.HBBusiness.CategoryPage;
import Pages.HBBusiness.HBBusinessPage;
import Pages.HomePage.HomePage;
import Pages.JoinUs.JoinUs;
import Pages.JoinUs.JoinUsPage;
import Pages.Login.LoginPage;
import Pages.State;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by liana on 4/10/17.
 */
public class HomePageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
    protected void openPage(){
        loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
    }
    @Test
    void openCategoryPage(){
        CategoriesPage page = homePage.openCategories();
        assertTrue(page.isVisible());
    }
    @Test
    void openHBBusinessPage(){
        HBBusinessPage page = homePage.openHBBusiness();
        assertTrue(page.isVisible());
    }
    @Test
    void openJoinUsPage(){
        JoinUsPage page = homePage.openJoinUs();
        assertTrue(page.isVisible());
    }
    @Test
    void openScratchAndWinPage(){
        //ScratchAndWinPage page = homePage.openScratchAndWin();
        //assertTrue(page.isVisible());
    }
    @Test
    void validateLogoutWorks(){
        LoginPage page = homePage.logout();
        assertTrue(page.isVisible());
    }
}
