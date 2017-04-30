package Pages.ScratchAndWin;

import Pages.BasePage;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class ScratchAndWinPage extends State {
    @FindBy(xpath = ScratchAndWinPageConst.PRICE_FIELD)
    private WebElement priceField;
    @FindBy(xpath = ScratchAndWinPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(xpath = ScratchAndWinPageConst.FINISH_BUTTON)
    private WebElement finishButton;
    @FindBy(xpath = ScratchAndWinPageConst.IMAGES)
    private List<WebElement> images;
    @FindBy(xpath = ScratchAndWinPageConst.REMOVE_BUTTONS)
    private List<WebElement> removeButtons;

    private WebDriver webDriver;

    public ScratchAndWinPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void setScratchAndWin(ScratchAndWin scratchAndWin){
        setPrice(scratchAndWin.getPrice());
        setImages(scratchAndWin.getImages());
    }

    public void setPrice(String price){
        priceField.sendKeys(price);
    }
    public String getPrice(){
        return priceField.getText();
    }
    public void clearPriceField(){
        priceField.clear();
    }
    public void setImages(List<String> images){
        for(String image:images){
            setImage(image);
        }
    }
    public void setImage(String image){
        imageField.click();
        if(image != null) {
            File file = new File(System.getProperty("user.dir"), image);
            uploadFile(file.getAbsolutePath());
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //isElementPresent(imageRemoveButton);
    }
    public List<String> getImages(){
        List<String> lst = new LinkedList<String>();
        for (WebElement image:images){
            lst.add(image.getAttribute("src"));
        }
        return lst;
    }
    public void clearImageField(){
        for (WebElement button:removeButtons){
            button.click();
        }
    }
    public void removeImage(){

    }
    public void finish(){
        finishButton.click();
    }

    private void uploadFile(String fileLocation) {
        try {
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            // setClipboardData(fileLocation);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public boolean isVisible() {
        return isElementPresent(priceField);
    }
}
