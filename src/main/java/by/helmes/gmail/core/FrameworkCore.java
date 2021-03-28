package by.helmes.gmail.core;

import by.helmes.gmail.core.utils.IOUtils;

public class FrameworkCore {
    public static String browser;
    public static String baseUrl;
    public static String login;
    public static String password;
    private static boolean isInit;


    public static void init(String fileName) {
        if (!isInit) {
            browser = IOUtils.loadGenericProperty("browser", fileName);
            baseUrl = IOUtils.loadGenericProperty("baseUrl", fileName);
            login = IOUtils.loadGenericProperty("login", fileName);
            password = IOUtils.loadGenericProperty("password", fileName);
            isInit = true;
        }
    }
}