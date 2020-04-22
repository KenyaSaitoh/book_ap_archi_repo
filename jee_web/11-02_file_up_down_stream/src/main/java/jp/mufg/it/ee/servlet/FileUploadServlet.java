package jp.mufg.it.ee.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig(maxFileSize = 10000000000L)
public class FileUploadServlet extends HttpServlet {

    @Inject
    private FileProcessorBean fileProcessorBean;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Integer> fileIdList = new ArrayList<Integer>();

        for(Part part: request.getParts()){
            String fileName = part.getSubmittedFileName();
            String contentType = part.getContentType();
            InputStream is = part.getInputStream();

            System.out.println("fileName ---> " + fileName);
            System.out.println("contentType ---> " + contentType);

            // 取得したファイルと付属情報をRDBに保存する
            int fileId = fileProcessorBean.uploadFile(fileName, contentType,
                    is);

            fileIdList.add(fileId);
        }

        // 結果を画面に出力する
        PrintWriter out = response.getWriter();
        out.print("NORMAL END ---> " + fileIdList);
        out.close();
    }
}