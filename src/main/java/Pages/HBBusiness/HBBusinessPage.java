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
public class HBBusinessPage {
    @FindBy(how = How.XPATH, using = HBBusinessPageXPath.ADD_BUTTON)
    public WebElement addButton;
    @FindBy(how = How.XPATH, using = HBBusinessPageXPath.SEARCH_FIELD)
    public WebElement searchField;
    @FindBy(how = How.XPATH, using = HBBusinessPageXPath.SEARCH_BUTTON)
    public WebElement searchButton;
    @FindBy(how = How.XPATH, using = HBBusinessPageXPath.ITEMS)
    public List<WebElement> items;
    @FindBy(how = How.XPATH, using = HBBusinessPageXPath.DELETE_BUTTONS)
    public List<WebElement> deleteButtons;

    public HBBusinessPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public void addHBBusiness(){
        addButton.click();
    }
    public void openHBBusiness(/*String name*/HBBusiness hbBusiness){
        String name = hbBusiness.getName();
        for(WebElement item : items){
            if(item.getText().equals(name)){
                item.click();
                break;
            }
        }
    }
    public void deleteHBBusiness(HBBusiness hbBusiness){
        String name = hbBusiness.getName();
        for(int i = 0; i < items.size(); ++i) {
            if(items.get(i).getText().equals(name)){
                deleteButtons.get(i).click();
               // break;
            }
        }
    }
    public boolean searchHBBusiness(HBBusiness hbBusiness){
        String name = hbBusiness.getName();
        searchField.sendKeys(name);
        searchButton.click();
        for(WebElement item : items){
            if(item.getText().contains(name)){
                return true;
            }
        }
        return false;
    }
}
