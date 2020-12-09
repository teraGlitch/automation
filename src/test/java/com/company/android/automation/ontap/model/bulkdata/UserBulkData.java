package com.company.android.automation.ontap.model.bulkdata;

import java.util.Arrays;

import com.company.android.automation.ontap.model.User;
import com.company.android.automation.ontap.model.builder.UserBuilder;

import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class UserBulkData {

  public User getUser(String username) {
    JSONObject json = new JSONObject()
        .put("conditions", Arrays.asList(
            new JSONObject() 
            .put("field", "Username")
            .put("operator", "EQ")
            .put("value", "'" + username + "'")
        ))
        .put("fields", Arrays.asList("Id", "Name", "Username", "Country", "LanguageLocaleKey"))
        .put("limit", "1")
        .put("object_schema", "User");
    JsonNode response = BulkDataOperations.query(json);
    JSONObject userData = response.getArray().getJSONObject(0);
    User user = new UserBuilder()
                                .id(userData.getString("Id"))
                                .name(userData.getString("Name"))
                                .username(userData.getString("Username"))
                                .country(userData.getString("Country"))
                                .language(userData.getString("LanguageLocaleKey")).build();
    return user;
  }
  
  public String getUserCountry(String username) {
    JSONObject json = new JSONObject()
        .put("conditions", Arrays.asList(
            new JSONObject() 
            .put("field", "Username")
            .put("operator", "EQ")
            .put("value", "'" + username + "'")
        ))
        .put("fields", Arrays.asList("Country"))
        .put("limit", "1")
        .put("object_schema", "User");
    JsonNode response = BulkDataOperations.query(json);
    return response.getArray().getJSONObject(0).getString("Country");
  }
  
  public String getUserLanguageLocaleKey(String username) {
    JSONObject json = new JSONObject()
        .put("conditions", Arrays.asList(
            new JSONObject() 
            .put("field", "Username")
            .put("operator", "EQ")
            .put("value", "'" + username + "'")
        ))
        .put("fields", Arrays.asList("LanguageLocaleKey"))
        .put("limit", "1")
        .put("object_schema", "User");
    JsonNode response = BulkDataOperations.query(json);
    return response.getArray().getJSONObject(0).getString("LanguageLocaleKey");
  }
}
