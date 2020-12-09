package com.company.android.automation.ontap.pages;

import java.util.Arrays;
import java.util.List;

import com.company.android.automation.ontap.constants.MaxTries;
import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.enums.AndroidPermission;
import com.company.android.automation.ontap.steps.shared.ConfigurationTest;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

public class PageHelper {
	private AppiumMobileDriver appium;

	public PageHelper(AppiumMobileDriver appium) {
		this.appium = appium;
	}

	/**
	 * Waits for the Sync progress bar to complete
	 * and retry case an error occurs
	 *
	 * @return
	 * @author mmarqsil
	 */
	public boolean waitInvisibilitySync() {
		appium.waitElementPresent(PageMapper.SYNC_PROGRESS_BAR, TimeOut.MEDIUM_SECONDS);
		boolean invisibility = false;
		int tries = 0;
		do {
			invisibility = appium.invisibilityWait(PageMapper.SYNC_PROGRESS_BAR, TimeOut.EXTRA_LARGE_SECONDS);
			if (appium.isElementPresent(PageMapper.getModalButton("TRY AGAIN"))) {
				appium.clickOn(PageMapper.getModalButton("TRY AGAIN"));
				invisibility = false;
			}
		} while (invisibility == false && tries++ < MaxTries.SYNC_MAX_TRIES);
		return invisibility;
	}

	/**
	 * Check if the Sync progress bar is present on page
	 *
	 * @return
	 * @author mmarqsil
	 */
	public boolean syncProgressBarIsDisplayed() {
		return appium.waitElementPresent(PageMapper.SYNC_PROGRESS_BAR, TimeOut.MAX_SECONDS);
	}

	/**
	 * Get the Sync progress percentage completed
	 *
	 * @return
	 * @author mmarqsil
	 */
	public String getSyncProgressPercentage() {
		return appium.getText(PageMapper.SYNC_TEXT);
	}

	/**
	 * Click on Allow or Deny button
	 * to an Android permission by your permission name
	 * (Dynamic Method)
	 *
	 * @param permission  Permission Type
	 * @param buttonLabel Values: ALLOW or DENY
	 * @return
	 * @author mmarqsil
	 */
	public PageHelper clickAndroidButtonPermission(AndroidPermission permission, String buttonLabel) {
		appium.waitElementPresent(PageMapper.getAndroidButtonPermission(permission, buttonLabel), TimeOut.MEDIUM_SECONDS);
	  appium.clickOn(PageMapper.getAndroidButtonPermission(permission, buttonLabel));
		return this;
	}

	/**
	 * Click on side bar hamburger icon to open the app menu
	 *
	 * @return
	 * @author mmarqsil
	 */

	public PageHelper clickToOpenSideBarMenu() {
		appium.clickOn(PageMapper.MENU_BUTTON);
		return this;
	}

	/**
	 * Click on an Menu Option button in the sidebar app menu
	 *
	 * @param menuName
	 * @return
	 * @author mmarqsil
	 */
	public PageHelper clickOnMenuButton(String menuName) {
		appium.scrollToElementVertically(PageMapper.getMenuButton(menuName), true);
		appium.clickOn(PageMapper.getMenuButton(menuName));
		return this;
	}

	/**
	 * Check if an menu option exists in the sidebar app menu
	 *
	 * @param menuName
	 * @return
	 * @author mmarqsil
	 */
	public boolean checkMenuButtonExists(String menuName) {
		if(!appium.waitElementPresent(PageMapper.getMenuButton(menuName), TimeOut.MIN_SECONDS)) {
			return appium.scrollToElementVertically(PageMapper.getMenuButton(menuName), true);
		}
		return true;
	}


	/**
	 * Grant or removes a access permission
	 * @return
	 * @author Thiago Calado
	 *<BR>Last update by: 
	 *<BR>Update details:
	 * @param permission 
	 * @param allowOrDeny boolean, true to grant/ false to revoke
	 */
	public PageHelper grantOrRevokeAPermission(String permission, boolean allowOrDeny) {
		AndroidPermission permissionLabel = null;

		if (permission.equalsIgnoreCase("CONTACTS"))
			permissionLabel = AndroidPermission.CONTACTS;
		else if(permission.equalsIgnoreCase("CAMERA"))
			permissionLabel = AndroidPermission.CAMERA;
		else if(permission.equalsIgnoreCase("FILES"))
			permissionLabel = AndroidPermission.FILES;
		else if(permission.equalsIgnoreCase("LOCATION"))
			permissionLabel = AndroidPermission.LOCATION;
		else if(permission.equalsIgnoreCase("PHONE"))
			permissionLabel = AndroidPermission.PHONE;

		appium.grantOrRevokeAPermission(permissionLabel, allowOrDeny);
		return this;
	}
	
	/**
	 * Deny a specific permission and allow the others
	 * @param whichPermission - Permission to be denied
	 * @return this
	 * @author Carlos Silva Costa | Gilson Nunes Junior
	 */
	public PageHelper allowOrDenyPermissions(String whichPermission) {
		List<AndroidPermission> permissionListEnum = Arrays.asList(AndroidPermission.values());
		for (AndroidPermission elementPermissionEnum : permissionListEnum) {
			if (whichPermission.equalsIgnoreCase(elementPermissionEnum.toString())) {
				appium.isElementPresent(PageMapper.getAndroidButtonPermission(elementPermissionEnum, "ALLOW"));
				clickAndroidButtonPermission(elementPermissionEnum, "DENY");
			} else {
				clickModalButton("ALLOW");
			}

		}
		return this;
	}
	
	/**
	 *  Click in Allow after denying a permission
	 * @param whichPermission - Permission to be allowed
	 * @return this
	 * @author Carlos Silva Costa
	 * @throws Exception Thrown if the given permission is not present in the permissions set
	 */
	public PageHelper allowDeniedPermission(String whichPermission) throws Exception {
		List<AndroidPermission> permissionListEnum = Arrays.asList(AndroidPermission.values());
		AndroidPermission permission = null;

		for (AndroidPermission elementPermissionEnum : permissionListEnum) {
			if (whichPermission.equalsIgnoreCase(elementPermissionEnum.toString())) {
				permission = elementPermissionEnum;
				appium.isElementPresent(PageMapper.getAndroidButtonPermission(elementPermissionEnum, "ALLOW"));
				clickAndroidButtonPermission(elementPermissionEnum, "ALLOW");
			}
		}

		if(permission == null) {
			throw new Exception(whichPermission + " does not exist in the permission set");
		}

		return this;
	}

	/**
	 * Bring back the application in the background
	 * @param packageName
	 * @return
	 * @author Thiago Calado
	 *<BR>Last update by: 
	 *<BR>Update details:
	 */
	public PageHelper returnToTheApp() {
		appium.bringAppToForeground(ConfigurationTest.GROUP_VARIABLES_AZURE.get("APP_PACKAGE").get("value"));
		return this;
	}

    /**
     * Validate that all permissions have been requested
     * @param parrameter
     * @param label
     * @return
     * @author Gleuter Pereira
     *<BR>Last update by: Thiago Calado
     *<BR>Update details: Action on else removed
     */
    public Boolean validadePermissionPop_Pup(String parrameter, String label) {
      List<AndroidPermission> permissionListEnum = Arrays.asList(AndroidPermission.values());
      boolean flag = false;
      String permissionAPP ="";
      for (AndroidPermission currentPermission : permissionListEnum) {
			 permissionAPP = appium.getText(PageMapper.PERMISSION_MESSAGE);
			if(permissionAPP.toUpperCase().contains("Picture".toUpperCase())) {
				permissionAPP = "CAMERA";
			}
			if(permissionAPP.toUpperCase().contains(parrameter.toUpperCase()) && parrameter.toUpperCase().contains(currentPermission.toString())) {
				clickOnPermissionDynamically(currentPermission.toString().toUpperCase());
				flag=true;
				break;
			}else{
				clickOnPermissionDynamically(currentPermission.toString().toUpperCase());
        	}
        }
        Hook.scenarioContext.setContext(Context.PERMISSION, flag);
        return flag;
    }

	public boolean validateIfPermissionEnable() {
		return (boolean) Hook.scenarioContext.getContext(Context.PERMISSION);
	}

	/**
	 * Enable or Desable the Device Internet Connection
	 *
	 * @author mmarqsil
	 *
	 * @param enable
	 *  true to enable or false to disable
	 * @return
	 */
	public PageHelper toggleDeviceConnection ( boolean enable){
		appium.toggleDeviceConnection(enable);
		return this;
	}

	/**
	 * Enable or Disable the Device GPS Location
	 *
	 * @author mmarqsil
	 *
	 * @param enable
	 *  true to enable or false do disable
	 * @return
	 */
	public PageHelper toggleDeviceLocation ( boolean enable){
		appium.toggleDeviceLocation(enable);
		return this;
	}

	/**
	 * Return the app alert modal text
	 * This can be used to validate the alert messages in assert conditions
	 *
	 * @author mmarqsil
	 *
	 * @return
	 */
	public String getModalContextText () {
		appium.waitElementPresent(PageMapper.MODAL_CONTENT, TimeOut.MIN_SECONDS);
		return appium.getText(PageMapper.MODAL_CONTENT);
	}

	/**
	 * Dynamic Method to click an option displayed in the alert app modal
	 *
	 * @author mmarqsil
	 *
	 * @param buttonLabel
	 *  Button text displayed in the app alert
	 * @return
	 */
	public PageHelper clickModalButton (String buttonLabel){
		appium.clickOn(PageMapper.getModalButton(buttonLabel));
		return this;
	}
	
	/**
	 * Dynamic Method to click an text view modal
	 *
	 * @author Caique Seren Ribeiro
	 *
	 * @param text
	 *  Textview text
	 * @return
	 */
	public PageHelper clickModalTextView(String text) {
		appium.clickOn(PageMapper.getModalTextView(text));
		return this;
	}
	
	/**
	 * Dynamic Method to return if text view modal is displayed
	 *
	 * @author Caique Seren Ribeiro
	 *
	 * @param text
	 *  Textview text
	 * @return boolean
	 */
	public boolean modalTextViewIsDisplayed(String text) {
		
		return appium.isElementDisplayed(PageMapper.getModalTextView(text));
	}

	/**
	 * Dynamic Method to click an option displayed in the alert app modal
	 *
	 * @author mmarqsil
	 *
	 * @param buttonLabel
	 *  Button text displayed in the app alert
	 * @return
	 */
	public PageHelper clickModalButtonIfExists (String buttonLabel){
		if(appium.waitElementPresent(PageMapper.getModalButton(buttonLabel), TimeOut.MIN_SECONDS))
			appium.clickOn(PageMapper.getModalButton(buttonLabel));
		return this;
	}

	/**
	 * Dynamic Method used to validate alert message in assert conditions
	 * 
	 * @param text
	 * 
	 * @author Carlos Silva Costa
	 * @return
	 */
	public boolean getModalContextTextView (String text) {
		appium.waitElementPresent(PageMapper.getModalTextView(text), TimeOut.MIN_SECONDS);
		return appium.getText(PageMapper.PERMISSION_TEXT).contains(text);
	}

	/**
	 * Select according parameter 
	 * @param parameter   case :CONTACTS , FILES,CAMERA,LOCATION,PHONE
	 * @author Gleuter Pereira
	 *
	 */
	public boolean clickOnPermissionDynamically(String parameter){
	  boolean elementPresent = false;
		switch (parameter.toUpperCase()){
			case "CONTACTS":
			  elementPresent = appium.waitElementPresent(PageMapper.getAndroidButtonPermission(AndroidPermission.CONTACTS, "ALLOW"));
				appium.clickOn(PageMapper.getAndroidButtonPermission(AndroidPermission.CONTACTS, "ALLOW"));
				break;
			case "FILES":
			  elementPresent = appium.waitElementPresent(PageMapper.getAndroidButtonPermission(AndroidPermission.FILES, "ALLOW"));
			  appium.clickOn(PageMapper.getAndroidButtonPermission(AndroidPermission.FILES, "ALLOW"));
				break;
			case "CAMERA":
			  elementPresent = appium.waitElementPresent(PageMapper.getAndroidButtonPermission(AndroidPermission.CAMERA, "ALLOW"));
			  appium.clickOn(PageMapper.getAndroidButtonPermission(AndroidPermission.CAMERA, "ALLOW"));
				break;
			case "LOCATION":
			  elementPresent = appium.waitElementPresent(PageMapper.getAndroidButtonPermission(AndroidPermission.LOCATION, "ALLOW"));
			  appium.clickOn(PageMapper.getAndroidButtonPermission(AndroidPermission.LOCATION, "ALLOW"));
				break;
			case "PHONE":
			  elementPresent = appium.waitElementPresent(PageMapper.getAndroidButtonPermission(AndroidPermission.PHONE, "ALLOW"));
			  appium.clickOn(PageMapper.getAndroidButtonPermission(AndroidPermission.PHONE, "ALLOW"));
				break;
			 default: System.out.println("Element"+ parameter  + " not found ");
	}
		return elementPresent;
	}
	 /**
   * Return if the modal alerta is open
   * 
   *
   * @author mmarqsil
   *
   * @return
   */
  public boolean checkModalIsOpen() {
    return appium.waitElementPresent(PageMapper.MODAL_CONTENT, TimeOut.MIN_SECONDS);
  }
	
}
