package Pages.BeforeRef;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm_Page_Before_Ref {
    WebDriver driver;
    Elements_Methods elementsMethods;
    JavaScript_Methods javaScriptMethods;


    public PracticeForm_Page_Before_Ref(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new Elements_Methods(driver);
        this.javaScriptMethods = new JavaScript_Methods(driver);
        PageFactory.initElements(driver, this);
    }

    //identificam webelementele specifice pentru Homepage
    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement phoneNumberElement;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobbyElement;

    //    @FindBy(xpath = "//div[@id='subjectsContainer']")
//    WebElement subjectsElement;
    @FindBy(id = "subjectsInput")
    WebElement subjectsElement;

    @FindBy(id = "submit")
    WebElement submitButton;


    public void completeFirstPart(String firstNme, String lastName, String email, String mobileNo, String address) {
        elementsMethods.fillElement(firstNameElement, firstNme);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(userEmailElement, email);
        elementsMethods.fillElement(phoneNumberElement, mobileNo);
        elementsMethods.fillElement(currentAddress, address);
    }

    public void completeGender(String gender) {
        switch (gender) {
            case "Male":
                elementsMethods.clickOnElement(maleGenderElement);
                break;
            case "Female":
                elementsMethods.clickOnElement(femaleGenderElement);
                break;
            case "Other":
                elementsMethods.clickOnElement(otherGenderElement);
                break;
        }
    }

    public void completeSubject(String subject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithActions(subjectsElement, subject);
    }

    public void completeSubjectWithList(List<String> list) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillMultipleValues(subjectsElement, list);

    }

    public void completeHobbies(List<String> hobbies) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethods.clickMultipleValuesList(hobbiesElement, hobbies);

    }

    public void completeStateElement(String value) {
        // Fill with value using your helper
        elementsMethods.fillElement(stateElement, value);
        // Press Enter to confirm the selection
        stateElement.sendKeys(Keys.ENTER);
    }

    public void completeCityElement(String value) {
        javaScriptMethods.forceClick(cityElement);
        elementsMethods.fillElement(cityElement, value);
        cityElement.sendKeys(Keys.ENTER);
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(uploadPictureElement);
    }

    public void clickOnButton() {
        elementsMethods.clickOnElement(submitButton);
    }
}
