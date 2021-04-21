package com.yunli.bigdata.dsep.service.orm.authentication;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author wangpengfei
 * @date 2019-06-27
 */
@Entity
@Table(name = "organizations")
public class Organization implements Serializable {
  @Id
  private String id;

  @Column
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "responsibleFor")
  private Set<User> responsibles = new HashSet<>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Set<User> getResponsibles() {
    return responsibles;
  }

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "organizationResponsible")
  private Set<Privilege> responsibleFor;

  public Set<Privilege> getResponsibleFor() {
    return responsibleFor;
  }

  public void setParent(Organization parent) {
    this.parent = parent;
  }

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "parent")
  private Organization parent;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "organizations")
  private Set<User> users = new HashSet<>();

  public Set<User> getUsers() {
    return users;
  }

  public Organization getParent() {
    return parent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization that = (Organization) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
