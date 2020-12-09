package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertTrue;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

//TODO
public class Feature76960 {
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
	public Feature76960(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}
	
	@Then("the POC insights will be displayed as a pop-up")
	public void thePOCInsightsWillBeDisplayedAsAPopup(){
		assertTrue(checkIn_CheckOutPage.validadePocInghtsPopUp("POC Insights"), "Pop-up doesn't display");
	}

}
