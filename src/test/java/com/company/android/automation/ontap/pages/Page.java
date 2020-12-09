package com.company.android.automation.ontap.pages;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.enums.AndroidPermission;

public abstract class Page {
	protected AppiumMobileDriver appium;
	private PageHelper pageHelper;

	protected Page(AppiumMobileDriver appium) {
		this.appium = appium;
		this.pageHelper = new PageHelper(appium);
	}

	public boolean waitInvisibilitySync() {
		return pageHelper.waitInvisibilitySync();
	}

	public boolean syncProgressBarIsDisplayed() {
		return pageHelper.syncProgressBarIsDisplayed();
	}

	public String getSyncProgressPercentage() {
		return pageHelper.getSyncProgressPercentage();
	}

	public Page clickAndroidButtonPermission(AndroidPermission permission, String buttonLabel) {
		pageHelper.clickAndroidButtonPermission(permission, buttonLabel);
		return this;
	}

	public Page clickToOpenSideBarMenu() {
		pageHelper.clickToOpenSideBarMenu();
		return this;
	}

	public Page clickOnMenuButton(String menuName) {
		pageHelper.clickOnMenuButton(menuName);
		return this;
	}

	public boolean checkMenuButtonExists(String menuName) {
		return pageHelper.checkMenuButtonExists(menuName);
	}

	public Page grantOrRevokeAPermission(String permission, boolean allowOrDeny) {
		pageHelper.grantOrRevokeAPermission(permission, allowOrDeny);
		return this;
	}

	public Page allowOrDenyPermissions(String whichParam) {
		pageHelper.allowOrDenyPermissions(whichParam);
		return this;
	}

	public Page allowDeniedPermission(String whichPermission) throws Exception {
		pageHelper.allowDeniedPermission(whichPermission);
		return this;
	}

	public Page returnToTheApp() {
		pageHelper.returnToTheApp();
		return this;
	}

	public Boolean validadePermissionPop_Pup(String permission,String label) {
		return pageHelper.validadePermissionPop_Pup(permission,label);
	}

	public boolean  validateIfPermissionEnable() {
		return pageHelper.validateIfPermissionEnable();
	}

	public Page toggleDeviceConnection(boolean enable) {
		pageHelper.toggleDeviceConnection(enable);
		return this;
	}

	public Page toggleDeviceLocation (boolean enable) {
		pageHelper.toggleDeviceLocation(enable);
		return this;
	}

	public String getModalContextText() {
		return pageHelper.getModalContextText();
	}

	public Page clickModalButton(String buttonLabel) {
		pageHelper.clickModalButton(buttonLabel);
		return this;
	}

	public Page clickModalTextView(String text) {
		pageHelper.clickModalTextView(text);
		return this;
	}

	public Page clickModalButtonIfExists(String buttonLabel) {
		pageHelper.clickModalButtonIfExists(buttonLabel);
		return this;
	}

	public boolean validateModalTextView(String text) {
		return pageHelper.getModalContextTextView(text);
	}

	public boolean checkModalIsOpen() {
		return pageHelper.checkModalIsOpen();
	}

	public boolean modalTextViewIsDisplayed(String text) {
		return pageHelper.modalTextViewIsDisplayed(text);
	}

	public boolean clickOnPermissionDynamically(String parameter) {
		return pageHelper.clickOnPermissionDynamically(parameter);
	}

}


