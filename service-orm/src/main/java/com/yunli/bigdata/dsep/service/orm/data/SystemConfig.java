package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author zhangws
 */
@Entity
@Table(name = "system_config", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))
@EntityListeners(AuditingEntityListener.class)
public class SystemConfig {
  /**
   * 编码
   */
  @Id
  @Column(name = "code")
  private String code;

  /**
   * 名称
   */
  @Column(name = "name")
  private String name;

  /**
   * 描述
   */
  @Column(name = "value")
  private String value;

  /**
   * 0:前端使用 1:后端使用 (前后端都需要使用直接用0就行)
   */
  @Column(name = "type")
  private Integer type;

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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemConfig that = (SystemConfig) o;
    return Objects.equals(code, that.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }
}
