package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

@Automated
public class Feature76732 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
public Feature76732(){
	checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
}

@Then("The system displays a message about the range allowed for Planned Visit visits")
public void theSystemDisplaysAMessageAboutTheRangeAllowedForPlannedVisitVisits(){
	Assert.assertTrue(checkIn_CheckOutPage.checkContainsTextWarning("outside the authorized"));
}

}
