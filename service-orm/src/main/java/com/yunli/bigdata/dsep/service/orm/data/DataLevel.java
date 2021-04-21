package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 数仓分层表(data_levels)
 *
 * @author zhangws
 */
@Entity
@Table(name = "data_levels")
@EntityListeners(AuditingEntityListener.class)
public class DataLevel implements Serializable {

  /**
   * id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /**
   * 名称
   */
  @Column(name = "code")
  private String code;

  /**
   * 描述
   */
  @Column(name = "name")
  private String name;

  public DataLevel() {
  }

  public DataLevel(Long id, String code, String name) {
    this.id = id;
    this.code = code;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataLevel that = (DataLevel) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}