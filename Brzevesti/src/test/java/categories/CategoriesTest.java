package categories;

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
import pages.CategoriesPage;

public class CategoriesTest extends BaseTest {
  
  protected CategoriesPage categoriesPage;

  @Before
  public void setUp() {
    categoriesPage = dashboardPage.clickOnCategoriesLink();
  }

  @Test
  public void testCategoriesLink() {
    categoriesPage.clickOnCategoriesLink();

    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
    assertTrue("failure - heading's doesn't match!", categoriesPage.getPanelHeading().contains("Categories"));
  }

  @Test
  public void testDashboardLink() {
    DashboardPage dashboardPage2 = categoriesPage.clickOnDashboardLink();

    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
    assertEquals("failure - heading's doesn't match!", "Dashboard", dashboardPage2.getPanelHeading());
  }

  @Test
  public void testPortalsLink() {
    PortalsPage portalsPage = categoriesPage.clickOnPortalsLink();

    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
    assertTrue("failure - heading's doesn't match!", portalsPage.getPanelHeading().contains("Portals"));
  }

  @Test
  public void testDeleteFirstCategory() {
    String categoryToBeDeleted = categoriesPage.deleteFirstCategory();
    Assume.assumeTrue(categoryToBeDeleted != "");

    assertTrue("failure - after delete wrong message", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
    assertTrue("failure - wrong category deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
  }

  @Test
  public void testDeleteLastCategory() {
    String categoryToBeDeleted = categoriesPage.deleteLastCategory();
    Assume.assumeTrue(categoryToBeDeleted != "");

    assertTrue("failure - after delete wrong message", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
    assertTrue("failure - wrong category deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
  }

  @Test
  public void testDeleteRandomCategory() {
    String categoryToBeDeleted = categoriesPage.deleteRandomCategory();
    Assume.assumeTrue(categoryToBeDeleted != "");

    assertTrue("failure - after delete wrong message", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
    assertTrue("failure - wrong category deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
  }
  
  @Test
  public void testCategoryAddUrl() {
    categoriesPage.clickOnAddButton();
    
    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/categories/insert", driver.getCurrentUrl());
  }
  
  @Test 
  public void testCategoryStatusChange() {
    List<WebElement> rows = categoriesPage.getAllRows();

    WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size() - 1));
    String oldRandowRowStatus = categoriesPage.getRowStatusText(randomRow);
    
    categoriesPage.clickOnStatusButton(randomRow);
    categoriesPage.confirmStatus();
    
      assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
      
    if (oldRandowRowStatus.equals("D")) {
      assertTrue("failure - after status change wrong message", categoriesPage.getAlertMessage().contains("has been enabled")); 
    }
    
    if (oldRandowRowStatus.equals("E")) {
      assertTrue("failure - after status change wrong message", categoriesPage.getAlertMessage().contains("has been disabled"));
    }
  }
}
