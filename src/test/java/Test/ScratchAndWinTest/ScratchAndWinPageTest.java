package Test.ScratchAndWinTest;


import Pages.HBBusiness.AddEditHBBusinessPage;
import Pages.HBBusiness.CategoryPage;
import Pages.HBBusiness.HBBusinessPage;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Pages.ScratchAndWin.ScratchAndWinPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;

import static org.testng.Assert.assertTrue;

public class ScratchAndWinPageTest extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;
    private ScratchAndWinPage scratchAndWinPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        scratchAndWinPage = new ScratchAndWinPage(webDriver);
    }
    protected void openPage(){
        loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openScratchAndWin();
        assertTrue(scratchAndWinPage.isVisible());
    }
}
