package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        loginPage.attemptValidLoginData();
        loginPage.checkSuccessMessage();
        Assert.assertEquals(
                webDriver.findElement(loginPage.successMessage).getText(),
                loginPage.expectedSuccessMessage
        );
    }

    @Test
    public void invalidLoginTest() {
        loginPage.attemptInvalidLoginData();
        loginPage.checkErrorMessage();
        Assert.assertEquals(
                webDriver.findElement(loginPage.errorMessage).getText(),
                loginPage.expectedErrorMessage
        );
    }
}
