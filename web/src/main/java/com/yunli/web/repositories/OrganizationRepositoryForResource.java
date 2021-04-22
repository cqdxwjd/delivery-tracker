package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.authentication.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangpengfei
 * @date 2019-06-27
 */
@Repository
public interface OrganizationRepositoryForResource extends JpaRepository<Organization, String> {
}
