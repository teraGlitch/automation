package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature76995 {
  private CheckIn_CheckOutPage checkIn_CheckOutPage;
  
public Feature76995(){
  checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
}
@When("I click on check in button")
public void iClickOnCheckInButton(){
  checkIn_CheckOutPage.clickTheButtonCheck_In();
}

@Then("I am able to cancel the check in in this POC")
public void iAmAbleToCancelTheCheckInInThisPOC(){
  checkIn_CheckOutPage.confirmOrCancel("Cancel");
  Assert.assertTrue(checkIn_CheckOutPage.validateVisitPage(),"Could not click Cancel button or return to the expected page.");
}

}
