package com.luma.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/featuresapi",
        glue = "com.luma.api",
        tags = "@Run",
        plugin = {"pretty", "json:target/cucumber-reports-api/cucumber.json", "html:target/target/cucumber-reports-api/cucumber.html"}
)


public class CucumberApiTestRunner {
}


