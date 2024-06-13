package com.jjh.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 业务基础实体
 *
 * @EntityListeners 开启jpa审计 https://www.cnblogs.com/niceyoo/p/10908647.html
 */
@Data
public abstract class BaseEntity implements Serializable {

    /** 唯一编号（ID）*/
    @Schema(description = "[base]唯一编号（ID）")
    private String id;

    /** 创建日期（yyyy-MM-dd HH:mm:ss）*/
    @Schema(description = "[base]创建日期（yyyy-MM-dd HH:mm:ss）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 更新日期（yyyy-MM-dd HH:mm:ss）*/
    @Schema(description = "[base]更新日期（yyyy-MM-dd HH:mm:ss）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;


}
