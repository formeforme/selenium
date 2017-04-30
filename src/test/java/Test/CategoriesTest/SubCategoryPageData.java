package Test.CategoriesTest;

import Pages.Categories.Category;
import Pages.Categories.SubCategory;
import org.testng.annotations.DataProvider;

import java.util.LinkedList;

/**
 * Created by liana on 4/30/17.
 */
public class SubCategoryPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new SubCategory() {{
                    setName("auto_SubCategory");
                    setIsShown(false);
                    setImages(new LinkedList<String>(){{
                        add("image/coffee.jpeg");
                        add("image/coffee.jpeg");
                    }}
                    );
                }}}
        };
    }
}
