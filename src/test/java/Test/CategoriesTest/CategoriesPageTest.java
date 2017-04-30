package Test.CategoriesTest;

import Pages.Categories.*;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CategoriesPageTest extends BaseTest{
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

    @Test(priority = -1, dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void validateAddWorks(Category category){
        categoriesPage.createCategory();
        assertTrue(addEditCategoryPage.isVisible());
        addEditCategoryPage.addCategory(category);
        assertTrue(categoriesPage.isVisible());
        assertTrue(categoriesPage.searchCategory(category.getName()));
    }
    @Test(dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void validateSearchWorks(Category category){
        assertTrue(categoriesPage.searchCategory(category.getName()));
    }
    @Test(dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void validateOpenWorks(Category category){
        String name = category.getName();
        assertTrue(categoriesPage.searchCategory(name));
        categoriesPage.openCategory(name);
        assertTrue(categoryPage.isVisible());
        assertEquals(categoryPage.getName(),name);
        //assertEquals(categoryPage.imageField.size(),hbBusiness.getImage());
    }
    @Test(priority = 1, dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void validateDeleteWorks(Category category){
        String name = category.getName();
        assertTrue(categoriesPage.searchCategory(name));
        categoriesPage.deleteCategory(name);
        assertFalse(categoriesPage.searchCategory(name));
    }
   // @Test(dataProvider = "NTData", dataProviderClass = HBBusinessPageData.class)
    void validateNoWrongInputsAdd(Category category){
        categoriesPage.createCategory();
        assertTrue(addEditCategoryPage.isVisible());
        addEditCategoryPage.addCategory(category);
        assertTrue(addEditCategoryPage.isVisible());
    }
    @Test(dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void validateRightEditPageOpened(Category category){
        String name = category.getName();
        categoriesPage.openCategory(name);
        assertTrue(categoryPage.isVisible());
        String image = categoryPage.getImage();
        categoryPage.editCategory();
        assertTrue(addEditCategoryPage.isVisible());
        assertEquals(addEditCategoryPage.getName(),name);
        assertTrue(image.contains(addEditCategoryPage.getImage()));
    }
    @Test(dataProvider = "PTData", dataProviderClass = CategoriesPageData.class)
    void validateEditWorks(Category category){
        String oldName = category.getName();
        String newName = category.getName()+category.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            categoriesPage.openCategory(oldName);
            assertTrue(categoryPage.isVisible());
            categoryPage.editCategory();
            assertTrue(addEditCategoryPage.isVisible());
            addEditCategoryPage.clearNameField();
            addEditCategoryPage.setName(newName);
            addEditCategoryPage.saveChanges();
            assertTrue(categoriesPage.isVisible());
            assertTrue(categoriesPage.searchCategory(newName));
            newName = oldName;
            oldName = name;
        }
    }
    @Test(dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void addSubCategory(SubCategory subCategory){
        categoriesPage.openCategory("auto_Category");
        assertTrue(categoryPage.isVisible());
        categoryPage.createSubCategory();
        assertTrue(addEditSubCategoryPage.isVisible());
        addEditSubCategoryPage.addSubCategory(subCategory);
        assertTrue(categoryPage.isVisible());
    }
    @Test(dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void editSubCategory(SubCategory subCategory){
        String oldName = subCategory.getName();
        String newName = subCategory.getName()+subCategory.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            categoriesPage.openCategory(oldName);
            assertTrue(categoryPage.isVisible());
            categoryPage.editCategory();
            assertTrue(addEditCategoryPage.isVisible());
            addEditCategoryPage.clearNameField();
            addEditCategoryPage.setName(newName);
            addEditCategoryPage.saveChanges();
            assertTrue(categoriesPage.isVisible());
            assertTrue(categoriesPage.searchCategory(newName));
            newName = oldName;
            oldName = name;
        }
    }
    @Test(dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void validateRightEditSubCategoryPage(SubCategory subCategory){
        String name = subCategory.getName();
        categoriesPage.openCategory("auto_Category");
        assertTrue(categoryPage.isVisible());
        categoryPage.editSubCategory(name);
        assertTrue(addEditSubCategoryPage.isVisible());
        assertEquals(addEditSubCategoryPage.getName(),name);
//        assertTrue(image.contains(addEditCategoryPage.getImage()));
    }
    @Test(dataProvider = "NTData", dataProviderClass = SubCategoryPageData.class)
    void neditSubCategory(SubCategory subCategory){

    }
    @Test(dataProvider = "PTData", dataProviderClass = SubCategoryPageData.class)
    void deleteSubCategory(SubCategory subCategory){
        String name = subCategory.getName();
        categoriesPage.openCategory("auto_Category");
        assertTrue(categoryPage.isVisible());

    }
}

