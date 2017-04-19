package Test.CategoriesTest;

import Pages.Categories.AddEditCategoryPage;
import Pages.Categories.Category;
import Pages.Categories.CategoriesPage;
import Pages.HomePage;
import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liana on 4/12/17.
 */
public class CategoriesPageTest {
    private String URL;
    private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
    private WebDriver webDriver;// = webDriverBase.getWebDriver();
    private HomePage homePage;// = new HomePage(webDriver);
    private LoginPage loginPage;// = new Login(webDriver);
    private CategoriesPage categoriesPage;// = new CategoriesPage(webDriver);
    private AddEditCategoryPage addEditCategoryPage;// = new AddEditCategoryPage(webDriver);

    @BeforeTest
    private void start(){
        webDriverBase.start();
    }
    @AfterTest
    private void finish(){
         webDriverBase.close();
    }
    @BeforeClass
    private void initializeMembers(){
        webDriver = webDriverBase.getWebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
        addEditCategoryPage = new AddEditCategoryPage(webDriver);
        Assert.assertTrue(loginPage.isVisible());
        loginPage.login("admin", "789456");
        Assert.assertTrue(homePage.isVisible());
        openPage();
        URL = webDriver.getCurrentUrl();

    }
    @BeforeMethod
    private void beforeMethod(){
        webDriver.navigate().to(URL);
    }
    private void openPage(){
        Assert.assertTrue(isElementClickable(homePage.appManagementMenuButton));
        homePage.appManagementMenuButton.click();
        Assert.assertTrue(isElementClickable(homePage.appManagementSubButtons.get(0)));
        homePage.appManagementSubButtons.get(0).click();
        ///Assert.assertTrue(categoriesPage.isVisible());
        Assert.assertTrue(isElementClickable(categoriesPage.createButton));
    }
    private boolean isElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver,20);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
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

    private Category getCategory(){
        String name = "sel_test";
        List<String> images = new LinkedList<String>();
        images.add("./image/coffee.jpeg");
        String type = "OnlineSales";
        Category category = new Category();
        category.setName(name);
        category.setImages(images);
        category.setType(type);
        return category;
    }
    @Test
    private void validateCreateWorks(){
        Assert.assertTrue(isElementClickable(categoriesPage.createButton));
        categoriesPage.createButton.click();
        Assert.assertTrue(isElementClickable(addEditCategoryPage.saveButton));
        addEditCategoryPage.fillFields(getCategory());
        //Assert.assertTrue();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(addEditCategoryPage.images.size(),1);
        addEditCategoryPage.save();
    }
    @Test(priority = 1)
    public void validateSearchWorks(){
        boolean isFound = false;
        Assert.assertTrue(isElementPresent(categoriesPage.searchButton));
        categoriesPage.searchCategory(getCategory());
        for(int i = 0; i < categoriesPage.categories.size(); ++i) {
            if(categoriesPage.categories.get(i).getText().contains(getCategory().getName())){
                isFound = true;
            }
        }
        Assert.assertTrue(isFound);
    }
    @Test(priority = 2)
    public void validateDeleteWorks(){
        Assert.assertTrue(isElementClickable(categoriesPage.createButton));
        WebElement deleteButton;
        Category category = getCategory();
        for(int i = 0; i < categoriesPage.categories.size(); ++i){
            if(categoriesPage.categories.get(i).getText().contains(category.getName())){
                deleteButton = webDriver.findElement(By.xpath(
                        "/html/body/div/div[2]/div[2]/div[2]/div/div/div/div[3]/table/tbody/tr["+ (i+1) +"]/td[2]/a"));
                deleteButton.click();
            }
        }
    }
}

