package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author david
 */
@Repository
public interface TopicRepository extends JpaRepository<DataTopic, Long>,
        JpaSpecificationExecutor<DataTopic> {

    public DataTopic findByTopicCode(String topicCode);

    public Set<DataTopic> findAllByIdIn(long[] ids);

    public Boolean existsByTopicCode(String topicCode);

    public Boolean existsByTopicName(String topicName);

    @Query(nativeQuery = true, value =
            "select dree.id as labelId,dree.name_cn as labelName,drep.id as typeId,drep.name_cn  as typeName"
                    + "       from data_topics dt "
                    + "       join data_topic_label_relation dtlr on dt.id = dtlr.topic_id "
                    + "       join data_resource_extend_enums dree on dree.id = dtlr.label_id "
                    + "       join data_resource_extend_properties drep on dree.property_id =drep .id "
                    + "       where drep.group_code = 'EXTEND_LABEL' and dt.id = :topicId "
                    + "       order by drep.update_time desc,dree.update_time  desc")
    List<Map<String, Object>> findLabels(@Param("topicId") Long id);

    @Query(nativeQuery = true, value = "SELECT\n" +
            "\tcount(1)\n" +
            "FROM\n" +
            "\tdata_topics a\n" +
            "LEFT JOIN data_topic_tag b ON a.id = b.topic_id\n" +
            "WHERE\n" +
            "\tb.topic_id IS NULL;")
    long countUnmounted();
}
