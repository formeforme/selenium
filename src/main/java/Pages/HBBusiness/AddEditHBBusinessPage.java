package Pages.HBBusiness;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

/**
 * Created by liana on 4/14/17.
 */
public class AddEditHBBusinessPage {
    @FindBy(how = How.XPATH, using = AddEditHBBusinessPageXPath.NAME_FIELD)
    public WebElement nameField;
    @FindBy(how = How.XPATH, using = AddEditHBBusinessPageXPath.IMAGE_FIELD)
    public WebElement imageField;
    @FindBy(how = How.XPATH, using = AddEditHBBusinessPageXPath.SAVE_BUTTON)
    public WebElement saveButton;

    public AddEditHBBusinessPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void add(HBBusiness hbBusiness){
        setName(hbBusiness.getName());
        setImage(hbBusiness.getImage());
    }
    public void setName(String name){
        nameField.sendKeys(name);
    }
    public void setImage(String image/*List<String> images*/) {
        //for(String image : images){
            File file = new File(System.getProperty("user.dir"), image);
            imageField.click();
            uploadFile(file.getAbsolutePath());
        //}
    }
    public void save(){
        saveButton.click();
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
}
