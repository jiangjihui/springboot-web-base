package com.jjh.business.system.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

import static com.jjh.business.system.user.model.SysUser.TABLE_NAME;

/**
 * 用户信息实体类
 *
 * @author jjh
 * @date 2019/11/19
 */
@Data
@TableName(TABLE_NAME)
public class SysUser extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"sys_user";

    /** 帐号 */
    @Excel(name = "帐号")
    @NotBlank(message = "用户名不能为空")
    @Schema(description = "帐号", required = true)
    private String username;

    /** 名称 */
    @Excel(name = "名称")
    @Schema(description = "名称")
    private String name;

    /** 密码 */
    @Excel(name = "密码", type = Excel.Type.IMPORT)
    @Schema(description = "密码", required = true)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /** 加密密码的盐 */
    // @JsonIgnore
    @Schema(description = "加密密码的盐")
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    /** 头像 */
    @Schema(description = "头像")
    private String avatar;

    /** 生日 */
    @Excel(name = "生日", dateFormat = "yyyy-MM-dd")
    @Schema(description = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    /** 性别 */
    @Excel(name = "性别", dictConverter = "系统字典[system:sysUser:sex]")
    @Schema(description = "性别")
    private Integer sex;

    /** 电子邮件 */
    @Excel(name = "生日")
    @Schema(description = "电子邮件")
    private String email;

    /** 电话 */
    @Excel(name = "电话")
    @Schema(description = "电话")
    private String phone;

    /** 部门code */
    @Schema(description = "部门code")
    private String orgCode;

    /** 部门编号 */
    @Schema(description = "部门编号")
    private String deptId;

    /** 状态  */
    @Schema(description = "状态", required = true)
    private Integer status;

    /** 工号，唯一键  */
    @Schema(description = "工号，唯一键")
    private String workNo;


    /** token */
    @Schema(description = "token")
    @TableField(exist = false)
    private String token;

    /** 角色Code */
    @Schema(description = "角色Code")
    @TableField(exist = false)
    private List<String> roleCode;

    /** 权限Code */
    @Schema(description = "权限Code")
    @TableField(exist = false)
    private List<String> permissionCode;

    /** 角色列表 */
    @Schema(description = "角色列表")
    @TableField(exist = false)
    private List<SysRole> roleList;


    @JsonIgnore
    public String getCredentialsSalt() {
        return username+salt;
    }
}
