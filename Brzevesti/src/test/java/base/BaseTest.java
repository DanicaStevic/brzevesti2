package base;

import framework.Configuration;
import pages.*;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

  protected static WebDriver driver;
  protected static WebDriverWait wait;
  protected static DashboardPage dashboardPage;

  @BeforeClass
  public static void setUpClass() throws IOException {
    Configuration.load();
    
    System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 5);
    driver.get(Configuration.adminLoginUrl);
    driver.manage().window().maximize();

    BasePage.setUp(driver, wait);
    
    LoginPage loginPage = new LoginPage();
    dashboardPage = loginPage.login();
  }

  @AfterClass
  public static void tearDownClass() throws InterruptedException {
    driver.quit();
  }
}
