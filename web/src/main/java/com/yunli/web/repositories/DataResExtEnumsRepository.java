package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataResourceExtendEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author guozhijun
 */
@Repository
public interface DataResExtEnumsRepository extends JpaRepository<DataResourceExtendEnums, Long>,JpaSpecificationExecutor<DataResourceExtendEnums> {

    /**
     * 名称是否重复
     * @param nameCn 中文名称
     * @param propertyId
     * @return
     */
    Boolean existsByNameCnAndPropertyId(String nameCn,Long propertyId);

    /**
     * 名称是否重复
     * @param id
     * @param nameCn 中文名称
     * @param propertyId
     * @return
     */
    Boolean existsByIdNotAndNameCnAndPropertyId(Long id, String nameCn, Long propertyId);

    /**
     * 根据名称获取对象
     * @param nameCn 中文名称
     * @return
     */
    DataResourceExtendEnums getByNameCn(String nameCn);

}
