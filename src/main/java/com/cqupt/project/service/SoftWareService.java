package com.cqupt.project.service;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.SoftWare;

import java.util.List;

/**
 * @author weigs
 * @date 2018/3/24 0024
 */
public interface SoftWareService {

    Result saveSoftware(SoftWare softWare);

    Result updateSoftware(SoftWare softWare);

    Result deleteSoftware(int softwareId);

    Result<List<SoftWare>> getByUserId(int userId);

    Result<SoftWare> getBySoftwareId(int softwareId);

    Result<List<SoftWare>> getBySoftwareName(String softwareName);

}
