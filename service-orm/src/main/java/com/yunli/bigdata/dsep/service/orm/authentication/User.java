package com.yunli.bigdata.dsep.service.orm.authentication;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author wangpengfei
 * @date 2019-06-25
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    // 密钥（用于数据共享交换时的加解密，base64）
    @Column
    private String secretKey;

    // 登录AKSK的公钥（用于后台登录，base64）
    @Column(length = 2048)
    private String publicKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_privilege",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<Privilege> privileges = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(name = "responsible_organization",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
    private Set<Organization> responsibleFor = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(name = "user_organization",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
    private Set<Organization> organizations = new HashSet<>();

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "users")
    private Set<Group> groups = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "creator")
    private Set<Role> rolesCreated = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "modifier")
    private Set<Role> rolesModified = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "creator")
    private Set<Group> groupsCreated = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "modifier")
    private Set<Group> groupsModified = new HashSet<>();

    public Set<Role> getRolesCreated() {
        return rolesCreated;
    }

    public Set<Role> getRolesModified() {
        return rolesModified;
    }

    public Set<Group> getGroupsCreated() {
        return groupsCreated;
    }

    public Set<Group> getGroupsModified() {
        return groupsModified;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void addOrganizationResponsed(Organization organization) {
        this.responsibleFor.add(organization);
        organization.getResponsibles().add(this);
    }

    public void removeOrganizationResponsed(Organization organization) {
        this.responsibleFor.remove(organization);
        organization.getResponsibles().remove(this);
    }

    public void setOrganizations(Set<Organization> organizations) {
        if (this.organizations != null) {
            this.organizations.forEach(org -> org.getUsers().remove(this));
        }
        this.organizations = organizations;
    }

    public void addOrganization(Organization organization) {
        this.organizations.add(organization);
        organization.getUsers().add(this);
    }


    public Set<Organization> getResponsibleFor() {
        return responsibleFor;
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addPrivilege(Privilege privilege) {
        this.privileges.add(privilege);
        privilege.getUsers().add(this);
    }

    public void removePrivilege(Privilege privilege) {
        this.privileges.remove(privilege);
        privilege.getUsers().remove(this);
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
        group.getUsers().add(this);
    }

    public void removeGroup(Group group) {
        if (this.groups.contains(group)) {
            this.groups.remove(group);
            group.getUsers().remove(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
