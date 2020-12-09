package com.company.android.automation.ontap.pages.visit_list;

import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.PageMapper;

public class VisitListHelper {
	private AppiumMobileDriver appium;

	public VisitListHelper(AppiumMobileDriver appium) {
		this.appium = appium;
	}
	
	/**
	 * Check if global search bar is displayed
	 * @return True if global search bar is present
	 * @author Gilson Nunes Junior
	 */
	public boolean isSearchBarDisplayed() {
		return appium.isElementPresent(VisitListMapper.GLOBAL_SEARCH_BAR);
	}

	/**
	 * Open Add Client screen
	 * @return this
	 * @author Gilson Nunes Junior
	 */
	public VisitListHelper openAddClientScreen() {
		appium.clickOn(VisitListMapper.PLUS_ICON);
		return this;
	}

	/**
	 * Check if Add Client screen is displayed
	 * @return True if screen main label is displayed
	 * @author Gilson Nunes Junior
	 */
	public boolean verifyAddClientScreen() {
		return appium.isElementPresent(VisitListMapper.ADD_NEW_CLIENT_LABEL);
	}

	/**
	 * Validate if there are any results in Add Client screen and show how many were found
	 * @return True if any result is displayed
	 * @author Gilson Nunes Junior
	 */
	public boolean validateAddClientScreen() {
		int counter = 0;
		counter = appium.getElements(VisitListMapper.ADD_NEW_CLIENT_BUTTON).size();

		System.out.println("   	> " + counter + " results are being displayed on current view");

		return (counter > 0);
	}
	
	/**
	 * Check if the Date Bar is present on Visit List page (App Main Page)
	 * 
	 * @author mmarqsil
	 *
	 * @return
	 */
	public boolean dateVisitListBarIsPresent() {
		return appium.waitElementPresent(VisitListMapper.DATE_LIST_BAR, TimeOut.MIN_SECONDS);
	}
	
	/**
	 * Click on hamburger
	 * 
	 * @author Caique Seren Ribeiro | Carlos Silva Costa
	 *
	 * @return
	 */
	public VisitListHelper clickOnHamburger() {
		appium.clickOn(PageMapper.MENU_BUTTON);
		return this;
	}
	
	/**
	 * Validate if company logo is displayed
	 * 
	 * @author Caique Seren Ribeiro | Carlos Silva Costa
	 *
	 * @return
	 */
	public boolean validateLogo() {
		return appium.isElementDisplayed(PageMapper.company_LOGO);
	}
	
}
