package by.helmes.gmail.core.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class IOUtils {

    public static String loadGenericProperty(String key, String filename) {
        if (filename == null) {
            filename = "configuration";
        }

        Properties properties = new Properties();
        FileInputStream filePath = null;

        try {
            String filePathString = "src/main/resources/" + filename + ".properties";
            filePath = new FileInputStream(filePathString);
            properties.load(filePath);
            filePath.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}
