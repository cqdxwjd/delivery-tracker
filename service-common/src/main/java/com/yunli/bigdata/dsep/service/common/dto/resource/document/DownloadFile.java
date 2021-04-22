package com.yunli.bigdata.dsep.service.common.dto.resource.document;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author zhangws
 */
public class DownloadFile implements Serializable {

  /**
   * 类型（例如MediaType.TEXT_PLAIN_VALUE）
   */
  private String type;

  /**
   * 文件内容
   */
  private byte[] content;

  public DownloadFile() {
  }

  public DownloadFile(String type, byte[] content) {
    this.type = type;
    if (null != content) {
      this.content = Arrays.copyOf(content, content.length);
    } else {
      this.content = new byte[0];
    }
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getContent() {
    return content == null ? null : Arrays.copyOf(content,  content.length);
  }

  public void setContent(byte[] content) {
    if (null != content) {
      this.content = Arrays.copyOf(content, content.length);
    } else {
      this.content = new byte[0];
    }
  }
}
