package com.yunli.bigdata.dsep.foundation;

public class GovernanceRule_QpsControl {
  private String resource;

  private Double qps;

  private Boolean enabled;

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public Double getQps() {
    return qps;
  }

  public void setQps(Double qps) {
    this.qps = qps;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public GovernanceRule_QpsControl() {
  }

  public GovernanceRule_QpsControl(String resource, Double qps, Boolean enabled) {
    this.resource = resource;
    this.qps = qps;
    this.enabled = enabled;
  }
}
