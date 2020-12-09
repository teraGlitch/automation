package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 
//TODO
public class Feature80916 {

	private Account360Page account350Page;

	public Feature80916(){

		account350Page = FactoryPage.factory(Account360Page.class, Hook.appium);
	}
	@And("I have a POC where the Potential Revenue value is different than zero")
	public void iHaveAPOCWhereThePotentialRevenueValueIsDifferentThanZero(){
		int value = account350Page.getPOCTotalRevenueValue();
		Assert.assertTrue(value != 0);
	}

	@Then("the What can we do phrase will displays the {string}")
	public void theWhatCanWeDoPhraseWillDisplaysThePhrase(String phrase){
		Assert.assertTrue(account350Page.validatePOCWhatWeDoText(phrase));
	}

}
