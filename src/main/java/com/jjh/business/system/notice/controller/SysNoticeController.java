package com.jjh.business.system.notice.controller;


import com.jjh.business.system.notice.controller.form.QuerySysNoticeForm;
import com.jjh.business.system.notice.model.SysNotice;
import com.jjh.business.system.notice.service.SysNoticeService;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.PageRequestForm;
import com.jjh.common.web.form.PageResponseForm;
import com.jjh.common.web.form.SimpleResponseForm;
import com.jjh.framework.aspect.operationlog.BusinessType;
import com.jjh.framework.aspect.operationlog.Log;
import com.jjh.framework.plugin.excel.ExcelUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*   通知管理
 *
 * @author jjh
 * @date 2020/05/07
*/
@Tag(name = "[a5010]通知管理")
@RestController
@RequestMapping("/system/notice/sys_notice")
public class SysNoticeController extends BaseController {

    @Autowired
    private SysNoticeService sysNoticeService;


    /**
     * 通知列表
     */
    @Operation(summary = "通知列表")
    @PostMapping("/list")
    public SimpleResponseForm<PageResponseForm<SysNotice>> list(@RequestBody PageRequestForm<QuerySysNoticeForm> form) {
        List<SysNotice> list = sysNoticeService.list(form);
        return page(form, list);
    }

    /**
     * 新增通知
     */
    @Log(title = "新增通知", businessType = BusinessType.INSERT)
    @Operation(summary = "新增通知")
    @PostMapping("/add")
    public SimpleResponseForm<SysNotice> add(@Valid @RequestBody SysNotice entity) {
        SysNotice result = sysNoticeService.add(entity);
        return success();
    }

    /**
     * 更新通知
     */
    @Log(title = "更新通知", businessType = BusinessType.UPDATE)
    @Operation(summary = "更新通知")
    @PostMapping("/update")
    public SimpleResponseForm<SysNotice> update(@Valid @RequestBody SysNotice entity) {
        SysNotice result = sysNoticeService.update(entity);
        return success();
    }

    /**
     * 删除通知
     */
    @Log(title = "删除通知", businessType = BusinessType.DELETE)
    @Operation(summary = "删除通知")
    @GetMapping("/delete")
    public SimpleResponseForm<String> delete(String ids) {
        sysNoticeService.del(ids);
        return success();
    }

    /**
     * 通知导出
     * @param form 分页请求参数
     * @return 导出文件
     */
    @Log(title = "通知导出", businessType = BusinessType.EXPORT)
    @Operation(summary = "通知导出")
    @PostMapping("/export")
    public SimpleResponseForm<String> export(@RequestBody PageRequestForm<QuerySysNoticeForm> form) {
        List<SysNotice> list = sysNoticeService.list(form);
        ExcelUtil<SysNotice> excelUtil = new ExcelUtil<>(SysNotice.class);
        return success(excelUtil.exportExcel(list, "通知列表"));
    }


    /**
     * 个人通知
     */
    @Operation(summary = "个人通知")
    @PostMapping("/list_self")
    public SimpleResponseForm<PageResponseForm<SysNotice>> listSelf(@RequestBody PageRequestForm<SysNotice> form) {
        List<SysNotice> list = sysNoticeService.listSelf(form);
        return page(form, list);
    }

    /**
     * 更新为已读
     */
    @Operation(summary = "更新为已读")
    @PostMapping("/update_read_flag")
    public SimpleResponseForm<String> updateReadFlag(String id) {
        sysNoticeService.updateReadFlag(id);
        return success();
    }
}
