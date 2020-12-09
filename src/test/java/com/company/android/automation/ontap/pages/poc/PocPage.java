package com.company.android.automation.ontap.pages.poc;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.Page;

public class PocPage extends Page {
	private PocHelper helper;

	public PocPage(AppiumMobileDriver appium) {
		super(appium);
		helper = new PocHelper(appium);
	}

	public PocPage searchAccount(String accountName) {
		helper.searchAccount(accountName);
		return this;
	}

	public boolean findAccountCard(String accountName) {
		return helper.findAccountCard(accountName);
	}
}