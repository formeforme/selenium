package Test;

import Pages.HomePage;
import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by liana on 4/10/17.
 */
public class HomePageTest {
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
       // webDriverBase.close();
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
        loginPage.login("admin","789456");
    }
    @Test
    public void menuItems(){
        Assert.assertTrue(isElementPresent(homePage.homeMenuButton));
        Assert.assertTrue(isElementPresent(homePage.merchantsMenuButton));
        Assert.assertTrue(isElementPresent(homePage.usersMenuButton));
        Assert.assertTrue(isElementPresent(homePage.organizationsMenuButton));
        Assert.assertTrue(isElementPresent(homePage.appManagementMenuButton));
    }

    private void menuSubItems(){
        //merchants&vouchers
        List<WebElement> list = webDriver.findElements(By.xpath("" +
                "/html/body/div/div[1]/div/div[2]/nav/ul/li[2]/ul/li"));
        Assert.assertEquals(3,list.size());
        //users
    }

    //@Test
    private void merchants(){
        List<WebElement> list = webDriver.findElements(By.xpath("" +
                "/html/body/div/div[1]/div/div[2]/nav/ul/li[2]/ul/li"));
        System.out.println("SIZE"+list.size());
    }

    private boolean isElementPresent(WebElement element){
        WebDriverWait wait = WebDriverBase.getWaitDriver();
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void mainPartItems(){

    }
    //void URL(){}
    //@Test
    private void checkLogoutWorks(){
        homePage.logout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(loginPage.isVisible());
    }
}
