package com.cqupt.project.dao;

import com.cqupt.project.entity.ConfirmInfo;
import org.springframework.stereotype.Repository;

/**
 * 上传信息认证接口DAO
 * @author weigs
 * @date 2018/3/18 0018
 */
@Repository
public interface ConfirmInfoDao {
    int saveConfirmInfo(ConfirmInfo confirmInfo);

    ConfirmInfo findConfirmInfo(Long userId);

    int updateConfirmInfo(ConfirmInfo confirmInfo);
}
