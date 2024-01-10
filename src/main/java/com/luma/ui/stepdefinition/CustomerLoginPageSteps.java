package com.luma.ui.stepdefinition;

import com.luma.ui.managers.DriverManager;
import com.luma.ui.pageobject.HomePage;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class CustomerLoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);
    private static final Logger logger = LogManager.getLogger(CustomerLoginPageSteps.class);


    @Given("CustomerLoginPage is displayed")
    public void customerLoginPageIsDisplayed() {
        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickOnTheSignInButton();
        logger.log(Level.INFO, "The Home Page is Displayed");
    }



    }






