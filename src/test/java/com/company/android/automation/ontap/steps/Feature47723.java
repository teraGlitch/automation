package com.company.android.automation.ontap.steps;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

//TODO
public class Feature47723 {
	private CheckIn_CheckOutPage checkIn_CheckOutPage;
	
	public Feature47723(){

		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);

	}
	
	@And("I did the check out successfully")
	public void iDidTheCheckOutSuccessfully(){
		checkIn_CheckOutPage.checkOut();
	}

	@Then("The button color will change")
	public void theButtonColorWillChange(){
		throw new PendingException();
	}

}
