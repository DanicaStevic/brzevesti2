package categories;

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
import pages.CategoryFormPage;
import pages.CategoriesPage;

public class CategoriesFormTest extends BaseTest {
  private CategoriesPage categoriesPage;
  private CategoryFormPage categoryFormPage;
  
  @Before
  public void setUp() {
    categoriesPage = dashboardPage.clickOnCategoriesLink();
    categoryFormPage = categoriesPage.clickOnAddButton();
  }
  
  @Test
  public void testCategoryFormHeading() {
    assertEquals("failure - Url's doesn't match", "http://bvtest.school.cubes.rs/admin/categories/insert", driver.getCurrentUrl());
    assertEquals("failure - heading's doesn't match!", categoryFormPage.getPanelHeading(), "Categories | Insert Category");
  }
  
  @Test
  public void testAddCategory() {
    String categoryTitle = "Category-rand-" + Math.random();
    categoryFormPage.addTitle(categoryTitle);
    categoryFormPage.clickOnSaveCategory();
    
    assertTrue("failure - after category inserted", categoriesPage.getAlertMessage().equals("Category \"" +categoryTitle+ "\" has been successfully saved!"));
  }
  
  @Test 
  public void testEditCategory() {
    testAddCategory();
    
    dashboardPage.clickOnCategoriesLink();
    List<WebElement> rows = categoriesPage.getAllRows();

    WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size() - 1));
    categoriesPage.clickOnEditButton(randomRow);
    
    assertTrue("failure - Url's doesn't match", driver.getCurrentUrl().contains("http://bvtest.school.cubes.rs/admin/categories/edit/"));
    
    String categoryNewTitle = "Category-new-" + Math.random();
    
    categoryFormPage.addTitle(categoryNewTitle);
    categoryFormPage.clickOnSaveCategory();
    
    assertTrue("failure - after category edited/saved", categoriesPage.getAlertMessage().equals("Category \"" +categoryNewTitle+ "\" has been successfully saved!"));
  }
}
