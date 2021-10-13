package classes.actionClases;

import classes.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Actions extends BasePage {
    public Actions(WebDriver driver) {
        super(driver);
    }


    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight));");
    }

    static void scrollDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    static void scrollHorizontal() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");

    }

    static void alertMethod() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    static void hoverEffect(WebElement element) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);
        action.moveToElement(element).moveToElement(element).build().perform();
    }

    static void selectMethod(WebElement element, int name) {
        Select select = new Select(element);
        select.selectByIndex(name);
    }


}
