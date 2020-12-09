package com.company.android.automation.ontap.pages.visit_list;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.Page;

public class VisitListPage extends Page {
	private VisitListHelper helper;

	protected VisitListPage(AppiumMobileDriver appium) {
		super(appium);
		helper = new VisitListHelper(appium);
	}

	public boolean isSearchBarDisplayed() {
		return helper.isSearchBarDisplayed();
	}

	public VisitListPage openAddClientScreen() {
		helper.openAddClientScreen();
		return this;
	}

	public boolean verifyAddClientScreen() {
		return helper.verifyAddClientScreen();
	}

	public boolean validateAddClientScreen() {
		return helper.validateAddClientScreen();
	}

	public boolean dateVisitListBarIsPresent() {
		return helper.dateVisitListBarIsPresent();
	}

	public Page clickOnHamburger() {
		helper.clickOnHamburger();
		return this;
	}

	public boolean validateLogo() {
		return helper.validateLogo();
	}

}
