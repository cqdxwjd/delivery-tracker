package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


/**
 * @author wei
 */
@Repository
public interface TagRepositoryForResource extends JpaRepository<DataTag, Long> {
  Set<DataTag> findAllByTreeId(Long treeId);

  Set<DataTag> findAllByIdIn(List<Long> tagIds);

  Set<DataTag> findAllByParent(DataTag parent);
}
