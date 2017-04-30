package Test.CategoriesTest;

import Pages.Categories.AddEditCategoryPage;
import Pages.Categories.CategoriesPage;
import Pages.Categories.CategoryPage;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;

import static org.testng.Assert.assertTrue;

/**
 * Created by liana on 4/30/17.
 */
public class SubCategoryPageTest extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoriesPage categoriesPage;
    private CategoryPage categoryPage;
    private AddEditCategoryPage addEditCategoryPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        addEditCategoryPage = new AddEditCategoryPage(webDriver);
    }
    protected void openPage(){
        loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openCategories();
        assertTrue(categoriesPage.isVisible());
    }

}
