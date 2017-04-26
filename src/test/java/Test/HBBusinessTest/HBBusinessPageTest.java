package Test.HBBusinessTest;

import Pages.HBBusiness.AddEditHBBusinessPage;
import Pages.HBBusiness.CategoryPage;
import Pages.HBBusiness.HBBusiness;
import Pages.HBBusiness.HBBusinessPage;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class HBBusinessPageTest extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoryPage categoryPage;
    private HBBusinessPage hbBusinessPage;
    private AddEditHBBusinessPage addEditHBBusinessPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        hbBusinessPage = new HBBusinessPage(webDriver);
        addEditHBBusinessPage = new AddEditHBBusinessPage(webDriver);
    }
    protected void openPage(){
        loginPage.login("admin", "789456");
        assertTrue(homePage.isVisible());
        homePage.appManagementMenuButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.appManagementSubButtons.get(1).click();
        assertTrue(hbBusinessPage.isVisible());
    }

    @Test(priority = -1, dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void validateAddWorks(HBBusiness hbBusiness){
        hbBusinessPage.addHBBusiness();
        assertTrue(addEditHBBusinessPage.isVisible());
        addEditHBBusinessPage.addHBBusiness(hbBusiness);
        assertTrue(hbBusinessPage.isVisible());
        assertTrue(hbBusinessPage.searchHBBusiness(hbBusiness.getName()));
    }
    @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void validateSearchWorks(HBBusiness hbBusiness){
        assertTrue(hbBusinessPage.searchHBBusiness(hbBusiness.getName()));
    }
    @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void validateOpenWorks(HBBusiness hbBusiness){
        String name = hbBusiness.getName();
        assertTrue(hbBusinessPage.searchHBBusiness(name));
        hbBusinessPage.openHBBusiness(name);
        assertTrue(categoryPage.isVisible());
        assertEquals(categoryPage.getName(),name);
        //assertEquals(categoryPage.imageField.size(),hbBusiness.getImage());
    }
    @Test(priority = 1, dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void validateDeleteWorks(HBBusiness hbBusiness){
        String name = hbBusiness.getName();
        assertTrue(hbBusinessPage.searchHBBusiness(name));
        hbBusinessPage.deleteHBBusiness(name);
        assertFalse(hbBusinessPage.searchHBBusiness(name));
    }
    @Test(dataProvider = "NTData", dataProviderClass = HBBusinessPageData.class)
    void validateNoWrongInputsAdd(HBBusiness hbBusiness){
        hbBusinessPage.addHBBusiness();
        assertTrue(addEditHBBusinessPage.isVisible());
        addEditHBBusinessPage.addHBBusiness(hbBusiness);
        assertTrue(addEditHBBusinessPage.isVisible());
    }

    @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void validateEditWorks(HBBusiness hbBusiness){
        String oldName = hbBusiness.getName();
        String newName = hbBusiness.getName()+hbBusiness.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            hbBusinessPage.openHBBusiness(oldName);
            assertTrue(categoryPage.isVisible());
            assertEquals(categoryPage.getName(), oldName);
            categoryPage.editHBBusiness();
            assertTrue(addEditHBBusinessPage.isVisible());
            assertEquals(addEditHBBusinessPage.getName(), oldName);
            //check image
            addEditHBBusinessPage.clearNameField();
            addEditHBBusinessPage.setName(newName);
            addEditHBBusinessPage.saveChanges();
            assertTrue(hbBusinessPage.isVisible());
            assertTrue(hbBusinessPage.searchHBBusiness(newName));
            newName = oldName;
            oldName = name;
        }
    }

    @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void validateRightEditPageOpened(HBBusiness hbBusiness){
        String name = hbBusiness.getName();
        hbBusinessPage.openHBBusiness(name);
        assertTrue(categoryPage.isVisible());
        assertEquals(categoryPage.getName(),name);
        String image = categoryPage.getImage();
        categoryPage.editHBBusiness();
        assertTrue(addEditHBBusinessPage.isVisible());
        assertEquals(addEditHBBusinessPage.getName(),name);
        assertTrue(image.contains(addEditHBBusinessPage.getImage()));
    }
    @Test
    void validateRightTitle(){}

    //comment save before run
   // @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void testAddFunctions(HBBusiness hbBusiness){
        hbBusinessPage.addHBBusiness();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addEditHBBusinessPage.addHBBusiness(hbBusiness);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(addEditHBBusinessPage.getName());
        addEditHBBusinessPage.clearNameField();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(addEditHBBusinessPage.getImage());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addEditHBBusinessPage.clearImageField();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


   // @Test(dataProvider = "PTData", dataProviderClass = HBBusinessPageData.class)
    void testCategoryFunctions(HBBusiness hbBusiness){
        hbBusinessPage.openHBBusiness(hbBusiness.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Name"+categoryPage.getName());
        System.out.println("Image of self-created hb"+hbBusiness.getImage());
        System.out.println("Image of categoryPage"+categoryPage.getImage());
        categoryPage.editHBBusiness();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image of editPage"+addEditHBBusinessPage.getImage());

    }
}
