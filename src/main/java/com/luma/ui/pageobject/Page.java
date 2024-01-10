package com.luma.ui.pageobject;

import com.luma.ui.managers.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@id='ui-id-3']//span[1]")
    protected WebElement whatsNewButton;

    @FindBy(xpath = "//span[normalize-space()='Women']")
    protected WebElement womenButton;

    @FindBy(xpath = "//span[normalize-space()='Men']")
    protected WebElement menButton;

    @FindBy(xpath = "//span[normalize-space()='Gear']")
    protected WebElement gearButton;

    @FindBy(xpath = "//span[normalize-space()='Training']")
    protected WebElement trainingButton;

    @FindBy(xpath = "//span[normalize-space()='Sale']")
    protected WebElement saleButton;



}




