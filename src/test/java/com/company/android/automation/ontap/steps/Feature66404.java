package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.enums.AndroidPermission;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

@Automated
public class Feature66404 {
private VisitListPage visitListPage;

public Feature66404(){
  visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
}

@And("The system finished syncing")
public void iConfirmTheLogout(){
  visitListPage.waitInvisibilitySync();
}

@Then("I will be at OnTap main page")
public void iWillBeLoggedOutSuccessfully(){
  visitListPage
      .clickAndroidButtonPermission(AndroidPermission.CONTACTS, "ALLOW")
      .clickAndroidButtonPermission(AndroidPermission.FILES, "ALLOW")
      .clickAndroidButtonPermission(AndroidPermission.LOCATION, "ALLOW")
      .clickAndroidButtonPermission(AndroidPermission.PHONE, "ALLOW")
      .clickAndroidButtonPermission(AndroidPermission.CAMERA, "ALLOW");
  Assert.assertTrue(visitListPage.dateVisitListBarIsPresent(), "OnTap main page has not been loaded");
}

}
