package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    static LoginPage loginPage = null;
    private final By EMAIL_FIELD = By.xpath("//input[@name='email']");
    private final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    private final By LOGIN_BUTTON = By.xpath("//button[@name='login']");
    private final String CORRECT_EMAIL = "michal.rzavucki@gmail.com";
    private final String CORRECT_PASSWORD = "30203050";
    private final String INCORRECT_EMAIL = "test@mail.com";
    private final String INCORRECT_PASSWORD = "sdf325fhg";
    public By successMessage = By.xpath("//div[@class='notice success']");
    public String expectedSuccessMessage = "You are now logged in as Michal Rzavucki.";
    public By errorMessage = By.xpath("//div[@class='notice errors']");
    public String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static LoginPage getInstance(WebDriver webDriver) {
        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }

    public void attemptValidLoginData() {
        webDriver.findElement(EMAIL_FIELD).sendKeys(CORRECT_EMAIL);
        webDriver.findElement(PASSWORD_FIELD).sendKeys(CORRECT_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void attemptInvalidLoginData() {
        webDriver.findElement(EMAIL_FIELD).sendKeys(INCORRECT_EMAIL);
        webDriver.findElement(PASSWORD_FIELD).sendKeys(INCORRECT_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void checkErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        System.out.println(webDriver.findElement(errorMessage).getText());
    }

    public void checkSuccessMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        System.out.println(webDriver.findElement(successMessage).getText());
    }

}
