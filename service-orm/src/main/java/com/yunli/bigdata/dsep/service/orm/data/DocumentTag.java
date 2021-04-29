package com.yunli.bigdata.dsep.service.orm.data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: 数据表和标签实体类
 * @Author: fdw
 * @CreateDate: 2020/9/22 13:42
 */
@Entity
@Table(name = "document_catalog")
@IdClass(DocumentTagIdClass.class)
@EntityListeners(AuditingEntityListener.class)
public class DocumentTag implements Serializable {

    // 标签ID
    @Id
    @Column(name = "document_id")
    private Long documentId;

    @Id
    @Column(name = "catalog_id")
    private Long tagId;


    public DocumentTag() {
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentTag that = (DocumentTag) o;
        return Objects.equals(documentId, that.documentId) &&
                Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, tagId);
    }
}
