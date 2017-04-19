package Pages.JoinUs;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Created by liana on 4/10/17.
 */
public class JoinUsPage {
    @FindBy(how = How.XPATH, using = JoinUsXPath.CREATE_BUTTON)
    public WebElement createButton;
    @FindBy(how = How.XPATH, using = JoinUsXPath.SEARCH_FIELD)
    public WebElement searchField;
    @FindBy(how = How.XPATH, using = JoinUsXPath.SEARCH_BUTTON)
    public WebElement searchButton;
    @FindBy(how = How.XPATH, using = JoinUsXPath.ORG_LIST)
    public List<WebElement> orgList;

    public JoinUsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void createOrganization(){
        createButton.click();
    }
    public void searchOrganization(String name){
        searchField.sendKeys(name);
        searchButton.click();
    }
    public void deleteOrganization(){}
    public boolean isVisible() {
        try {
            return createButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
