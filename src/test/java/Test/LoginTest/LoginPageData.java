package Test.LoginTest;

import Pages.HBBusiness.HBBusiness;
import Pages.Login.User;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by liana on 4/15/17.
 */
public class LoginPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new User() {{
                    setUsername("admin");
                    setPassword("789456");
                }},}
        };
    }

    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new User()},
                {new User() {{
                    setUsername("admin");
                }},},
                {new User() {{
                    setUsername("another");
                    setPassword("another");
                }},},
                {new User() {{
                    setPassword("789456");
                }},}

        };
    }
   /* public static List<String> parseFile(String file){
        String FilePath = "./data/data.xlx";
        FileInputStream fs = null;
        Workbook wb = null;
        try {
            fs = new FileInputStream(FilePath);
            wb = Workbook.getWorkbook(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheet(0);
        for (int j = 0; j < sheet.getColumns(); j++)
        {
            for (int i = 0; i < sheet.getRows(); i++)
            {
                Cell cell = sheet.getCell(j, i);
                System.out.println(cell.getContents());
            }
        }
        return null;
    }
*/

}
