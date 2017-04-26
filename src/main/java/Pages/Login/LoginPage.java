package Pages.Login;

import Pages.State;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by liana on 4/7/17.
 */
public class LoginPage extends State {
    @FindBy(xpath = LoginPageConst.USERNAME_FIELD)
    private WebElement usernameField;
    @FindBy(xpath = LoginPageConst.PASSWORD_FIELD)
    private WebElement passwordField;
    @FindBy(xpath = LoginPageConst.LOGIN_BUTTON)
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
    public void login(String username, String password){
        clearUsernameField();
        clearPasswordField();
        setUsername(username);
        setPassword(password);
        pressloginButton();
    }
    public void login(User user){
        clearUsernameField();
        clearPasswordField();
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        pressloginButton();
    }

    public void setUsername(String username){
        usernameField.sendKeys(username);
    }
    public void setPassword(String password){
        passwordField.sendKeys(password);
    }
    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }
    public void clearUsernameField(){
        usernameField.clear();
    }
    public void clearPasswordField(){
        passwordField.clear();
    }
    public void pressloginButton(){
        loginButton.click();
    }

    public boolean isVisible(){
        return isElementPresent(loginButton);
    }
}
