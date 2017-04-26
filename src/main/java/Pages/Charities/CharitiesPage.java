package Pages.Charities;

import Pages.HBBusiness.HBBusinessPageConst;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/23/17.
 */
public class CharitiesPage extends State {
    @FindBy(how = How.XPATH, using = CharitiesPageConst.TITLE)
    private WebElement title;
    @FindBy(how = How.XPATH, using = CharitiesPageConst.CREATE_BUTTON)
    private WebElement createButton;
    @FindBy(how = How.XPATH, using = CharitiesPageConst.SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = CharitiesPageConst.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = CharitiesPageConst.ORGANIZATIONS)
    private List<WebElement> organizations;
    @FindBy(how = How.XPATH, using = CharitiesPageConst.DELETE_BUTTONS)
    private List<WebElement> deleteButtons;

    public CharitiesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public String getTitle(){
        return title.getText();
    }
    public void createCharity(){
        createButton.click();
    }
    public void openCharity(String name){
        for(WebElement org : organizations){
            if(org.getText().equals(name)){
                org.click();
                break;
            }
        }
    }
    public void deleteCharity(String name){
        for(int i = 0; i < organizations.size(); ++i) {
            if(organizations.get(i).getText().contains(name)){
                deleteButtons.get(i).click();
                break;
            }
        }
    }
    public boolean searchCharity(String name){
        searchField.sendKeys(name);
        searchButton.click();
        for(WebElement org : organizations){
            if(org.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean isVisible(){
        return isElementPresent(createButton);
    }
}
