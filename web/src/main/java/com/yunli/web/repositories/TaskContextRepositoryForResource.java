package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.job.TaskContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangws
 */
@Repository
public interface TaskContextRepositoryForResource extends JpaRepository<TaskContext, Long> {
}
