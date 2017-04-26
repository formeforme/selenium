package Pages.Categories;

import Pages.State;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by liana on 4/13/17.
 */
public class CategoryPage extends State {
    @FindBy(how = How.XPATH, using = CategoryPageConst.NAME_FIELD)
    public WebElement nameField;
    @FindBy(how = How.XPATH, using = CategoryPageConst.IMAGE_FIELD)
    public WebElement imageField;
    @FindBy(how = How.XPATH, using = CategoryPageConst.EDIT_BUTTON)
    public WebElement editButton;

    public String getName(){
        return nameField.getText();
    }
    public String getImage(){
        return imageField.getAttribute("src");
    }
    public void edit(){
        editButton.click();
    }
    public boolean isVisible() {
        return isElementPresent(editButton);
    }
}
