package com.luma.ui.pageobject;


import com.luma.ui.data.RegistrationData;
import com.luma.ui.managers.RandomDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerAccountPage extends Page {


    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//div[@class='message-success success message']")
    private WebElement success;

    public CreateNewCustomerAccountPage (WebDriver driver){
        super(driver);
    }



    public void fillInTheRegistrationForm(RegistrationData registrationData) {
        if (registrationData.getFirstName() == null && registrationData.getLastName() == null && registrationData.getEmail() == null && registrationData.getPassword() == null && registrationData.getConfirmPassword() == null) {
            registrationData.setFirstName(RandomDataGenerator.getRandomFirstName());
            registrationData.setLastName(RandomDataGenerator.getRandomLastName());
            registrationData.setEmail(RandomDataGenerator.getRandomEmail());
            registrationData.setPassword(RandomDataGenerator.getRandomPassword());
            registrationData.setConfirmPassword(registrationData.getPassword());
        }
        firstNameField.sendKeys(registrationData.getFirstName());
        lastNameField.sendKeys(registrationData.getLastName());
        emailField.sendKeys(registrationData.getEmail());
        passwordField.sendKeys(registrationData.getPassword());
        confirmPasswordField.sendKeys(registrationData.getPassword());
    }


    public WebElement getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public void clickOnTheContinueButton() {
        createAnAccountButton.click();
    }


}