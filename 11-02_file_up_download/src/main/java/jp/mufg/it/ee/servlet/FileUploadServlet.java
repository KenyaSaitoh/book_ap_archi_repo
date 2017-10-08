package jp.mufg.it.ee.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        for(Part part: request.getParts()){
            String contentType = part.getContentType();
            String fileName = part.getSubmittedFileName();
            // String fileName = FileUtil.getFileName(part);
            long fileSize = part.getSize();

            System.out.println("contentType ---> " + contentType);
            // System.out.println("name ---> " + name);
            System.out.println("fileName ---> " + fileName);
            System.out.println("size ---> " + fileSize);

            // GlassFishの場合、C:\Java\glassfish4\glassfish\domains\domain1\configの下に出力される模様
            File outputFile = new File(fileName);
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(part.getInputStream());
                bos = new BufferedOutputStream(new FileOutputStream(outputFile));
                byte[] buf = new byte[50];
                int size;
                while ((size = bis.read(buf, 0, buf.length)) != -1) {
                    bos.write(buf, 0, size);
                }
            } catch(IOException ioe) {
                throw new RuntimeException(ioe);
            } finally {
                bos.close();
                bis.close();
            }
        }
    }
}