package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class Feature54845 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
	// TODO
public Feature54845(){
	
	checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
}

@When("I choose a visit {string} to Reschedule in the next week")
public void iChooseAVisitToRescheduleInTheNextWeek(String visit){
	String pocName = ""; // TODO - Receives created visit POC name
	Hook.scenarioContext.setContext(Context.POC_NAME, pocName);
	checkIn_CheckOutPage.swipeAccount()
	.clickRescheduleVisit();
}

@Then("the app will deny this action")
public void theAppWillDenyThisAction(){
	Assert.assertTrue(checkIn_CheckOutPage.validateDaysNextWeekEnabled(), "App is allowing to reschedule visit to the next Week");
}

}
