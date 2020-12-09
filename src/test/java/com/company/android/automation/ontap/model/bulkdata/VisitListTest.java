package com.company.android.automation.ontap.model.bulkdata;

import java.util.Arrays;
import java.util.List;

import com.company.android.automation.ontap.model.Account;
import com.company.android.automation.ontap.model.VisitPlan;
import com.company.android.automation.ontap.model.VisitPlanValues;

public class VisitListTest {
  
  public void test() {
     VisitFactory visitFactory = new VisitFactory();
     VisitPlan newVisit = visitFactory.createVisitPlan("bdr1@company.com.companycoe.ssci");
     System.out.println("Visit ID: " + newVisit.getId());
     Account accountColmado = new AccountBulkdata().getAccountByName("COLMADO WISENDY");
     List<VisitPlanValues> visitPlanValues = visitFactory.createVisitValues(newVisit, Arrays.asList(accountColmado), "POCs", "Acc");
     visitPlanValues.forEach(visitPlanValue -> {
       System.out.println("Visit Plan Value: "  + visitPlanValue.getId());
     });
  }
}
