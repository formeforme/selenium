package Pages.HBBusiness;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by liana on 4/14/17.
 */
public class AddEditHBBusinessPage extends State {
    @FindBy(xpath = AddEditHBBusinessPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(xpath = AddEditHBBusinessPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(xpath = AddEditHBBusinessPageConst.IMAGE)
    private WebElement image;
    @FindBy(xpath = AddEditHBBusinessPageConst.IMAGE_REMOVE_BUTTON)
    private WebElement imageRemoveButton;
    @FindBy(xpath = AddEditHBBusinessPageConst.SAVE_BUTTON)
    private WebElement saveButton;

    public AddEditHBBusinessPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public void addHBBusiness(HBBusiness hbBusiness){
        setName(hbBusiness.getName());
        setImage(hbBusiness.getImage());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveChanges();
    }
    public void setName(String name){
        nameField.sendKeys(name);
    }
    public void setImage(String image) {
        imageField.click();
        if(image != null) {
            File file = new File(System.getProperty("user.dir"), image);
            uploadFile(file.getAbsolutePath());
        }
        isElementPresent(imageRemoveButton);
    }
    public String getName(){
        return nameField.getAttribute("value");
    }
    public String getImage(){
        return image.getAttribute("innerHTML");
    }
    public void clearNameField(){
        nameField.clear();
    }
    public void clearImageField(){
        imageRemoveButton.click();
    }
    public void saveChanges(){
        saveButton.click();
    }
    private void uploadFile(String fileLocation) {
        try {
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
           // setClipboardData(fileLocation);
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
    public boolean isVisible(){
        return isElementPresent(saveButton);
    }
}
