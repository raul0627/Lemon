package com.hexin.Dto;

/**
 * Created by Administrator on 2015/12/30.
 */
public class TransFileHead {
    // 文件名长度
    private int fileNameLength;
    // 文件路径长度
    private int filePathLength;
    // 文件名
    private String fileName;
    // 文件路径
    private String filePath;

    public int getFileNameLength() {
        return fileNameLength;
    }

    public void setFileNameLength(int fileNameLength) {
        this.fileNameLength = fileNameLength;
    }

    public int getFilePathLength() {
        return filePathLength;
    }

    public void setFilePathLength(int filePathLength) {
        this.filePathLength = filePathLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
