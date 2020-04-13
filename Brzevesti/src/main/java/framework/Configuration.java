package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
  public static String chromeDriverPath;
  public static String adminLoginUrl;
  public static String validEmail;
  public static String validPassword;
    
  public static void load() throws IOException {
    FileInputStream stream = new FileInputStream("resources/env.properties");
    Properties prop = new Properties();
    prop.load(stream);
    
    chromeDriverPath = prop.getProperty("chromeDriverPath");
    adminLoginUrl = prop.getProperty("adminLoginUrl");
    validEmail = prop.getProperty("validEmail");
    validPassword = prop.getProperty("validPassword");
  }
}
