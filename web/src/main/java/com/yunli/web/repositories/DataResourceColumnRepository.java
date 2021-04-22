package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataResourceColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author wei
 */
@Repository
public interface DataResourceColumnRepository extends JpaRepository<DataResourceColumn, Long> {
  Set<DataResourceColumn> findAllByResourceAndPartitionColumnOrderById(long resourceId, boolean partitionColumn);
}
