package pages;

import framework.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
  private final By emailFieldLocator = By.name("email");
  private final By passwordFieldLocator = By.name("password");
  private final By loginButtonLocator = By.className("btn-primary");
  private final By rememberMeCheckBoxLocator = By.name("remember");

  private void setValidEmail() {
    findAndSendKeys(emailFieldLocator, Configuration.validEmail);
  }

  private void setValidPassword() {
    findAndSendKeys(passwordFieldLocator, Configuration.validPassword);
  }

  private void setEmail(String username) {
    findAndSendKeys(emailFieldLocator, username);
  }

  private void setPassword(String password) {
    findAndSendKeys(passwordFieldLocator, password);
  }

  private void clickLoginButton() {
    findAndClick(loginButtonLocator);
  }

  public void clickRememberMe() {
    findAndClick(rememberMeCheckBoxLocator);
  }

  public DashboardPage login() {
    setValidEmail();
    setValidPassword();
    clickLoginButton();
    return new DashboardPage();
  }

  public DashboardPage loginWithRememberMe() {
    setValidEmail();
    setValidPassword();
    clickRememberMe();
    clickLoginButton();
    return new DashboardPage();
  }

  public void login(String username, String password) {
    setEmail(username);
    setPassword(password);
    clickLoginButton();
  }
}
