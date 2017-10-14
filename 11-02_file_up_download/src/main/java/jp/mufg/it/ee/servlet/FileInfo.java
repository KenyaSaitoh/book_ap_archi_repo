package jp.mufg.it.ee.servlet;

public class FileInfo {
    private Integer fileId;
    private String fileName;
    private String contentType;
    private byte[] file;

    // 引数なしのコンストラクタ
    public FileInfo() {
    }

    // コンストラクタ
    public FileInfo(Integer fileId, String fileName, String contentType,
            byte[] file) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.file = file;
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
    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}