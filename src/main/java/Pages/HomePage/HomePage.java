package Pages.HomePage;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/9/17.
 */
public class HomePage extends State {
    @FindBy(xpath = HomePageConst.MENU_ITEMS)
    private List<WebElement> menuItems;
    @FindBy(xpath = HomePageConst.MENU_SUBITEMS)
    private List<WebElement> menuSubItems;
    @FindBy(xpath = HomePageConst.LOGOUT_BUTTON)
    private WebElement logoutButton;

    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/nav/ul/li[1]/a/span[2]")
    public WebElement homeMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[2]/a/span[3]")
    public WebElement merchantsMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[3]/a/span[3]")
    public WebElement usersMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[4]/a/span[2]")
    public WebElement organizationsMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[5]/a")
    public WebElement appManagementMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[5]/ul/li")
    public List<WebElement> appManagementSubButtons;

    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    private void openDropdown(String menuItem){
        for(WebElement webElement : menuItems){
            if(webElement.getText().equals(menuItem)){
                webElement.click();
                break;
            }
        }
    }
    private void chooseElement(String menuSubItem){
        for(WebElement webElement : menuSubItems){
            if(webElement.getText().equals(menuSubItem)){
                webElement.click();
                break;
            }
        }
    }
    public void openPage(String menuItem,String menuSubItem){
        openDropdown(menuItem);
        areElementsPresent(menuSubItems);
        chooseElement(menuSubItem);
    }
    public void logout(){
        logoutButton.click();
    }

    public boolean isVisible() {
        return isElementPresent(logoutButton);
    }

   /* private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div/div[1]/div/div[3]/div/span/a")
    public WebElement logoutButton;
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/nav/ul/li[1]/a/span[2]")
    public WebElement homeMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[2]/a/span[3]")
    public WebElement merchantsMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[3]/a/span[3]")
    public WebElement usersMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[4]/a/span[2]")
    public WebElement organizationsMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[5]/a")
    public WebElement appManagementMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[5]/ul/li")
    public List<WebElement> appManagementSubButtons;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void logout(){
        logoutButton.click();
    }

    public boolean isVisible(){
        try {
            return logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    */
}
