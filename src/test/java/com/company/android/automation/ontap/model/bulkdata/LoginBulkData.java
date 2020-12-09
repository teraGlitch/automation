package com.company.android.automation.ontap.model.bulkdata;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.company.android.automation.ontap.model.LoginModel;
import com.company.android.automation.ontap.model.builder.LoginBuilder;
import com.company.android.automation.ontap.steps.shared.ConfigurationTest;

public final class LoginBulkData {

    public static LoginModel getLogin(String profile) {

        String password = "";

        Map<String, LinkedHashMap<String, String>> users = ConfigurationTest.GROUP_VARIABLES_AZURE;

        if(users.size() == 0)
            throw new RuntimeException("No login defined for this execution!");

        password = System.getProperty("salesforcePassword");

        Map<String, LoginModel> profiles = new HashMap<String, LoginModel>();

        LoginModel loginBDR = LoginBuilder.builder()
                .withUserName(users.get("USER_BDR").get("value"))
                .withPassword(password)
                .withProfile("BDR")
                .withNameUser(users.get("NAME_BDR").get("value"))
                .build();

        LoginModel loginBackoffice = LoginBuilder.builder()
                .withUserName(users.get("USER_BACKOFFICE").get("value"))
                .withPassword(password)
                .withProfile("Backoffice")
                .withNameUser("Backoffice User QA")
                .build();

        profiles.put("BDR User", loginBDR);
        profiles.put("Backoffice", loginBackoffice);

        return profiles.get(profile);
    }


}
