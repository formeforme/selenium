package Test.JoinUs;

import Pages.HomePage.HomePage;
import Pages.JoinUs.AddEditJoinUsPage;
import Pages.JoinUs.CharityPage;
import Pages.JoinUs.JoinUs;
import Pages.JoinUs.JoinUsPage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by liana on 4/23/17.
 */
public class JoinUsTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private JoinUsPage joinUsPage;
    private CharityPage charityPage;
    private AddEditJoinUsPage addEditJoinUsPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        joinUsPage = new JoinUsPage(webDriver);
        charityPage = new CharityPage(webDriver);
        addEditJoinUsPage = new AddEditJoinUsPage(webDriver);
    }
    protected void openPage(){
        loginPage.login("admin", "789456");
        assertTrue(isElementPresent(homePage.appManagementMenuButton));
        homePage.appManagementMenuButton.click();
        assertTrue(isElementPresent(homePage.appManagementSubButtons.get(1)));
        homePage.appManagementSubButtons.get(2).click();
        assertTrue(joinUsPage.isVisible());
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

    @Test(dataProvider = "PTData", dataProviderClass = JoinUsData.class)
    public void validateSearchWorks(JoinUs joinUs){
        assertTrue(joinUsPage.searchOrganization(joinUs.getName()));
    }
    @Test(dataProvider = "PTData",
            dataProviderClass = JoinUsData.class)
    public void validateOpenWorks(JoinUs joinUs){
        String name = joinUs.getName();
        assertTrue(joinUsPage.searchOrganization(name));
        joinUsPage.openOrganization(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
       // assertEquals(,1);
    }
    @Test(priority = 1, dataProvider = "PTData",
            dataProviderClass = JoinUsData.class)
    public void validateDeleteWorks(JoinUs joinUs){
        String name = joinUs.getName();
        assertTrue(joinUsPage.searchOrganization(name));
        joinUsPage.deleteOrganization(name);
        assertFalse(joinUsPage.searchOrganization(name));
    }
    @Test(priority = -1, dataProvider = "PTData",
            dataProviderClass = JoinUsData.class)
    public void validateAddWorks(JoinUs joinUs){
        String name = joinUs.getName();
        joinUsPage.createOrganization();
        assertTrue(addEditJoinUsPage.isVisible());
        addEditJoinUsPage.addJoinUs(joinUs);
        assertTrue(joinUsPage.isVisible());
        assertTrue(joinUsPage.searchOrganization(name));
    }
    @Test(dataProvider = "NTData",
            dataProviderClass = JoinUsData.class)
    public void validateNoWrongInputsAdd(JoinUs joinUs){
        joinUsPage.createOrganization();
        assertTrue(addEditJoinUsPage.isVisible());
        addEditJoinUsPage.addJoinUs(joinUs);
        assertTrue(addEditJoinUsPage.isVisible());
    }
    @Test(dataProvider = "PTData", dataProviderClass = JoinUsData.class)
    public void validateEditWorks(JoinUs joinUs){
        String oldName = joinUs.getName();
        String newName = joinUs.getName()+joinUs.getName();
        String name = newName;
        for (int i = 0; i < 2; ++i) {
            joinUsPage.openOrganization(oldName);
            assertTrue(charityPage.isVisible());
            assertEquals(charityPage.getName(), oldName);
            // assertEquals(categoryPage.imageField.size(),1);
            charityPage.editJoinUs();
            assertTrue(addEditJoinUsPage.isVisible());
            assertEquals(addEditJoinUsPage.getName(), oldName);
            //check image
            addEditJoinUsPage.clearNameField();
            addEditJoinUsPage.setName(newName);
            addEditJoinUsPage.saveChanges();
            //change image
            assertTrue(joinUsPage.isVisible());
            assertTrue(joinUsPage.searchOrganization(newName));
            newName = oldName;
            oldName = name;
        }



    }

    @Test(dataProvider = "PTData", dataProviderClass = JoinUsData.class)
    public void validateRightEditPageOpened(JoinUs joinUs){
        String name = joinUs.getName();
        joinUsPage.openOrganization(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
        // assertEquals(categoryPage.imageField.size(),1);
        charityPage.editJoinUs();
        assertTrue(addEditJoinUsPage.isVisible());
        assertEquals(addEditJoinUsPage.getName(),name);
        //check image
    }
    @Test
    public void validateRightTitle(){}
}
