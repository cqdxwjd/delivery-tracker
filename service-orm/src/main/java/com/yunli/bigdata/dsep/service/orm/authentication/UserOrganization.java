package com.yunli.bigdata.dsep.service.orm.authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_organization")
public class UserOrganization implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name="organization_id")
    private String organizationId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
