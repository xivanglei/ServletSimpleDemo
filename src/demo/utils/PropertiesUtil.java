package demo.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Author:xianglei
 * Date: 2019-12-22 12:06
 * Description:
 */
public class PropertiesUtil {
    public static Properties loadFile(String realPath) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(realPath));
            properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
