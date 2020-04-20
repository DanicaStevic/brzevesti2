package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryFormPage extends AdminPage {
  private final By titleSelector = By.id("title");
  private final By saveButtonSelector = By.id("save-category-button");
  
  public void addTitle(String title) {
    WebElement titleField = webDriver.findElement(titleSelector); 
    titleField.clear();
    titleField.sendKeys(title);
  }
  
  public CategoriesPage clickOnSaveCategory() {
    webDriver.findElement(saveButtonSelector).click();
    return new CategoriesPage();
  }
}
