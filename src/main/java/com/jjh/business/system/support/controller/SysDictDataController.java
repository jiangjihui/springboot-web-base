package com.jjh.business.system.support.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jjh.business.system.support.model.SysDictData;
import com.jjh.business.system.support.service.SysDictDataService;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.PageRequestForm;
import com.jjh.common.web.form.PageResponseForm;
import com.jjh.common.web.form.SimpleResponseForm;
import com.jjh.framework.plugin.excel.ExcelUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
*   字典数据管理
 * @author jjh
 * @date 2019/12/09
*/
@Tag(name = "[a1070]字典数据管理")
@RestController
@RequestMapping("/system/support/sys_dict_data")
public class SysDictDataController extends BaseController {

    @Autowired
    private SysDictDataService sysDictDataService;


    /**
     * 字典数据列表
     */
    @Operation(summary = "字典数据列表")
    @PostMapping("/list")
    public SimpleResponseForm<PageResponseForm<SysDictData>> list(@RequestBody PageRequestForm<SysDictData> form) {
        List<SysDictData> list = sysDictDataService.list(form);
        return page(form, list);
    }

    /**
     * 新增字典数据
     */
    @Operation(summary = "新增字典数据")
    @ApiOperationSupport(ignoreParameters = {"id","createTime","updateTime","createBy","updateBy"})
    @PostMapping("/add")
    public SimpleResponseForm<SysDictData> add(HttpServletRequest request, @Valid @RequestBody SysDictData entity) {
        SysDictData result = sysDictDataService.add(entity);
        return success(result);
    }

    /**
     * 更新字典数据
     */
    @Operation(summary = "更新字典数据")
    @ApiOperationSupport(ignoreParameters = {"createTime","updateTime","createBy","updateBy"})
    @PostMapping("/update")
    public SimpleResponseForm<SysDictData> update(HttpServletRequest request, @Valid @RequestBody SysDictData entity) {
        SysDictData result = sysDictDataService.update(entity);
        return success(result);
    }

    /**
     * 删除字典数据
     */
    @Operation(summary = "删除字典数据")
    @GetMapping("/delete")
    public SimpleResponseForm<String> delete(String ids) {
        sysDictDataService.del(ids);
        return success();
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @Operation(summary = "根据字典类型查询字典数据信息")
    @GetMapping("/list_by_dict_type")
    @Parameter(description = "dictType", name = "字典类型（码值）", required = true, in = ParameterIn.HEADER)
    public SimpleResponseForm<List<SysDictData>> listByDictType(String dictType) {
        return success(sysDictDataService.listByDictType(dictType));
    }

    /**
     * 字典数据导入模板
     * @return
     */
    @Operation(summary = "字典数据导入模板")
    @GetMapping("/import_template")
    public SimpleResponseForm<String> importTemplate() {
        ExcelUtil<SysDictData> util = new ExcelUtil<>(SysDictData.class);
        return success(util.importTemplateExcel( "字典数据导入"));
    }

    /**
     * 字典数据导出
     * @param form 分页请求参数
     * @return 导出文件
     */
    @Operation(summary = "字典数据导出")
    @PostMapping("/export")
    public SimpleResponseForm<String> export(@RequestBody PageRequestForm<SysDictData> form) {
        List<SysDictData> list = sysDictDataService.list(form);
        ExcelUtil<SysDictData> excelUtil = new ExcelUtil<>(SysDictData.class);
        return success(excelUtil.exportExcel(list, "字典数据列表"));
    }

    /**
     * 字典数据导入
     * @return
     */
    @Operation(summary = "字典数据导入")
    @PostMapping("/import_data")
    public SimpleResponseForm<String> importData(MultipartFile file, boolean updateSupport) {
        if (file != null) {
            ExcelUtil<SysDictData> util = new ExcelUtil<>(SysDictData.class);
            List<SysDictData> list = util.importExcel(file);
            sysDictDataService.importData(list, updateSupport);
        }
        return success();
    }
}
