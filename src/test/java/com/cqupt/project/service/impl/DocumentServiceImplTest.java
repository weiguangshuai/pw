package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.Document;
import com.cqupt.project.service.DocumentService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * DocumentServiceImpl Tester.
 *
 * @author weigs
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class DocumentServiceImplTest {

    @Autowired
    private DocumentService documentService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: saveDocument(Document document)
     */
    @Test
    public void testSaveDocument() throws Exception {
        Document document = new Document();
        document.setContent("天知道损有余而力不足");
        document.setSoftwareId(1000);
        document.setTitle("九阴真经");

        documentService.saveDocument(document);
    }

    /**
     * Method: getDocByDocId(int docId)
     */
    @Test
    public void testGetDocByDocId() throws Exception {
        Result<Document> document = documentService.getDocByDocId(1000);
        System.out.println(document);
    }

    /**
     * Method: getBySoftwareId(int softwareId)
     */
    @Test
    public void testGetBySoftwareId() throws Exception {
        Result<List<Document>> documentResult =
                documentService.getBySoftwareId(1000);
        System.out.println(documentResult);
    }

    /**
     * Method: deleteDoc(int docId)
     */
    @Test
    public void testDeleteDoc() throws Exception {
        documentService.deleteDoc(1001);
    }

    /**
     * Method: updateDoc(Document document)
     */
    @Test
    public void testUpdateDoc() throws Exception {
        Result<Document> document = documentService.getDocByDocId(1000);
        document.getData().setTitle("天龙");
        documentService.updateDoc(document.getData());
    }


} 
