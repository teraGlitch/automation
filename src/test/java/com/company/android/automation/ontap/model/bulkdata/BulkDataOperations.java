package com.company.android.automation.ontap.model.bulkdata;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class BulkDataOperations {

  /**
   * Create or edit an salesforce object record
   * 
   * @author Matheus Marques Silva
   *
   * @param json
   *    Json with the below keys:
   *        
   *    {
          "csvData": "string",
          "object": "string"
        }
   * @return
   */
  public static String create(JSONObject json) {
    HttpResponse<JsonNode> httpResponse = 
        sendRequest(json, "/v1/salesforce");
    JsonNode jsonResponse = httpResponse.getBody();
    if(jsonResponse.getArray().length() > 0
        && (jsonResponse.getArray().getJSONObject(0).optString("sf__Created")).equals("true")) 
      return jsonResponse.getArray().getJSONObject(0).getString("sf__Id");
    else 
      return null;
  }
  
  /**
   * Get records from salesforce
   *  
   * @author Matheus Marques Silva
   *
   * @param json
   *      Json with the below keys:
   *      {
            "conditions": [
              {
                "field": "Email",
                "operator": "EQ",
                "value": "john@mail.com"
              }
            ],
            "fields": [
              "Id",
              "Name",
              "Email"
            ],
            "limit": 0,
            "object_schema": "Account"
          }
   * @return
   */
  public static JsonNode query(JSONObject json) {
    HttpResponse<JsonNode> httpResponse = 
        sendRequest(json, "/v1/salesforce/query");
    return httpResponse.getBody();
  } 
  
  /**
   * Delete an record by salesforce 
   * 
   * @author Matheus Marques Silva
   *
   * @param recordObject
   *          record type (Object Name)
   * @param recordId
   *          record id generated in salesforce
   * @return
   */
  public static JsonNode delete(String recordObject, String recordId) {
    HttpResponse<JsonNode> httpResponse = 
        sendRequest(null, "/v1/salesforce/object/" + recordObject + "/" + recordId);
    return httpResponse.getBody();
  }
  /**
   * Send a post request to bulkdata v2.0 API
   * 
   * @author Matheus Marques Silva
   *
   * @param jsonBody
   *    Json to attach in request body
   * @param postURL
   *    Post path to send request
   * @return
   */
  private static HttpResponse<JsonNode> sendRequest(JSONObject jsonBody, String postURL) {
    String url = System.getProperty("bulkUriApi");
    HttpResponse<JsonNode> httpResponse = Unirest
        .post(url + postURL)
        .header("Authorization", "Bearer " + System.getProperty("bearer_token_azure"))        
        .header("Content-Type", "application/json")
        .header("token", System.getProperty("bulkToken"))
        .header("uri-salesforce", System.getProperty("bulkUriOrg"))
        .body(jsonBody)
        .asJson();
    JsonNode jsonResponse = httpResponse.getBody();
    String error = "";
    if(jsonResponse.getArray().length() > 0 && !(error = jsonResponse.getArray().getJSONObject(0).optString("error")).equals("")) {
      System.err.println("BulkData API ERROR: " + error);
    }
    return httpResponse;
  }
}
