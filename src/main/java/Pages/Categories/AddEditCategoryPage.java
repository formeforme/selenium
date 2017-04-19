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
 * Created by liana on 4/12/17.
 */
public class AddEditCategoryPage {
    @FindBy(how = How.XPATH, using = AddEditCategoryPageXPath.NAME_FIELD)
    public WebElement categoryNameField;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageXPath.IMAGE_FIELD)
    public WebElement categoryImageField;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageXPath.ONLINE_SALES_BUTTON)
    public WebElement categoryOnlineSalesButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageXPath.FREE_BUTTON)
    public WebElement categoryFreeButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageXPath.SAVE_BUTTON)
    public WebElement saveButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageXPath.IMAGES)
    public List<WebElement> images;

    public AddEditCategoryPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void fillFields(Category category){
        fillNameField(category.getName());
        fillImageField(category.getImages());
        chooseType(category.getType());
    }
    private void fillNameField(String name){
        categoryNameField.sendKeys(name);
    }
    private void fillImageField(List<String> images) {
        for(String image : images){
            File file = new File(System.getProperty("user.dir"), image);
            System.out.println(file.getAbsolutePath());
            categoryImageField.click();
            uploadFile(file.getAbsolutePath());
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
    //TODO
    private void chooseType(String type){
        if(type.contains("OnlineSales")){
            categoryOnlineSalesButton.click();
        } else {
            categoryFreeButton.click();
        }
    }
    public void save(){
        saveButton.click();
    }
}
