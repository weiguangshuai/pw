package com.cqupt.project.entity;

/**
 * 产品文档表
 *
 * @author weigs
 * @date 2017/11/17 0017
 */
public class Document {
    private int docId;
    private String content;
    private int softwareId;
    private String title;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", content='" + content + '\'' +
                ", softwareId=" + softwareId +
                ", title='" + title + '\'' +
                '}';
    }
}
