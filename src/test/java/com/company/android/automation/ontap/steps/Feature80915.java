package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 
//TODO
public class Feature80915 {
	private LoginPage loginPage;
	private Account360Page account360Page;

	public Feature80915(){

		loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
		account360Page = FactoryPage.factory(Account360Page.class, Hook.appium);

	}

	@And("I am at POCs Page")
	public void iAmAtPOCsPage(){
		account360Page.clickToOpenSideBarMenu();
		account360Page.clickOnMenuButton("POCs");
	}

	@And("I have a POC where the Potential Revenue value is equals to zero")
	public void iHaveAPOCWhereThePotentialRevenueValueIsEqualsToZero(){
		// TODO - Bulk data creates a visit, based on available POCs in Salesforce database
		String pocName = ""; // TODO - Receives created visit POC name
		account360Page.clickModalTextView(pocName);
	}

	@When("I open the POC Insights inside the POC")
	public void iOpenThePOCInsightsInsideThePOC(){
		account360Page.clickModalTextView("POC Insights");
	}

	@Then("the What can we do phrase will be {string}")
	public void theWhatCanWeDoPhraseWillBePhrase(String phrase){
		Assert.assertTrue(account360Page.validateModalTextView(phrase));
	}

}
