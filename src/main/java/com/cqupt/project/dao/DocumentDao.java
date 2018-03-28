package com.cqupt.project.dao;

import com.cqupt.project.entity.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author weigs
 * @date 2018/3/24 0024
 */
@Repository
public interface DocumentDao {
    int saveDoc(Document document);

    int updateDoc(Document document);

    int deleteDoc(int docId);

    Document selectByDocId(int docId);

    List<Document> selectBySoftwareId(int softwareId);
}
