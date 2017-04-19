package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by liana on 4/16/17.
 */

class Xpaths {
    //reports
    final   By reports = By.xpath("//a[@href='#']");
    final  By jobReports = By.xpath("//a[contains(.,'Jobs Reports')]");
    //marketMatcher
    final   By marketMatcher = By.xpath("//a[text()='Market Matcher']");
    final   By comboBox = By.xpath("//a[@class='custom-combobox-toggle ui-corner-right']");
    final   By liEngineer = By.xpath("//li[text()='Engineer']");
    //surveys
    final   By surveys = By.xpath("//a[text()='Surveys']");
    final   By surveyData = By.xpath(".//tbody/tr[1 and @class='survey_job_code active'] ");
    final   By detailsIcon = By.xpath(".//*[@id='survey_types']");
    final   By detailsElement = By.xpath(".//*[@id='survey_types']/option[4]");
    //employees
    final   By employes = By.xpath("//a[text()='Employees']");
    final   By lastNameIcon = By.xpath(".//*[@id='employee_table']/div/div[2]/table/thead/tr/th[2]/button");
    final   By inpFild = By.xpath(".//*[@id='first_name_panel']/div[1]/div[1]/input");
    final   By searchbutton = By.xpath(".//*[@id='first_name_panel']/div[1]/div[1]/button");
    final   By searchIcon = By.xpath(".//*[@id='employee_table']/div/div[2]/table/thead/tr/th[2]/button");
    final   By clearTina = By.xpath(".//*[@id='first_name_panel']/div[1]/div[1]/input");
    final   By navigateSecond = By.xpath(".//html/body/div/div[3]/ul/li[4]/a");
    //jobList
    final   By employees = By.xpath("//a[text()='Employees']");
    final   By jobList = By.xpath("//a[text()='Job List']");
    final   By verifyJoblist = By.xpath("//h6[text()='City of Houston: Job list']");
    final   By findJobDropdown = By.xpath("//a[@data-original-title='Show All Items']");
    final   By firstEdit = By.xpath(".//tbody/tr[1]/td[9]/a");
    //sighnin
    final   By login = By.xpath("//a[@href='/accounts/login']");
    final   By username = By.xpath("//input[@id='id_username']");
    final   By password = By.xpath("//input[@id='id_password']");
    final   By submit = By.xpath("//input[@class='btn blockBtn blue']");


}

public class Compensation {
    WebDriver driver;
    Xpaths xpaths;
    @BeforeTest
    private void  sighninDriver() throws InterruptedException {
        xpaths = new Xpaths();
        // Opened "Mozilla Firefox"
        System.setProperty("webdriver.firefox.marionette","./driver/geckodriver");
        driver = new FirefoxDriver();
        // Open http://compensation.codebnb.me/ page
        driver.get("http://compensation.codebnb.me/");
        // Make sure that our site has an element by this xpath    //span[contains(.,'Compensation')]
        assertEquals("COMPENSATION", driver.findElement(By.xpath("//span[contains(.,'Compensation')]")).getText());
        // Make sure that our site has an element by this xpath    //a[@href='/accounts/login']"
        assertEquals("SIGN IN", driver.findElement(By.xpath("//a[@href='/accounts/login']")).getText());
        // Click on the button "SIGN IN"
        driver.findElement(xpaths.login).click();
        //shoud be opened "login" and "password" popup window
        Thread.sleep(2000);
        // sendkey for the input field "username"
        driver.findElement(xpaths.username).sendKeys("armen" );
        // sendkey for the input field "password"
        driver.findElement(xpaths.password).sendKeys("Password" );
        Thread.sleep(3000);
        //press submit
        driver.findElement(xpaths.submit).click();
        Thread.sleep(3000);

    }
    @Test
    void openMarketMatcher() throws InterruptedException {
        WebElement reportsButton = driver.findElement(By.xpath("/html/body/div/header/div/div[2]/nav/ul/ul/li[4]/a"));
        reportsButton.click();
        Thread.sleep(3000);
        WebElement marketMatcher = driver.findElement(By.xpath("/html/body/div/header/div/div[2]/nav/ul/ul/li[4]/ul/li[2]"));
        marketMatcher.click();
        Thread.sleep(3000);
    }
}
