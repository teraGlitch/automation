package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

//TODO
public class Feature47719 {

	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature47719(){
		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
	}
	@And("I turn off my cellular data")
	public void iTurnOffMyCellularData(){
		checkIn_CheckOutPage.toggleDeviceConnection(false);
	}

	@Then("I am able to check in even with my cellular data turned off")
	public void iAmAbleToCheckInEvenWithMyCellularDataTurnedOff(){
		Assert.assertTrue(checkIn_CheckOutPage.checkMenuButtonExists("Check Out"));
	}

}
