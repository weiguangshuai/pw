package com.cqupt.project.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * ftp工具类
 *
 * @author weigs
 * @date 2018/3/30 0030
 */
public class FTPUtil {
    private static final Logger log = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    private String ip;
    private int port;
    private String user;
    private String pass;
    private FTPClient ftpClient;

    public static boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
        log.info("开始连接ftp服务器上传文件");
        boolean result = ftpUtil.uploadFiles(remotePath, fileList);
        log.info("上传成功");
        return result;
    }


    private boolean uploadFiles(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fileInputStream = null;
        if (connectServer(ip, user, pass)) {
            try {

                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF_8");
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                for (File file : fileList) {
                    fileInputStream = new FileInputStream(file);
                    ftpClient.storeFile(file.getName(), fileInputStream);
                }
            } catch (Exception e) {
                log.error("上传文件异常", e);
                uploaded = false;
            } finally {
                fileInputStream.close();
                ftpClient.disconnect();
            }

        }
        return uploaded;
    }

    /**
     * 连接ftp服务器
     * @param ip
     * @param user
     * @param pass
     * @return
     */
    private boolean connectServer(String ip, String user, String pass) {
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pass);
        } catch (Exception e) {
            log.error("连接失败", e);
        }
        return isSuccess;

    }

    private FTPUtil(String ip, int port, String user, String pass) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}
