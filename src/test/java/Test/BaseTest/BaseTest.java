package Test.BaseTest;

import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by liana on 4/25/17.
 */
public abstract class BaseTest {
    private WebDriverBase webDriverBase;
    protected WebDriver webDriver;
    protected abstract void initializeMembers();
    protected abstract void openPage();
    protected void createObjects(){};
    protected void deleteObjects(){};

    @BeforeClass
    protected void prepare(){
        createObjects();
    }
    @BeforeMethod
    protected void start(){
        startDriver();
        initializeMembers();
        openPage();
    }
    private void startDriver(){
        webDriverBase = WebDriverBase.getDriverInstance();
        webDriverBase.start();
        webDriver = webDriverBase.getWebDriver();
    }
    @AfterMethod
    protected void finish(){
//        deleteObjects();
        webDriverBase.close();
    }
}
