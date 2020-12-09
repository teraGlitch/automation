package com.company.android.automation.ontap.pages.login;

import org.openqa.selenium.By;

public class LoginMapper {
  public static final By SALESFORCE_LOGO = By.xpath("//android.view.View[@resource-id='logo_wrapper']");
  public static final By MORE_OPTIONS = By.xpath("//android.view.ViewGroup[@resource-id='android:id/action_bar']//android.widget.ImageButton");
  public static final By CHANGE_SERVER = By.xpath("//android.widget.TextView[@text='Change Server']");
  public static final By SANDBOX_OPTION = By.xpath("//android.widget.RadioButton[contains(@text,'Sandbox')]");
  public static final By SERVER_APPLY_BUTTON = By.id("com.company.ontap:id/sf__apply_button");
  public static final By USERNAME = By.xpath("//android.widget.EditText[@resource-id='username']");
  public static final By PASSWORD = By.xpath("//android.widget.EditText[@resource-id='password']");
  public static final By LOGIN_BUTTON = By.xpath("//android.widget.Button[@text='Log In to Sandbox']");
  public static final By ALLOW_ACCESS_BUTTON = By.xpath("//android.widget.Button[@resource-id='oaapprove']");
}
