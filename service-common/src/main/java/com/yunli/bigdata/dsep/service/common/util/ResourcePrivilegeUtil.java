package com.yunli.bigdata.dsep.service.common.util;


import com.yunli.bigdata.dsep.service.common.Actions;
import com.yunli.bigdata.dsep.service.common.ResourceTypes;
import com.yunli.bigdata.dsep.service.common.constant.RoleOrGroupPrivilegeCode;
import com.yunli.bigdata.dsep.service.common.dto.authentication.ActionDto;
import com.yunli.bigdata.dsep.service.common.dto.authentication.ResourcePrivilegeDto;
import com.yunli.bigdata.dsep.service.common.dto.authentication.RoleOrGroupPrivilegeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wei
 */
public class ResourcePrivilegeUtil {
  public static List<ResourcePrivilegeDto> getResourcePrivileges(String type) {
    List<ResourcePrivilegeDto> result = new ArrayList<>();
    List<ActionDto> actions = new ArrayList<>();
    RoleOrGroupPrivilegeCode code = RoleOrGroupPrivilegeCode.valueOf(type);
    switch (code) {
      case MenuPrivilege:
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.MENU,
            ResourceTypes.getResourceTypeName(ResourceTypes.MENU), deepCopyActionDtoList(actions)));
        break;
      case AppPrivilege:
        actions.add(new ActionDto(Actions.ALL, "编辑"));
        result.add(new ResourcePrivilegeDto(ResourceTypes.DATA_TAG,
            ResourceTypes.getResourceTypeName(ResourceTypes.DATA_TAG), deepCopyActionDtoList(actions)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.LABEL,
            ResourceTypes.getResourceTypeName(ResourceTypes.LABEL), deepCopyActionDtoList(actions)));

        actions.clear();
        actions.add(new ActionDto(Actions.CREATE, Actions.getActionName(Actions.CREATE)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.DATA,
            ResourceTypes.getResourceTypeName(ResourceTypes.DATA), deepCopyActionDtoList(actions)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.DOCUMENT,
            ResourceTypes.getResourceTypeName(ResourceTypes.DOCUMENT), deepCopyActionDtoList(actions)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.TOPIC,
            ResourceTypes.getResourceTypeName(ResourceTypes.TOPIC), deepCopyActionDtoList(actions)));

        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB), deepCopyActionDtoList(actions)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_DOCUMENT_SYNCHRONOUS,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_DOCUMENT_SYNCHRONOUS), deepCopyActionDtoList(actions)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_TOPIC_SYNCHRONOUS,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_TOPIC_SYNCHRONOUS), deepCopyActionDtoList(actions)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_TOPIC_DEVELOPMENT,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_TOPIC_DEVELOPMENT), deepCopyActionDtoList(actions)));

        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_DATASOURCE,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_DATASOURCE), deepCopyActionDtoList(actions)));

        actions.clear();
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.AUDIT,
            ResourceTypes.getResourceTypeName(ResourceTypes.AUDIT), deepCopyActionDtoList(actions)));
        break;
      case DataPrivilege:
      case DocumentPrivilege:
      case TopicPrivilege:
        actions.add(new ActionDto("**", "全部"));
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        actions.add(new ActionDto(Actions.MODIFY, Actions.getActionName(Actions.MODIFY)));
        actions.add(new ActionDto(Actions.BE_PUBLISHED, Actions.getActionName(Actions.BE_PUBLISHED)));
        actions.add(new ActionDto(Actions.CHANGE, Actions.getActionName(Actions.CHANGE)));
        actions.add(new ActionDto(Actions.BE_UNPUBLISHED, Actions.getActionName(Actions.BE_UNPUBLISHED)));
        actions.add(new ActionDto(Actions.ASSOCIATED_TAG, Actions.getActionName(Actions.ASSOCIATED_TAG)));
        actions.add(new ActionDto(Actions.DELETE, Actions.getActionName(Actions.DELETE)));
        String resourceType = ResourceTypes.DATA;
        if (code.getName().equalsIgnoreCase(RoleOrGroupPrivilegeCode.DocumentPrivilege.getName())) {
          resourceType = ResourceTypes.DOCUMENT;
        } else if (code.getName().equalsIgnoreCase(RoleOrGroupPrivilegeCode.TopicPrivilege.getName())) {
          resourceType = ResourceTypes.TOPIC;
        }
        result.add(new ResourcePrivilegeDto(resourceType,
            ResourceTypes.getResourceTypeName(resourceType), deepCopyActionDtoList(actions)));
        break;
      case JobPrivilege:
        actions.add(new ActionDto("**", "全部"));
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        actions.add(new ActionDto(Actions.MODIFY, "编辑"));
        actions.add(new ActionDto(Actions.START_STOP, Actions.getActionName(Actions.START_STOP)));
        actions.add(new ActionDto(Actions.SUPPLEMENTARY_DATA, Actions.getActionName(Actions.SUPPLEMENTARY_DATA)));
        actions.add(new ActionDto(Actions.DELETE, Actions.getActionName(Actions.DELETE)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB), deepCopyActionDtoList(actions)));
        break;
      case JobDocumentSynchronousPrivilege:
        actions.add(new ActionDto("**", "全部"));
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        actions.add(new ActionDto(Actions.DELETE, Actions.getActionName(Actions.DELETE)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_DOCUMENT_SYNCHRONOUS,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_DOCUMENT_SYNCHRONOUS), deepCopyActionDtoList(actions)));
        break;
      case JobTopicSynchronousPrivilege:
        actions.add(new ActionDto("**", "全部"));
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        actions.add(new ActionDto(Actions.START_STOP, "停止"));
        actions.add(new ActionDto(Actions.DELETE, Actions.getActionName(Actions.DELETE)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_TOPIC_SYNCHRONOUS,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_TOPIC_SYNCHRONOUS), deepCopyActionDtoList(actions)));
        break;
      case JobTopicDevelopmentPrivilege:
        actions.add(new ActionDto("**", "全部"));
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        actions.add(new ActionDto(Actions.START_STOP, "停止"));
        actions.add(new ActionDto(Actions.DELETE, Actions.getActionName(Actions.DELETE)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_TOPIC_DEVELOPMENT,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_TOPIC_DEVELOPMENT), deepCopyActionDtoList(actions)));
        break;
      case DataSourcePrivilege:
        actions.add(new ActionDto("**", "全部"));
        actions.add(new ActionDto(Actions.READ, Actions.getActionName(Actions.READ)));
        actions.add(new ActionDto(Actions.MODIFY, Actions.getActionName(Actions.MODIFY)));
        actions.add(new ActionDto(Actions.DELETE, Actions.getActionName(Actions.DELETE)));
        result.add(new ResourcePrivilegeDto(ResourceTypes.JOB_DATASOURCE,
            ResourceTypes.getResourceTypeName(ResourceTypes.JOB_DATASOURCE), deepCopyActionDtoList(actions)));
        break;
      default:
        break;
    }
    return result;
  }

  public static List<RoleOrGroupPrivilegeDto> getRoleOrGroupResourcePrivileges(String resourcePrivilegeName) {
    List<RoleOrGroupPrivilegeDto> result = new ArrayList<>();
    boolean isEmpty = StringUtils.isEmpty(resourcePrivilegeName);
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.MenuPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.MenuPrivilege.name(), "菜单权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.MenuPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.AppPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.AppPrivilege.name(), "功能权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.AppPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.DataPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.DataPrivilege.name(), "数据表权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.DataPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.DocumentPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.DocumentPrivilege.name(), "文件夹权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.DocumentPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.TopicPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.TopicPrivilege.name(), "实时数据通道权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.TopicPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.JobPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.JobPrivilege.name(), "数据表同步作业权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.JobPrivilege.name())));
    }
    // 文件夹同步作业不展示
//    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.JobDocumentSynchronousPrivilege.name())) {
//      result
//          .add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.JobDocumentSynchronousPrivilege.name(), "文件夹同步作业权限",
//              getResourcePrivileges(RoleOrGroupPrivilegeCode.JobDocumentSynchronousPrivilege.name())));
//    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.JobTopicSynchronousPrivilege.getName())) {
      result
          .add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.JobTopicSynchronousPrivilege.name(), "实时数据同步作业权限",
              getResourcePrivileges(RoleOrGroupPrivilegeCode.JobTopicSynchronousPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.JobTopicDevelopmentPrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.JobTopicDevelopmentPrivilege.name(), "实时数据开发作业权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.JobTopicDevelopmentPrivilege.name())));
    }
    if (isEmpty || resourcePrivilegeName.equals(RoleOrGroupPrivilegeCode.DataSourcePrivilege.getName())) {
      result.add(new RoleOrGroupPrivilegeDto(RoleOrGroupPrivilegeCode.DataSourcePrivilege.name(), "数据源权限",
          getResourcePrivileges(RoleOrGroupPrivilegeCode.DataSourcePrivilege.name())));
    }
    return result;
  }

  public static List<ActionDto> deepCopyActionDtoList(List<ActionDto> src) {
    if (src == null) {
      return new ArrayList<>();
    }
    return src.stream().map(s -> new ActionDto(s.getCode(), s.getName(), s.getValue()))
        .collect(Collectors.toList());
  }
}
