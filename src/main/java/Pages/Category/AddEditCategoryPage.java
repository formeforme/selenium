package Pages.Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/12/17.
 */
public class AddEditCategoryPage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[1]/div/input")
    public WebElement categoryNameField;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[2]/div/div")
    public WebElement categoryImageField;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[3]/div/label[1]/input")
    public WebElement categoryOnlineSalesButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[2]/div[3]/div/label[2]/input")
    public WebElement categoryFreeButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/form/div[2]/div[3]/button")
    public WebElement saveButton;

    public AddEditCategoryPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    public void createCategory(Category category){
        fillNameField(category.getName());
        fillImageField(category.getImages());
        chooseType(category.getType());
        save();
    }
    private void fillNameField(String name){
        categoryNameField.sendKeys(name);
    }
    private void fillImageField(List<String> images) {
        for(String image : images){
            categoryImageField.sendKeys(image);
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
    private void save(){
        saveButton.click();
    }
}
