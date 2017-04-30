package WebDriverSupport;

import Pages.Login.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by liana on 4/7/17.
 */
public class WebDriverBase {
    private static WebDriver webDriver;
    private String URL;
    private BROWSER executeBrowser;
    private static WebDriverBase driverInstance = new WebDriverBase();
    private final String PROPERTIES_FILE = "data/data.properties";
    public static User user;

    public enum BROWSER {
        FIREFOX, CHROME
    }

    private WebDriverBase(){
        initializeMembers();
    }

    private void initializeMembers() {
        try {
            FileInputStream stream = new FileInputStream(new File(PROPERTIES_FILE));
            Properties properties = new Properties();
            properties.load(stream);
            this.URL = properties.getProperty("URL");
            String browser = properties.getProperty("BROWSER");
            this.executeBrowser = BROWSER.valueOf(browser);
            user = new User();
            user.setUsername(properties.getProperty("USERNAME"));
            user.setPassword(properties.getProperty("PASSWORD"));
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public static WebDriverBase getDriverInstance(){
        return driverInstance;
    }


    public void start(){
        if(webDriver != null) {
            return;
        }
        switch (executeBrowser){
            case CHROME:
              //  System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
                webDriver = new ChromeDriver();
                webDriver.get(URL);
                break;
            case FIREFOX:
              //  System.setProperty("webdriver.firefox.marionette","./driver/geckodriver");
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
