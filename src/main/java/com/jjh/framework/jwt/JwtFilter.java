package com.jjh.framework.jwt;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.jjh.common.web.form.SimpleResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.http.HttpStatus;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  整合shiro+jwt
 *https://zhuanlan.zhihu.com/p/663925382
 *
 * @author jjh
 * @date 2019/11/25
 **/
@Slf4j
public class JwtFilter extends AccessControlFilter {

    /**
     * isAccessAllowed()判断是否携带了有效的JwtToken
     * onAccessDenied()是没有携带JwtToken的时候进行账号密码登录，登录成功允许访问，登录失败拒绝访问
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        /**
         * 1. 返回true，shiro就直接允许访问url
         * 2. 返回false，shiro才会根据onAccessDenied的方法的返回值决定是否允许访问url
         *  这里先让它始终返回false来使用onAccessDenied()方法
         */
        log.info("isAccessAllowed方法被调用");
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(JWTConstants.X_ACCESS_TOKEN);
        if (StrUtil.isBlank(token)) {
            throw new AuthenticationException("请求异常，缺少token");
        }
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request,response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 处理用户token验证失败异常
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        try {
            return super.preHandle(request, response);
        } catch (AuthenticationException e) {
            // 处理token校验异常，避免登录异常打印到控制台。
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.getWriter().print(JSONObject.toJSONString(SimpleResponseForm.error(e.getMessage())));
            return false;
        }
    }
}
