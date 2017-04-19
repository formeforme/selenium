package Pages.Login;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by liana on 4/7/17.
 */
public class LoginPage{
    private WebDriver webDriver;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/form/div[2]/div[2]/div[2]/input")
    private WebElement usernameField;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/form/div[2]/div[2]/div[3]/input")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/form/div[2]/div[2]/button")
    public WebElement loginButton;
    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public void clearFields(){
        usernameField.clear();
        passwordField.clear();
    }
    public boolean isVisible(){
        try {
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
