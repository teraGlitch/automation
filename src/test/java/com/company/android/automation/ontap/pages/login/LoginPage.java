package com.company.android.automation.ontap.pages.login;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.Page;

public class LoginPage extends Page{
  private LoginHelper helper;
  
  protected LoginPage(AppiumMobileDriver appium) {
    super(appium);
    helper = new LoginHelper(appium);
  }
  
  public boolean checkSalesforceLoginPage() {
    return helper.checkSalesforceLoginPage();
  }
  
  public LoginPage changeServerToSandbox() throws InterruptedException {
    helper.changeServerToSandbox();
    return this;
  }
  
  public LoginPage fillSalesforceCredencials(String username, String password) {
    helper.fillSalesforceCredentials(username, password);
    return this;
  }
  
  public LoginPage clickSalesforceLoginButton() {
    helper.clickSalesforceLoginButton();
    return this;
  }
  public LoginPage allowSalesforcePermitions() {
    helper.allowSalesforcePermitions();
    return this;
  }
}
