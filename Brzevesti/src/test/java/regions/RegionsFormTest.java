package regions;

import base.BaseTest;
import framework.Helper;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PortalsPage;
import pages.RegionFormPage;
import pages.RegionsPage;

public class RegionsFormTest extends BaseTest {
  private RegionsPage regionsPage;
  private RegionFormPage regionFormPage;
  
  @Before
  public void setUp() {
    regionsPage = dashboardPage.clickOnRegionsLink();
    regionFormPage = regionsPage.clickOnAddButton();
  }
  
  @Test
  public void testRegionFormHeading() {
    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/regions/insert", driver.getCurrentUrl());
    assertEquals("failure - heading's doesn't match!", regionFormPage.getPanelHeading(), "Regions | Insert Region");
  }
  
  @Test
  public void testAddRegion() {
    String regionTitle = "Region-rand-" + Math.random();
    regionFormPage.addTitle(regionTitle);
    regionFormPage.clickOnSaveRegion();
    
    assertTrue("failure - after region inserted", regionsPage.getAlertMessage().equals("Region \"" +regionTitle+ "\" has been successfully saved!"));
  }
  
  @Test 
  public void testEditRegion() {
    testAddRegion();
    
    dashboardPage.clickOnRegionsLink();
    List<WebElement> rows = regionsPage.getAllRows();

    WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size() - 1));
    regionsPage.clickOnEditButton(randomRow);
    
    assertTrue("failure - Url's doesn't match", driver.getCurrentUrl().contains("http://bvtest.school.cubes.rs/admin/regions/edit/"));
    
    String regionNewTitle = "Region-new-" + Math.random();
    
    regionFormPage.addTitle(regionNewTitle);
    regionFormPage.clickOnSaveRegion();
    
    assertTrue("failure - after region edited/saved", regionsPage.getAlertMessage().equals("Region \"" +regionNewTitle+ "\" has been successfully saved!"));
  }
}
