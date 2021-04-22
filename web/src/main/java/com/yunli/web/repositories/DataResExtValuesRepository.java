package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataResourceExtendValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guozhijun
 */
@Repository
public interface DataResExtValuesRepository extends
        JpaRepository<DataResourceExtendValues,Long>, JpaSpecificationExecutor<DataResourceExtendValues> {
    /**
     * 根据标签ID删除关系表
     * @param enumsId 标签ID
     * @return
     */
    @Modifying @Query(nativeQuery = true ,  value = "delete from data_resource_extend_values WHERE data_info = ?1 ")
    void deleteByEnumsId(Long enumsId);
    /**
     * 根据扩展声明名称和内容获取资源ID
     * @param nameEn
     * @param dataInfo
     * @return
     */
    @Query(nativeQuery = true ,  value = "SELECT " +
            " v.resource_id  " +
            "FROM " +
            " data_resource_extend_properties p " +
            " RIGHT JOIN data_resource_extend_values v ON p.id = v.extend_id  " +
            "WHERE " +
            " p.name_en = ?1  " +
            " AND v.data_info = ?2")
    List<Long> getDataResourcesByNameEnAndDataInfo(String nameEn, String dataInfo);

    /**
     * 根据扩展内容信息获取资源名称
     * @param nameEn
     * @param id
     * @return
     */
    @Query(nativeQuery = true ,  value = "SELECT " +
            " s.name  " +
            "FROM " +
            " data_resources r " +
            " LEFT JOIN data_resource_extend_values v ON r.id = v.resource_id " +
            " LEFT JOIN data_resource_extend_properties p ON v.extend_id = p.id  " +
            " left join data_source s on s.id = v.data_info " +
            "WHERE p.name_en = ?1 and r.id = ?2")
    String getSourceNameByDataInfo(String nameEn, Long id);

    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    List<DataResourceExtendValues> findByResourceId(Long id);

    /**
     * 获取扩展内容的去重列表
     * @param nameEn
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT DISTINCT " +
            " v.data_info  " +
            "FROM " +
            " data_resource_extend_values v " +
            " LEFT JOIN data_resource_extend_properties p ON v.extend_id = p.id  " +
            "WHERE " +
            " p.name_en = ?1 ORDER BY v.data_info desc")
    List<String> getDistinctByDataInfoByNameEn(String nameEn);

}
