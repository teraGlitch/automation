package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

public class Feature76699 {

	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature76699(){

		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);

	}
	@And("I have a {string} visit to perform")
	public void iHaveAVisitVisitToPerform(String visit){
		// TODO - Bulk data creates a visit, based on available POCs in Salesforce database
		String pocName = ""; // TODO - Receives created visit POC name
		Hook.scenarioContext.setContext(Context.POC_NAME, pocName);
		checkIn_CheckOutPage.scrollToOpenAccount(pocName);
	}

	@Then("The system displays a message about the range allowed for Negotiation visits")
	public void theSystemDisplaysAMessageAboutTheRangeAllowedForNegotiationVisits(){
		Assert.assertTrue(checkIn_CheckOutPage.checkContainsTextWarning("outside the authorized 200.0m range"));
	}

}
