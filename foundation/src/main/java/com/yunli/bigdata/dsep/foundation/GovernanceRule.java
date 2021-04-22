package com.yunli.bigdata.dsep.foundation;

import java.util.List;

public class GovernanceRule {
  private List<GovernanceRule_QpsControl> qps;

  public List<GovernanceRule_QpsControl> getQps() {
    return qps;
  }

  public void setQps(List<GovernanceRule_QpsControl> qps) {
    this.qps = qps;
  }

  public GovernanceRule() {
  }

  public GovernanceRule(List<GovernanceRule_QpsControl> qps) {
    this.qps = qps;
  }
}