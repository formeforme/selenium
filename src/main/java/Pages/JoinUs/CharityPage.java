package Pages.JoinUs;

import Pages.HBBusiness.CategoryPageConst;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/14/17.
 */
public class CharityPage extends State {
    @FindBy(xpath = CharityPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(xpath = CharityPageConst.MAIN_IMAGE_FIELD)
    private WebElement mainImageField;
    @FindBy(xpath = CharityPageConst.SLIDER_IMAGE_FIELD)
    private List<WebElement> sliderImagesField;
    @FindBy(xpath = CharityPageConst.EDIT_BUTTON)
    private WebElement editButton;

    public CharityPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public String getName(){
        return nameField.getText();
    }
    //TODO
    public String getMainImage(){
        return mainImageField.getAttribute("src");
    }
    //TODO
    public String getSliderImages(){
        return nameField.getAttribute("value");
    }
    public void editJoinUs(){
        editButton.click();
    }

    public boolean isVisible() {
        return isElementPresent(editButton);
    }
}
