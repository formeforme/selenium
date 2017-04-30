package Test.CategoriesTest;

import Pages.Categories.Category;
import Pages.HBBusiness.HBBusiness;
import org.testng.annotations.DataProvider;

/**
 * Created by liana on 4/21/17.
 */
public class CategoriesPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new Category() {{
                    setName("auto_Category");
                    setImage("image/coffee.jpeg");
                    setType("OnlineSales");
                }}}
        };
    }
}
