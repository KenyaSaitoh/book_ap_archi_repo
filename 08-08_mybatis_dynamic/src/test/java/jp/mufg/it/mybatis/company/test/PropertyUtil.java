package jp.mufg.it.mybatis.company.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyUtil {

    private static ResourceBundle resource;
    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("db.properties");
        try {
            resource = new PropertyResourceBundle(is);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public static String getValue(String key) {
        return resource.getString(key);
    }
}
