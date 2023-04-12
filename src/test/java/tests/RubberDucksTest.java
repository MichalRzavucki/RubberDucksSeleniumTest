package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTest extends BaseTest {

    @Test
    public void countDucksTest() {
        rubberDucksPage.goToRubberDucks();
        Assert.assertEquals(
                rubberDucksPage.getDucksQuantity(),
                rubberDucksPage.expectedDucksQuantity

        );
        System.out.println("Ducks found on the page: " + rubberDucksPage.getDucksQuantity());
    }

    @Test
    public void getYellowDuckPrice() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.clickDateButton();
        Assert.assertEquals(
                webDriver.findElement(rubberDucksPage.yellowDuckPriceFilteredByDate).getText(),
                rubberDucksPage.expectedYellowDuckPriceByDate
        );
        System.out.println("Yellow duck price sorted by Date: " +
                webDriver.findElement(rubberDucksPage.yellowDuckPriceFilteredByDate).getText());
    }

    @Test
    public void getBlueDuckPrice() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.clickNameButton();
        Assert.assertEquals(
                webDriver.findElement(rubberDucksPage.blueDuckPriceFilteredByName).getText(),
                rubberDucksPage.expectedBlueDuckPriceByName
        );
        System.out.println("Blue duck price sorted by Name: " +
                webDriver.findElement(rubberDucksPage.blueDuckPriceFilteredByName).getText());
    }
}
