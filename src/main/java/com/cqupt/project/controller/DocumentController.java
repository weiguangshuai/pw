package com.cqupt.project.controller;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.Document;
import com.cqupt.project.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author weigs
 * @date 2018/3/26 0026
 */
@RestController
@RequestMapping(value = "/document")
//@CrossOrigin("*")
public class DocumentController {

    private static final Logger log = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentService documentService;

    /**
     * 保存文档
     *
     * @param document
     * @return
     */
    @RequestMapping(value = "/submit")
    public Result submitDoc(Document document) {
        return documentService.saveDocument(document);
    }


    /**
     * 修改文档内容
     *
     * @param document
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateDoc(Document document) {
        if (document == null) {
            return Result.error("请求参数错误");
        }
        return documentService.updateDoc(document);
    }

    /**
     * 根据id删除文档
     *
     * @param docId
     * @return
     */
    @RequestMapping(value = "/delete/{docId}", method = RequestMethod.GET)
    public Result deleteDoc(@PathVariable("docId") Integer docId) {
        if (docId == null) {
            return Result.error("参数错误");
        }
        return documentService.deleteDoc(docId);
    }


    /**
     * 获取文档内容
     *
     * @param docId
     * @return
     */
    @RequestMapping(value = "/{docId}", method = RequestMethod.GET)
    public Result<Document> getDoc(@PathVariable("docId") Integer docId) {

        return documentService.getDocByDocId(docId);
    }

    /**
     * 获取某个软件的所有关联文档
     *
     * @param softwareId
     * @return
     */
    @RequestMapping(value = "/list/{softwareId}", method = RequestMethod.GET)
    public Result<List<Document>> getDocList(@PathVariable("softwareId") Integer softwareId) {
        if (softwareId == null) {
            return Result.error("参数错误");
        }
        return documentService.getBySoftwareId(softwareId);
    }

    /**
     * 上传图片
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload/image", method = RequestMethod.POST)
    public Result<String> uploadImage(MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/image");
        path = path + "\\" + UUID.randomUUID().toString().replace("-", "");
        log.info("文件上传的路径为：" + path);
        return documentService.uploadFile(file, path);
    }
}
