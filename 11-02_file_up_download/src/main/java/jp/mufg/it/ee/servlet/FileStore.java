package jp.mufg.it.ee.servlet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_STORE")
public class FileStore {
    private Integer fileId;
    private String fileName;
    private byte[] file;

    // 引数なしのコンストラクタ
    public FileStore() {
    }

    // コンストラクタ
    public FileStore(String fileName, byte[] file) {
        this.fileName = fileName;
        this.file = file;
    }

    // ファイル番号へのアクセサメソッド
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "FILE_ID")
    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    // ファイル名へのアクセサメソッド
    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // ファイルへのアクセサメソッド
    @Column(name = "FILE")
    @Lob
    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}