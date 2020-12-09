package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.pages.poc.PocPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

@Automated
public class Feature100853 {
	private Account360Page accountPage;
	private PocPage pocPage;

	public Feature100853(){
		accountPage = FactoryPage.factory(Account360Page.class, Hook.appium);
		pocPage = FactoryPage.factory(PocPage.class, Hook.appium);
	}

	@When("I type the name of the POC in the Global Search bar {string}")
	public void iTypeTheNameOfThePOCInTheGlobalSearchBarAccount(String account) throws Exception{
		accountPage.accessSubmenuUser_360("POCs");
		pocPage.searchAccount(account);
	}

	@Then("the app will apply the filter and bring me the results according")
	public void theAppWillApplyTheFilterAndBringMeTheResultsAccording(){
		Assert.assertTrue(pocPage.findAccountCard(Hook.scenarioContext.getContext(Context.POC_NAME).toString()), "Error - The POC card was not been found");
	}
}
