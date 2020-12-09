package com.company.android.automation.ontap.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.steps.shared.Hook;

@Automated
public class Feature156671 {
	LoginPage loginPage;
public Feature156671(){
	loginPage= FactoryPage.factory(LoginPage.class, Hook.appium);
}
@When("I allow all the permissions until I find {string} pop up")
public void iAllowAllThePermissionsUntilIFindPermissionPopUp(String permission){
 loginPage.validadePermissionPop_Pup(permission ,"ALLOW");
 }

@Then("I can allow the permission")
public void iCanAllowThePermission(){
Assert.assertTrue(loginPage.validateIfPermissionEnable(),"#Access permissions have not  been Validate");
}

}
