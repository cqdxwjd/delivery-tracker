package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * layui 树形结构数据源属性类
 *
 * @author wangjingdong
 * @date 2021/5/28 10:07
 * @Copyright © 云粒智慧 2018
 */

@Data
@AllArgsConstructor
public class TreeObject {
    String title;
    Long id;
    String field;
    List<TreeObject> children;
    String href;
    Boolean spread;
    Boolean checked;
    Boolean disabled;

    public void addChild(TreeObject t) {
        children.add(t);
    }
}
