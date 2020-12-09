package com.company.android.automation.ontap.pages.account360;

import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.driver.DriverFactory;

import io.appium.java_client.MobileElement;

public class Account360Helper {

	private AppiumMobileDriver appium;

	public Account360Helper(AppiumMobileDriver appium) {
		this.appium = appium;
	}

	/**
	 * Clicks account name through go by name
	 * 
	 * @author Carlos Silva Costa
	 * @param index - name that will be clicked 
	 *            
	 */
	public Account360Helper clickOnAccountName(String name) {
		appium.clickOn(Account360Mapper.accountName(name));
		return this;
	}
	
	/**
	 * Get only numeric value of POC Total Revenue 
	 * @return int value
	 * @author Thiago Calado
	 *<BR>Last update by: 
	 *<BR>Update details:
	 */
	public int getPOCTotalRevenueValue() {
		String fullText = appium.getText(Account360Mapper.POC_TOTAL_REVENUE);
		int value = Integer.parseInt(fullText.replaceAll("//D+", ""));
		
		return value;
	}
	
	/**
	 *  Validate phrase of "What we can do?" field
	 * @param text
	 * @return boolean
	 * @author Thiago Calado
	 *<BR>Last update by: 
	 *<BR>Update details:
	 */
	public boolean validatePOCWhatWeDoText(String text) {
		appium.waitElementPresent(Account360Mapper.WHAT_DO_VALUE, TimeOut.MIN_SECONDS);
		return appium.getText(Account360Mapper.WHAT_DO_VALUE).contains(text);
	}

	/**	
	 * validates the position above the icons
	 * 
	 * @author Carlos Silva Costa | Gustavo Borges Cardoso
	 * @return
	 */
	public boolean validateIconsOrders() {
		String[] icons = {"om.company.ontap:id/poc_insights_button", "com.company.ontap:id/insights_button", "com.company.ontap:id/timeline_button", 
				"com.company.ontap:id/chatter_button", "com.company.ontap:id/notes_button"};
		
		int iconPosition = 1;
		for (int i = 0; i< icons.length; i++) {
			if (!appium.getAttribute(Account360Mapper.getItemByPosition(iconPosition), "resource-id").equals(icons[i])) {
				
				return false;
			}
			
			iconPosition++;
		}
		
		return true;
		
	}
	
	/**
	 * click on poc insights button icon
	 * 
	 * @author Darlan Silva Ferreira
	 */
	public Account360Helper clickOnPocInsightsButton() {
	  appium.clickOn(Account360Mapper.POC_INSIGHTS_BUTTON);
	  return this;
	}
	
	/**
	 * Check POC Insights Pop-Up Appeared
	 * 
	 * @author Darlan Silva Ferreira
	 * @return
	 *     true or false
	 */
	public Boolean checkPOCInsightsPopUpAppeared() {
	  return appium.isElementPresent(Account360Mapper.POP_UP_POC_INSIGHTS);
	}

	/**
	 * Click the button Navigate Up (Tella main left side)
	 * @author Gleuter Pereira Barbosa
	 */
	public Account360Helper clickOnNavigateUp() {
		appium.clickOn(Account360Mapper.NAVIGATE_UP);
		return this;
	}

	/**
	 *Access the submenu tab and click on the option
	 * @param subMenuOption
	 * @author Gleuter Pereira Barbosa
	 */
	  public Account360Helper accessSubmenuUser_360(String subMenuOption) throws Exception{
		  clickOnNavigateUp();
	            if(!appium.isElementPresent(Account360Mapper.user_360_submenu(subMenuOption))){
	           appium.scrollDown();
	            }
	            appium.clickOn(Account360Mapper.user_360_submenu(subMenuOption));
	        return this;
	    }

	/**
	 * Click on the option informed by parameters
	 *
	 * @
	 * @return
	 * @throws Exception
	 * @author Gleuter Pereira Barbosa
	 */
	public Account360Helper clickByText_User360(String submenu) {
			appium.clickOn(Account360Mapper.user_360_Home(submenu));
			return this;
	}
	/**
	 *
	 * Validate field position at the top of the screen
	 *
	 * 
	 * @return
	 * @throws Exception
	 * @author Gleuter Pereira Barbosa
	 */
	public boolean validateFieldPosition (){
		// TODO - Finish validation
		MobileElement inputSearch = (MobileElement) appium.getElement(Account360Mapper.INPUT_SEARCH_EDIT_TEXT);
		int x = inputSearch.getLocation().getX();
		int y = inputSearch.getLocation().getY();
		return false;
	}


}



