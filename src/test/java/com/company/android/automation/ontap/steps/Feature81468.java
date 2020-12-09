package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature81468 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
public Feature81468(){
	checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
}
@When("I open the created visit")
public void iOpenTheCreatedVisit(){
	String pocName = Hook.scenarioContext.getContext(Context.POC_NAME).toString();
	checkIn_CheckOutPage.scrollToOpenAccount(pocName);
	checkIn_CheckOutPage.clickOnAccountName(pocName);
}

@Then("I should see the background sync at the top of the screen")
public void iShouldSeeTheBackgroundSyncAtTheTopOfTheScreen(){
		Assert.assertTrue(checkIn_CheckOutPage.syncProgressBarIsDisplayed(), "Background sync message not displayed");
}

}
