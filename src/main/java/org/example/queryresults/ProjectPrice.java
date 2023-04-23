package org.example.queryresults;

import java.math.BigDecimal;

public class ProjectPrice {
    private long projectName;
    private BigDecimal projectCost;

    public long getProjectName() {
        return projectName;
    }

    public void setProjectName(long projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(BigDecimal projectCost) {
        this.projectCost = projectCost;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "projectName=" + projectName +
                ", projectCost=" + projectCost +
                '}';
    }
}
