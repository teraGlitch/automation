package com.company.android.automation.ontap.driver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;

import com.company.android.automation.ontap.enums.AndroidPermission;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public interface AppiumMobileDriver {

    WebElement getElement(By locator);

    void sendKeys(By by, String value);

    void clickOn(By by);

    WebElement simpleWait(By element);

    WebElement simpleWait(By element, int timeout);

    WebElement clickableWait(By element);

    boolean invisibilityWait(By element);

    boolean invisibilityWait(By element, int timeout);

    void selectBy(By element, String type, String value);

    boolean checkText(By element, String expectedText);

    String getText(By element);

    void selectCheckBox(By element);

    boolean isElementPresent(By element);

    boolean isElementDisplayed(By element);

    boolean isElementInPage(By element);

    boolean waitElementPresent(By element);

    boolean waitElementPresent(By element, int timeout);

    Boolean scrollToElementVertically(By element, boolean direction);

    Boolean scrollToElementVertically(By element, boolean direction, int loops);

    void swipeElementHorizontally(String direction);
    
    String getAttribute(By element, String attribute);

    void dobleTap(By element);

    void longTap(By element);

    void hideKeyboard();

    void javascriptClick(By element);

    void changeOrientation();

    String getCurrentContext();

    void changeContext(String context);

    boolean isElementSelected(By element);

    String getXpathFromWebElement(WebElement webElement);

    List<MobileElement> getElements(By element);

    MobileElement findElement(By element);

    void tapBackButton() throws Exception;

    void deleteDriver();

    void airPlaneMode(boolean key);

    void clearAppCache() throws Exception;
    
    void launchApp();

    void grantAllPermissions() throws Exception;

    void executeScript(String script);

    void runAppInBackground(Duration duration);

    String currentActivity();

    void back() throws Exception;

    Dimension getWindowSize();

    AndroidDriver<MobileElement> getDriver();

    void scrollDown() throws Exception;

    void scrollDownToObject(By Element, int tries) throws Exception;

    void scrollDynamic(double start, double end) ;

    void forcedWait(int time) throws InterruptedException;

    void clickOnPageDoesntChanged(By element);

    void androidBackButtonOnPageDoesntChanged(By Element, int timeout) throws Exception;

    Location getLocation();

    void setLocation(Double latitude, Double longitude);

    void getDeviceInformation();
   
    void grantOrRevokeAPermission(AndroidPermission permission, boolean allow);
	
    void bringAppToForeground(String packageName);
    
    void toggleDeviceConnection(boolean enable);
    
    void toggleDeviceLocation(boolean enable);

    void locationMode(boolean key);
	
    void setDeviceLocation(Double latitude, Double longitude, Double size, Double percentage, Boolean flag);

}
