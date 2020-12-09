package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature47734 {
  private CheckIn_CheckOutPage checkIn_CheckOutPage;
  
public Feature47734(){
  checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
}
@And("I have two visits to perform")
public void iHaveTwoVisitsToPerform(){
		throw new PendingException();
}

@And("I do the check in in the first POC")
public void iDoTheCheckInInTheFirstPOC(){
  // TODO - Bulk data creates a visit, based on available POCs in Salesforce database
  String pocName = "LA MATA SUPER FRÃCA 2"; // TODO - Receives created visit POC name
  checkIn_CheckOutPage.clickOnAccountName(pocName).checkIn();
}

@When("I open the second visit")
public void iOpenTheSecondVisit() throws Exception{
 checkIn_CheckOutPage.tapBackButton();
 //TODO - Bulk data creates a visit, based on available POCs in Salesforce database
 String pocName = "COLMADO SANTA"; // TODO - Receives created visit POC name
 checkIn_CheckOutPage.clickOnAccountName(pocName);
}

@Then("A message about the current check in is displayed")
public void aMessageAboutTheCurrentCheckInIsDisplayed(){
  Assert.assertTrue(checkIn_CheckOutPage.checkMessageAlertCheckIn(), "Current check-in message was not displayed");
}

@And("I am able to check out the current visit and check in in the second")
public void iAmAbleToCheckOutTheCurrentVisitAndCheckInInTheSecond(){
  checkIn_CheckOutPage.clickOnCheckOutAlert().checkIn();
  Assert.assertFalse(checkIn_CheckOutPage.validatesIfCheckInWasDone(),"Check-in was unsuccessful");
}

}
