package Pages.HBBusiness;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/14/17.
 */
public class CategoryPage {
    @FindBy(how = How.XPATH, using = CategoryPageXPath.NAME_FIELD)
    public WebElement nameField;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.IMAGE_FIELD)
    public List<WebElement> imageField;
    @FindBy(how = How.XPATH, using = CategoryPageXPath.EDIT_BUTTON)
    public WebElement editButton;

    public CategoryPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public String getName(){
        return nameField.getText();
    }
    public void editHBBusiness(){
        editButton.click();
    }

}