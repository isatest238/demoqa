package Pages;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import ObjectData.PracticeForm_Object;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm_Page extends SubMenu_Common_Page{


    //identificam webelementele specifice pentru Homepage
    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement phoneNumberElement;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyElement;

    //    @FindBy(xpath = "//div[@id='subjectsContainer']")
//    WebElement subjectsElement;
    @FindBy(id = "subjectsInput")
    WebElement subjectsElement;

    @FindBy(id = "submit")
    WebElement submitButton;

    public PracticeForm_Page(WebDriver driver) {
        super(driver);
    }


    public void completeFirstPart(PracticeForm_Object practiceFormObject) {
        elementsMethods.fillElement(firstNameElement,practiceFormObject.getFirstName());
        elementsMethods.fillElement(lastNameElement, practiceFormObject.getLastName());
        elementsMethods.fillElement(userEmailElement, practiceFormObject.getEmail());
        elementsMethods.fillElement(phoneNumberElement, practiceFormObject.getMobileno());
        elementsMethods.fillElement(currentAddress, practiceFormObject.getAddress());
    }

    public void completeGender(PracticeForm_Object practiceFormObject) {
        switch (practiceFormObject.getGender()) {
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

//    public void completeSubjectWithList(List<String> list) {
//        elementsMethods.clickOnElement(subjectsElement);
//        elementsMethods.fillMultipleValues(subjectsElement, list);
//
//    }

    public void completeSubjectWithList(PracticeForm_Object practiceFormObject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillMultipleValues(subjectsElement, practiceFormObject.getSubjects());

   }


    public void completeHobbies(PracticeForm_Object practiceFormObject) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethods.clickMultipleValuesList(hobbiesElement, practiceFormObject.getHobbies());
        javaScriptMethods.scrollMethod(0, 400);

    }

    public void completeStateElement(PracticeForm_Object practiceFormObject) {
        // Fill with value using your helper
        elementsMethods.fillElement(stateElement, practiceFormObject.getState());
        // Press Enter to confirm the selection
        stateElement.sendKeys(Keys.ENTER);
    }

    public void completeCityElement(PracticeForm_Object practiceFormObject) {
        javaScriptMethods.forceClick(cityElement);
        elementsMethods.fillElement(cityElement, practiceFormObject.getCity());
        cityElement.sendKeys(Keys.ENTER);
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(uploadPictureElement);
    }

    public void clickOnButton() {
        elementsMethods.clickOnElement(submitButton);
    }
}
