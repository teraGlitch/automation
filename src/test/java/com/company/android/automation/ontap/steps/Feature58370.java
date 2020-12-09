package com.company.android.automation.ontap.steps;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature58370 {

	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature58370(){

		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
		
	}
	@When("I click on exceptions option")
	public void iClickOnExceptionsOption(){
		checkIn_CheckOutPage.clickExceptions();
	}

	@And("I apply an {string} for the exception")
	public void iApplyAnExceptionOptionForTheException(String exceptionOption){
		
		checkIn_CheckOutPage.selectException(exceptionOption);
		
	}

	@Then("The app will sync my changes")
	public void theAppWillSyncMyChanges(){
		throw new PendingException();
	}

	@And("The check out will be done successfully")
	public void theCheckOutWillBeDoneSuccessfully(){
		throw new PendingException();
	}

}
