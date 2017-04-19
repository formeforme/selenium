package Test.CharitiesTest;

import Pages.HBBusiness.HBBusiness;
import org.testng.annotations.DataProvider;

/**
 * Created by liana on 4/18/17.
 */
public class CharitiesPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new HBBusiness("auto_HBBusiness","image/coffee.jpeg")},
        };
    }
    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new HBBusiness("","image/coffee.jpeg")},
                {new HBBusiness("auto_HBBusiness","")},
                {new HBBusiness("","")},
                {new HBBusiness("auto_HBBusiness","image/non_existing_image")},
        };
    }
}
