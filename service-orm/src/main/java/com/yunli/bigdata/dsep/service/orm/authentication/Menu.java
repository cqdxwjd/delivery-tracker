package com.yunli.bigdata.dsep.service.orm.authentication;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author wei
 */
@Entity
@Table(name = "menus")
@EntityListeners(AuditingEntityListener.class)
public class Menu implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "parentId")
  private Menu parent = null;

  @Column
  private Integer level;

  /**
   * 状态（0:停用，1:启用）
   */
  @Column
  private Integer status = 1;

  public Menu() {
  }

  public Menu(String code, String name, Integer level) {
    this.code = code;
    this.name = name;
    this.level = level;
  }

  public Menu(String code, String name, Menu parent, Integer level, Integer status) {
    this.code = code;
    this.name = name;
    this.parent = parent;
    this.level = level;
    this.status = status;
  }

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

  public Menu getParent() {
    return parent;
  }

  public void setParent(Menu parent) {
    this.parent = parent;
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
    Menu group = (Menu) o;
    return id == group.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
