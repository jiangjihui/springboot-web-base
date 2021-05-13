package com.jjh.business.system.user.controller;

import com.jjh.business.system.record.model.OnlineLog;
import com.jjh.business.system.record.service.OnlineLogService;
import com.jjh.business.system.user.controller.form.LoginForm;
import com.jjh.business.system.user.model.SysUser;
import com.jjh.business.system.user.service.SysUserService;
import com.jjh.common.exception.BusinessException;
import com.jjh.common.key.CacheConstants;
import com.jjh.common.util.EncryptUtils;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.SimpleResponseForm;
import com.jjh.framework.jwt.JwtUtil;
import com.jjh.framework.redis.RedisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 登录接口
 * 参考：http://www.ityouknow.com/springboot/2017/06/26/spring-boot-shiro.html
 *
 * @author jjh
 * @date 2019/9/20
 **/
@Api(tags = "[a1010]登录管理")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private OnlineLogService onlineLogService;
    @Autowired
    private RedisRepository redisRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    /**
     * 用户登录
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public SimpleResponseForm<SysUser> login(@Valid @RequestBody LoginForm form, HttpServletRequest request) {
        String username = form.getUsername();
        String password = form.getPassword();

        SysUser sysUser = sysUserService.findByUsername(username);
        if (sysUser == null) {
            throw new BusinessException("未找到该用户，请重新再试");
        }
        String passwd = EncryptUtils.encryptPassword(username, password, sysUser.getSalt());
        if (!passwd.equals(sysUser.getPassword())) {
            throw new BusinessException("密码错误，请检查后重新再试");
        }

        // 生成token
        String sign = JwtUtil.sign(username, passwd, sysUser.getId());
        sysUser.setToken(sign);
        OnlineLog onlineLog = onlineLogService.add(sysUser, request);
        redisRepository.set(CacheConstants.SYS_USER_TOKEN, sign, onlineLog, JwtUtil.EXPIRE_TIME * 2, TimeUnit.MILLISECONDS);
        redisRepository.zSetAdd(CacheConstants.SYS_USER_TOKEN, onlineLog);

        //获取用户角色
        List<String> roleList = sysUserService.listSysRoleCode(sysUser.getId());
        // 获取用户权限
        List<String> permissionList = sysUserService.listSysPermissionCode(sysUser.getId());
        sysUser.setRoleCode(roleList);
        sysUser.setPermissionCode(permissionList);

        return success(sysUser);
    }

    /**
     * 用户注册
     * shiro中的密码是如何验证是否匹配的
     * https://blog.csdn.net/chenyidong521/article/details/80245362
     * @return
     * @throws Exception
     */
//    @ApiOperation("用户注册")
//    @PostMapping("/register")
    public SimpleResponseForm<SysUser> register(@Valid @RequestBody SysUser sysUser) throws Exception {
        SysUser user = sysUserService.add(sysUser);
        return success(user);
    }

    /**
     * 用户退出
     */
    @ApiOperation("用户退出")
    @GetMapping("/logout")
    public SimpleResponseForm<String> logout() {
        String token = JwtUtil.getToken();
        OnlineLog onlineLog = (OnlineLog) redisRepository.get(CacheConstants.SYS_USER_TOKEN, token);
        redisRepository.zSetDelete(CacheConstants.SYS_USER_TOKEN, onlineLog);
        // TODO 需要创建定时任务 定时清理界面上不再操作自动过期的用户
        redisRepository.delete(CacheConstants.SYS_USER_TOKEN, token);
        return success();
    }

}
