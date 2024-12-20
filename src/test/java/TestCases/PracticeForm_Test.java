package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeForm_Test {
    public WebDriver driver;

    @Test
    public void automationMethod1() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();
        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram 'Forms' element si dam click pe el
        WebElement FormElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        FormElement.click();

        // declaram 'Practice Form' element si dam click pe el
        WebElement PracticeFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        PracticeFormElement.click();

        // declaram FirstName field si introducem valoarea
        WebElement FirstNameElement = driver.findElement(By.id("firstName"));
        String FirstNameValue = "Isabela";
        FirstNameElement.sendKeys(FirstNameValue);

        //LastName
        WebElement LastNameElement = driver.findElement(By.id("lastName"));
        String LastNameValue = "Popescu";
        LastNameElement.sendKeys(LastNameValue);

        // EmailAddress
        WebElement EmailAddressElement = driver.findElement(By.id("userEmail"));
        String EmailAddresValue = "isabela.popescu@gmail.com";
        EmailAddressElement.sendKeys(EmailAddresValue);

        //PhoneNumber
        WebElement PhoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String PhoneNumberValue = "0746832902";
        PhoneNumberElement.sendKeys(PhoneNumberValue);

        // Picture - ''Choose File'' button - upload a picture
        WebElement PictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/pic_automation.png");
        PictureElement.sendKeys(file.getAbsolutePath());

        // gender selection
        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Other";
        if (maleElement.getText().equals(genderValue)) {
            maleElement.click();
        } else if (femaleElement.getText().equals(genderValue)) {
            femaleElement.click();
        } else if (otherElement.getText().equals(genderValue)){
            otherElement.click();
        }
        // Subjects input selection
        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        subjectsElement.sendKeys(subjectsValue);
        subjectsElement.sendKeys(Keys.ENTER);

        // state element
        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("window.scrollBy(0,400)");
        js.executeScript("arguments[0].click();", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        // Select City
        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityElement);
        cityElement.sendKeys("Noida");
        cityElement.sendKeys(Keys.ENTER);
    }
}
