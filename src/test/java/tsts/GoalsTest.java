package tsts;

import classes.LoginPage;
import org.testng.annotations.Test;

public class GoalsTest extends MainTest {
    String goalURL = ("https://largeaccounttest.eleapdev.com/apm/goals");

    @Test
    void signeIn() {
        driver.get(goalURL);
        LoginPage loginPage;
        loginPage = new LoginPage(driver);
        loginPage.fillEmail();
        loginPage.fillPass();
        loginPage.clickLoginButton();
        System.out.println("ok");

    }



    }



