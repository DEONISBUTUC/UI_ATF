package com.luma.ui.stepdefinition;


import com.luma.ui.managers.DriverManager;
import com.luma.ui.pageobject.HomePage;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class CreateNewCustomerPageStep {
    private static final Logger logger = LogManager.getLogger(CustomerLoginPageSteps.class);


    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);


    @Given("CreateNewCustomer Page is displayed")
    public void CreateNewCustomerPageIsDisplayed() {
        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickOnTheCreateAnAccountButton();
        logger.log(Level.INFO, "The driver access the Create New Customer Page");

    }


}
