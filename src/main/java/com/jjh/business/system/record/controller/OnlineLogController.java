package com.jjh.business.system.record.controller;


import com.jjh.business.system.record.model.OnlineLog;
import com.jjh.business.system.record.service.OnlineLogService;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.PageRequestForm;
import com.jjh.common.web.form.PageResponseForm;
import com.jjh.common.web.form.SimpleResponseForm;
import com.jjh.framework.aspect.operationlog.BusinessType;
import com.jjh.framework.aspect.operationlog.Log;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
*   在线日志管理
 *
 * @author jjh
 * @date 2021/05/13
*/
@Api(tags = "在线日志管理")
@RestController
@RequestMapping("/system/record/online_log")
public class OnlineLogController extends BaseController {

    @Autowired
    private OnlineLogService onlineLogService;


    /**
     * 在线用户列表
     */
    @ApiOperation("在线用户列表")
    @ApiOperationSupport(order = 1)
    @PostMapping("/list_online")
    public SimpleResponseForm<PageResponseForm<OnlineLog>> listOnline(@RequestBody PageRequestForm form) {
        List<OnlineLog> list = onlineLogService.listOnline(form);
        return page(form, list);
    }

    /**
     * 在线日志列表
     */
    @ApiOperation("在线日志列表")
    @ApiOperationSupport(order = 10)
    @PostMapping("/list")
    public SimpleResponseForm<PageResponseForm<OnlineLog>> list(@RequestBody PageRequestForm<OnlineLog> form) {
        List<OnlineLog> list = onlineLogService.list(form);
        return page(form, list);
    }

    /**
     * 新增在线日志
     */
    @Log(title = "新增在线日志", businessType = BusinessType.INSERT)
    @ApiOperation("新增在线日志")
    @ApiOperationSupport(order = 20, ignoreParameters = {"id","createTime","updateTime","createBy","updateBy"})
    @PostMapping("/add")
    public SimpleResponseForm<OnlineLog> add(@Valid @RequestBody OnlineLog entity) {
        OnlineLog result = onlineLogService.add(entity);
        return success();
    }

    /**
     * 更新在线日志
     */
    @Log(title = "更新在线日志", businessType = BusinessType.UPDATE)
    @ApiOperation("更新在线日志")
    @ApiOperationSupport(order = 30, ignoreParameters = {"createTime","updateTime","createBy","updateBy"})
    @PostMapping("/update")
    public SimpleResponseForm<OnlineLog> update(@Valid @RequestBody OnlineLog entity) {
        OnlineLog result = onlineLogService.update(entity);
        return success();
    }

    /**
     * 删除在线日志
     */
    @Log(title = "删除在线日志", businessType = BusinessType.DELETE)
    @ApiOperation("删除在线日志")
    @ApiOperationSupport(order = 40)
    @GetMapping("/delete")
    public SimpleResponseForm<String> delete(String ids) {
        onlineLogService.del(ids);
        return success();
    }

}
