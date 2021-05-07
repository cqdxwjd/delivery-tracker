package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.stub.StubServiceJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StubServiceJobRepository extends JpaRepository<StubServiceJob, Long> {
    Long countByType(String s);
}
