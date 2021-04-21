package com.yunli.bigdata.dsep.service.orm.authentication;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author wangpengfei
 * @date 2019-06-25
 */
@Entity
@Table(name = "groups", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@EntityListeners(AuditingEntityListener.class)
public class Group extends GroupOrRoleForAuthentication implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  @CreatedDate
  private Date createTime;

  @Column
  @LastModifiedDate
  private Date lastUpdateTime;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "creator")
  private User creator;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "modifier")
  private User modifier;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "group_role",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "group_user",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "group_privilege",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id"))
  private Set<Privilege> privileges = new HashSet<>();

  @Override
  public void addPrivilege(Privilege privilege) {
    this.privileges.add(privilege);
    privilege.getGroups().add(this);
  }

  @Override
  public void removePrivilege(Privilege privilege) {
    this.privileges.remove(privilege);
    privilege.getGroups().remove(this);
  }

  @Override
  public Set<Privilege> getPrivileges() {
    return privileges;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    if (this.creator != null) {
      this.creator.getGroupsCreated().remove(this);
    }
    this.creator = creator;
    if (creator != null) {
      creator.getGroupsCreated().add(this);
    }
  }

  public User getModifier() {
    return modifier;
  }

  public void setModifier(User modifier) {
    if (this.modifier != null) {
      this.modifier.getGroupsCreated().remove(this);
    }
    this.modifier = modifier;
    if (modifier != null) {
      modifier.getGroupsCreated().add(this);
    }
  }

  public void addRole(Role role) {
    this.roles.add(role);
    role.getGroups().add(this);
  }

  public void removeRole(Role role) {
    this.roles.remove(role);
    role.getGroups().remove(this);
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void addUser(User user) {
    this.users.add(user);
    user.getGroups().add(this);
  }

  public void removeUser(User user) {
    this.users.remove(user);
    user.getGroups().remove(this);
  }

  public Set<User> getUsers() {
    return users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return id == group.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
