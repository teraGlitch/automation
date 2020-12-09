package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

// TODO
public class Feature47731 {

	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature47731(){
		
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium); 
		
	}
	
	@Then("The label will change to check in")
	public void theLabelWillChangeToCheckIn(){
		String btDisplayed = checkIn_CheckOutPage.checkModalButtonText("Check In");
		Assert.assertTrue(Boolean.getBoolean(btDisplayed));
	}

}
