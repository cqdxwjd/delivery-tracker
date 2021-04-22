package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.job.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangws 2019/07/05
 */
@Repository
public interface JobInfoRepositoryForResource extends JpaRepository<JobInfo, Long> {
  boolean existsByNameAndStatusNot(String name,Integer status);
}