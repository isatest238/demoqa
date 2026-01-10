package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VOD_Detail_Page {

    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

    // BUTON / ICON add to favourites
    //@FindBy(id = "PIN")
    @FindBy(xpath = "//button[@id='PIN' and .//span[normalize-space()='Merken']]")
    private WebElement addToFavoritesBtn;


    public VOD_Detail_Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void openByUrl(String url) {
        driver.get(url);
    }

    public void clickAddToFavourites() {
        // dacă apare, așteaptă să dispară
        wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesBtn)).click();

    }

    public boolean isFavouriteSelected() {
        wait.until(ExpectedConditions.visibilityOf(addToFavoritesBtn));
        String ariaSelected = addToFavoritesBtn.getAttribute("aria-selected");
        return "true".equalsIgnoreCase(ariaSelected);
    }


}
