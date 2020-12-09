package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature145438 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
public Feature145438(){
	
	checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	
}
@When("I click on check in")
public void iClickOnCheckIn(){
	checkIn_CheckOutPage.checkIn();
	checkIn_CheckOutPage.checkIn();
}

@And("The background sync is displayed")
public void theBackgroundSyncIsDisplayed(){
	Assert.assertTrue(checkIn_CheckOutPage.syncProgressBarIsDisplayed());
}

@Then("I should be able to check out without being blocked by background sync")
public void iShouldBeAbleToCheckOutWithoutBeingBlockedByBackgroundSync(){
	checkIn_CheckOutPage.syncProgressBarIsDisplayed();
	checkIn_CheckOutPage.checkOut();
	Assert.assertTrue(checkIn_CheckOutPage.checkTextDisplayed("Completed Visits"));
	
}

}
