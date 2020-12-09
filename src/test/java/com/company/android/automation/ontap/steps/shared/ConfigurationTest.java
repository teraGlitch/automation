package com.company.android.automation.ontap.steps.shared;

import com.company.switchvariable.automation.VariableManager;
import com.company.switchvariable.automation.VariableModel;
import com.company.android.automation.ontap.util.ConfigurationProperties;
import com.sync.azure.helper.VariableHelper;
import com.sync.azure.util.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigurationTest {


    public static String URL_DEFAULT = ConfigurationProperties.getConfig("url_default");

    public static long DEFAULT_TIME_WAIT = Long.parseLong(ConfigurationProperties.getConfig("default_time_wait"));

    public static String TEST_PLAN_NAME = ConfigurationProperties.getConfig("test_plan_name");

    public static String PACKAGE_STEPS = ConfigurationProperties.getConfig("package_steps");

    public static String PREFIX_ORG = System.getProperty("prefixOrg") != null ? System.getProperty("prefixOrg") : "";

    public static Map<String, LinkedHashMap<String, String>> GROUP_VARIABLES_AZURE = new HashMap<String, LinkedHashMap<String, String>>();

    @SuppressWarnings("unchecked")
    public static void setConfigurationDefault() {
      Configuration.CREDENTIALS = System.getProperty("azureSyncToken");
      Configuration.URI_API = "https://dev.azure.com/company";
      Configuration.PROJECT_NAME = "GHQ_company_Salesforce_OneApp";
      Configuration.PLAN_ID = 74993;
      Configuration.PACKAGE = PACKAGE_STEPS;

      GROUP_VARIABLES_AZURE = (Map<String, LinkedHashMap<String, String>>) VariableHelper.getGroupVariable(System.getProperty("variableGroupAzure")).get("variables");
    }

    public static void setVariablesEnvironmentDefault() {
        if (System.getProperty("variableGroupAzureName") != null && System.getProperty("variableGroupAzure") != null) {
            ArrayList<VariableModel> variables = new ArrayList<>();
            variables.add(new VariableModel("BULK_URI_API", true, "bulkUriApi"));
            variables.add(new VariableModel("AZURE_TOKEN", true, "azureSyncToken"));
            variables.add(new VariableModel("AZURE_GROUP_VARIABLE", true, "variableGroupAzure" ));
            variables.add(new VariableModel("AZURE_GROUP_VARIABLE_NAME", true, "variableGroupAzureName" ));
            variables.add(new VariableModel("SALESFORCE_PASSWORD_GLOBAL", true, "salesforcePassword"));
            variables.add(new VariableModel("UPDATE_STATUS_EXECUTION", false, "updateStatusExecution"));
            variables.add(new VariableModel("URL_ORG", false, "urlOrg"));
            variables.add(new VariableModel("CUSTOMER_ID", false, "customerId"));
            variables.add(new VariableModel("URL_ORG", false, "urlOrg"));
            variables.add(new VariableModel("PATH_TO_SDFX", false, "pathToSfdx"));
            variables.add(new VariableModel("PATH_TO_LIB_PYTHON", false, "pathToLibPython"));
            variables.add(new VariableModel("ORG_ADDRESS", false, "orgAddress"));
            VariableManager.applyVariableDefault(variables);
        }
    }
}
