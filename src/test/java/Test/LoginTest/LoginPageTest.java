package Test.LoginTest;

import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Pages.Login.User;
import Test.BaseTest.BaseTest;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;


public class LoginPageTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
    protected void openPage() {}

    @Test(dataProvider = "PTData", dataProviderClass = LoginPageData.class)
    void validateLoginWorks(User user/*String username, String password*/) {
        loginPage.login(user);
        assertTrue(homePage.isVisible());
    }
    @Test(dataProvider = "NTData", dataProviderClass = LoginPageData.class)
    void validateFieldCheckIsDone(User user/*String username, String password*/) {
        loginPage.login(user);
        assertTrue(loginPage.isVisible());
    }
   // @Test
    void t(){
        try {
            org.apache.log4j.BasicConfigurator.configure();
            ExcelUtils.setExcelFile("./data/data2.xlsx","Sheet1");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
                    +ExcelUtils.getCellData(1,1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
