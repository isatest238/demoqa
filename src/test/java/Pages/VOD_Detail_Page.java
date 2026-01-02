package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VOD_Detail_Page {

    private WebDriver driver;
    private WebDriverWait wait;

    // BUTON / ICON add to favourites
    @FindBy(id = "PIN")
    private WebElement addToFavoritesBtn;

//    // STARE activă (adaptezi)
//    @FindBy(css = "[data-testid='add-to-favourites'].active, .fav-toggle.active, [aria-pressed='true']")
//    private WebElement favouritesActiveState;


    public VOD_Detail_Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void openByUrl(String url) {
        driver.get(url);
    }

    public VOD_Detail_Page clickAddToFavoriteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesBtn)).click();
        return this;
    }

    public void clickAddToFavourites() {
        wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesBtn)).click();
    }

}
