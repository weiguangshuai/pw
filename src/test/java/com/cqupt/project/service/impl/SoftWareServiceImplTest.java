package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.SoftWare;
import com.cqupt.project.service.SoftWareService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * SoftWareServiceImpl Tester.
 *
 * @author weigs
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class SoftWareServiceImplTest {

    @Autowired
    private SoftWareService softWareService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: saveSoftware(SoftWare softWare)
     */
    @Test
    public void testSaveSoftware() throws Exception {
        SoftWare softWare = new SoftWare();
        softWare.setIntroduction("基因分析的软件");
        softWare.setPath("/home/file");
        softWare.setSoftwareName("基因帮");
        softWare.setUserId(103);

        softWareService.saveSoftware(softWare);
    }

    /**
     * Method: updateSoftware(SoftWare softWare)
     */
    @Test
    public void testUpdateSoftware() throws Exception {
        SoftWare softWare = new SoftWare();
        softWare.setIntroduction("基因分析的软件");
        softWare.setPath("/home/file");
        softWare.setSoftwareName("基因组棒");
        softWare.setSoftwareId(1002);
        softWare.setUserId(103);

        softWareService.updateSoftware(softWare);
    }

    /**
     * Method: deleteSoftware(int softwareId)
     */
    @Test
    public void testDeleteSoftware() throws Exception {
        softWareService.deleteSoftware(1001);
    }

    /**
     * Method: getByUserId(int userId)
     */
    @Test
    public void testGetByUserId() throws Exception {
        Result<List<SoftWare>> listResult = softWareService.getByUserId(103);
        System.out.println(listResult);
    }

    /**
     * Method: getBySoftwareId(int softwareId)
     */
    @Test
    public void testGetBySoftwareId() throws Exception {
    }

    /**
     * Method: getBySoftwareName(String softwareName)
     */
    @Test
    public void testGetBySoftwareName() throws Exception {
    }


} 
