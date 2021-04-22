package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataTopicColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author david
 */
@Repository
public interface DataTopicColumnRepository extends JpaRepository<DataTopicColumn, Long> {
  Set<DataTopicColumn> findAllByTopicId(long topicId);
}
