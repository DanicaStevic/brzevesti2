package pages;

import org.openqa.selenium.By;

public class AdminPage extends BasePage {

  protected By dashboardLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
  protected By signaturesLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[2]/a");
  protected By categoriesLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[3]/a");
  protected By regionsLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[4]/a");
  protected By portalsLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[5]/a");
  protected By sourcesLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[6]/a");
  private By panelHeading = By.className("panel-heading");

  public DashboardPage clickOnDashboardLink() {
    webDriver.findElement(dashboardLink).click();
    return new DashboardPage();
  }

  public SignaturesPage clickOnSignaturesLink() {
    webDriver.findElement(signaturesLink).click();
    return new SignaturesPage();
  }

  public CategoriesPage clickOnCategoriesLink() {
    webDriver.findElement(categoriesLink).click();
    return new CategoriesPage();
  }

  public RegionsPage clickOnRegionsLink() {
    webDriver.findElement(regionsLink).click();
    return new RegionsPage();
  }

  public PortalsPage clickOnPortalsLink() {
    webDriver.findElement(portalsLink).click();
    return new PortalsPage();
  }

  public SourcesPage clickOnSourcesLink() {
    webDriver.findElement(sourcesLink).click();
    return new SourcesPage();
  }

  public String getPanelHeading() {
    return webDriver.findElement(panelHeading).getText();
  }
}
