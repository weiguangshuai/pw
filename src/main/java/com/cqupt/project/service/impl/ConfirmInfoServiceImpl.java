package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.dao.ConfirmInfoDao;
import com.cqupt.project.entity.ConfirmInfo;
import com.cqupt.project.service.ConfirmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weigs
 * @date 2018/3/19 0019
 */
@Service
public class ConfirmInfoServiceImpl implements ConfirmInfoService {

    @Autowired
    private ConfirmInfoDao confirmInfoDao;

    //保存认证信息
    @Override
    public Result<String> saveConfirmInfo(ConfirmInfo confirmInfo) {
        int result = confirmInfoDao.saveConfirmInfo(confirmInfo);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("数据为插入成功，请重启提交");
    }

    //根据认证信息Id获取认证信息
    @Override
    public Result<ConfirmInfo> getConfirmInfoByUserId(long userId) {
        ConfirmInfo confirmInfo = confirmInfoDao.findConfirmInfo(userId);
        if (confirmInfo != null) {
            return Result.success(confirmInfo);
        }
        return Result.error("为查到认证信息");
    }

    //更新认证信息
    @Override
    public Result<String> updateConfirmInfo(ConfirmInfo confirmInfo) {
        int result = confirmInfoDao.updateConfirmInfo(confirmInfo);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("更新失败，请重试");
    }
}
