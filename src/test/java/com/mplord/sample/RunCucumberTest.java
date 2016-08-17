package com.mplord.sample;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
)
public class RunCucumberTest {
}
