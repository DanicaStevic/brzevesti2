package pages;

import framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static pages.BasePage.wait;
import static pages.BasePage.webDriver;

public class CategoriesPage extends AdminPage {

  private By tableRow = By.tagName("tr");
  private By resultsTable = By.xpath("//*[@id=\"categoriesTable\"]/tbody"); //Zasto /tbody?
  private final By addCategoryLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[1]/a");
  private final By editCategoryLocation = By.xpath("//*[@id=\"\"]/tbody/tr[1]/td[5]/div/a");
  private By alertBox = By.className("alert");
  private By confirmDeleteButton = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]");
  private By confirmStatusButton = By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]");
  private By statusButtonLocator = By.xpath(".//td[5]/div/button[1]");
  private By statusTextLocator = By.xpath(".//td[4]/span");
  
  public List<WebElement> getAllRows() {
    if (!webDriver.findElements(tableRow).isEmpty()) {
      WebElement table = webDriver.findElement(resultsTable);
      return table.findElements(tableRow);
    }

    return new ArrayList<>();
  }
  

  public String deleteFirstCategory() {
    List<WebElement> rows = this.getAllRows();
    if (rows.size() == 0) {
      return "";
    }

    WebElement firstRow = rows.get(0);
    String category = this.getCategoryFromRow(firstRow);
    this.clickOnDeleteButton(firstRow);
    this.confirmDelete();
    return category;
  }

  public String deleteLastCategory() {
    List<WebElement> rows = this.getAllRows();
    if (rows.size() == 0) {
      return "";
    }

    WebElement lastRow = rows.get(rows.size() - 1);
    String category = this.getCategoryFromRow(lastRow);
    this.clickOnDeleteButton(lastRow);
    this.confirmDelete();

    return category;
  }

  public String deleteRandomCategory() {
    List<WebElement> rows = this.getAllRows();
    if (rows.isEmpty()) {
      return "";
    }

    WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size() - 1));
    String category = this.getCategoryFromRow(randomRow);
    this.clickOnDeleteButton(randomRow);
    this.confirmDelete();

    return category;
  }

  public String getAlertMessage() {
    return webDriver.findElement(alertBox).getText();
  }

  private String getCategoryFromRow(WebElement row) {
    return row.findElement(By.xpath(".//td[3]")).getText();
  }

  private void clickOnDeleteButton(WebElement row) {
    row.findElement(By.xpath(".//td[5]/div/button[2]")).click();
  }
  
  public CategoryFormPage clickOnEditButton(WebElement row) {
    row.findElement(By.xpath(".//td[5]/div/a")).click();
    return new CategoryFormPage();
  }
  
  public CategoryFormPage clickOnAddButton() {
    webDriver.findElement(addCategoryLocator).click();
    return new CategoryFormPage();
  }

  private void confirmDelete() {
    wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
  }
  
  public CategoriesPage clickOnStatusButton(WebElement row) {
    row.findElement(statusButtonLocator).click();
    return new CategoriesPage();
  }
  
  public void confirmStatus() {
    wait.until(ExpectedConditions.elementToBeClickable(confirmStatusButton)).click();
  }
  
  public String getRowStatusText(WebElement row) {
    return row.findElement(statusTextLocator).getText();
  }
}
