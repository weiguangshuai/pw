package com.cqupt.project.service;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文档接口Service
 *
 * @author weigs
 * @date 2018/3/24 0024
 */
public interface DocumentService {
    Result saveDocument(Document document);

    Result<Document> getDocByDocId(int docId);

    Result<List<Document>> getBySoftwareId(int softwareId);

    Result deleteDoc(int docId);

    Result updateDoc(Document document);

    Result<String> uploadFile(MultipartFile file, String path);
}
