package com.jjh.business.system.support.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.druid.pool.ha.PropertiesUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jjh.common.exception.BusinessException;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.SimpleResponseForm;
import com.jjh.framework.config.condition.HelpConditional;
import com.jjh.framework.properties.AppHelpProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
* @author  jiangjihui
*  @date 2022/10/9
**/
@Slf4j
@Api(tags = "[a1090]系统管理")
@RestController
@RequestMapping("/system/support/help")
@Conditional(HelpConditional.class)
@RequiredArgsConstructor
public class HelpController extends BaseController {

    private final SqlSessionTemplate sessionTemplate;
    private final static String HEADER_AUTH_KEY = "X-Authorization";

    @ApiOperation("服务状态")
    @GetMapping("/server_status")
    public SimpleResponseForm<Map> serverStatus() {
        HashMap<String, String> map = new HashMap<>();
        map.put("startTime", System.getProperty("app.startup.time"));
        map.put("env", System.getProperty("app.startup.env"));

        Properties gitProperties = PropertiesUtils.loadProperties("git.properties");
        if (gitProperties != null) {
            map.put("version", gitProperties.getProperty("git.build.version", ""));
        }
        return success(map);
    }

    @ApiOperation("更新数据")
    @PostMapping("/db/update_by_id")
    public SimpleResponseForm<Integer> dbUpdateById(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
        checkAuth(request);
        Preconditions.checkArgument(StrUtil.isNotBlank(String.valueOf(paramMap.get("__namespace"))), "namespace is required.");
        String namespace = String.valueOf(paramMap.remove("__namespace"));
        String jsonString = JSON.toJSONString(paramMap);
        Integer result = 0;
        try {
            Object mapper = SpringUtil.getBean(Class.forName(namespace));
            Method method = mapper.getClass().getMethod("updateById", Object.class);
            result = (Integer) method.invoke(mapper , paramMap);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            log.error("Class not find. {} ", paramMap.get("__namespace"));
            throw new BusinessException("namespace class not find.");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return SimpleResponseForm.success(result);
    }

    @ApiOperation("查询数据")
    @PostMapping("/db/select_by_id")
    public SimpleResponseForm<Integer> dbSelectById(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
        checkAuth(request);
        Preconditions.checkArgument(StrUtil.isNotBlank(String.valueOf(paramMap.get("__namespace"))), "namespace is required.");
        Preconditions.checkArgument(StrUtil.isNotBlank(String.valueOf(paramMap.get("id"))), "id is required.");
        String namespace = String.valueOf(paramMap.remove("__namespace"));

        String statement = namespace + ".selectById";
        return SimpleResponseForm.success(sessionTemplate.selectOne(statement, paramMap.get("id")));
    }

    private void checkAuth(HttpServletRequest request) {
        String authValue = request.getHeader(HEADER_AUTH_KEY);
        Preconditions.checkArgument(StrUtil.isNotBlank(authValue), HEADER_AUTH_KEY + "can not be empty.");
        Preconditions.checkArgument(authValue.equals(AppHelpProperties.getAuth()), HEADER_AUTH_KEY + "is valid, please check.");
    }
}
