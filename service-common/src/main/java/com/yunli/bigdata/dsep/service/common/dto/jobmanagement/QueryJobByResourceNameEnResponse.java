package com.yunli.bigdata.dsep.service.common.dto.jobmanagement;

public class QueryJobByResourceNameEnResponse {

  private Long id;

  private String name;

  public QueryJobByResourceNameEnResponse() {
  }

  public QueryJobByResourceNameEnResponse(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
