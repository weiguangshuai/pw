package com.cqupt.project.entity;

/**
 * 软件对应表
 *
 * @author weigs
 * @date 2018/3/24 0024
 */
public class SoftWare {
    private int softwareId;
    private String path;
    private String softwareName;
    private String introduction;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "SoftWare{" +
                "softwareId=" + softwareId +
                ", path='" + path + '\'' +
                ", softwareName='" + softwareName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", userId=" + userId +
                '}';
    }
}
