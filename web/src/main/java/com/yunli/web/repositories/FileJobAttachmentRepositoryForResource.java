package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.job.FileJobAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangws 2019/07/05
 */
@Repository
public interface FileJobAttachmentRepositoryForResource extends JpaRepository<FileJobAttachment, Long> {
}