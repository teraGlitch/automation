package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

// TODO
public class Feature58372 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
	public Feature58372(){
		
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
		
	}
	
	@And("The check in button is being displayed")
	public void theCheckInButtonIsBeingDisplayed(){
		String btDisplayed = checkIn_CheckOutPage.checkModalButtonText("Check In");

		Assert.assertTrue(Boolean.getBoolean(btDisplayed));
	}

	@Then("The app will sync the changes")
	public void theAppWillSyncTheChanges(){
		throw new PendingException();
	}

	@And("The visit should not be completed")
	public void theVisitShouldNotBeCompleted(){
		throw new PendingException();
	}

}
