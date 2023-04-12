package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.RubberDucksPage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    private final String HOME_PAGE = "https://litecart.stqa.ru/en/";
    WebDriver webDriver;
    LoginPage loginPage;
    RubberDucksPage rubberDucksPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));

        loginPage = LoginPage.getInstance(webDriver);
        rubberDucksPage = RubberDucksPage.getInstance(webDriver);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        webDriver.get(HOME_PAGE);
    }

    @AfterTest
    public void teardown() {
        webDriver.quit();
    }
}
