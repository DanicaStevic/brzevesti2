package regions;

import base.BaseTest;
import framework.Helper;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.PortalsPage;
import pages.RegionsPage;

public class RegionsTest extends BaseTest {
  
  protected RegionsPage regionsPage;

  @Before
  public void setUp() {
    regionsPage = dashboardPage.clickOnRegionsLink();
  }

  @Test
  public void testRegionsLink() {
    regionsPage.clickOnRegionsLink();

    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
    assertTrue("failure - heading's doesn't match!", regionsPage.getPanelHeading().contains("Regions"));
  }

  @Test
  public void testDashboardLink() {
    DashboardPage dashboardPage2 = regionsPage.clickOnDashboardLink();

    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
    assertEquals("failure - heading's doesn't match!", "Dashboard", dashboardPage2.getPanelHeading());
  }

  @Test
  public void testPortalsLink() {
    PortalsPage portalsPage = regionsPage.clickOnPortalsLink();

    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
    assertTrue("failure - heading's doesn't match!", portalsPage.getPanelHeading().contains("Portals"));
  }

  @Test
  public void testDeleteFirstRegion() {
    String regionToBeDeleted = regionsPage.deleteFirstRegion();
    Assume.assumeTrue(regionToBeDeleted != "");

    assertTrue("failure - after delete wrong message", regionsPage.getAlertMessage().contains("has been successfully deleted"));
    assertTrue("failure - wrong region deleted", regionsPage.getAlertMessage().contains(regionToBeDeleted));
  }

  @Test
  public void testDeleteLastRegion() {
    String regionToBeDeleted = regionsPage.deleteLastRegion();
    Assume.assumeTrue(regionToBeDeleted != "");

    assertTrue("failure - after delete wrong message", regionsPage.getAlertMessage().contains("has been successfully deleted"));
    assertTrue("failure - wrong region deleted", regionsPage.getAlertMessage().contains(regionToBeDeleted));
  }

  @Test
  public void testDeleteRandomRegion() {
    String regionToBeDeleted = regionsPage.deleteRandomRegion();
    Assume.assumeTrue(regionToBeDeleted != "");

    assertTrue("failure - after delete wrong message", regionsPage.getAlertMessage().contains("has been successfully deleted"));
    assertTrue("failure - wrong region deleted", regionsPage.getAlertMessage().contains(regionToBeDeleted));
  }
  
  @Test
  public void testRegionAddUrl() {
    regionsPage.clickOnAddButton();
    
    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/regions/insert", driver.getCurrentUrl());
  }
  
  @Test 
  public void testRegionStatusChange() {
    List<WebElement> rows = regionsPage.getAllRows();

    WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size() - 1));
    String oldRandowRowStatus = regionsPage.getRowStatusText(randomRow);
    
    regionsPage.clickOnStatusButton(randomRow);
    regionsPage.confirmStatus();
    
      assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
      
    if (oldRandowRowStatus.equals("D")) {
      assertTrue("failure - after status change wrong message", regionsPage.getAlertMessage().contains("has been enabled")); 
    }
    
    if (oldRandowRowStatus.equals("E")) {
      assertTrue("failure - after status change wrong message", regionsPage.getAlertMessage().contains("has been disabled"));
    }
  }
}
