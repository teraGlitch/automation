package com.company.android.automation.ontap.steps;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

//TODO
public class Feature58365 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature58365(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}
	@And("I am within the POC visit allowed check in range")
	public void iAmWithinThePOCVisitAllowedCheckInRange(){
		checkIn_CheckOutPage.setLocationOutOfRange(22.7226346,47.011967, 50.0, 50.0, true);
	}

	@Then("I am able to check in successfully")
	public void iAmAbleToCheckInSuccessfully(){
		throw new PendingException();
	}

}
