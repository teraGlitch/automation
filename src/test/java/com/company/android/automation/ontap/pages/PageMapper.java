package com.company.android.automation.ontap.pages;

import org.openqa.selenium.By;

import com.company.android.automation.ontap.enums.AndroidPermission;

public class PageMapper {
  public static final By SYNC_PROGRESS_BAR = By.id("com.company.ontap:id/progressBarSync");
  public static final By SYNC_TEXT = By.id("com.company.ontap:id/progressBarSyncText");
  public static final By MENU_BUTTON = By.xpath("//android.view.ViewGroup[@resource-id='com.company.ontap:id/toolbar']//android.widget.ImageButton");
  public static final By MODAL_CONTENT = By.xpath("//android.widget.FrameLayout[@resource-id='com.company.ontap:id/contentPanel']//android.widget.TextView");
  public static final By company_LOGO = By.id("com.company.ontap:id/nav_header_company_logo");
  public static final By PERMISSION_TEXT = By.id("android:id/message");
  public static final By PERMISSION_MESSAGE = By.id("com.android.packageinstaller:id/permission_message");
  
  public static By getAndroidButtonPermission(AndroidPermission permission, String buttonLabel) {
    String permissionLabel = "";
    switch (permission) {
      case CONTACTS:
        permissionLabel = "contacts";
        break;
      case CAMERA:
        permissionLabel = "pictures";
        break;
      case FILES:
        permissionLabel = "files";
        break;
      case LOCATION:
        permissionLabel = "location";
        break;
      case PHONE:
        permissionLabel = "phone";
        break;

    }
    return By.xpath("//android.widget.FrameLayout//android.widget.TextView[contains(@text,'"+ permissionLabel +"')]//ancestor::android.widget.ScrollView//android.widget.Button[@text='" + buttonLabel + "']");
  }
  
  public static By getMenuButton(String menuName) {
    return By.xpath("//android.widget.FrameLayout[@resource-id='com.company.ontap:id/navigation_drawer']//android.widget.CheckedTextView[@text='" + menuName + "']");
  }
  
  public static By getModalButton(String buttonLabel) {
    return By.xpath("//android.widget.FrameLayout//android.widget.Button[@text='" + buttonLabel + "']");
  }
  
  public static By getModalTextView(String text) {
	 return By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='"+text+"']");
  }
  
}
