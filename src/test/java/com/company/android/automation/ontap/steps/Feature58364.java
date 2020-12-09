package com.company.android.automation.ontap.steps;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

// TODO
public class Feature58364 {
	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature58364(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}
	@And("I have a visit to perform")
	public void iHaveAVisitToPerform(){
		// TODO - Bulk data creates a visit, based on available POCs in Salesforce database
		String pocName = ""; // TODO - Receives created visit POC name
		Hook.scenarioContext.setContext(Context.POC_NAME, pocName);
		checkIn_CheckOutPage.scrollToOpenAccount(pocName);
	}

	@And("I open the visit")
	public void iOpenTheVisit(String s){
		String pocName = Hook.scenarioContext.getContext(Context.POC_NAME).toString();
		checkIn_CheckOutPage.scrollToOpenAccount(pocName);
		checkIn_CheckOutPage.clickOnAccountName(pocName);
	}

	@And("I am oustide of the POC visit allowed check in range")
	public void iAmOustideOfThePOCVisitAllowedCheckInRange(){
	  // TODO get latitude and longitude dynamically
		checkIn_CheckOutPage.setLocationOutOfRange(75.2509766,0.071389, 15.0, 20.0, false);
	}

	@When("I try to perform the check in")
	public void iTryToPerformTheCheckIn(){
		checkIn_CheckOutPage.clickCheckIn();
		checkIn_CheckOutPage.clickCheckIn();
	}

	@Then("The app displays an error message informing that I am out of the allowed distance")
	public void theAppDisplaysAnErrorMessageInformingThatIAmOutOfTheAllowedDistance(){
		throw new PendingException();
	}

	@And("I am able to cancel the check in")
	public void iAmAbleToCancelTheCheckIn(){
		throw new PendingException();
	}

}
