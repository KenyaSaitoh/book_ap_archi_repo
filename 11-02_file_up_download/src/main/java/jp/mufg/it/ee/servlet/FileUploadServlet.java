package jp.mufg.it.ee.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig(maxFileSize = 10 * 1024)
public class FileUploadServlet extends HttpServlet {

    @Inject
    private FileBean fileBean;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for(Part part: request.getParts()){
            String fileName = part.getSubmittedFileName();
            String contentType = part.getContentType();

            // ファイルを読み込んでByteArrayOutputStreamに出力する
            BufferedInputStream bis = null;
            ByteArrayOutputStream baos = null;
            try {
                bis = new BufferedInputStream(part.getInputStream());
                baos = new ByteArrayOutputStream();
                byte[] buf = new byte[50];
                int size;
                while ((size = bis.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, size);
                }
            } catch(IOException ioe) {
                throw new RuntimeException(ioe);
            } finally {
                baos.close();
                bis.close();
            }
            // ファイル本体（バイナリデータ）を取得する
            byte[] file = baos.toByteArray();
            // 取得したファイルと付属情報をRDBに保存する
            fileBean.uploadFile(fileName, contentType, file);
        }
    }
}