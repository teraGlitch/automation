package com.company.android.automation.ontap.model.bulkdata;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.company.android.automation.ontap.model.Account;
import com.company.android.automation.ontap.model.VisitPlan;
import com.company.android.automation.ontap.model.VisitPlanValues;
import com.company.android.automation.ontap.model.builder.VisitPlanBuilder;
import com.company.android.automation.ontap.model.builder.VisitPlanValuesBuilder;

public class VisitFactory {

    public static final String STR_NAME = "name";
    
    public VisitPlan createVisitPlan(String username) {
        String userId = new UserBulkData().getUser(username).getId();
        return new VisitPlanBuilder()
            .stage("Visit Plan Definition")
            .status("Open")
            .country("DO")
            .startTime(Instant.now().toString())
            .endTime(Instant.now().plus(2, ChronoUnit.HOURS).toString())
            .eventType("Planned Visit")
            .assignTo(userId).buildOnSalesforce();
    }
    
    public List<VisitPlanValues> createVisitValues(VisitPlan vp, List<Account> lacc, String stage, String visitType) {
        List<VisitPlanValues> lvisitVal = new ArrayList<VisitPlanValues>();
        for(Account acc : lacc) {
            lvisitVal.add(
                new VisitPlanValuesBuilder()
                .stage(stage.equals("") ? "POCs" : stage)
                .type(visitType.equals("") ? "Acc" : visitType)
                .value(acc.getId())
                .sequence(1)
                .duration(20)
                .visitPlanId(vp.getId())
                .name("Acc-" + acc.getName()).buildOnSalesforce()
            );
        }
        return lvisitVal;
    }
}
  
