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

public class Frames_Page {
    WebDriver driver;
    Elements_Methods elementsMethods;
    Frames_Methods framesMethods;
    JavaScript_Methods javaScriptMethods;

    public Frames_Page(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new Elements_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    WebElement firstFrame;

    @FindBy(id = "frame2")
    WebElement secondFrame;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

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
