package Pages.Categories;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

/**
 * Created by liana on 4/12/17.
 */
public class AddEditCategoryPage extends State {
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.NAME_FIELD)
    private WebElement categoryNameField;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.IMAGE_FIELD)
    private WebElement categoryImageField;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.ONLINE_SALES_BUTTON)
    private WebElement categoryOnlineSalesButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.FREE_BUTTON)
    private WebElement categoryFreeButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.SAVE_BUTTON)
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.IMAGES)
    private List<WebElement> images;

    private WebDriver webDriver;
    public AddEditCategoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void fillFields(Category category){
        fillNameField(category.getName());
        fillImageField(category.getImage());
        chooseType(category.getType());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        save();
    }
    private void fillNameField(String name){
        categoryNameField.sendKeys(name);
    }
    private void fillImageField(String image) {
            //for(String image : images) {
                File file = new File(System.getProperty("user.dir"), image);
                categoryImageField.click();
                uploadFile(file.getAbsolutePath());
            //}
    }
    private void chooseType(String type) {
        if (type.contains("OnlineSales")) {
            categoryOnlineSalesButton.click();
        } else {
            categoryFreeButton.click();
        }
    }
    public void save(){
        if (isElementPresent(saveButton)){
            saveButton.click();
        }
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

    public boolean isVisible(){
        return isElementPresent(saveButton);
    }
}
