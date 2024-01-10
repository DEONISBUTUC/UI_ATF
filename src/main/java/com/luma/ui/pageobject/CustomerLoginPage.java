package com.luma.ui.pageobject;


import com.luma.ui.data.LoginData;
import com.luma.ui.managers.RandomDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Page {


    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailCustomerLoginPage;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
    private WebElement passwordCustomerLoginPage;

    @FindBy(xpath = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]")
    private WebElement createAnAccountButtonCustomerLoginPage;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    private WebElement signInButtonLoginPage;

    @FindBy(xpath = "//div[@class='message-error error message']")
    private WebElement error;

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }


    public void loginWithInvalidData(LoginData loginData) {
        if (loginData.getPassword() == null && loginData.getEmail() == null) {
            loginData.setEmail(RandomDataGenerator.getRandomEmail());
            loginData.setPassword(RandomDataGenerator.getRandomPassword());
        }
        emailCustomerLoginPage.sendKeys(loginData.getEmail());
        passwordCustomerLoginPage.sendKeys(loginData.getPassword());

    }


    public void clickOnTheCreateAnAccountButton() {
        createAnAccountButtonCustomerLoginPage.click();
    }

    public void clickOnTheSighInButton() {
        signInButtonLoginPage.click();
    }


}


