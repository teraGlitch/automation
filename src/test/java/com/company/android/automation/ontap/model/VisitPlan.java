package com.company.android.automation.ontap.model;

public class VisitPlan {
  private String id;
  private String stage;
  private String status;
  private String country;
  private String startTime;
  private String endTime;
  private String eventType;
  private String assignTo;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getStage() {
    return stage;
  }
  public void setStage(String stage) {
    this.stage = stage;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getStartTime() {
    return startTime;
  }
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }
  public String getEndTime() {
    return endTime;
  }
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
  public String getEventType() {
    return eventType;
  }
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }
  public String getAssignTo() {
    return assignTo;
  }
  public void setAssignTo(String assignTo) {
    this.assignTo = assignTo;
  }
}
