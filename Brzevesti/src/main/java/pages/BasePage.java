package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  public static WebDriver webDriver;
  public static WebDriverWait wait;
  
  public static void setUp(WebDriver driverObject, WebDriverWait waitObject) {
    webDriver = driverObject;
    wait = waitObject;
  }
  
  protected static void findAndSendKeys(By element, String key) {
    webDriver.findElement(element).sendKeys(key);
  }
  
  protected static void findAndClick(By element) {
    webDriver.findElement(element).click();
  }
}
