package Pages.Categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/12/17.
 */
public class CategoriesPage {
    @FindBy(how = How.XPATH, using = CategoriesPageXPath.CREATE_BUTTON)
    public WebElement createButton;
    @FindBy(how = How.XPATH, using = CategoriesPageXPath.SEARCH_FIELD)
    public WebElement searchField;
    @FindBy(how = How.XPATH, using = CategoriesPageXPath.SEARCH_BUTTON)
    public WebElement searchButton;
    @FindBy(how = How.XPATH, using = CategoriesPageXPath.CATEGORIES)
    public List<WebElement> categories;

    public CategoriesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void createCategory(){
        createButton.click();
    }
    public void searchCategory(Category category){
        searchField.sendKeys(category.getName());
        searchButton.click();
    }
    public void deleteCategory(){}
}
