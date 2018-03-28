package com.cqupt.project.service;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.ConfirmInfo;

/**
 * 信息认证接口Service
 *
 * @author weigs
 * @date 2018/3/19 0019
 */
public interface ConfirmInfoService {

    Result<String> saveConfirmInfo(ConfirmInfo confirmInfo);

    Result<ConfirmInfo> getConfirmInfoByUserId(long userId);

    Result<String> updateConfirmInfo(ConfirmInfo confirmInfo);

}
