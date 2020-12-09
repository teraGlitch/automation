package com.company.android.automation.ontap.driver;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capcompanylities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.company.android.automation.ontap.constants.MaxTries;
import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.enums.AndroidPermission;
import com.company.android.automation.ontap.exceptions.ActionNotCompletedException;
import com.company.android.automation.ontap.steps.shared.ConfigurationTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumMobileDriverImpl implements AppiumMobileDriver {

    private final static long DEFAULT_TIME_WAIT = ConfigurationTest.DEFAULT_TIME_WAIT;

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private WebDriverWait mutableWait;

    public AppiumMobileDriverImpl(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TimeOut.MEDIUM_SECONDS);
    }

    @Override
    public WebElement getElement(By locator) throws NoSuchElementException {

        WebElement element;
        try {

            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("No elements found with " + locator + " locator");
        } catch (TimeoutException ex) {
            throw new TimeoutException("Time (" + DEFAULT_TIME_WAIT + ") exceeded to find element: " + locator);
        }
        return element;
    }

    public void sendKeys(By by, String value) {

        WebElement element = getElement(by);

        element.clear();
        element.sendKeys(value);
    }

    public void clickOn(By by) {
        WebElement element = getElement(by);
        element.click();
    }

    public WebElement simpleWait(By element) {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return el;
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public WebElement simpleWait(By element, int timeOut) {
        try {
            mutableWait = new WebDriverWait(driver, timeOut);
            WebElement el = mutableWait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return el;
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public WebElement clickableWait(By element) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            return el;
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public boolean invisibilityWait(By element) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            System.out.println("The element : " + element + " has not disappeared");
        }
        return false;
    }


    public boolean invisibilityWait(By element, int timeOut) {
        try {
            mutableWait = new WebDriverWait(driver, timeOut);
            return mutableWait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            System.out.println("The element : " + element + " has not disappeared");
        }
        return false;
    }


    public void selectBy(By element, String type, String value) {
        try {
            WebElement el = clickableWait(element);
            if (el != null) {
                Select menu = new Select(el);
                switch (type.toLowerCase()) {
                    case "text":
                        menu.selectByVisibleText(value);
                        break;
                    case "index":
                        menu.selectByIndex(Integer.parseInt(value));
                        break;
                    case "value":
                        menu.selectByValue(value);
                        break;
                    default:
                        break;
                }
            } else {
                throw new NotFoundException("Element not found: " + element);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public boolean checkText(By element, String expectedText) {
        WebElement el = simpleWait(element);
        if (el != null) {
            String elementText = el.getText();
            if (!StringUtils.equals(elementText, expectedText)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public String getText(By element) {
        try {
            WebElement el = simpleWait(element);
            if (el != null) {
                return el.getText();
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
        return "";
    }

    public void selectCheckBox(By element) {
        try {
            WebElement el = clickableWait(element);
            if (el != null) {
                if (el.isSelected())
                    el.click();
            } else {
                throw new NotFoundException("Element not found: " + element);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public boolean isElementPresent(By element) {
        try {
            return (driver.findElements(element).size() != 0);
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public boolean isElementDisplayed(By element) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element)) != null;
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public boolean isElementInPage(By element) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        if (el != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean waitElementPresent(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitElementPresent(By element, int timeOut) {
        mutableWait = new WebDriverWait(driver, timeOut);
        try {
            mutableWait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("rawtypes")
    public Boolean scrollToElementVertically(By element, boolean direction) {
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth() / 4;
        int startY;
        int endY;
        Boolean elementVisible = false;
        ;
        if (direction) {
            startY = (int) (dim.getHeight() * 0.7);
            endY = (int) (dim.getHeight() * 0.3);
        } else {
            endY = (int) (dim.getHeight() * 0.7);
            startY = (int) (dim.getHeight() * 0.3);
        }
        try {
            for (int i = 0; i < 10; i++) {
                new TouchAction((PerformsTouchActions) driver).press(PointOption.point(width, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(width, endY)).release().perform();
                if (isElementPresent(element)) {
                    elementVisible = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
        return elementVisible;
    }

    @SuppressWarnings("rawtypes")
    public void swipeElementHorizontally(String direction) {
        Dimension dim = driver.manage().window().getSize();
        int startY;
        int startX;
        int endY;
        int endX;
        
        startY = (int) (dim.getHeight() * 0.7);
        endY = (int) (dim.getHeight() * 0.7);
        
        if (direction.equalsIgnoreCase("R")) {
          startX = (int) (dim.getWidth() * 0.5);
          endX = (int) (dim.getWidth() * 0.9);
        }else {
          startX = (int) (dim.getWidth() * 0.9);
          endX = (int) (dim.getWidth() * 0.5);	
        }

        try {
                new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endX, endY)).release().perform();
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }
    
    @SuppressWarnings("rawtypes")
    public Boolean scrollToElementVertically(By element, boolean direction, int loops) {
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth() / 4;
        int startY;
        int endY;
        Boolean elementVisible = false;
        if (direction) {
            startY = (int) (dim.getHeight() * 0.7);
            endY = (int) (dim.getHeight() * 0.4);
        } else {
            endY = (int) (dim.getHeight() * 0.6);
            startY = (int) (dim.getHeight() * 0.4);
        }
        try {
            for (int i = 0; i < loops; i++) {
                if (isElementPresent(element)) {
                    elementVisible = true;
                    break;
                }
                new TouchAction((PerformsTouchActions) driver).press(PointOption.point(width, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(width, endY)).release().perform();
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
        return elementVisible;
    }

    public String getAttribute(By element, String attribute) {
        WebElement el = clickableWait(element);
        try {
            if (el != null) {
                return el.getAttribute(attribute);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
        return "";
    }


    public void dobleTap(By element) {
        WebElement el = clickableWait(element);
        try {
            if (el != null) {
                TouchActions action = new TouchActions(driver);
                action.doubleTap(el);
                action.perform();
            } else {
                throw new NotFoundException("Element not found: " + element);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public void longTap(By element) {
        WebElement el = clickableWait(element);
        try {
            if (el != null) {
                TouchActions action = new TouchActions(driver);
                action.longPress(el);
                action.perform();
            } else {
                throw new NotFoundException("Element not found: " + element);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public void javascriptClick(By element) {
        WebElement el = clickableWait(element);
        try {
            if (el != null) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", el);
            } else {
                throw new NotFoundException("Element not found: " + element);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }

    public void changeOrientation() {
        ScreenOrientation orientation = driver.getOrientation();
        try {
            if (orientation == ScreenOrientation.LANDSCAPE) {
                driver.rotate(ScreenOrientation.PORTRAIT);
            } else {
                driver.rotate(ScreenOrientation.LANDSCAPE);
            }
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public String getCurrentContext() {
        try {
            return driver.getContext();
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public Set<String> getContexts() {
        try {
            return driver.getContextHandles();
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public void changeContext(String context) {
        try {
            driver.context(context);
        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public boolean isElementSelected(By element) {
        WebElement el = simpleWait(element);
        if (el != null) {
            return el.isSelected();
        } else {
            return false;
        }
    }


    public String getXpathFromWebElement(WebElement webElement) {
        String[] xpath = webElement.toString().split(" xpath: ");
        return xpath[1].substring(0, xpath[1].length() - 1);
    }


    public List<MobileElement> getElements(By element) {
        simpleWait(element);
        List<MobileElement> elements = driver.findElements(element);
        return elements;
    }


    @Override
    public MobileElement findElement(By element) {
        return driver.findElement(element);
    }


    public void tapBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


    public void deleteDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver instance deleted");
            driver = null;
        }
    }


    public void airPlaneMode(boolean key) {
        try {

            Map<String, Object> args = new HashMap<>();
            args.put("command", "settings");
            args.put("args", "put global airplane_mode_on " + (key ? 1 : 0));
            driver.executeScript("mobile:shell", args);

        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }


    public void clearAppCache() {


        Map<String, Object> args = new HashMap<>();
        args.put("command", "pm");
        args.put("args", "clear " + ConfigurationTest.GROUP_VARIABLES_AZURE.get("APP_PACKAGE").get("value"));
        driver.executeScript("mobile:shell", args);
        forcedWait(3000);

    }

    @Override
    public void launchApp() {
      int currentTries = 0;
      while(!driver.getCurrentPackage().equals(ConfigurationTest.GROUP_VARIABLES_AZURE.get("APP_PACKAGE").get("value"))
          && currentTries <= MaxTries.START_APP_TRIES) {
        driver.launchApp();
        System.out.println("launch app: " + currentTries);
        forcedWait(5000);
        System.out.println("current package: " + driver.getCurrentPackage());
        currentTries++;
      } 
    }

    public void grantAllPermissions() {
    }


    @Override
    public void executeScript(String script) {
        driver.executeScript(script);
    }


    @Override
    public void runAppInBackground(Duration duration) {
        driver.runAppInBackground(duration);
    }


    @Override
    public String currentActivity() {
        return driver.currentActivity();
    }


    @Override
    public void back() {
        driver.navigate().back();
    }

    @Override
    public Dimension getWindowSize() {
        return driver.manage().window().getSize();
    }


    @Override
    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }


    @SuppressWarnings("rawtypes")
    @Override
	public void scrollDown()  throws Exception {
		Dimension dim = driver.manage().window().getSize();
		Double scrollHeight = dim.getHeight() * 0.5;
		int scrollStart = scrollHeight.intValue();
		Double scrollHeightEnd = dim.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(0, scrollEnd)).release().perform();
	}

    @SuppressWarnings("rawtypes")
    @Override
    public void scrollDownToObject(By element, int tries) {
        int i = 0;
        Dimension dim = driver.manage().window().getSize();
        Double scrollHeight = dim.getHeight() * 0.5;
        int scrollStart = scrollHeight.intValue();
        Double scrollHeightEnd = dim.getHeight() * 0.2;
        int scrollEnd = scrollHeightEnd.intValue();
        TouchAction ta = new TouchAction(driver);
        while (!isElementPresent(element)) {
            ta.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(0, scrollEnd)).release().perform();
            i++;
            if (isElementPresent(element)) {
                break;
            } else if (i == tries) {
                throw new RuntimeException("ERROR - Element not found");
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public void scrollDynamic(double start, double end) {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * start);
        int end_y = (int) (size.height * end);
        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x, end_y))
                .release().perform();
    }


    public void forcedWait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickOnPageDoesntChanged(By element) {
        List<MobileElement> source1, source2;
        do {
            source1 = getElements(By.xpath("//*"));
            clickOn(element);
            source2 = getElements(By.xpath("//*"));
        } while (source1.size() == source2.size());
    }


    public void androidBackButtonOnPageDoesntChanged(By element, int timeOut) {
        List<MobileElement> source1, source2;
        Integer cont = 0;
        do {
            invisibilityWait(element, timeOut);
            source1 = getElements(By.xpath("//*"));
            back();
            invisibilityWait(element, timeOut);
            source2 = getElements(By.xpath("//*"));
            cont++;
            if (cont.equals(5)) {
                break;
            }
        } while (source1.equals(source2));
    }


    public Location getLocation() {
        return driver.location();
    }


    public void setLocation(Double latitude, Double longitude) {
        driver.setLocation(new Location(latitude, longitude, 0));
    }


    public void getDeviceInformation() {
        if ((System.getProperty("executionType") == null)
                || (System.getProperty("executionType") != null && !System.getProperty("executionType").equalsIgnoreCase("Local"))) {
            Capcompanylities capcompanylities = driver.getCapcompanylities();
            String deviceModel = capcompanylities.getCapcompanylity("device.model").toString();
            String deviceName = capcompanylities.getCapcompanylity("device.name").toString();
            System.out.println("Device = " + deviceModel + " (" + deviceName + ")");
        } else {
            System.out.println("Running Locally");
        }
    }
    
    @Override
    public void grantOrRevokeAPermission(AndroidPermission permission, boolean allow) {
      Map<String, Object> args = new HashMap<>();
      String packageName = driver.getCurrentPackage();
      args.put("command", "pm");
      switch (permission) {
      case CONTACTS:
        if(allow == false) {
          args.put("args", "revoke "+packageName+" android.permission.GET_ACCOUNTS");
          driver.executeScript("mobile:shell", args);
        }
        else {
          args.put("args", "grant "+packageName+" android.permission.GET_ACCOUNTS");
          driver.executeScript("mobile:shell", args);
        }

        break;
      case CAMERA:
        if(allow == false) {
          args.put("args", "revoke "+packageName+" android.permission.CAMERA");
          driver.executeScript("mobile:shell", args);
        }
        else {
          args.put("args", "grant "+packageName+" android.permission.CAMERA");
          driver.executeScript("mobile:shell", args);
        }

        break;
      case FILES:
        if(allow == false) {
          args.put("args", "revoke "+packageName+" android.permission.READ_EXTERNAL_STORAGE");
          driver.executeScript("mobile:shell", args);
          args.put("args", "revoke "+packageName+" android.permission.WRITE_EXTERNAL_STORAGE");
          driver.executeScript("mobile:shell", args);
        }
        else {
          args.put("args", "grant "+packageName+" android.permission.READ_EXTERNAL_STORAGE");
          driver.executeScript("mobile:shell", args);
          args.put("args", "grant "+packageName+" android.permission.WRITE_EXTERNAL_STORAGE");
          driver.executeScript("mobile:shell", args);
        }

        break;
      case LOCATION:
        if(allow == false) {
          args.put("args", "revoke "+packageName+" android.permission.ACCESS_FINE_LOCATION");
          driver.executeScript("mobile:shell", args);
          args.put("args", "revoke "+packageName+" android.permission.ACCESS_COARSE_LOCATION");
          driver.executeScript("mobile:shell", args);
        }
        else {
          args.put("args", "grant "+packageName+" android.permission.ACCESS_FINE_LOCATION");
          driver.executeScript("mobile:shell", args);
          args.put("args", "grant "+packageName+" android.permission.ACCESS_COARSE_LOCATION");
          driver.executeScript("mobile:shell", args);
        }
        break;
      case PHONE:
        if(allow == false) {
          args.put("args", "revoke "+packageName+" android.permission.READ_PHONE_STATE");
          driver.executeScript("mobile:shell", args);
        }
        else {
          args.put("args", "grant "+packageName+" android.permission.READ_PHONE_STATE");
          driver.executeScript("mobile:shell", args);
        }
        break;

      }

    }
    
    @Override
    public void bringAppToForeground(String packageName) {
    	driver.activateApp(packageName);
    }

    @Override
    public void toggleDeviceConnection(boolean enable) {
      Map<String, Object> args = new HashMap<>();
      args.put("command", "svc");
      if(enable) {
        args.put("args", "wifi enable");
        driver.executeScript("mobile:shell", args);
        args.put("args", "data enable");
      }
      else {
        args.put("args", "wifi disable");
        driver.executeScript("mobile:shell", args);
        args.put("args", "data disable");
      }
      driver.executeScript("mobile:shell", args);
      forcedWait(5000);
    }

    @Override
    public void toggleDeviceLocation(boolean enable) {
      Map<String, Object> args = new HashMap<>();
      args.put("command", "settings");
      if(enable)
        args.put("args", "put secure location_providers_allowed +gps,-network");
      else
        args.put("args", "put secure location_providers_allowed -gps,-network");
      driver.executeScript("mobile:shell", args);
      forcedWait(5000);
    }
    
    @Override
    public void locationMode(boolean key) {
        try {

            Map<String, Object> args = new HashMap<>();
            args.put("command", "settings");
            args.put("args", "put secure location_providers_allowed" + (key ? " +gps" : " -gps"));
            driver.executeScript("mobile:shell", args);

        } catch (Exception e) {
            throw new ActionNotCompletedException(e.getMessage());
        }
    }
    
    public void setDeviceLocation(Double latitude, Double longitude, Double size, Double percentage, Boolean flag) {
      double rangeInMeters = (double) size + (flag ? + size* (percentage/100) : - size * (percentage/100));
      int bear = 90;
      double brngRad = Math.toRadians(bear);
      double latRad = Math.toRadians(latitude);
      double lonRad = Math.toRadians(longitude);
      int earthRadiusInMeters = 6371000;
      double distFrac = rangeInMeters / earthRadiusInMeters;
      double latitudeResult = Math.asin(Math.sin(latRad) * Math.cos(distFrac) + Math.cos(latRad) * Math.sin(distFrac) * Math.cos(brngRad));
      double a = Math.atan2(Math.sin(brngRad) * Math.sin(distFrac) * Math.cos(latRad),
          Math.cos(distFrac) - Math.sin(latRad) * Math.sin(latitudeResult));
      double longitudeResult = (lonRad + a + 3 * Math.PI) % (2 * Math.PI) - Math.PI;
      setLocationADB(Math.toDegrees(latitudeResult), Math.toDegrees(longitudeResult));
    }
    
    public void setLocationADB(Double latitude, Double longitude) {
      try {
          Map<String, Object> args = new HashMap<>();
          args.put("command", "am");
          args.put("args", "startservice -e latitude "+ latitude +" -e longitude "+ longitude +" io.appium.settings/.LocationService");
          driver.executeScript("mobile:shell", args);
      } catch (Exception e) {
          throw new ActionNotCompletedException(e.getMessage());
      }
  }
}
