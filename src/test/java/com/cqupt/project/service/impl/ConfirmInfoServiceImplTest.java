package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.ConfirmInfo;
import com.cqupt.project.service.ConfirmInfoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ConfirmInfoServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ConfirmInfoServiceImplTest {

    @Autowired
    private ConfirmInfoService confirmInfoService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: saveConfirmInfo(ConfirmInfo confirmInfo)
     */
    @Test
    public void testSaveConfirmInfo() throws Exception {
        ConfirmInfo confirmInfo = new ConfirmInfo();
        confirmInfo.setUserId(1000);
        confirmInfo.setAddress("广州市天河区");
        confirmInfo.setEmail("2740182109@qq.com");
        confirmInfo.setName("weigs");
        confirmInfo.setPhone("18883994369");

        Result result = confirmInfoService.saveConfirmInfo(confirmInfo);
        System.out.println(result);

    }

    /**
     * Method: getConfirmInfoByUserId(int userId)
     */
    @Test
    public void testGetConfirmInfoByUserId() throws Exception {
        Result<ConfirmInfo> confirmInfo =
                confirmInfoService.getConfirmInfoByUserId(1000);
        Gson gson = new Gson();
        String result = gson.toJson(confirmInfo);
        System.out.println(result);
    }

    /**
     * Method: updateConfirmInfo(ConfirmInfo confirmInfo)
     */
    @Test
    public void testUpdateConfirmInfo() throws Exception {
        Result<ConfirmInfo> confirmInfo =
                confirmInfoService.getConfirmInfoByUserId(1000);
        ConfirmInfo confirmInfo1 = confirmInfo.getData();
        confirmInfo1.setAddress("广州市天河区");
        confirmInfoService.updateConfirmInfo(confirmInfo1);
    }


} 
