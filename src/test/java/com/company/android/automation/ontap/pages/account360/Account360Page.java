package com.company.android.automation.ontap.pages.account360;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.Page;

public class Account360Page extends Page{
	private Account360Helper helper;

	public Account360Page(AppiumMobileDriver appium) {
		super(appium);
		helper = new Account360Helper(appium);
	}

	public int getPOCTotalRevenueValue() {
		return helper.getPOCTotalRevenueValue();
	}

	public boolean validatePOCWhatWeDoText(String text) {
		return helper.validatePOCWhatWeDoText(text);
	}

	public Account360Page clickOnAccountName(String name) {
		helper.clickOnAccountName(name);
		return this;
	}
	public Account360Page clickOnPocInsightsButton() {
		helper.clickOnPocInsightsButton();
		return this;
	}

	public Account360Page validateIconsOrders() {
		helper.validateIconsOrders();
		return this;
	}
	public Boolean checkPOCInsightsPopUpAppeared() {
		return helper.checkPOCInsightsPopUpAppeared();
	}

	public Account360Page accessSubmenuUser_360(String menuOption) throws Exception{
		helper.accessSubmenuUser_360(menuOption);
		return this;
	}

	public Account360Page clickByText_User360(String submenu){
	helper.clickByText_User360(submenu);
		return this;
	}

	public boolean validateFieldPosition (){
		return  helper.validateFieldPosition();
	}
}
