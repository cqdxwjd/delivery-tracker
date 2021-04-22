package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataResourceExtendProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guozhijun
 */
@Repository
public interface DataResExtPropertiesRepository extends JpaRepository<DataResourceExtendProperties, Long>,
        JpaSpecificationExecutor<DataResourceExtendProperties> {

    /**
     * 根据名称获取对象
     * @param nameEn 英文名称
     * @return
     */
    DataResourceExtendProperties getByNameEn(String nameEn);

    /**
     * 根据名称获取对象
     * @param nameCn 中文名称
     * @return
     */
    DataResourceExtendProperties getByNameCn(String nameCn);

    /**
     * 获取状态列表
     * @param status 状态值
     * @return
     */
    List<DataResourceExtendProperties> getByStatus(int status);

    /**
     * 根据名称和分组值获取对象
     * @param nameCn    中文名称
     * @param groupCode 分组值
     * @return
     */
    DataResourceExtendProperties getByNameCnAndGroupCode(String nameCn, String groupCode);

    /**
     * 根据分组值获取列表
     * @param groupCode 分组值
     * @return
     */
    List<DataResourceExtendProperties> findAllByGroupCode(String groupCode);

    /**
     * 是否存在
     * @param nameCn    中文名称
     * @param groupCode 分组值
     * @return
     */
    Boolean existsByNameCnAndGroupCode(String nameCn, String groupCode);

    /**
     * 是否存在
     * @param id
     * @param nameCn    中文名称
     * @param groupCode 分组值
     * @return
     */
    Boolean existsByIdNotAndNameCnAndGroupCode(Long id, String nameCn, String groupCode);

}
