package com.jjh.business.system.record.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.jjh.business.system.record.mapper.OnlineLogMapper;
import com.jjh.business.system.record.model.OnlineLog;
import com.jjh.business.system.record.service.OnlineLogService;
import com.jjh.business.system.user.mapper.SysUserMapper;
import com.jjh.business.system.user.model.SysUser;
import com.jjh.common.exception.BusinessException;
import com.jjh.common.key.CacheConstants;
import com.jjh.common.util.IdGenerateHelper;
import com.jjh.common.util.PojoUtils;
import com.jjh.common.util.request.RequestUtils;
import com.jjh.common.web.form.PageRequestForm;
import com.jjh.framework.redis.RedisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 在线日志 服务层实现
 *
 * @author jjh
 * @date 2021/05/13
 */
@Service
public class OnlineLogServiceImpl implements OnlineLogService {

    @Resource
    private OnlineLogMapper onlineLogMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private RedisRepository redisRepository;


    /**
     * 查询在线日志列表
     *
     * @param form 查询条件
     * @return 在线日志集合
     */
    @Override
    public List<OnlineLog> list(PageRequestForm<OnlineLog> form) {
        return onlineLogMapper.selectList(form.pageWrapper());
    }

    /**
     * 查询在线用户列表
     *
     * @param form 查询条件
     * @return 在线日志集合
     */
    @Override
    public List<OnlineLog> listOnline(PageRequestForm form) {
        Set<Object> onlineList = redisRepository.zSetRange(
                CacheConstants.SYS_USER_TOKEN, (long) (form.getPageNum() - 1) * form.getPageSize(), form.getPageSize());
        form.setTotal(redisRepository.zSetSize(CacheConstants.SYS_USER_TOKEN));
        ArrayList<OnlineLog> resultList = new ArrayList<>(onlineList.size());
        for (Object o : onlineList) {
            OnlineLog onlineLog = (OnlineLog) o;
            onlineLog.setSysUserName(sysUserMapper.selectById(onlineLog.getUserId()).getUsername());
            resultList.add(onlineLog);
        }
        return resultList;
    }

    /**
     * 新增在线日志对象
     *
     * @param entity 待新增对象
     * @return 在线日志对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public OnlineLog add(OnlineLog entity) {
        entity.setId(IdGenerateHelper.nextId());
        onlineLogMapper.insert(entity);
        return entity;
    }

    /**
     * 新增在线日志对象
     *
     * @param sysUser 用户信息
     * @param request 请求信息
     * @return 在线日志对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public OnlineLog add(SysUser sysUser, HttpServletRequest request) {
        OnlineLog onlineLog = new OnlineLog();
        onlineLog.setId(IdGenerateHelper.nextId());
        onlineLog.setUserId(sysUser.getId());
        onlineLog.setToken(sysUser.getToken());
        onlineLog.setLoginTime(new Date());
        onlineLog.setBrowser(RequestUtils.currentRequestIP());
        onlineLogMapper.insert(onlineLog);
        return onlineLog;
    }

    /**
     * 更新在线日志对象
     *
     * @param entity 待更新对象
     * @return 在线日志对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public OnlineLog update(OnlineLog entity) {
        OnlineLog oldEntity = onlineLogMapper.selectById(entity.getId());
        if (oldEntity == null) {
            throw new BusinessException("对象不存在，请检查");
        }
        //对象属性复制
        PojoUtils.copyPropertiesIgnoreNull(entity, oldEntity);
        onlineLogMapper.updateById(oldEntity);
        return oldEntity;
    }

    /**
     * 删除在线日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean del(String ids) {
        onlineLogMapper.deleteBatchIds(CollectionUtil.toList(ids.split(",")));
        return true;
    }

}
