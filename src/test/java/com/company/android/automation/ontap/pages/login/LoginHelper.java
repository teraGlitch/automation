package com.company.android.automation.ontap.pages.login;

import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.driver.AppiumMobileDriver;

public class LoginHelper {
  private AppiumMobileDriver appium;
  
  public LoginHelper(AppiumMobileDriver appium) {
    this.appium = appium;
  }
  
  /**
   * Check if the actual page is the salesforce login page
   * 
   * @author mmarqsil
   *
   * @return
   */
  public boolean checkSalesforceLoginPage() {
    return appium.waitElementPresent(LoginMapper.SALESFORCE_LOGO, TimeOut.MAX_SECONDS);
  }
  
  /**
   * Change the salesforce server to sandbox option
   * 
   * @author mmarqsil
   *
   * @return
   * @throws InterruptedException
   */
  public LoginHelper changeServerToSandbox() throws InterruptedException {
    appium.waitElementPresent(LoginMapper.MORE_OPTIONS, TimeOut.EXTRA_LARGE_SECONDS);
    appium.clickOn(LoginMapper.MORE_OPTIONS);
    appium.clickOn(LoginMapper.CHANGE_SERVER);
    appium.clickOn(LoginMapper.SANDBOX_OPTION);
    appium.clickOn(LoginMapper.SERVER_APPLY_BUTTON);
    appium.forcedWait(3000);
    return this;
  }
  
  /**
   * Fill the salesforce authentication form with the parameterized username and password 
   * 
   * @author mmarqsil
   *
   * @param username
   * profile username to login
   * @param password
   * profile password to login
   * @return
   */
  public LoginHelper fillSalesforceCredentials(String username, String password) {
    appium.sendKeys(LoginMapper.USERNAME, username);
    appium.sendKeys(LoginMapper.PASSWORD, password);
    return this;
  }
  
  /**
   * Click on salesforce login button
   * 
   * @author mmarqsil
   *
   * @return
   */
  public LoginHelper clickSalesforceLoginButton() {
    appium.clickOn(LoginMapper.LOGIN_BUTTON);
    return this;
  }
  
  /**
   * Allow the first permission required by salesfoce application
   * 
   * @author mmarqsil
   *
   * @return
   */
  public LoginHelper allowSalesforcePermitions() {
    appium.waitElementPresent(LoginMapper.ALLOW_ACCESS_BUTTON);
    appium.clickOn(LoginMapper.ALLOW_ACCESS_BUTTON);
    return this;
  }
}
