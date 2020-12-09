package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertEquals;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature76777 {
	private Account360Page account360;
	
	public Feature76777(){
		account360 = FactoryPage.factory(Account360Page.class, Hook.appium);
	}
	
	@When("I see the Action Icons above the Check In button")
	public void iSeeTheActionIconsAboveTheCheckInButton(){
		account360.clickModalTextView("Account Name");
	}

	@Then("the icons should be order by: POC Insights KPI {int} Timeline Chatter Notes")
	public void theIconsShouldBeOrderByPOCInsightsKPI360TimelineChatterNotes(){
		assertEquals(account360.validateIconsOrders(), "Icons are not in order");
	}

}
