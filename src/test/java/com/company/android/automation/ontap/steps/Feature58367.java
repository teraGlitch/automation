package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature58367 {
	private CheckIn_CheckOutPage checkIn_CheckOutPage;

public Feature58367(){
	
	checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	
}

@When("I am back to the app main page")
public void iAmBackToTheAppMainPage(){
	String pocName = Hook.scenarioContext.getContext(Context.POC_NAME).toString();
	checkIn_CheckOutPage.scrollToOpenAccount(pocName);
}

@Then("My visit will have a completed layout")
public void myVisitWillHaveACompletedLayout(){
	String pocName = Hook.scenarioContext.getContext(Context.POC_NAME).toString();
	checkIn_CheckOutPage.scrollToCompletedAccount(pocName);
	Assert.assertTrue(checkIn_CheckOutPage.checkTextDisplayed(pocName));
}

}
