package Pages.Categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by liana on 4/13/17.
 */
public class CategoryPage {
    @FindBy(how = How.XPATH, using = CategoryPageXPath.ADD_SUBCATEGORY)
    public WebElement addSubCategory;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.EDIT_CATEGORY)
    public WebElement editCategory;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.EDIT_SUBCATEGORY)
    public WebElement editSubCategory;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.EDIT_SUBCATEGORY)
    public WebElement deleteSubCategory;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.NAME_FIELD)
    public WebElement nameField;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.IMAGE_FIELD)
    public WebElement imageField;

    //@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/div/div[1]/table/tbody/tr")

}
