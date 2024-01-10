package com.luma.ui.stepdefinition;


import com.luma.ui.managers.DriverManager;
import com.luma.ui.managers.ExplicitWaitManager;
import com.luma.ui.managers.RandomDataGenerator;
import com.luma.ui.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Field;
import java.util.Map;



public class GenericSteps {

    private static final Logger logger = LogManager.getLogger(GenericSteps.class);

    WebDriver driver = DriverManager.getInstance().getDriver();

    @And("click on the {string} button on the {string}")
    public void clickOnTheSignInButtonOnThe(String elementName, String pageName) {
        WebElement elementToBeClicked = findWebElementFromAPageObjectClass(elementName, pageName);
        DriverManager.waitElement(elementToBeClicked,1);
        ExplicitWaitManager.waitTillTheElementIsClickable(elementToBeClicked);
        ScrollManager.scrollToTheElement(elementToBeClicked);
        elementToBeClicked.click();
        logger.log(Level.INFO, "The element " + elementName + " is clicked");
    }


    @When("populate the following fields on the {string}")
    public void populateTheFollowingFieldsOnTheCustomerLoginPage(String pageName, Map<String, String> fieldAndValuesMap) {
        fieldAndValuesMap.forEach((fieldName, fieldValue) -> {
            fieldValue = fieldValue.toUpperCase().contains("RANDOM") ? RandomDataGenerator.dataSubstitution(fieldValue) : fieldValue;
            WebElement inputElement = findWebElementFromAPageObjectClass(fieldName, pageName);
            ExplicitWaitManager.waitTillElementIsVisible(inputElement);
            inputElement.sendKeys(fieldValue);
            logger.log(Level.INFO, "The field [" + fieldName + "] is populated with [" + fieldValue + " ]");
        });
    }

    private WebElement findWebElementFromAPageObjectClass(String elementName, String pageName) {
        Class classInstance;
        WebElement webElement = null;
        try {
            classInstance = Class.forName("com.luma.ui.pageobject." + pageName);
            Field classField = classInstance.getDeclaredField(elementName);
            classField.setAccessible(true);
            webElement = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }


    @Then("the {string} messages is displayed on the {string}")
    public void theMessagesIsDisplayedOnThe(String elementName, String pageName){
        WebElement element = findWebElementFromAPageObjectClass(elementName, pageName);
        ExplicitWaitManager.waitTillElementIsVisible(element);
        boolean messageIsDisplayed = element.isDisplayed();
        Assertions.assertTrue(messageIsDisplayed, "The message: " + elementName + " is displayed");
        logger.log(Level.INFO, "The element " + elementName + " is displayed");
    }
}

