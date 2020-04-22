package jp.mufg.it.ee.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {

    @Inject
    private FileProcessorBean fileProcessorBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer fileId = Integer.parseInt(request.getParameter("fileId"));

        FileInfo fileInfo = fileProcessorBean.downloadFile(fileId);
        String fileName = fileInfo.getFileName();
        String contentType = fileInfo.getContentType();
        InputStream is = fileInfo.getFileStream();

        // ファイル名をURLエンコードする
        String downloadFileName = URLEncoder.encode(fileName, "UTF-8");

        // HTTPヘッダにファイル名を設定する
        response.setHeader("Content-Disposition", "attachment; filename="
                + downloadFileName);

        // HTTPヘッダにMIMEタイプを設定する
        response.setContentType(contentType);

        BufferedInputStream bis = null;
        ServletOutputStream sos = null;

        try {
            // ファイル本体をServletOutputStreamに出力する
            bis = new BufferedInputStream(is); // isは入力ストリーム
            sos = response.getOutputStream();
            byte[] buf = new byte[50];
            int size;
            while ((size = bis.read(buf, 0, buf.length)) != -1) {
                sos.write(buf, 0, size);
            }
        } catch(IOException ioe) {
            // 例外処理
            throw new RuntimeException(ioe);
        } finally {
            // リソースのクローズ処理
        }
    }
}