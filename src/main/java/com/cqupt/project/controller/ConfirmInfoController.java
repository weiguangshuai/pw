package com.cqupt.project.controller;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.ConfirmInfo;
import com.cqupt.project.service.ConfirmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author weigs
 * @date 2018/3/28 0028
 */
@RestController
@RequestMapping(value = "/confirminfo")
@CrossOrigin("*")
public class ConfirmInfoController {

    @Autowired
    private ConfirmInfoService confirmInfoService;

    /**
     * 提交认证信息
     *
     * @param confirmInfo
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public Result submitConfirmInfo(ConfirmInfo confirmInfo) {
        return confirmInfoService.saveConfirmInfo(confirmInfo);
    }

    /**
     * 获取用户认证信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Result<ConfirmInfo> getConfirmInfo(@PathVariable("userId") Long userId) {
        return confirmInfoService.getConfirmInfoByUserId(userId);
    }

    /**
     * 更新用户认证信息
     *
     * @param confirmInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateConfirmInfo(ConfirmInfo confirmInfo) {

        return confirmInfoService.updateConfirmInfo(confirmInfo);
    }
}
