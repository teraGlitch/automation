package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature47729 {
	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature47729(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}

	@When("I try to perform the check out")
	public void iTryToPerformTheCheckOut(){
		checkIn_CheckOutPage.checkOut();
	}

	@Then("The button color will be changed")
	public void theButtonColorWillBeChanged(){
		String btDisplayed = checkIn_CheckOutPage.checkModalButtonText("Check Out");
		Assert.assertTrue(Boolean.getBoolean(btDisplayed));
	}

}
