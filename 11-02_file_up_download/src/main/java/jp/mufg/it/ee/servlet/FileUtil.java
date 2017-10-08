package jp.mufg.it.ee.servlet;

import javax.servlet.http.Part;

public class FileUtil {
    public static String getFileName(Part part) {
        String partHeader = part.getHeader("Content-Disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1)
                        .trim().replace("\"", "");
            }
        }
        return null;
    }
}