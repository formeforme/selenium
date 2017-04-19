package Pages.Categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by liana on 4/13/17.
 */
public class CategoryPage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/div/div[2]/a[1]/button")
    public WebElement addSubCategory;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/div/div[2]/a[2]/button")
    public WebElement editCategory;
    //@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[2]/div[2]/div/div/div[1]/table/tbody/tr")

}
