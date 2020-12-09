package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then; 

//TODO
public class Feature76747 {
  private CheckIn_CheckOutPage checkInCheckOutPage;
  
public Feature76747(){
  checkInCheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
  
}
@Then("I am able to check in in a already completed visit in the list")
public void iAmAbleToCheckInInAAlreadyCompletedVisitInTheList(){
  Assert.assertFalse(checkInCheckOutPage.validatesIfCheckInWasDone(),"Check-in was unsuccessful");
}

}
