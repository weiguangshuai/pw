package com.cqupt.project.controller;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.SoftWare;
import com.cqupt.project.service.SoftWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weigs
 * @date 2018/3/27 0027
 */
@RestController
@RequestMapping(value = "/software")
@CrossOrigin("*")
public class SoftwareController {

    @Autowired
    private SoftWareService softWareService;

    /**
     * 提交软件信息
     *
     * @param softWare
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Result saveSoftware(SoftWare softWare) {

        return softWareService.saveSoftware(softWare);
    }

    /**
     * 删除某个软件
     *
     * @param softwareId
     * @return
     */
    @RequestMapping(value = "/delete/{softwareId}", method = RequestMethod.GET)
    public Result deleteSoftware(@PathVariable("softwareId") Integer softwareId) {
        //todo 从ftp服务器上删除文件
        return softWareService.deleteSoftware(softwareId);
    }

    /**
     * 根据用户id获取软件
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public Result<List<SoftWare>> getSoftwareByUserId(@PathVariable("userId") Integer userId) {

        return softWareService.getByUserId(userId);
    }

    /**
     * 根据软件id获取软件详情
     *
     * @param sofewareId
     * @return
     */
    @RequestMapping(value = "/{softwareId}", method = RequestMethod.GET)
    public Result<SoftWare> getSoftware(@PathVariable("softwareId") Integer sofewareId) {
        return softWareService.getBySoftwareId(sofewareId);
    }


    /**
     * 根据软件名模糊搜索软件
     *
     * @param softwareName
     * @return
     */
    @RequestMapping(value = "/{softwareName}", method = RequestMethod.GET)
    public Result<List<SoftWare>> getBySoftwareName(@PathVariable("softwareName") String softwareName) {

        return softWareService.getBySoftwareName(softwareName);
    }
}
