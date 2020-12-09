package com.company.android.automation.ontap.pages.checkin_checkout;

import org.openqa.selenium.By;

public class CheckIn_CheckOutMapper {
	public static final By CHECK_IN_BUTTON = By.id("com.company.ontap:id/check_in_button");
	public static final By FILTER_BUTTON = By.id("com.company.ontap:id/date_list_bar_filter");
	public static final By BUTTON_CLOSE_POC_INSIGHTS = By.id("com.company.ontap:id/poc_insights_close_button");
	public static final By FRAME_POC_INSIGHTS = By.id("android:id/content");
	public static final By OPEN_VISITS_NUMBER = By.xpath("//android.widget.TextView[@resource-id='com.company.ontap:id/visit_list_visits_number']");
	public static final By POC_OPEN = By.id("account_title_layout");
	public static final By SPINNER_STATUS = By.id("android.widget.Spinner[@resource-id='com.company.ontap:id/spinner_status");
	public static final By WARNING_MESSAGE = By.xpath("//android.widget.TextView[@resource-id='com.company.ontap:id/dialog_message']");
	public static final By EXEPTIONS = By.id("check_in_out_exceptions");
	public static final By EXCEPTION_ALERT = By.id("action_bar_root");
	public static final By MESSEGE_CHECKIN = By.id("snackbar_text");
	public static final By CHECK_OUT_ALERT = By.id("snackbar_action");
	public static final By RESCHEDULE_BUTTON = By.id("com.company.ontap:id/action_reschedule");
	
	public static By buttonCheckIn_Cancel(String buttonName) {
		return By.xpath("//android.widget.Button[@text='"+buttonName+"']");
	}

	public static final By accountName(String name) {
		return By.xpath("(//android.widget.TextView[@text='"+name+"'])[1]");
	}

	public static final By clickButtonModal(String text) {
		return By.xpath("(//android.widget.Button[@text='"+text+"'])");
	}

	public static final By selectTextViewModal(String text) {
		return By.xpath("(//android.widget.TextView[@text='"+text+"'])");
	}

	public static By getModalTextViewPopUp(String text) {
		return By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='"+text+"']");
	}

	public static By getModalCheckedTextView(String text) {
		return By.xpath("//android.widget.FrameLayout//android.widget.CheckedTextView[@text='"+text+"']");
	}
	
	public static By pocInsightsPopUp(String text) {
		return By.xpath("//*[@resource-id='android:id/content']//*[@text='"+text+"']");
	}
	
	public static By getdayOfWeekEnabled(int index) {
		return By.xpath("//android.view.View[@resource-id='android:id/month_view']//android.view.View[@enabled='true']["+index+"]");
	}
}

