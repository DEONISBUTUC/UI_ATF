package com.luma.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "com.luma.ui.stepdefinition",
        tags = "@Run",
        plugin = { "pretty" , "json:target/cucumber-reports/cucumber.json" , "html:target/cucumber-reports/cucumber.html"}
)


public class CucumberTestRunner {
}
