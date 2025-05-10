package Pages;

import Helper_Methods.Elements_Methods;
import Helper_Methods.Frames_Methods;
import Helper_Methods.JavaScript_Methods;
import Helper_Methods.Windows_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames_Page extends SubMenu_Common_Page{


    @FindBy(id = "frame1")
    private WebElement firstFrame;

    @FindBy(id = "frame2")
    private WebElement secondFrame;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    public Frames_Page(WebDriver driver) {
        super(driver);
    }

    public void switchToFrameVerifySwitchToMain() throws InterruptedException {
        framesMethods.switchToFrame(firstFrame);
        System.out.println("Textul din primul frame este: " + sampleHeading.getText());
        framesMethods.switchToTheMainePage();
    }

    public void switchToFrameScrollSwitchToMain() throws InterruptedException {
        framesMethods.switchToFrame(secondFrame);
        System.out.println("Textul din primul frame este: " + sampleHeading.getText());
        javaScriptMethods.scrollMethod(200, 200);
        framesMethods.switchToTheMainePage();
    }
}
