package com.luma.ui;


import com.luma.ui.data.LoginData;
import com.luma.ui.data.RegistrationData;
import com.luma.ui.managers.DriverManager;
import com.luma.ui.managers.ScrollManager;
import com.luma.ui.pageobject.CreateNewCustomerAccountPage;
import com.luma.ui.pageobject.CustomerLoginPage;
import com.luma.ui.pageobject.HomePage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRunnerUsingJUnit {
    WebDriver driver;
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    CreateNewCustomerAccountPage createNewCustomerAccountPage;
    RegistrationData registrationData;
    LoginData loginData;
    private static final Logger logger = LogManager.getLogger(TestRunnerUsingJUnit.class);

    @BeforeAll
    public static void beforeAll() {
        System.out.println("===========The execution is start===========");
    }

    @BeforeEach
    public void beforeEach() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        customerLoginPage = new CustomerLoginPage(driver);
        createNewCustomerAccountPage = new CreateNewCustomerAccountPage(driver);
        loginData = new LoginData();
        registrationData = new RegistrationData();

    }

    @Test
    @DisplayName("Validate that the user is not able to login with invalid data")
    public void loginWithInvalidData() throws InterruptedException {
        homePage.clickOnTheSignInButton();
        customerLoginPage.loginWithInvalidData(loginData);
        customerLoginPage.clickOnTheSighInButton();
        WebElement errorMessageElement = null;
        boolean isDisplayed = false;
        do{
            try{
                errorMessageElement = driver.findElement(By.xpath("//div[@class='message-error error message']"));
                isDisplayed = true;

            }
            catch(Exception e){
                DriverManager.waitElement(errorMessageElement, 1);
            }

        } while (!isDisplayed);
        Assertions.assertTrue(errorMessageElement.isDisplayed(), "The user can login with invalid data");

    }

    @Test
    @DisplayName("Validate that user is able to create an account with valid data")
    public void createNewCustomerWithValidData() throws InterruptedException {
        homePage.clickOnTheCreateAnAccountButton();
        createNewCustomerAccountPage.fillInTheRegistrationForm(registrationData);
        ScrollManager.scrollToTheElement(createNewCustomerAccountPage.getCreateAnAccountButton());
        createNewCustomerAccountPage.clickOnTheContinueButton();
        WebElement successMessageIsDisplayed = driver.findElement(By.xpath("//div[@class='message-success success message']"));
        if (successMessageIsDisplayed.isDisplayed()) {
            boolean isSuccessMessageIsDisplayed = successMessageIsDisplayed.isDisplayed();
            Assertions.assertTrue(isSuccessMessageIsDisplayed, "The success message is not displayed");
        } else {
        DriverManager.waitElement(successMessageIsDisplayed,2);
        }
    }

    @AfterEach
    public void afterEachTcExecution() {

        logger.log(Level.INFO, "===========The TestCase is executed===========");
    }

    @AfterAll
    public static void afterAllExecution() {
        System.out.println("===========The execution is done===========");
        DriverManager.getInstance().tearDown();
    }

}
