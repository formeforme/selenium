package Pages.Charities;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by liana on 4/23/17.
 */
public class AddCharityPage extends State{
    @FindBy(how = How.XPATH, using = AddCharityPageConst.TITLE)
    private WebElement title;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.NAME)
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.EMAIL)
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.INFO)
    private WebElement infoField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.LOGO)
    private WebElement logoField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.SAVE_BUTTON)
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.IMAGES)
    private WebElement images;

    public AddCharityPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public void addCharity(Organization organization){
        setName(organization.getName());
        setEmail(organization.getEmail());
        setInfo(organization.getInfo());
        setLogo(organization.getLogo());
        save();
    }

    public String getName(){
        return nameField.getAttribute("value");
    }
    public String getEmail(){
        return emailField.getAttribute("value");
    }
    public String getInfo(){
        return infoField.getAttribute("value");
    }
    public String getLogo(){
        return logoField.getAttribute("value");
    }

    public void setName(String name){
        nameField.sendKeys(name);
    }
    public void setEmail(String email){
        emailField.sendKeys(email);
    }
    public void setInfo(String info){
        infoField.sendKeys(info);
    }
    public void setLogo(String image){
        if(image != null) {
            //for(String image : images){
            File file = new File(System.getProperty("user.dir"), image);
            logoField.click();
            uploadFile(file.getAbsolutePath());
        }
    }

    public void clearNameField(){
        nameField.clear();
    }
    public void clearEmailField(){
        emailField.clear();
    }
    public void clearInfoField(){
        infoField.clear();
    }
    //TODO
    public void clearLogo(){}

    public void save(){
        saveButton.click();
    }
    public boolean isVisible() {
        return isElementPresent(nameField);
    }

    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
    private void uploadFile(String fileLocation) {
        try {
            setClipboardData(fileLocation);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    public boolean waitUntilImageLoaded(){
        return isElementPresent(images);
    }

}
