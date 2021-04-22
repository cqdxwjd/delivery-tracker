package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.audit.AccessAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @Description: 数据访问日志DAO
 * @Author: jiangxunyu
 * @CreateDate: 2019/7/1 15:48
 */
@Repository
public interface DataAccessLogRepositoryForResource extends JpaRepository<AccessAuditLog, String> {
  Long countAllByResourceTypeAndResourceIdAndStatus(String resourceType, Long resourceId, Integer status);
}
