package Pages.HomePage;

/**
 * Created by liana on 4/26/17.
 */
public class HomePageConst {
    public static final String MENU_ITEMS = "//ul[@class='nav']/li/a/span[@class='nav-text']";
    public static final String MENU_SUBITEMS = "//li[.//span[text()='App Management']]//ul[@class='nav-sub']/li";
    public static final String LOGOUT_BUTTON = "//a[contains(@href,'logOut')]";
}
