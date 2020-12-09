package com.company.android.automation.ontap.pages.poc;

import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

public class PocHelper {
	private AppiumMobileDriver appium;

	public PocHelper(AppiumMobileDriver appium) {
		this.appium = appium;
	}

	/**
	 * Search by an account at POC page
	 * @param accountName - Name of the account to be search
	 * @return this
	 * @author Gilson Nunes Junior
	 */
	public PocHelper searchAccount(String accountName) {
		appium.sendKeys(PocMapper.POC_SEARCH_BAR, accountName);
		Hook.scenarioContext.setContext(Context.POC_NAME, accountName);
		return this;
	}

	/**
	 * Validate if account search brought results 
	 * @param text - Account name in POC result card
	 * @return True if a card with given account name is displayed
	 * @author Gilson Nunes Junior
	 */
	public boolean findAccountCard(String text) {
		appium.simpleWait(PocMapper.accountName(text), TimeOut.MIN_SECONDS);
		return appium.isElementPresent(PocMapper.accountName(text));
	}
}