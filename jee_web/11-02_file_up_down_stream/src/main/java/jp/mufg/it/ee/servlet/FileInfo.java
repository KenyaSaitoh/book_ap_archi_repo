package jp.mufg.it.ee.servlet;

import java.io.InputStream;

public class FileInfo {
    private Integer fileId;
    private String fileName;
    private String contentType;
    private InputStream fileStream;

    // 引数なしのコンストラクタ
    public FileInfo() {
    }

    // コンストラクタ
    public FileInfo(Integer fileId, String fileName, String contentType,
            InputStream fileStream) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileStream = fileStream;
    }

    // ファイル番号へのアクセサメソッド
    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    // ファイル名へのアクセサメソッド
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // コンテントタイプへのアクセスメソッド
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    // ファイルへのアクセサメソッド
    public InputStream getFileStream() {
        return fileStream;
    }

    public void setFileStream(InputStream fileStream) {
        this.fileStream = fileStream;
    }
}