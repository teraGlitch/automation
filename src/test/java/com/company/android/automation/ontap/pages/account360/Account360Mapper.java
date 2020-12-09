package com.company.android.automation.ontap.pages.account360;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Account360Mapper {
	public static By POC_INSIGHTS_BUTTON = By.id("poc_insights_button");
	public static By POP_UP_POC_INSIGHTS = By.id("toolbar_layout");
	public static final By POC_TOTAL_REVENUE = By.id("com.company.ontap:id/poc_insights_performance_revenue_value");
	public static final By WHAT_DO_VALUE = By.id("com.company.ontap:id/poc_insights_performance_what_do_value");
	public static final By NAVIGATE_UP = MobileBy.AccessibilityId("Navigate up");
	public static final By INPUT_SEARCH_EDIT_TEXT = By.id("com.company.ontap:id/searchEditText");

	public static final By accountName(String name) {
		return By.xpath("(//android.widget.TextView[@text='"+name+"'])[1]");
	}
	
	public static final By getItemByPosition(int pos) {
		return By.xpath("//android.widget.HorizontalScrollView[@resource-id='com.company.ontap:id/horizontal_scroll_view']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout"+pos+"]/android.widget.ImageButton");
	}

	public static final By user_360_submenu(String option ) {
		return By.xpath("//android.widget.CheckedTextView[@text='"+option+"']");
	}

	public static final By user_360_Home(String option ) {
		return By.xpath("//android.widget.TextView[@text='"+option+"']");
	}

}
