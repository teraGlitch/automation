package com.company.android.automation.ontap.pages.checkin_checkout;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.Page;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

public class CheckIn_CheckOutPage extends Page {

	private CheckIn_CheckOutHelper helper;

	protected CheckIn_CheckOutPage(AppiumMobileDriver appium) {
		super(appium);
		helper = new CheckIn_CheckOutHelper(appium);
	}

	public CheckIn_CheckOutPage clickOnAccountName(String name) {
		helper.clickOnAccountName(name);
		return this;
	}

	public CheckIn_CheckOutPage clickExceptions() {
		helper.clickModalTextView("Exceptions");
		return this;
	}

	public CheckIn_CheckOutPage selectException(String s) {
		helper.selectExceptionVisitStatus(s);
		return this;
	}

	public int getOpenVisitsNumber() {
		return helper.getOpenVisitsNumber();
	}

	public CheckIn_CheckOutPage clickTheButtonCheck_In (){
		helper.clickTheButtonCheck_In();
		return this;
	}

	public CheckIn_CheckOutPage confirmOrCancel(String confirmOrCancel){
		helper.confirmOrCancel(confirmOrCancel);
		return this;
	}
	
	public CheckIn_CheckOutPage swipeAccount(){
		helper.swipeAccount();
		return this;
	}
	
	public CheckIn_CheckOutPage clickRescheduleVisit() {
		helper.clickRescheduleVisit();
		return this;
	}
	
	public Boolean validateDaysNextWeekEnabled() {
		return helper.validateDaysNextWeekEnabled();
	}

	public CheckIn_CheckOutPage scrollToOpenAccount(String name) {
		Hook.scenarioContext.setContext(Context.OPEN_VISITS, helper.getOpenVisitsNumber()); 
		helper.clickFilterButton();
		helper.clickTextViewModal("Visit State");
		helper.clickTextViewModal("Open");
		helper.clickButtonModal("FILTER");
		helper.scrollToAccount(name);
		return this;
	}
	
	public CheckIn_CheckOutPage scrollToCompletedAccount(String name) {
		helper.clickFilterButton();
		helper.clickTextViewModal("Visit State");
		helper.clickTextViewModal("Completed");
		helper.clickButtonModal("FILTER");
		helper.scrollToAccount(name);
		return this;
	}
	
	public CheckIn_CheckOutPage scrollToAcc(String name) {
		helper.scrollToAccount(name);
		return this;
	}

	public CheckIn_CheckOutPage setLocationOutOfRange(Double latitude, Double longitude, Double size, Double percentage, Boolean flag) {
		helper.setLocationOutOfRange(latitude, longitude, size, percentage, flag);
		return this;
	}

	public CheckIn_CheckOutPage checkIn() {
		helper.clickButtonModal("Check In");
		helper.clickButtonModal("Check In");
		helper.clickButtonModal("Check In");
		helper.clickCloseButton();
		return this;
	}

	public CheckIn_CheckOutPage checkOut() {
		helper.clickButtonModal("Check Out");
		helper.clickButtonModal("Check Out");
		return this;
	}

	public CheckIn_CheckOutPage clickCheckOut() {
		helper.clickButtonModal("Check Out");
		return this;
	}

	public CheckIn_CheckOutPage clickCheckIn() {
		helper.clickButtonModal("Check In");
		return this;
	}

	public Boolean validateVisitPage () {
		return helper.validateVisitPage();
	}

	public String checkModalButtonText(String s) {
		return helper.checkModalButtonText(s);
	}

	public Boolean validadePocInghtsPopUp(String text) {
		return helper.validadePocInghtsPopUp(text);
	}

	public Boolean checkContainsTextWarning(String text) {
		return helper.checkContainsTextWarning(text);
	}

	
	public Boolean checkTextDisplayed(String text) {
		return helper.checkTextDisplayed(text);
	}

	public Boolean validatesIfCheckInWasDone() {
    return helper.validatesIfCheckInWasDone();
  }
	
	public CheckIn_CheckOutPage clickOnExeptions() {
	  helper.clickOnExeptions();
	  return this;
	}
	
	public Boolean checkExceptionAlert() {
    return helper.checkExceptionAlert();
	}
	
	public CheckIn_CheckOutPage tapBackButton() throws Exception {
	  helper.tapBackButton();
	  return this;
	}
	
	public Boolean checkMessageAlertCheckIn() {
	  return helper.checkMessageAlertCheckIn();
	}
	public CheckIn_CheckOutPage clickOnCheckOutAlert() {
	  helper.clickOnCheckOutAlert();
    return this;
  }
}
