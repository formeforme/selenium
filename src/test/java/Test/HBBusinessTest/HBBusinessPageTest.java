package Test.HBBusinessTest;

import Pages.HBBusiness.AddEditHBBusinessPage;
import Pages.HBBusiness.CategoryPage;
import Pages.HBBusiness.HBBusiness;
import Pages.HBBusiness.HBBusinessPage;
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
 * Created by liana on 4/14/17.
 */
public class HBBusinessPageTest {
    private WebDriverBase webDriverBase;
    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoryPage categoryPage;
    private HBBusinessPage hbBusinessPage;
    private AddEditHBBusinessPage addEditHBBusinessPage;

    @BeforeTest
    private void start(){
        webDriverBase = WebDriverBase.getDriverInstance();
        webDriverBase.start();
        webDriver = webDriverBase.getWebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        hbBusinessPage = new HBBusinessPage(webDriver);
        addEditHBBusinessPage = new AddEditHBBusinessPage(webDriver);
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
        Assert.assertTrue(isElementPresent(homePage.appManagementSubButtons.get(1)));
        homePage.appManagementSubButtons.get(1).click();
        Assert.assertTrue(isElementPresent(hbBusinessPage.addButton));
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
    @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    private void validateSearchWorks(HBBusiness hbBusiness){
        Assert.assertTrue(isElementPresent(hbBusinessPage.searchField));
        Assert.assertTrue(hbBusinessPage.searchHBBusiness(hbBusiness));
    }
    @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    private void validateRightPageOpened(HBBusiness hbBusiness){
        Assert.assertTrue(isElementPresent(hbBusinessPage.items.get(0)));
        hbBusinessPage.openHBBusiness(hbBusiness);
        Assert.assertTrue(isElementPresent(categoryPage.nameField));
        Assert.assertEquals(categoryPage.getName(),hbBusiness.getName());
        //TODO
        Assert.assertEquals(categoryPage.imageField.size(),1);
    }
    @Test
    private void validateOpenWorks(){
        Assert.assertTrue(isElementPresent(hbBusinessPage.items.get(0)));
        String name = hbBusinessPage.items.get(0).getText();
        hbBusinessPage.items.get(0).click();
        Assert.assertTrue(isElementPresent(categoryPage.nameField));
        Assert.assertEquals(categoryPage.getName(),name);
        Assert.assertEquals(categoryPage.imageField.size(),1);
    }
    @Test(priority = 1, dataProvider = "PTData",
            dataProviderClass = HBBusinessPageData.class)
    private void validateDeleteWorks(HBBusiness hbBusiness){
        Assert.assertTrue(isElementPresent(hbBusinessPage.searchField));
        if (hbBusinessPage.searchHBBusiness(hbBusiness)) {
            hbBusinessPage.deleteHBBusiness(hbBusiness);
        }
        Assert.assertFalse(hbBusinessPage.searchHBBusiness(hbBusiness));
    }
    @Test(priority = -1, dataProvider = "PTData",
            dataProviderClass = HBBusinessPageData.class)
    private void validateAddWorks(HBBusiness hbBusiness){
        Assert.assertTrue(isElementPresent(hbBusinessPage.addButton));
        hbBusinessPage.addHBBusiness();
        Assert.assertTrue(isElementPresent(addEditHBBusinessPage.saveButton));
        addEditHBBusinessPage.add(hbBusiness);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addEditHBBusinessPage.save();
        Assert.assertTrue(isElementPresent(hbBusinessPage.items.get(0)));
        Assert.assertTrue(hbBusinessPage.searchHBBusiness(hbBusiness));
    }
    @Test(dataProvider = "NTData", dataProviderClass = HBBusinessPageData.class)
    private void validateNoWrongInputsAdd(HBBusiness hbBusiness){
        Assert.assertTrue(isElementPresent(hbBusinessPage.addButton));
        hbBusinessPage.addHBBusiness();
        Assert.assertTrue(isElementPresent(addEditHBBusinessPage.saveButton));
        addEditHBBusinessPage.add(hbBusiness);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addEditHBBusinessPage.save();
        Assert.assertTrue(isElementPresent(addEditHBBusinessPage.saveButton));
    }
    @Test
    private void validateEditPageOpened(){
        validateOpenWorks();
        String name = categoryPage.getName();
        Assert.assertTrue(isElementPresent(categoryPage.editButton));
        categoryPage.editButton.click();
        Assert.assertTrue(isElementPresent(addEditHBBusinessPage.nameField));
        Assert.assertEquals(addEditHBBusinessPage.nameField.getAttribute("value"),name);
        Assert.assertEquals(addEditHBBusinessPage.imageField.size(),1);
    }
   // @Test
    private void validateEditWorks(){
        validateEditPageOpened();
        String newName = "alsfoek";
        addEditHBBusinessPage.nameField.clear();
        addEditHBBusinessPage.nameField.sendKeys(newName);
        Assert.assertTrue(isElementPresent(addEditHBBusinessPage.saveButton));
        addEditHBBusinessPage.save();
        Assert.assertTrue(isElementPresent(hbBusinessPage.items.get(0)));
    }
}
