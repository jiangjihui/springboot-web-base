package com.jjh.business.common.file.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jjh.common.model.AuditBaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static com.jjh.business.common.file.model.FileInfo.TABLE_NAME;


/**
 * 文件信息
 *
 * @author jjh
 * @date 2019/11/19
 */
@Data
@TableName(TABLE_NAME)
public class FileInfo extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"file_info";

    /** 文件名称*/
    @Schema(description = "文件名称")
    private String filename;

    /** 实际文件名*/
    @Schema(description = "实际文件名")
    private String fileKey;

    /** 文件内容的md5摘要*/
    @Schema(description = "文件内容的md5摘要")
    private String fileMd5;

    /** 文件大小*/
    @Schema(description = "文件大小")
    private Long fileSize;

}
