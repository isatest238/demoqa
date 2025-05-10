package Pages;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTable_Page extends SubMenu_Common_Page {


    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "age")
    WebElement ageField;

    @FindBy(id = "salary")
    WebElement salaryField;

    @FindBy(id = "department")
    WebElement departamentField;

    @FindBy(id = "submit")
    WebElement submitButton;

    public WebTable_Page(WebDriver driver) {
        super(driver);
    }


    public void clickOnAddButton() {
        elementsMethods.clickOnElement(addButton);
    }

    public void fillRegistationForm(String FirstName, String LastName, String Email, String Age, String Salary, String Department) {
        elementsMethods.fillElement(firstName, FirstName);
        elementsMethods.fillElement(lastName, LastName);
        elementsMethods.fillElement(userEmail, Email);
        elementsMethods.fillElement(ageField, Age);
        elementsMethods.fillElement(salaryField, Salary);
        elementsMethods.fillElement(departamentField, Department);
    }
    public void clickOnSubmit() {
        elementsMethods.clickOnElement(submitButton);
    }

}

