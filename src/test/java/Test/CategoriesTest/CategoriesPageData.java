package Test.CategoriesTest;

import Pages.Categories.Category;
import Pages.Categories.SubCategory;
import Pages.HBBusiness.HBBusiness;
import Pages.HomePage;
import Pages.Login.LoginPage;
import WebDriverSupport.WebDriverBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by liana on 4/18/17.
 */
public class CategoriesPageData {
    @DataProvider(name = "PTData_category")
    public static Object[][] PTData_category() {
        return new Object[][]{
                {new Category("auto_Category",
                        Arrays.asList("image/coffee.jpeg"),
                        "OnlineSales")}
        };
    }
    @DataProvider(name = "NTData_category")
    public static Object[][] NTData_category() {
        return new Object[][]{
                {new HBBusiness("","image/coffee.jpeg")},
                {new HBBusiness("auto_HBBusiness","")},
                {new HBBusiness("","")},
                {new HBBusiness("auto_HBBusiness","image/non_existing_image")},
        };
    }
    @DataProvider(name = "PTData_subcategory")
    public static Object[][] PTData_subcategory() {
        return new Object[][]{
                {new SubCategory("auto_Category",
                        Arrays.asList("image/coffee.jpeg"),
                        true)}
        };
    }
    @DataProvider(name = "NTData_subcategory")
    public static Object[][] NTData_subcategory() {
        return new Object[][]{
                {new HBBusiness("","image/coffee.jpeg")},
                {new HBBusiness("auto_HBBusiness","")},
                {new HBBusiness("","")},
                {new HBBusiness("auto_HBBusiness","image/non_existing_image")},
        };
    }
}
