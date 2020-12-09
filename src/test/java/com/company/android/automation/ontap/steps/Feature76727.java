package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

//TODO
public class Feature76727 {

	private CheckIn_CheckOutPage checkIn_CheckOutPage;

	public Feature76727(){

		checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);

	}
	@Then("I will be able to check in in Phone Call type visits")
	public void iWillBeAbleToCheckInInPhoneCallTypeVisits(){
		Assert.assertTrue(checkIn_CheckOutPage.checkMenuButtonExists("Check Out"));
	}

}
