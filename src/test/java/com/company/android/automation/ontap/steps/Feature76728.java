package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertTrue;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

//TODO
public class Feature76728 {
	private CheckIn_CheckOutPage checkIn;
	
	public Feature76728(){
		checkIn = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}
	@And("I am within the POC allowed check in range")
	public void iAmWithinThePOCAllowedCheckInRange(){
		// TODO get latitude and longitude dynamically
		checkIn.setLocationOutOfRange(22.664296,46.953763, 100.0, 20.0, true);
	}

	@Then("The check in will be done successfully in my Planned Visit activity")
	public void theCheckInWillBeDoneSuccessfullyInMyPlannedVisitActivity(){
		assertTrue(checkIn.validadePocInghtsPopUp("POC Insights"), "Pop-up doesn't on displayed");
	}

}
