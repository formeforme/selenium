package Test.CategoriesTest;

/**
 * Created by liana on 4/12/17.
 */
public class CategoriesPageTest {
 /*   private WebDriverBase webDriverBase = WebDriverBase.getDriverInstance();
    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoriesPage categoriesPage;
    private AddEditCategoryPage addEditCategoryPage;

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
    }
    @BeforeMethod
    private void beforeMethod(){
        Assert.assertTrue(isElementPresent(homePage.appManagementMenuButton));
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
        String name = "auto_test_category";
        List<String> images = new LinkedList<String>();
        images.add("./image/coffee.jpeg");
        String type = "OnlineSales";
        Category category = new Category();
        category.setName(name);
        category.setImages(images);
        category.setType(type);
        return category;
    }
    @Test(priority = -1)
    private void validateCreateWorks(){
        categoriesPage.createCategory();
        addEditCategoryPage.fillFields(getCategory());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addEditCategoryPage.save();
    }
    @Test
    public void validateSearchWorks(){
        Assert.assertTrue(categoriesPage.searchCategory(getCategory().getName()));
    }
    @Test(priority = 1)
    public void validateDeleteWorks(){
        categoriesPage.deleteCategory(getCategory().getName());
        Assert.assertFalse(categoriesPage.searchCategory(getCategory().getName()));
    }
    @Test
    public void validateOpenWorks(){

    }
    */
}

