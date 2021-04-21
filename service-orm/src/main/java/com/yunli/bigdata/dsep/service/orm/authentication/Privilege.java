package com.yunli.bigdata.dsep.service.orm.authentication;

import com.yunli.bigdata.dsep.service.common.SystemPrivilege;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author wangpengfei
 * @date 2019-06-24
 */
@Entity
@Table(name = "privileges",
    uniqueConstraints = @UniqueConstraint(columnNames = {"resourceType", "resourceId", "action"}))
public class Privilege implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String resourceType;

  /**
   * MIN_VALUE means not related
   */
  @Column()
  private long resourceId = SystemPrivilege.ALL_OF_RESOURCES;

  @Column
  private String action;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "organization_responsible")
  private Organization organizationResponsible;

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "privileges")
  private Set<User> users = new HashSet<>();

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "privileges")
  private Set<Role> roles = new HashSet<>();

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "privileges")
  private Set<Group> groups = new HashSet<>();

  public Privilege() {
  }

  public Privilege(String resourceType, long resourceId, String action) {
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.action = action;
  }

  public Privilege(String resourceType, long resourceId, String action,
      Organization organizationResponsible) {
    this.resourceType = resourceType;
    this.resourceId = resourceId;
    this.action = action;
    this.organizationResponsible = organizationResponsible;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public Set<Group> getGroups() {
    return groups;
  }

  public Organization getOrganizationResponsible() {
    return organizationResponsible;
  }

  public void setOrganizationResponsible(Organization organizationResponsible) {
    if (this.organizationResponsible != null) {
      this.organizationResponsible.getResponsibleFor().remove(this);
    }

    this.organizationResponsible = organizationResponsible;
    if (organizationResponsible != null) {
      organizationResponsible.getResponsibleFor().add(this);
    }
  }

  public Set<User> getUsers() {
    return users;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public long getResourceId() {
    return resourceId;
  }

  public void setResourceId(long resourceId) {
    this.resourceId = resourceId;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Privilege resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

  public Privilege resourceId(long resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public Privilege action(String action) {
    this.action = action;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Privilege privilege = (Privilege) o;
    return resourceId == privilege.resourceId &&
        resourceType.equals(privilege.resourceType) &&
        action.equals(privilege.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, resourceId, action);
  }
}
