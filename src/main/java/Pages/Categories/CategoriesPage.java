package Pages.Categories;

import Pages.State;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by liana on 4/12/17.
 */
public class CategoriesPage extends State {
    @FindBy(how = How.XPATH, using = CategoriesPageConst.CREATE_BUTTON)
    private WebElement createButton;
    @FindBy(how = How.XPATH, using = CategoriesPageConst.SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = CategoriesPageConst.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = CategoriesPageConst.CATEGORIES)
    private List<WebElement> categories;
    @FindBy(how = How.XPATH, using = CategoriesPageConst.DELETE_BUTTONS)
    private List<WebElement> deleteButtons;


    public CategoriesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void createCategory(){
            createButton.click();
    }
    public boolean searchCategory(String name){
        searchField.sendKeys(name);
        searchButton.click();
        for(WebElement category : categories){
            if(category.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public void deleteCategory(String name){
        for(int i = 0; i < categories.size(); ++i){
            if(categories.get(i).getText().contains(name)) {
                deleteButtons.get(i).click();
                break;
            }
        }
    }
    public void openCategory(String name){
        for(WebElement category : categories){
            if(category.getText().equals(name)){
                category.click();
                break;
            }
        }
    }
    public boolean isVisible(){
        return isElementPresent(createButton);
    }
}
