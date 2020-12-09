package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

@Automated
public class Feature100848 {
	private VisitListPage visitPage;

	public Feature100848(){
		visitPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
	}

	@When("I access the add new client screen")
	public void iAccessTheAddNewClientScreen() throws Exception {
		visitPage.openAddClientScreen();
	}

	@Then("The app will list the POCs available to schedule an unplanned visit")
	public void theAppWillListThePOCsAvailableToScheduleAnUnplannedVisit(){
		Assert.assertTrue(visitPage.verifyAddClientScreen(), "The client screen was not found");
		visitPage.validateAddClientScreen();
	}

	@And("The Global Search Bar will be at the top of the screen")
	public void theGlobalSearchBarWillBeAtTheTopOfTheScreen(){
		Assert.assertTrue(visitPage.isSearchBarDisplayed(), "The global search bar is not displayed");
	}
}