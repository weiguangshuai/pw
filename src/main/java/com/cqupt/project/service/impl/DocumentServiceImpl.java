package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.dao.DocumentDao;
import com.cqupt.project.entity.Document;
import com.cqupt.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weigs
 * @date 2018/3/24 0024
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    //保存文档
    @Override
    public Result saveDocument(Document document) {
        int result = documentDao.saveDoc(document);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("保存文档失败");
    }

    //根据文档id查询
    @Override
    public Result<Document> getDocByDocId(int docId) {
        Document document = documentDao.selectByDocId(docId);
        if (document != null) {
            return Result.success(document);
        }
        return Result.error("未查询到数据");
    }

    //查询某个软件的所有文档
    @Override
    public Result<List<Document>> getBySoftwareId(int softwareId) {
        List<Document> documentList =
                documentDao.selectBySoftwareId(softwareId);
        if (documentList != null || documentList.size() > 0) {
            return Result.success(documentList);
        }
        return Result.error("为查询出数据");
    }

    //删除某个文档
    @Override
    public Result deleteDoc(int docId) {
        int result = documentDao.deleteDoc(docId);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("未删除成功，请重试");
    }

    //更新文档内容
    @Override
    public Result updateDoc(Document document) {
        int result = documentDao.updateDoc(document);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("文档更新失败，请重试");
    }
}
