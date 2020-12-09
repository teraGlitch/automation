package com.company.android.automation.ontap.model.bulkdata;

import java.util.Arrays;

import com.company.android.automation.ontap.model.Account;
import com.company.android.automation.ontap.model.builder.AccountBuilder;

import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class AccountBulkdata {
  
  public Account getAccountByName(String name) {
    JSONObject json = new JSONObject()
        .put("conditions", Arrays.asList(
            new JSONObject() 
            .put("field", "Name")
            .put("operator", "EQ")
            .put("value", "'" + name + "'")
        ))
        .put("fields", Arrays.asList("Id", "Name"))
        .put("limit", "1")
        .put("object_schema", "Account");
    JsonNode response = BulkDataOperations.query(json);
    JSONObject userData = response.getArray().getJSONObject(0);
    Account account = new AccountBuilder()
                                .id(userData.getString("Id"))
                                .name(userData.getString("Name")).build();
    return account;
  }
}
