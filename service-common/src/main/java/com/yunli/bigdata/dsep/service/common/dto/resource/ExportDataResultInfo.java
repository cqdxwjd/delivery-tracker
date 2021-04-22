package com.yunli.bigdata.dsep.service.common.dto.resource;

import java.io.Serializable;

/**
 * @author wei
 */
public class ExportDataResultInfo implements Serializable {
  private Long count;

  private boolean preview = false;

  public ExportDataResultInfo(Long count) {
    this.count = count;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public boolean getPreview() {
    return preview;
  }

  public void setPreview(boolean preview) {
    this.preview = preview;
  }
}
