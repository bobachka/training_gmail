package by.helmes.gmail.core;

import by.helmes.gmail.core.utils.IOUtils;

public class FrameworkCore {

    private static String fileName;
    public static String browser;
    public static String baseUrl;
    public static String sampleText;
    public static String login;
    public static String password;

    private static boolean isInit;


    public static void init(String fileName) {
        if (!isInit) {
            FrameworkCore.fileName = fileName;
            browser = IOUtils.loadGenericProperty("browser", fileName);
            baseUrl = IOUtils.loadGenericProperty("baseUrl", fileName);
            sampleText = IOUtils.loadGenericProperty("sampleText", fileName);
            login = IOUtils.loadGenericProperty("login", fileName);
            password = IOUtils.loadGenericProperty("password", fileName);
            isInit = true;
        }
    }


}
