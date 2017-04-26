package Test.CharitiesTest;

import Pages.Charities.AddCharityPage;
import Pages.Charities.CharitiesPage;
import Pages.Charities.CharityPage;
import Pages.Charities.Organization;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by liana on 4/10/17.
 */
public class CharitiesPageTest extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;
    private CharityPage charityPage;
    private CharitiesPage charitiesPage;
    private AddCharityPage addCharityPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        charityPage = new CharityPage(webDriver);
        charitiesPage = new CharitiesPage(webDriver);
        addCharityPage = new AddCharityPage(webDriver);
    }
    protected void openPage(){
        loginPage.login("admin","789456");
        assertTrue(isElementPresent(homePage.appManagementMenuButton));
        homePage.organizationsMenuButton.click();
        assertTrue(charitiesPage.isVisible());
    }
    public boolean isElementPresent(WebElement element){
        WebDriver webDriver = WebDriverBase.getDriverInstance().getWebDriver();
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Test(dataProvider = "PTData", dataProviderClass = CharitiesPageData.class)
    private void validateSearchWorks(Organization organization){
        assertTrue(charitiesPage.searchCharity(organization.getName()));
    }
    @Test(dataProvider = "PTData", dataProviderClass = CharitiesPageData.class)
    private void validateOpenWorks(Organization organization){
        String name = organization.getName();
        assertTrue(charitiesPage.searchCharity(name));
        charitiesPage.openCharity(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
        //assertEquals(categoryPage.imageField.size(),1);
    }
    @Test(priority = 1, dataProvider = "PTData",
            dataProviderClass = CharitiesPageData.class)
    private void validateDeleteWorks(Organization organization){
        assertTrue(charitiesPage.searchCharity(organization.getName()));
        charitiesPage.deleteCharity(organization.getName());
        assertFalse(charitiesPage.searchCharity(organization.getName()));
    }
    @Test(priority = -1, dataProvider = "PTData",
            dataProviderClass = CharitiesPageData.class)
    private void validateAddWorks(Organization organization){
        charitiesPage.createCharity();
        assertTrue(addCharityPage.isVisible());
        addCharityPage.addCharity(organization);
        addCharityPage.waitUntilImageLoaded();
        addCharityPage.save();
        assertTrue(charitiesPage.isVisible());
        assertTrue(charitiesPage.searchCharity(organization.getName()));

    }
    @Test(dataProvider = "NTData", dataProviderClass = CharitiesPageData.class)
    private void validateNoWrongInputsAdd(Organization organization){
        charitiesPage.createCharity();
        assertTrue(addCharityPage.isVisible());
        addCharityPage.addCharity(organization);
        addCharityPage.waitUntilImageLoaded();
        addCharityPage.save();
        assertTrue(addCharityPage.isVisible());
    }
    @Test(dataProvider = "PTData", dataProviderClass = CharitiesPageData.class)
    private void validateEditWorks(Organization organization){
        String name = organization.getName();
        charitiesPage.openCharity(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
        // assertEquals(categoryPage.imageField.size(),1);
        charityPage.edit();
        assertTrue(addCharityPage.isVisible());
        assertEquals(addCharityPage.getName(),name);
        //check image
        addCharityPage.clearNameField();
        addCharityPage.setName(name+name);
        //change image
        addCharityPage.save();
        assertTrue(charitiesPage.isVisible());
        assertTrue(charitiesPage.searchCharity(name+name));



        charitiesPage.openCharity(name+name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name+name);
        // assertEquals(categoryPage.imageField.size(),1);
        charityPage.edit();
        assertTrue(addCharityPage.isVisible());
        assertEquals(addCharityPage.getName(),name+name);
        //check image
        addCharityPage.clearNameField();
        addCharityPage.setName(name);
        //change image
        addCharityPage.save();
        assertTrue(charitiesPage.isVisible());
        assertTrue(charitiesPage.searchCharity(name));
    }

    @Test(dataProvider = "PTData", dataProviderClass = CharitiesPageData.class)
    private void validateRightEditPageOpened(Organization organization){
        String name = organization.getName();
        charitiesPage.openCharity(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
        // assertEquals(categoryPage.imageField.size(),1);
        charityPage.edit();
        assertTrue(addCharityPage.isVisible());
        assertEquals(addCharityPage.getName(),name);
        //check image
    }
    @Test
    void validateRightTitle(){}
}
//    private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
//    //private WebDriverWait wait = WebDriverBase.getWaitDriver();
//    private WebDriver webDriver = null;
//    private JoinUsPage charityPage = null;
//    private HomePage homePage = null;
//    private LoginPage loginPage = null;
//    @BeforeTest
//    private void start(){
//        webDriverBase.start();
//    }
//    @AfterTest
//    private void finish(){
//        webDriverBase.close();
//    }
//    @BeforeClass
//    private void initializeMembers(){
//        webDriver = webDriverBase.getWebDriver();
//        homePage = new HomePage(webDriver);
//        loginPage = new LoginPage(webDriver);
//        charityPage = new JoinUsPage(webDriver);
//    }
//    @BeforeMethod
//    private void beforeMethod(){
//        loginPage.login("admin","789456");
//        Assert.assertTrue(homePage.isVisible());
//        openPage();
//    }
//    @Test
//    private void validateCreateWorks(){
//
//    }
//    @Test(priority = 1)
//    private void validateSearchWorks(){
//        String org = "o";
//        Assert.assertTrue(isElementPresent(charityPage.searchButton));
//        charityPage.searchOrganization(org);
//        for(int i = 0; i < charityPage.orgList.size(); ++i) {
//            Assert.assertTrue(charityPage.orgList.get(i).getText().contains(org));
//        }
//    }
//    private void openPage(){
//        Assert.assertTrue(isElementClickable(homePage.organizationsMenuButton));
//    }
//    private boolean isElementPresent(WebElement element){
//        WebDriverWait wait = new WebDriverWait(webDriver,8);
//        try{
//            element.isDisplayed();
//            //wait.until(ExpectedConditions.visibilityOf(element));
//            return true;
//        } catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//    private boolean isElementClickable(WebElement element){
//        WebDriverWait wait = new WebDriverWait(webDriver,8);
//        try{
//            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//            return true;
//        } catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//    private JoinUs getCharity(){
//        String name = "sel_test";
//        List<String> images = new LinkedList<String>();
//        images.add("./image/coffee.jpeg");
//        JoinUs charity = new JoinUs();
//        charity.setName(name);
//        charity.setMainImage(images.get(0));
//        charity.setSliderImages(images);
//        return charity;
//    }
//}
