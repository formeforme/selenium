package Test.CharitiesTest;

import Pages.Charities.Organization;
import Pages.HBBusiness.HBBusiness;
import org.testng.annotations.DataProvider;

/**
 * Created by liana on 4/23/17.
 */
public class CharitiesPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new Organization() {{
                    setName("auto_Charity");
                    setEmail("auto_Charity@c.com");
                    setInfo("general_info");
                    setLogo("image/coffee.jpeg");
                }}}
        };
    }
    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new Organization()},
                {new Organization() {{
                    setName("auto_Charity");
                    setEmail("auto_Charity@c.com");
                    setInfo("general_info");
                }}},
                {new Organization() {{
                    setName("auto_Charity");
                    setEmail("auto_Charity@c.com");
                    setLogo("image/coffee.jpeg");
                }}},
                {new Organization() {{
                    setName("auto_Charity");
                    setInfo("general_info");
                    setLogo("image/coffee.jpeg");
                }}},
                {new Organization() {{
                    setEmail("auto_Charity@c.com");
                    setInfo("general_info");
                    setLogo("image/coffee.jpeg");
                }}}
        };
    }
}
