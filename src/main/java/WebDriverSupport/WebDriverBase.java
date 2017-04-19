package WebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by liana on 4/7/17.
 */
public class WebDriverBase {
    private static WebDriver webDriver = null;
    private static WebDriverWait driverWait = null;
    private String URL = "http://hbao.codebnb.me";
    private BROWSER executeBrowser = BROWSER.FIREFOX;
    private static WebDriverBase driverInstance = new WebDriverBase();

    public enum BROWSER {
        FIREFOX, CHROME
    }

    private WebDriverBase(){}

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public static WebDriverBase getDriverInstance(){
        return driverInstance;
    }

    public static WebDriverWait getWaitDriver(){
        if(driverWait == null) {
            driverWait = new WebDriverWait(webDriver,4);
        }
        return driverWait;
    }

    public void start(){
        //if(webDriver != null) {
        //    return;
        //}
        switch (executeBrowser){
            case CHROME:
                System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
                webDriver = new ChromeDriver();
                webDriver.get(URL);
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.marionette","./driver/geckodriver");
                webDriver = new FirefoxDriver();
                webDriver.get(URL);
                break;
        }
    }

    public void close(){
        if(webDriver != null) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        }
    }

}
