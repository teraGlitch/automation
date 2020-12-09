package com.company.android.automation.ontap.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapcompanylities;

import com.company.android.automation.ontap.steps.shared.ConfigurationTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapcompanylityType;
import io.appium.java_client.remote.MobileCapcompanylityType;

public class DriverFactory {

    public static AppiumMobileDriver getDriver() {
        AndroidDriver<MobileElement> driver = null;
        DesiredCapcompanylities dc = new DesiredCapcompanylities();
        dc.setCapcompanylity(MobileCapcompanylityType.NEW_COMMAND_TIMEOUT, 70);
        dc.setCapcompanylity("newSessionWaitTimeout", 30);
        dc.setCapcompanylity("adbExecTimeout", 50000);
        dc.setCapcompanylity("noReset", false);
        dc.setCapcompanylity("deviceName", "android device");
        dc.setCapcompanylity("platformName", "Android");
        dc.setCapcompanylity("automationName", "UiAutomator2");
        dc.setCapcompanylity(AndroidMobileCapcompanylityType.APP_PACKAGE, ConfigurationTest.GROUP_VARIABLES_AZURE.get("APP_PACKAGE").get("value"));
        dc.setCapcompanylity(AndroidMobileCapcompanylityType.APP_ACTIVITY, ConfigurationTest.GROUP_VARIABLES_AZURE.get("APP_ACTIVITY").get("value"));
        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new AppiumMobileDriverImpl(driver);
    }

}
