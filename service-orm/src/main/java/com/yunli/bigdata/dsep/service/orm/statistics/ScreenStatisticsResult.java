package com.yunli.bigdata.dsep.service.orm.statistics;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author guozhijun
 * CREATE TABLE `screen_statistics` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
 *   `title_en` varchar(20) NOT NULL COMMENT '主题英文名称',
 *   `title_cn` varchar(20) NOT NULL COMMENT '主题中文名称',
 *   `text` text NOT NULL COMMENT '主题对应的内容信息(json格式)',
 *   `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '统计时间',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大屏各项指标信息存储表,按照次数存储只允许插入,禁止更新';
 */
@Table(name = "screen_statistics")
@Entity
public class ScreenStatisticsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "title_cn")
    private String titleCn;

    @Column(name = "text")
    private String text;

    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;

    public ScreenStatisticsResult() {
    }

    /**
     * @param titleEn   英文title
     * @param titleCn   中文title
     */
    public ScreenStatisticsResult(String titleEn, String titleCn){
        this.titleEn = titleEn;
        this.titleCn = titleCn;
        this.createTime = new Date();
    }

    public ScreenStatisticsResult(String titleEn, String titleCn,String text){
        this.titleEn = titleEn;
        this.titleCn = titleCn;
        this.text = text;
        this.createTime = new Date();
    }

    public ScreenStatisticsResult(String titleEn, String titleCn,String text, Date createTime){
        this.titleEn = titleEn;
        this.titleCn = titleCn;
        this.text = text;
        this.createTime = createTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
