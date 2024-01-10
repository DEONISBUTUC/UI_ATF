package com.luma.ui.managers;

import io.cucumber.java.sl.In;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;

public class DriverManager {
    public static final Logger logger = LogManager.getLogger(DriverManager.class);

    private static String webDriverType = ConfigPropertiesReaderManager.getPropertyValue("browserType");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        try {
            switch (webDriverType.toUpperCase()) {
                case "CHROME":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("use-fake-ui-for-media-stream");
                    options.addArguments("--disable-web-security");
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-infobars");
                    // options.addArguments("--headless");
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\DButuc\\.ms-ad\\LumaAutomationATF\\LumaAutomationATF\\src\\main\\resources\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver(options);
                    logger.log(Level.INFO, "The Chrome Driver is initiated");
                    break;
                case "FIREFOX":
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.addArguments("--incognito", "--maximized");
                    driver = new FirefoxDriver();
                    logger.log(Level.INFO, "The Firefox Driver was initiated");
                    break;
                case "EDGE":
                    driver = new EdgeDriver();
                    logger.log(Level.INFO, "The Edge Driver was initiated");
                    break;
                case "SAFARI":
                    driver = new SafariDriver();
                    logger.log(Level.INFO, "The Safari Driver is initiated");
                    break;
                default:

            }
        } catch (NoSuchDriverException E) {
            logger.log(Level.INFO, "There is not such browser " + webDriverType + " " + E.getMessage());
        }
        int implicitWaiterValue = parseInt(ConfigPropertiesReaderManager.getPropertyValue("implicitWaiterValue"));
        int implicitPageLoadValue = parseInt(ConfigPropertiesReaderManager.getPropertyValue("pageLoadTimeOut"));


        assert driver != null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaiterValue));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implicitPageLoadValue));


    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        driver.quit();
        instance = null;
        driver = null;
        logger.log(Level.WARN, "The driver is null");
    }

    public static void waitElement(WebElement element, int time) {
        Wait<WebDriver> wait = new WebDriverWait(instance.driver, Duration.ofSeconds(time));
        wait.until(driver -> element.isDisplayed());
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
