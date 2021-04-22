package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DocumentResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangws
 */
@Repository
public interface DocumentResourceRepository extends JpaRepository<DocumentResource, Long>,
    JpaSpecificationExecutor<DocumentResource> {
  Boolean existsByName(String name);

  Set<DocumentResource> findAllByIdIn(long[] ids);

  @Query(nativeQuery = true, value = "select t3.id as typeId, t3.name_cn as typeName,"
      + " t1.label_id as labelId, t2.name_cn as labelName"
      + " from document_label_relation t1"
      + " join data_resource_extend_enums t2"
      + " on t2.id = t1.label_id"
      + " join data_resource_extend_properties t3"
      + " on t3.id = t2.property_id and t3.group_code = 'EXTEND_LABEL'"
      + " where t1.document_id = :documentId"
      + " order by t3.update_time desc, t2.update_time desc")
  List<Map<String, Object>> findLabels(@Param("documentId") Long id);
}
