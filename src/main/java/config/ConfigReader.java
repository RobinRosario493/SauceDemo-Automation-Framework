package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        properties = new Properties();

        try {

            FileInputStream fis = new FileInputStream(
                    "src/main/resources/config.properties");

            properties.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }
    public static String getFirstName() {
        return properties.getProperty("firstname");
    }

    public static String getLastName() {
        return properties.getProperty("lastname");
    }

    public static String getZipCode() {
        return properties.getProperty("zipcode");
    }
    

}