package com.yunli.bigdata.dsep.service.orm.util;

import com.yunli.bigdata.dsep.service.orm.authentication.Organization;
import com.yunli.bigdata.dsep.service.orm.authentication.User;

import java.util.HashSet;
import java.util.Set;


/**
 * @author wangpengfei
 * @date 2019-07-05
 */
public class OrganizationUtil {
  public static String getOrganizationAllName(Organization org) {
    if (org == null) {
      return null;
    }
    Organization parent = org.getParent();
    if (parent != null) {
      return String.format("%s-%s", getOrganizationAllName(parent), org.getName());
    } else {
      return org.getName();
    }
  }

  public static String getOrganizationAllName(Set<Organization> organizations) {
    String organizationAllName = "";
    for (Organization organization : organizations) {
      organizationAllName = String
          .format("%s%s;", organizationAllName, OrganizationUtil.getOrganizationAllName(organization));
    }
    if (organizationAllName.endsWith(";")) {
      organizationAllName = organizationAllName.substring(0, organizationAllName.length() - 1);
    }
    return organizationAllName;
  }

  public static Set<User> getSuperUsersOfOrganization(Organization organization, Set<User> superUsers) {
    if (superUsers == null) {
      superUsers = new HashSet<>();
    }
    if (organization == null) {
      return superUsers;
    }
    superUsers.addAll(organization.getResponsibles());
    Organization parent = organization.getParent();
    if (parent == null) {
      return superUsers;
    }
    return getSuperUsersOfOrganization(parent, superUsers);
  }
}
