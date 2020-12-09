package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature110920 {
  private CheckIn_CheckOutPage checkIn_CheckOutPage;
  
public Feature110920(){
  checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
}
@When("I select the Exceptions option")
public void iSelectTheExceptionsOption(){
  checkIn_CheckOutPage.clickOnExeptions();

}

@Then("A warning about the completed visit should be displayed")
public void aWarningAboutTheCompletedVisitShouldBeDisplayed(){
  Assert.assertTrue(checkIn_CheckOutPage.checkExceptionAlert(),"Notice about the completed visit did not appear");
}
}
