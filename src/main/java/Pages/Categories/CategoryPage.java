package Pages.Categories;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/13/17.
 */
public class CategoryPage extends State {
    @FindBy(how = How.XPATH, using = CategoryPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = CategoryPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(how = How.XPATH, using = CategoryPageConst.EDIT_BUTTON)
    private WebElement editButton;
    @FindBy(how = How.XPATH, using = CategoryPageConst.SUBCATEGORIES)
    private List<WebElement> subCategories;
    @FindBy(how = How.XPATH, using = CategoryPageConst.CREATE_SUBCATEGORY_BUTTON)
    private WebElement createSubCategoryButton;
    @FindBy(how = How.XPATH, using = CategoryPageConst.EDIT_SUBCATEGORY_BUTTON)
    private List<WebElement> editSubCategoryButton;
    @FindBy(how = How.XPATH, using = CategoryPageConst.DELETE_SUBCATEGORY_BUTTON)
    private List<WebElement> deleteSubCategoryButton;


    public CategoryPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public String getName(){
        return nameField.getText();
    }
    public String getImage(){
        return imageField.getAttribute("src");
    }
    public void editCategory(){
        editButton.click();
    }

    public void createSubCategory(){
        createSubCategoryButton.click();
    }
    public void editSubCategory(String name){
        for(int i = 0; i < subCategories.size(); ++i) {
            if(subCategories.get(i).getText().contains(name)){
                editSubCategoryButton.get(i).click();
                break;
            }
        }
    }
    public void deleteSubCategory(String name){
        for(int i = 0; i < subCategories.size(); ++i) {
            if(subCategories.get(i).getText().contains(name)){
                deleteSubCategoryButton.get(i).click();
                break;
            }
        }
    }

    public boolean isVisible() {
        return isElementPresent(editButton);
    }
}
