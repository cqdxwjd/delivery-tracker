package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataResourceRepository extends JpaRepository<DataResource, Long>, JpaSpecificationExecutor<DataResource> {
    @Query(nativeQuery = true, value = "select t2.name_cn as type, t1.id as code, t1.name_cn as name "
            + " from data_resource_extend_enums t1 "
            + " join data_resource_extend_properties t2"
            + " on t1.property_id = t2.id"
            + " where group_code = 'EXTEND_LABEL'"
            + " order by t2.id desc, t1.id desc")
    List<Object> findByLabel();

    @Query(nativeQuery = true, value = "select id from data_resources where status >= 2 and id in :tableIds")
    List<Long> findByTableId(@Param("tableIds") List<Long> tableIds);

    @Query(nativeQuery = true, value = "select id from document_resources where status >= 2 and id in :documentIds")
    List<Long> findByDocumentId(@Param("documentIds") List<Long> documentIds);

    @Query(nativeQuery = true, value = "select id from data_topics where status >= 2 and id in :topicIds")
    List<Long> findByTopicId(@Param("topicIds") List<Long> topicIds);

    // 分层级查询
    @Query(nativeQuery = true, value = "select count(1) from data_resources where name_en like ?1%")
    Long countByLayer(String layer);

    @Query(nativeQuery = true, value = "select count(1) from data_resources where count=0 and name_en like ?1%")
    Long countBlankTableByLayer(String layer);

    @Query(nativeQuery = true, value = "select count(1) from data_resources a LEFT JOIN resource_tag b on a.id = b.resource_id where b.tag_id is null and a.name_en like ?1%")
    Long countUnrelatedTableCountByLayer(String layer);

    @Query(nativeQuery = true, value = "select count(1) from data_resources where status <> 2 and name_en like ?1%")
    Long countUnpublishedTableCountByLayer(String layer);

    // 总查询
    @Query(nativeQuery = true, value = "select count(1) from data_resources where count=0")
    Long countBlankTable();

    @Query(nativeQuery = true, value = "select count(1) from data_resources a LEFT JOIN resource_tag b on a.id = b.resource_id where b.tag_id is null")
    Long countUnrelatedTableCount();

    @Query(nativeQuery = true, value = "select count(1) from data_resources where status <> 2")
    Long countUnpublishedTableCount();

    //其他查询
    @Query(nativeQuery = true, value = "select count(1) from data_resources where substr(name_en,1,3) not in ('stg','ods','dwd','dws','adm','dim')")
    Long countOtherLayer();

    @Query(nativeQuery = true, value = "select count(1) from data_resources where count=0 and substr(name_en,1,3) not in ('stg','ods','dwd','dws','adm','dim')")
    Long countOtherLayerBlankTable();

    @Query(nativeQuery = true, value = "select count(1) from data_resources a LEFT JOIN resource_tag b on a.id = b.resource_id where b.tag_id is null and substr(name_en,1,3) not in ('stg','ods','dwd','dws','adm','dim')")
    Long countOtherLayerUnrelatedTableCount();

    @Query(nativeQuery = true, value = "select count(1) from data_resources where status <> 2 and substr(name_en,1,3) not in ('stg','ods','dwd','dws','adm','dim')")
    Long countOtherLayerUnpublishedTableCount();
}
