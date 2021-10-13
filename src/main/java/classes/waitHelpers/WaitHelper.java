package classes.waitHelpers;

import classes.actionClases.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper extends Actions {

    public WaitHelper(WebDriver driver) {
        super(driver);
    }

    public static void clickVisitable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    public static void clickToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.elementToBeClickable(element)));
        element.click();

    }

    public static void clickInvisibilityOf(WebElement invisible, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.invisibilityOf(invisible)));
        element.click();
    }


}

