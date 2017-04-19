package Pages.Categories;

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
 * Created by liana on 4/13/17.
 */
public class AddEditSubCategoryPage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[1]/div/div")
    public WebElement imageField;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[2]/div/input")
    public WebElement nameField;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[3]/label[2]/input")
    public WebElement yesRadioButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[3]/label[3]/input")
    public WebElement noRadioButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[3]/button")
    public WebElement saveButton;

    public AddEditSubCategoryPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void fillRequiredFields(SubCategory subCategory){
        fillNameField(subCategory.getName());
        fillImageField(subCategory.getImages());
        chooseType(subCategory.getIsShown());
    }
    private void fillNameField(String name){
        nameField.sendKeys(name);
    }
    private void fillImageField(List<String> images) {
        for(String image : images){
            File file = new File(System.getProperty("user.dir"), image);
            System.out.println(file.getAbsolutePath());
            imageField.click();
            uploadFile(file.getAbsolutePath());
        }
    }
    //TODO
    private void chooseType(boolean isShown){
        if(isShown){
            yesRadioButton.click();
        } else {
            noRadioButton.click();
        }
    }
    public void save(){
        saveButton.click();
    }

    private void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private void uploadFile(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
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
