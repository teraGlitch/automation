package com.company.android.automation.ontap.runner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.company.android.automation.ontap.steps.shared.ConfigurationTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@100853",
        plugin = {
                "pretty",
                "json:test-output/cucumber.json",
                "html:test-output",
                "junit:test-output/cucumber.xml"},
        features = "classpath:features",
        monochrome = true,
        glue = "com.company.android.automation.ontap.steps")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    /***
     * Run before running the scenarios
     * set up settings or test data
     */
    @BeforeClass
    public void setInit(){
      ConfigurationTest.setVariablesEnvironmentDefault();
      ConfigurationTest.setConfigurationDefault();
    }

    
    /***
     * Run before running the scenarios
     * Kill drivers if necessary, clean up data ...
     */
    @AfterClass
    public void tearDown(){

    }

}