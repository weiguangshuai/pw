package com.cqupt.project.controller;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.SoftWare;
import com.cqupt.project.service.SoftWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

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
     * 上传软件
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result uploadSoftware(MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        path = path + "/" + UUID.randomUUID();
        return softWareService.uploadSoftware(file, path);
    }

    /**
     * 删除某个软件
     *
     * @param softwareId
     * @return
     */
    @RequestMapping(value = "/delete/{softwareId}", method = RequestMethod.GET)
    public Result deleteSoftware(@PathVariable("softwareId") Integer softwareId) {
        Result<SoftWare> softwareResult = softWareService.getBySoftwareId(softwareId);
        if (softwareResult.isSuccess()) {
            SoftWare softWare = softwareResult.getData();
            String path = softWare.getPath();
            String softwareName = softWare.getSoftwareName();

        } else {
            return Result.error("参数错误");
        }
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
     * @param softwareId
     * @return
     */
    @RequestMapping(value = "/{softwareId}", method = RequestMethod.GET)
    public Result<SoftWare> getSoftware(@PathVariable("softwareId") Integer softwareId) {
        return softWareService.getBySoftwareId(softwareId);
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
