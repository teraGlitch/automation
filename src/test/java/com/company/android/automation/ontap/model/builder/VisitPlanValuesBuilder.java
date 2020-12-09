package com.company.android.automation.ontap.model.builder;

import com.company.android.automation.ontap.model.VisitPlanValues;
import com.company.android.automation.ontap.model.bulkdata.BulkDataOperations;

import kong.unirest.json.JSONObject;

public class VisitPlanValuesBuilder {
  private VisitPlanValues visitPlanValues;
  
  public VisitPlanValuesBuilder() {
    visitPlanValues = new VisitPlanValues();
  }
  
  public VisitPlanValuesBuilder stage(String stage) {
    visitPlanValues.setStage(stage);
    return this;
  }
  
  public VisitPlanValuesBuilder type(String type) {
    visitPlanValues.setType(type);
    return this;
  }
  
  public VisitPlanValuesBuilder value(String value) {
    visitPlanValues.setValue(value);
    return this;
  }
  
  public VisitPlanValuesBuilder sequence(int sequence) {
    visitPlanValues.setSequence(sequence);
    return this;
  }
  
  public VisitPlanValuesBuilder duration(int duration) {
    visitPlanValues.setDuration(duration);
    return this;
  }
  
  public VisitPlanValuesBuilder visitPlanId(String visitPlanId) {
    visitPlanValues.setVisitPlanId(visitPlanId);
    return this;
  }
  
  public VisitPlanValuesBuilder name(String name) {
    visitPlanValues.setName(name);
    return this;
  }
  
  public VisitPlanValues build() {
    return visitPlanValues;
  }
  
  public VisitPlanValues buildOnSalesforce() {
    String createCSV = "Stage__c,Type__c,Value__c,Sequence__c,Duration__c,Visit_Plan__c\n"
                      + visitPlanValues.getStage() + "," + visitPlanValues.getType() + "," 
                      + visitPlanValues.getValue() + "," + visitPlanValues.getSequence() + ","
                      + visitPlanValues.getDuration() + "," + visitPlanValues.getVisitPlanId(); 
    JSONObject json = new JSONObject()                  
        .put("csvData", createCSV)
        .put("object", "Visit_Plan_Values__c");
    String id = BulkDataOperations.create(json);
    visitPlanValues.setId(id);
    return visitPlanValues;
  }
}
