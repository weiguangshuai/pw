package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.dao.SoftWareDao;
import com.cqupt.project.entity.SoftWare;
import com.cqupt.project.entity.User;
import com.cqupt.project.service.SoftWareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author weigs
 * @date 2018/3/24 0024
 */
@Service
public class SoftWareServiceImpl implements SoftWareService {

    private static final Logger log = LoggerFactory.getLogger(SoftWareServiceImpl.class);

    @Autowired
    private SoftWareDao softWareDao;

    //保存上传软件
    @Override
    public Result saveSoftware(SoftWare softWare) {
        int result = softWareDao.saveSoftware(softWare);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("未上传成功，请重新上传");
    }

    //更新软件相关内容
    @Override
    public Result updateSoftware(SoftWare softWare) {
        int result = softWareDao.updateSoftware(softWare);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("更新失败，请重试");
    }

    //删除软件相关内容
    @Override
    public Result deleteSoftware(int softwareId) {
        int result = softWareDao.deleteSoftware(softwareId);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("删除失败，请重试");
    }

    //获取用户上传的所有软件
    @Override
    public Result<List<SoftWare>> getByUserId(int userId) {
        List<SoftWare> softWareList = softWareDao.selectByUserId(userId);
        if (softWareList != null || softWareList.size() > 0) {
            return Result.success(softWareList);
        }
        return Result.error("上传失败，请重试");
    }

    //根据软件id查询软件信息
    @Override
    public Result<SoftWare> getBySoftwareId(int softwareId) {
        SoftWare softWare = softWareDao.selectBySoftwareId(softwareId);
        if (softWare != null) {
            return Result.success(softWare);
        }
        return Result.error("未找到相关软件");
    }

    //根据软件名查找软件
    @Override
    public Result<List<SoftWare>> getBySoftwareName(String softwareName) {
        List<SoftWare> softWareList = softWareDao.selectBySoftwareName(softwareName);
        if (softWareList != null || softWareList.size() > 0) {
            return Result.success(softWareList);
        }
        return Result.error("未找到相关软件");
    }

    //上传文件
    @Transactional
    @Override
    public Result<String> uploadFile(MultipartFile file, String path, SoftWare softWare) {
        String filename = file.getOriginalFilename();
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File uploadFile = new File(path, filename);
        try {
            file.transferTo(uploadFile);
            //todo
            softWare.setPath(uploadFile.getPath());
            softWareDao.saveSoftware(softWare);
//            FTPUtil.uploadFile("file", Lists.newArrayList(uploadFile));
//            uploadFile.delete();
        } catch (IOException e) {
            log.error("上传文件错误", e);
            return Result.error("上传失败");
        }
        return Result.success(uploadFile.getPath());
    }
}
