package com.jjh.business.common.gen.controller;

import com.jjh.business.common.gen.controller.form.GenEntitySqlForm;
import com.jjh.business.common.gen.controller.form.GenFileForm;
import com.jjh.business.common.gen.controller.form.GenTargetPathForm;
import com.jjh.business.common.gen.service.GenService;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.SimpleResponseForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码生成
 *
 * @author jjh
 * @date 2019/11/18
 **/
@Tag(name = "[a]代码生成")
@RestController
@RequestMapping("/gen")
public class GenController extends BaseController {

    private static final Logger logger= LoggerFactory.getLogger(GenController.class);

    @Autowired
    private GenService genService;


    /**
     * 代码生成
     * @param form
     */
    @Operation(summary = "代码生成", description = "包含到实体所在包下的目录")
    @GetMapping("/gen_code_to_target_path")
    public SimpleResponseForm<String> genCodeToTargetPath(@Valid GenTargetPathForm form) {
        genService.genCodeFromTargetPath(form);
        return success();
    }

    /**
     * 生成指定文件
     * @param form
     */
    @Operation(summary = "生成指定文件", description = "自定义模板和参数进行指定文件生成")
    @PostMapping("/gen_file")
    public SimpleResponseForm<String> genFile(@RequestBody @Valid GenFileForm form) {
        genService.genFile(form);
        return success();
    }

    @Operation(summary = "生成实体SQL", description = "参数为模型类包名+类名")
    @PostMapping("/get_model_sql")
    public SimpleResponseForm<String> getModelSql(@Valid GenEntitySqlForm form) {
        return success(genService.createModelSql(form));
    }
}
