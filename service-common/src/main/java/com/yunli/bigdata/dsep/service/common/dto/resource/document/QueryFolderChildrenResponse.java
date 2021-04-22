package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangws
 */
public class QueryFolderChildrenResponse extends Node implements Serializable {

  public QueryFolderChildrenResponse() {
  }

  public QueryFolderChildrenResponse(Long parentId, Long nid, String name, Date createTime,
      Date updateTime, boolean directory) {
    super(parentId, nid, name, createTime, updateTime, directory);
  }
}
