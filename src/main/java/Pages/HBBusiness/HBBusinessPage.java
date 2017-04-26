package Pages.HBBusiness;

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
public class HBBusinessPage extends State {
    @FindBy(xpath = HBBusinessPageConst.ADD_BUTTON)
    private WebElement addButton;
    @FindBy(xpath = HBBusinessPageConst.SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(xpath = HBBusinessPageConst.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(xpath = HBBusinessPageConst.ITEMS)
    private List<WebElement> items;
    @FindBy(xpath = HBBusinessPageConst.DELETE_BUTTONS)
    private List<WebElement> deleteButtons;

    public HBBusinessPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public void addHBBusiness(){
        addButton.click();
    }
    public void openHBBusiness(String name){
        for(WebElement item : items){
            if(item.getText().equals(name)){
                item.click();
                break;
            }
        }
    }
    public void deleteHBBusiness(String name){
        for(int i = 0; i < items.size(); ++i) {
            if(items.get(i).getText().contains(name)){
                deleteButtons.get(i).click();
                break;
            }
        }
    }
    public boolean searchHBBusiness(String name){
        searchField.sendKeys(name);
        searchButton.click();
        for(WebElement item : items){
            if(item.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean isVisible(){
        return isElementPresent(addButton);
    }
}
