package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangws
 */
@Repository
public interface SystemConfigRepository extends JpaRepository<SystemConfig, Long> {
  List<SystemConfig> findAllByType(Integer type);
}
