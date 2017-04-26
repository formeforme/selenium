package Test.JoinUs;

import Pages.HBBusiness.HBBusiness;
import Pages.JoinUs.JoinUs;
import org.testng.annotations.DataProvider;

/**
 * Created by liana on 4/23/17.
 */
public class JoinUsData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new JoinUs() {{
                    setName("auto_JoinUs");
                    setMainImage("image/coffee.jpeg");
                    setSliderImages("image/coffee.jpeg");
                }}}
        };
    }
    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new JoinUs()},
        };
    }
}
