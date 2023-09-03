package com.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/project/test"},
        plugin = {"summary", "pretty",
               "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
        monochrome = true

)
public class TestRunner {
}
