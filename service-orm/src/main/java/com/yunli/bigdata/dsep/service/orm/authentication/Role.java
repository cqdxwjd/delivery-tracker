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
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@EntityListeners(AuditingEntityListener.class)
public class Role extends GroupOrRoleForAuthentication implements Serializable {
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

  @ManyToOne
  @JoinColumn(name = "creator")
  private User creator;

  @ManyToOne
  @JoinColumn(name = "modifier")
  private User modifier;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "roles")
  private Set<User> users = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
      mappedBy = "roles")
  private Set<Group> groups = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "role_privilege",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id"))
  private Set<Privilege> privileges = new HashSet<>();

  public Set<Group> getGroups() {
    return groups;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    this.users.add(user);
    user.getRoles().add(this);
  }

  public void removeUser(User user) {
    if (this.users.remove(user)) {
      user.getRoles().remove(this);
    }
  }

  @Override
  public void addPrivilege(Privilege privilege) {
    this.privileges.add(privilege);
    privilege.getRoles().add(this);
  }

  @Override
  public void removePrivilege(Privilege privilege) {
    if (this.privileges.remove(privilege)) {
      privilege.getRoles().remove(this);
    }
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
      creator.getRolesCreated().add(this);
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
      modifier.getRolesCreated().add(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return name.equals(role.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
