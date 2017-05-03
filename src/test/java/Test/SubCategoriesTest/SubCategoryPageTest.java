package Test.SubCategoriesTest;

import Pages.Categories.*;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import Test.CategoriesTest.CategoriesPageData;
import Test.SubCategoriesTest.SubCategoryPageData;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SubCategoryPageTest extends BaseTest{
    private Category category;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoriesPage categoriesPage;
    private CategoryPage categoryPage;
    private AddEditCategoryPage addEditCategoryPage;
    private AddEditSubCategoryPage addEditSubCategoryPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        addEditCategoryPage = new AddEditCategoryPage(webDriver);
        addEditSubCategoryPage = new AddEditSubCategoryPage(webDriver);
    }
    protected void openPage(){
        loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openCategories();
        assertTrue(categoriesPage.isVisible());
    }
    @Test(priority = -2, dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void createCategory(Category category){
        this.category = category;
        categoriesPage.createCategory();
        assertTrue(addEditCategoryPage.isVisible());
        addEditCategoryPage.addCategory(category);
        assertTrue(categoriesPage.isVisible());
        assertTrue(categoriesPage.searchCategory(category.getName()));
    }
    @Test(priority = -1, dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void addSubCategory(SubCategory subCategory){
        categoriesPage.openCategory(this.category.getName());
        assertTrue(categoryPage.isVisible());
        categoryPage.createSubCategory();
        assertTrue(addEditSubCategoryPage.isVisible());
        addEditSubCategoryPage.addSubCategory(subCategory);
        assertTrue(categoryPage.isVisible());
    }
    //@Test(dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void editSubCategory(SubCategory subCategory){
        categoriesPage.openCategory(this.category.getName());
        assertTrue(categoryPage.isVisible());
        String oldName = subCategory.getName();
        String newName = subCategory.getName()+subCategory.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            categoryPage.editSubCategory(oldName);
            assertTrue(addEditSubCategoryPage.isVisible());
            addEditSubCategoryPage.clearNameField();
            addEditSubCategoryPage.setName(newName);
            addEditSubCategoryPage.saveChanges();
            assertTrue(categoryPage.isVisible());
            newName = oldName;
            oldName = name;
        }
    }
   // @Test(dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void validateRightEditSubCategoryPage(SubCategory subCategory){
        String name = subCategory.getName();
        categoriesPage.openCategory(this.category.getName());
        assertTrue(categoryPage.isVisible());
        categoryPage.editSubCategory(name);
        assertTrue(addEditSubCategoryPage.isVisible());
        assertEquals(addEditSubCategoryPage.getName(),name);
//        assertTrue(image.contains(addEditCategoryPage.getImage()));
    }
    @Test(dataProvider = "NTData", dataProviderClass = SubCategoryPageData.class)
    void validateNotWrongEditInputs(SubCategory subCategory){
        String name = subCategory.getName();
        categoriesPage.openCategory(this.category.getName());
        assertTrue(categoryPage.isVisible());
        categoryPage.editSubCategory(name);
        assertTrue(addEditSubCategoryPage.isVisible());
        addEditSubCategoryPage.addSubCategory(subCategory);
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(addEditSubCategoryPage.isVisible());
    }
    @Test(priority = 1, dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void deleteSubCategory(SubCategory subCategory){
        String name = subCategory.getName();
        categoriesPage.openCategory(this.category.getName());//change if only this run
        assertTrue(categoryPage.isVisible());
        categoryPage.deleteSubCategory(name);
    }
}
