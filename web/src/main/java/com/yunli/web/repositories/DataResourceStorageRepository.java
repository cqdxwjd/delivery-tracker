package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DataResourceStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wei
 */
@Repository
public interface DataResourceStorageRepository extends JpaRepository<DataResourceStorage, Long> {

  Boolean existsByName(String name);

  List<DataResourceStorage> findByScopeAndType(int scope, String type);
}
