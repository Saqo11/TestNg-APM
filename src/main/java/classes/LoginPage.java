package classes;

import classes.waitHelpers.WaitHelper;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WaitHelper {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".primary_action")
    private WebElement loginButton;

    @FindBy(css = "[name='email']")
    private WebElement fillEmail;

    @FindBy(css = "[name='password']")
    private WebElement fillPassword;

    static String decodePass(String pass) {
        byte[] decodePass = Base64.decodeBase64(pass);
        return (new String(decodePass));
    }

    public void fillEmail() {
        fillEmail.sendKeys("saqo21harutyunyan+19@gmail.com");
    }

    public void fillPass() {
        fillPassword.sendKeys(decodePass(("N3J1amQxMmY=")));
    }

    public void clickLoginButton() {
        clickToBeClickable(loginButton);
    }


}
