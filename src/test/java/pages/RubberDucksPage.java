package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class RubberDucksPage extends BasePage {
    static RubberDucksPage rubberDucksPage = null;
    private final By RUBBER_DUCKS_LINK = By.xpath("//nav[@id='site-menu']/ul/li[@class='category-1']/a");

    private final By DATE_BUTTON =  By.cssSelector("nav.filter :last-child");

    private final By NAME_BUTTON = By.cssSelector("nav.filter :first-child");
    private final By DUCK = By.cssSelector(".product.column.shadow.hover-light");
    public By yellowDuckPriceFilteredByDate = By.xpath("//a[@title='Yellow Duck']/div/strong");
    public By blueDuckPriceFilteredByName = By.xpath("//a[@title='Blue Duck']/div/span");
    public int expectedDucksQuantity = 5;
    public String expectedYellowDuckPriceByDate = "$18";
    public String expectedBlueDuckPriceByName = "$20";

    public RubberDucksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static RubberDucksPage getInstance(WebDriver webDriver) {
        if (rubberDucksPage == null) {
            rubberDucksPage = new RubberDucksPage(webDriver);
        }
        return rubberDucksPage;
    }

    public void clickRubberDucksLink() {
        webDriver.findElement(RUBBER_DUCKS_LINK).click();
    }
    public void clickDate() {
        webDriver.findElement(DATE_BUTTON).click();
    }
    public void clickName() {
        webDriver.findElement(NAME_BUTTON).click();
    }

    public int getDucksQuantity() {
        List<WebElement> ducksQuantity = webDriver.findElements(DUCK);
        return ducksQuantity.size();
    }

    public void checkRubberDucksLinkAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(RUBBER_DUCKS_LINK));
    }
    public void checkDateButtonAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DATE_BUTTON));
    }
    public void checkNameButtonAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(NAME_BUTTON));
    }
    public void checkDuckAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DUCK));
    }

    public void goToRubberDucks() {
        checkRubberDucksLinkAppeared();
        clickRubberDucksLink();
        checkDuckAppeared();
    }
    public void clickDateButton() {
        checkDateButtonAppeared();
        clickDate();
        checkDuckAppeared();
    }
    public void clickNameButton() {
        checkNameButtonAppeared();
        clickName();
        checkDuckAppeared();
    }

}
