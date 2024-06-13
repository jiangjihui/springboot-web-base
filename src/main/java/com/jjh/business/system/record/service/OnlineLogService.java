package com.jjh.business.system.record.service;

import com.jjh.business.system.record.model.OnlineLog;
import com.jjh.business.system.user.model.SysUser;
import com.jjh.common.web.form.PageRequestForm;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 在线日志 服务层
 *
 * @author jjh
 * @date 2021/05/13
 */
public interface OnlineLogService {

    /**
     * 查询在线日志列表
     *
     * @param form 查询条件
     * @return 在线日志集合
     */
    List<OnlineLog> list(PageRequestForm<OnlineLog> form);

    /**
     * 查询在线用户列表
     *
     * @param form 查询条件
     * @return 在线日志集合
     */
    List<OnlineLog> listOnline(PageRequestForm form);

    /**
     * 新增在线日志对象
     *
     * @param entity 待新增对象
     * @return 在线日志对象
     */
    @Transactional(rollbackFor = Exception.class)
    OnlineLog add(OnlineLog entity);

    /**
     * 新增在线日志对象
     *
     * @param sysUser 用户信息
     * @param request 请求信息
     * @return 在线日志对象
     */
    @Transactional(rollbackFor = Exception.class)
    OnlineLog add(SysUser sysUser, HttpServletRequest request);


    /**
     * 更新在线日志对象
     *
     * @param entity 待更新对象
     * @return 在线日志对象
     */
    @Transactional(rollbackFor = Exception.class)
    OnlineLog update(OnlineLog entity);


    /**
     * 删除在线日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    boolean del(String ids);

}
