package com.company.android.automation.ontap.model;

public class VisitPlanValues {
  private String id;
  private String name;
  private String stage;
  private String type;
  private String value;
  private int sequence;
  private int duration;
  private String visitPlanId;
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getStage() {
    return stage;
  }
  
  public void setStage(String stage) {
    this.stage = stage;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getValue() {
    return value;
  }
  
  public void setValue(String value) {
    this.value = value;
  }
  
  public int getSequence() {
    return sequence;
  }
  
  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
  
  public int getDuration() {
    return duration;
  }
  
  public void setDuration(int duration) {
    this.duration = duration;
  }
  
  public String getVisitPlanId() {
    return visitPlanId;
  }
  
  public void setVisitPlanId(String visitPlanId) {
    this.visitPlanId = visitPlanId;
  }
}
