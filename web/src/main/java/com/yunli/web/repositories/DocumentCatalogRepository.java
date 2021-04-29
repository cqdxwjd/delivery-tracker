package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.data.DocumentTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentCatalogRepository extends JpaRepository<DocumentTag, Long> {
    Optional<DocumentTag> findByDocumentId(long id);
}
