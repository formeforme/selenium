package Test.CategoriesTest;

import Pages.Categories.AddEditCategoryPage;
import Pages.Categories.Category;
import Pages.Categories.CategoriesPage;
import Pages.Categories.CategoryPage;
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
    private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoryPage categoryPage;
    private CategoriesPage categoriesPage;
    private AddEditCategoryPage addEditCategoryPage;// = new AddEditCategoryPage(webDriver);

    @BeforeTest
    private void start(){
        webDriverBase = WebDriverBase.getDriverInstance();
        webDriverBase.start();
        webDriver = webDriverBase.getWebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
        addEditCategoryPage = new AddEditCategoryPage(webDriver);
        Assert.assertTrue(isElementPresent(loginPage.loginButton));
        loginPage.login("admin","789456");
        Assert.assertTrue(isElementPresent(homePage.logoutButton));
    }
    @AfterTest
    private void finish(){
        webDriverBase.close();
    }
    @BeforeMethod
    private void beforeMethod(){
        Assert.assertTrue(isElementPresent(homePage.appManagementMenuButton));
        homePage.appManagementMenuButton.click();
        Assert.assertTrue(isElementPresent(homePage.appManagementSubButtons.get(0)));
        homePage.appManagementSubButtons.get(0).click();
        Assert.assertTrue(isElementPresent(categoriesPage.createButton));
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

    @Test(priority = -1, dataProvider = "PTData_category",
            dataProviderClass = CategoriesPageData.class)
    private void validateCreateCategoryWorks(Category category){
        Assert.assertTrue(isElementPresent(categoriesPage.createButton));
        categoriesPage.createButton.click();
        Assert.assertTrue(isElementPresent(addEditCategoryPage.saveButton));
        addEditCategoryPage.fillFields(category);
        //Assert.assertTrue();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(addEditCategoryPage.images.size(),1);
        addEditCategoryPage.save();
    }
    @Test(dataProvider = "PTData_category", dataProviderClass = CategoriesPageData.class)
    public void validateSearchWorks(Category category){
        boolean isFound = false;
        Assert.assertTrue(isElementPresent(categoriesPage.searchButton));
        categoriesPage.searchCategory(category);
        for(int i = 0; i < categoriesPage.categories.size(); ++i) {
            if(categoriesPage.categories.get(i).getText().contains(category.getName())){
                isFound = true;
            }
        }
        Assert.assertTrue(isFound);
    }
    @Test(dataProvider = "PTData_category",
            dataProviderClass = CategoriesPageData.class)
    public void validateOpenCategoryWorks(Category category){
        Assert.assertTrue(isElementPresent(categoriesPage.categories.get(0)));
        String name = categoriesPage.categories.get(0).getText();
        categoriesPage.categories.get(0).click();
        Assert.assertTrue(isElementPresent(categoryPage.editCategory));
        Assert.assertEquals(categoryPage);
        /*Assert.assertEquals(categoryPage.,name);
        Assert.assertEquals(categoryPage.imageField.size(),1);

        Assert.assertTrue(isElementPresent(categoriesPage.searchButton));
        categoriesPage.searchCategory(category);
        for(int i = 0; i < categoriesPage.categories.size(); ++i) {
            if(categoriesPage.categories.get(i).getText().contains(category.getName())){

            }
        }
        //Assert.assertTrue(isFound);
        */
    }
    @Test(dataProvider = "PTData_category", dataProviderClass = CategoriesPageData.class)
    public void validateRightCategoryPageWorks(Category category){
        Assert.assertTrue(isElementPresent(categoriesPage.createButton));
        WebElement deleteButton;
        for(int i = 0; i < categoriesPage.categories.size(); ++i){
            if(categoriesPage.categories.get(i).getText().contains(category.getName())){
                deleteButton = webDriver.findElement(By.xpath(
                        "/html/body/div/div[2]/div[2]/div[2]/div/div/div/div[3]/table/tbody/tr["+ (i+1) +"]/td[2]/a"));
                deleteButton.click();
            }
        }
    }
 /*   @Test(priority = -1, dataProvider = "PTData_subcategory",
            dataProviderClass = CategoriesPageData.class)
    private void validateCreateSubCategoryWorks(){

    }
    */

}

