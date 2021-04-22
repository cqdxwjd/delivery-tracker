package com.yunli.bigdata.dsep.service.common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 调度类型
 *
 * @author zhangws
 */
public class JobType {

  public static final String FILE_IMPORT = "文件导入";

  public static final String TABLE_IMPORT = "库表导入";

  public static final String TABLE_EXPORT = "库表导出";

  public static final String SQL_JOB = "SQL作业";

  public static final String FILE_PULL = "文件拉取";

  public static final String REAL_DATA_BATCH_IMPORT = "实时数据批量导入";

  public static final String FILE_UPLOAD = "文件上传";

  private JobType() {
  }

  /**
   * 返回名称列表（会创建新的实例）
   */
  public static List<String> getNamesForTable() {
    List<String> types = new ArrayList<>(10);
    types.add(FILE_IMPORT);
    types.add(TABLE_IMPORT);
    types.add(TABLE_EXPORT);
//    types.add(REAL_DATA_BATCH_IMPORT);
    // TODO 注释掉，这次测试屏蔽掉
//    types.add(SQL_JOB);
//    types.add(FILE_PULL);
    return types;
  }

  /**
   * 返回名称列表（会创建新的实例）
   */
  public static List<String> getNamesForFile() {
    List<String> types = new ArrayList<>(3);
    types.add(FILE_UPLOAD);
    return types;
  }

  public static boolean isImport(String type) {
    return true;
  }

  public static boolean isExport(String type) {
    return true;
  }
}
