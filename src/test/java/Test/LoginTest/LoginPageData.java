package Test.LoginTest;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by liana on 4/15/17.
 */
public class LoginPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {"admin","789456"}
        };
    }
    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {"admin", ""},
                {"another", "another"},
                {"", ""},
                {"", "789456"}
        };
    }
}
