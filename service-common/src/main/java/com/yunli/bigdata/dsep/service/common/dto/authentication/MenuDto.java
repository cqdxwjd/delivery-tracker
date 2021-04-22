package com.yunli.bigdata.dsep.service.common.dto.authentication;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wei
 */
public class MenuDto implements Serializable {
  private long id;

  private String code;

  private String name;

  private Long parentId;

  private Integer level;

  public MenuDto(long id, String code, String name, Long parentId, Integer level, Integer status) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.parentId = parentId;
    this.level = level;
    this.status = status;
  }

  /**
   * 状态（0:停用，1:启用）
   */
  private Integer status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuDto menuDto = (MenuDto) o;
    return Objects.equals(code, menuDto.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return "MenuDto{" +
        "id=" + id +
        ", code='" + code + '\'' +
        ", name='" + name + '\'' +
        ", parentId=" + parentId +
        ", level=" + level +
        ", status=" + status +
        '}';
  }
}
