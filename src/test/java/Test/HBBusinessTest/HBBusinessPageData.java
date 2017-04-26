package Test.HBBusinessTest;

import Pages.HBBusiness.HBBusiness;
import org.testng.annotations.DataProvider;


public class HBBusinessPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new HBBusiness() {{
                    setName("auto_HBBusiness");
                    setImage("image/coffee.jpeg");
                }}}
        };
    }
    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new HBBusiness()},
                {new HBBusiness(){{
                    setImage("image/coffee.jpeg");}}},
                {new HBBusiness(){{
                    setName("auto_HBBusiness");
                }}},
                {new HBBusiness(){{
                    setName("auto_HBBusiness");
                }}},
                {new HBBusiness(){{
                    setName("auto_HBBusiness");
                    setImage("image/non_existing_image");
                }}}
        };
    }
}