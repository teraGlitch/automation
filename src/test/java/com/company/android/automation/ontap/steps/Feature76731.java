package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertTrue;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

//TODO
public class Feature76731 {
	private CheckIn_CheckOutPage checkIn;

	public Feature76731(){
		checkIn = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);

	}
	@Then("I am able to check in Negotiation type visits")
	public void iAmAbleToCheckInNegotiationTypeVisits(){
		assertTrue(checkIn.validadePocInghtsPopUp("POC Insights"), "Pop-up doesn't on displayed");
	}

}
