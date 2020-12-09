package com.company.android.automation.ontap.model.builder;

import com.company.android.automation.ontap.model.VisitPlan;
import com.company.android.automation.ontap.model.bulkdata.BulkDataOperations;

import kong.unirest.json.JSONObject;

public class VisitPlanBuilder {
  private VisitPlan visitPlan;
  
  public VisitPlanBuilder() {
    visitPlan = new VisitPlan();
  }
  
  public VisitPlanBuilder stage(String stage) {
    visitPlan.setStage(stage);
    return this;
  }
  
  public VisitPlanBuilder status(String status) {
    visitPlan.setStatus(status);
    return this;
  }
  
  public VisitPlanBuilder country(String country) {
    visitPlan.setCountry(country);
    return this;
  }
  
  public VisitPlanBuilder startTime(String startTime) {
    visitPlan.setStartTime(startTime);
    return this;
  }
  
  public VisitPlanBuilder endTime(String endTime) {
    visitPlan.setEndTime(endTime);
    return this;
  }
  
  public VisitPlanBuilder eventType(String eventType) {
    visitPlan.setEventType(eventType);
    return this;
  }
  
  public VisitPlanBuilder assignTo(String bdrId) {
    visitPlan.setAssignTo(bdrId);
    return this;
  }
  
  public VisitPlan build() {
    return visitPlan;
  }
  
  public VisitPlan buildOnSalesforce() {
    String createCSV = "Stage__c,Status__c,Country__c,Start_Time__c,End_Time__c,Event_Type__c,AssignTo__c\n" 
                      + visitPlan.getStage() + "," + visitPlan.getStatus() + ","+ visitPlan.getCountry() +","
                      + visitPlan.getStartTime() + "," + visitPlan.getEndTime() + "," + visitPlan.getEventType() + ","
                      + visitPlan.getAssignTo();
    JSONObject json = new JSONObject()
        .put("csvData", createCSV)
        .put("object", "Visit_Plan__c");
    String id = BulkDataOperations.create(json);
    visitPlan.setId(id);
    return visitPlan;
  }
}
