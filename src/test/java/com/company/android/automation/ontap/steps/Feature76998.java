package com.company.android.automation.ontap.steps;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class Feature76998 {
	
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
	public Feature76998(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}
	
	@And("I did the check in successfully")
	public void iDidTheCheckInSuccessfully(){
		checkIn_CheckOutPage.checkIn();
	}

	@When("I click on check out button")
	public void iClickOnCheckOutButton(){
		checkIn_CheckOutPage.checkOut();
	}

	@Then("I am able to cancel the check out in this POC")
	public void iAmAbleToCancelTheCheckOutInThisPOC(){
		throw new PendingException();
	}

}
