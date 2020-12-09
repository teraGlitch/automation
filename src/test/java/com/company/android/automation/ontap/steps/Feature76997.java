package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Context;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

//TODO
public class Feature76997 {

	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
	public Feature76997(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}

	@Then("I am able to check out this visit")
	public void iAmAbleToCheckOutThisVisit(){
		Integer pastNumberMinusOne = (Integer.parseInt(Hook.scenarioContext.getContext(Context.OPEN_VISITS).toString())-1);
		Integer actualNumber = checkIn_CheckOutPage.getOpenVisitsNumber();

		Assert.assertEquals(pastNumberMinusOne, actualNumber);
	}

}
