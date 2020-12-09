package com.company.android.automation.ontap.pages.checkin_checkout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.company.android.automation.ontap.constants.TimeOut;
import com.company.android.automation.ontap.driver.AppiumMobileDriver;
import com.company.android.automation.ontap.pages.PageMapper;

public class CheckIn_CheckOutHelper {
	private AppiumMobileDriver appium;

	public CheckIn_CheckOutHelper(AppiumMobileDriver appium) {
		this.appium = appium;
	}

	/**
	 * Clicks account name through go by name
	 * 
	 * @author cserenri
	 * @param index - name that will be clicked 
	 *            
	 */
	public CheckIn_CheckOutHelper clickOnAccountName(String name) {
		appium.clickOn(CheckIn_CheckOutMapper.accountName(name));
		return this;
	}

	/**
	 * Dynamic Method to click an text view modal
	 *
	 * @author Caique Seren Ribeiro
	 *
	 * @param label
	 *  text displayed in textView
	 * @return
	 */
	public CheckIn_CheckOutHelper clickModalTextView (String buttonLabel){
		appium.clickOn(PageMapper.getModalTextView(buttonLabel));
		return this;
	}
	
	
	/**
	 * select option exception
	 *
	 * @author Caique Seren Ribeiro
	 *
	 * @param exception
	 *  Visit Status exception
	 * @return
	 */
	public CheckIn_CheckOutHelper selectExceptionVisitStatus (String exception){
		appium.clickOn(CheckIn_CheckOutMapper.SPINNER_STATUS);
		appium.clickOn(CheckIn_CheckOutMapper.getModalCheckedTextView(exception));


		return this;
	}
	
	/**
	 * return quantity of opened visits
	 * 
	 * @author mmarqsil
	 *
	 * @return
	 *   Open Visit Quantity
	 */
	public int getOpenVisitsNumber() {
		int number = Integer.parseInt(appium.getText(CheckIn_CheckOutMapper.OPEN_VISITS_NUMBER));
		return number;
	}

	/**
	 * Scrolls to Account dynamically
	 * 
	 * @author cserenri
	 * @param name - Account that will be selected 
	 *            
	 */
	public CheckIn_CheckOutHelper scrollToAccount(String name) {
		appium.scrollToElementVertically(CheckIn_CheckOutMapper.accountName(name), true);
		return this;
	}

	/**
	 * Swipe left to open the menu on account
	 * @param name
	 * @return
	 * @author Gustavo Borges
	 */
	public CheckIn_CheckOutHelper swipeAccount() {
		appium.swipeElementHorizontally("L");
		return this;
	}
	
	/**
	 * Click on the icon to Reschedule a visit
	 * @return
	 * @author Gustavo Borges
	 */
	public CheckIn_CheckOutHelper clickRescheduleVisit() {
		appium.clickOn(CheckIn_CheckOutMapper.RESCHEDULE_BUTTON);
		return this;
	}
	
	/**
	 * Validate if the days enabled to reschedule the visit is in the current week
	 * @return
	 * @author Gustavo Borges
	 */
	public Boolean validateDaysNextWeekEnabled() {
		Calendar c = Calendar.getInstance(); 
		int curentWeekNumber = c.get(Calendar.WEEK_OF_MONTH);	
		int dayIndex = 1;
		int dayWeekNumber = 0;
		Date dateWeekNumber = null;
		
		while(appium.isElementPresent(CheckIn_CheckOutMapper.getdayOfWeekEnabled(dayIndex))) {
			String dateString = appium.getAttribute(CheckIn_CheckOutMapper.getdayOfWeekEnabled(dayIndex), "content-desc");
			 
			try {
				dateWeekNumber = new SimpleDateFormat("dd MMMM yyyy", Locale.US).parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
			 c.setTime(dateWeekNumber);
			 dayWeekNumber = c.get(Calendar.WEEK_OF_MONTH);
			
			if(curentWeekNumber != dayWeekNumber) {
				return false;
			}
			
			dayIndex++;
		}
		return true;
	}
	
	/**
	 * Method clicks the check in button
	 * @author Gleuter Pereira
	 */
	public CheckIn_CheckOutHelper clickTheButtonCheck_In(){
		appium.clickOn(CheckIn_CheckOutMapper.CHECK_IN_BUTTON);
		return this;
	}

	/**
	 * Click on filter button
	 * 
	 *
	 * @return
	 */
	public CheckIn_CheckOutHelper clickFilterButton() {
		appium.clickOn(CheckIn_CheckOutMapper.FILTER_BUTTON);
		return this;
	}

	/**
	 * Click close button poc insights
	 * 
	 *
	 * @return
	 */
	public CheckIn_CheckOutHelper clickCloseButton() {
	  if(appium.isElementPresent(CheckIn_CheckOutMapper.BUTTON_CLOSE_POC_INSIGHTS))
      appium.clickOn(CheckIn_CheckOutMapper.BUTTON_CLOSE_POC_INSIGHTS);
		return this;
	}

	/**
	 * Method click button dynamically by text
	 * @param name - Button text 
	 * @author cserenri
	 */
	public CheckIn_CheckOutHelper clickButtonModal(String name) {
	  if(appium.isElementPresent(CheckIn_CheckOutMapper.clickButtonModal(name)))
	    appium.clickOn(CheckIn_CheckOutMapper.clickButtonModal(name));
		return this;
	}

	/**
	 * Method click text view dynamically by text
	 * @param text- TextView text 
	 * @author cserenri
	 */
	public CheckIn_CheckOutHelper clickTextViewModal(String text) {
		appium.clickOn(CheckIn_CheckOutMapper.selectTextViewModal(text));
		return this;
	}

	/**
	 * Starts or ends the Check in
	 * @param confirmOrCancel - Check in or Cancel
	 * @author Gleuter Pereira
	 */
	public CheckIn_CheckOutHelper confirmOrCancel(String confirmOrCancel){
		appium.clickOn(CheckIn_CheckOutMapper.buttonCheckIn_Cancel(confirmOrCancel));
		return this;
	}

	/**
	 * set a location out of the range
	 * 
	 * @param latitude
	 *          Latitude value of DC
	 * @param longitude
	 *          Longitude value of DC
	 * @param size
	 *          Range distance of DC
	 * @param percentage
	 *          percentage that will be assigned over size
	 * @param flag
	 *          true to increase or false range to decrease
	 *          
	 * @return this
	 * @author dsilvafe
	 */
	public CheckIn_CheckOutHelper setLocationOutOfRange(Double latitude, Double longitude, Double size, Double percentage, Boolean flag) {
		appium.setDeviceLocation(latitude, longitude, size, percentage, flag);
		return this;
	}

	/**
	 * check if it is on the visit page
	 * 
	 * @author dsilvafe
	 * @return true  if it is inside the page or  false  if is not
	 */
	public Boolean validateVisitPage () {
		return appium.isElementDisplayed(CheckIn_CheckOutMapper.POC_OPEN);
	}

	/**
	 * return the text of a button dynamically
	 * @param text
	 *          button text
	 * @author Caique Seren Ribeiro
	 * @return return the text of a button dynamically
	 */
	public String checkModalButtonText(String text) {
		return appium.getText(CheckIn_CheckOutMapper.clickButtonModal(text));
	}
	
    /**
     * Validates that the Poc Insights window is present
     * @author Gleuter Pereira
     */
    public CheckIn_CheckOutHelper validePocInghts(){
    appium.isElementPresent(CheckIn_CheckOutMapper.FRAME_POC_INSIGHTS);
    return this;
    }
    
	/**
	 * check if the text of POC Insights
	 * @param text
	 * @return return the text of POC Insights
	 * @author Carlos Silva Costa
	 */
	public boolean validadePocInghtsPopUp(String text){
		appium.waitElementPresent(CheckIn_CheckOutMapper.getModalTextViewPopUp(text), TimeOut.MIN_SECONDS);
		return appium.getText(CheckIn_CheckOutMapper.pocInsightsPopUp(text)).contains(text);
	}
	
	
	/**
	 * check if text is being displayed
	 * @param text
	 * @return boolean
	 * @author Caique Seren Ribeiro
	 */
	public boolean checkTextDisplayed(String text){
		return appium.isElementDisplayed(CheckIn_CheckOutMapper.getModalTextViewPopUp(text));	
				
	}

	
	/**
	 * Check If Warning Message contains the text
	 * @param text
	 * @return boolean corresponding if text is displayed or not
	 * @author Caique Seren
	 */
	public boolean checkContainsTextWarning(String text){
		return appium.getText(CheckIn_CheckOutMapper.WARNING_MESSAGE).contains(text);
	}
	
	/**
   * Validates if the check-in button is present on the screen
   * 
   * @author dsilvafe
   * @return true or False
   */
  public Boolean validatesIfCheckInWasDone() {
    return appium.isElementPresent(CheckIn_CheckOutMapper.clickButtonModal("Check In"));
  }
  
  /**
   * Click exceptions
   * 
   * @author Darlan Silva Ferreira
   * @return this
   */
  public CheckIn_CheckOutHelper clickOnExeptions() {
    appium.clickOn(CheckIn_CheckOutMapper.EXEPTIONS);
    return this;
  }
  
  /**
   * Check if a warning about the completed visit appears
   * 
   * @author Darlan Silva Ferreira
   * 
   * @return true or false
   */
  public Boolean checkExceptionAlert() {
    return appium.isElementPresent(CheckIn_CheckOutMapper.EXCEPTION_ALERT);
  }
  
  /**
   * Click back button android
   * 
   * @author Darlan Silva Ferreira
   * 
   * @return this
   * @throws Exception
   */
  public CheckIn_CheckOutHelper tapBackButton() throws Exception {
    appium.tapBackButton();
    return this;
  }
  
  /**
   * Check if a message about the current check-in is displayed
   * 
   * @author Darlan Silva Ferreira
   * 
   * @return true or false
   */
  public Boolean checkMessageAlertCheckIn() {
    return appium.isElementPresent(CheckIn_CheckOutMapper.MESSEGE_CHECKIN);
  }
  
  /**
   * click on Check-Out alert
   * 
   * @author Darlan Silva Ferreira
   * 
   * @return this
   */
  public CheckIn_CheckOutHelper clickOnCheckOutAlert() {
    appium.clickOn(CheckIn_CheckOutMapper.CHECK_OUT_ALERT);
    return this;
  }
}
