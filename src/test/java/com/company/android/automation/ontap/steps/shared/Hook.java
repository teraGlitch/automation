package com.company.android.automation.ontap.steps.shared;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.driver.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
    public static ScenarioContext scenarioContext;
    public static AppiumMobileDriver appium;
    
    @Before
    public void setup() throws Exception{
      appium = DriverFactory.getDriver();
      appium.getDriver().manage().logs().getAvailableLogTypes();
      if (appium.getDriver().isDeviceLocked())
        appium.getDriver().unlockDevice();
      appium.airPlaneMode(false);
      appium.locationMode(true);
      appium.toggleDeviceLocation(true);
      appium.toggleDeviceConnection(true);
      appium.launchApp();
      appium.getDriver().getContextHandles();
      appium.getDriver().context("NATIVE_APP");
      scenarioContext = new ScenarioContext();
    }

    @After
    public void tearDown(Scenario scenario){
      byte[] screenshot = null;
      try {
        if (appium != null && appium.getDriver() != null && scenario.isFailed()) {
          screenshot = ((TakesScreenshot) appium.getDriver()).getScreenshotAs(OutputType.BYTES);
          String testName = scenario.getName();
          scenario.embed(screenshot, "image/png", "error image");
          scenario.write(testName);
        }
        appium.toggleDeviceLocation(true);
        appium.toggleDeviceConnection(true);
        appium.deleteDriver();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

}
