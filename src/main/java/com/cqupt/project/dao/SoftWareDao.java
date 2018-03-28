package com.cqupt.project.dao;

import com.cqupt.project.entity.SoftWare;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author weigs
 * @date 2018/3/24 0024
 */
@Repository
public interface SoftWareDao {

    int saveSoftware(SoftWare softWare);

    int updateSoftware(SoftWare softWare);

    int deleteSoftware(int softwareId);

    List<SoftWare> selectByUserId(int userId);

    SoftWare selectBySoftwareId(int softwareId);

    List<SoftWare> selectBySoftwareName(String softwareName);
}
