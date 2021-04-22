package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.authentication.Organization;
import com.yunli.bigdata.dsep.service.orm.authentication.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author wangpengfei
 * @date 2019-06-25
 */
@Repository
public interface PrivilegeRepositoryForResource extends JpaRepository<Privilege, Long> {
  Privilege findByResourceTypeAndResourceIdAndAction(String resourceType, long resourceId, String action);

  Set<Privilege> findAllByOrganizationResponsibleAndResourceTypeAndAction(Organization organization,
      String resourceType, String action);
}
