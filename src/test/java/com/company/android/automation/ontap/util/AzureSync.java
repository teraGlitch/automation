package com.company.android.automation.ontap.util;

import org.testng.annotations.Test;

import com.company.android.automation.ontap.steps.shared.ConfigurationTest;
import com.sync.azure.util.Configuration;

public class AzureSync {
  
  @Test
  public void Sync() {
    ConfigurationTest.setVariablesEnvironmentDefault();
    ConfigurationTest.setConfigurationDefault();
    String[] args = new String[] { Configuration.CREDENTIALS, String.valueOf(Configuration.PLAN_ID), Configuration.PROJECT_NAME,
        Configuration.URI_API, Configuration.PACKAGE, System.getProperty("variableGroupAzureName"), System.getProperty("variableGroupAzure") };
    com.sync.azure.Sync.main(args);
  }
}
