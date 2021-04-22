package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataTagTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: 数据标签树DAO接口
 * @Author: jiangxunyu
 * @CreateDate: 2019/6/25 11:49
 */
@Repository
public interface DataTagTreeRepositoryForResource extends JpaRepository<DataTagTree, Long> {

}
