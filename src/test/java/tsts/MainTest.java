package tsts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainTest {

    WebDriver driver = null;

    @Parameters("browserName")

    @BeforeTest

    public void start(String browserName) throws MalformedURLException {

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();


        } else if (browserName.equalsIgnoreCase("remoteDriver")) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();

            URL u = new URL("http://localhost:4444/wd/hub");
            //URL u = new URL("Fill local URL");

            driver = new RemoteWebDriver(u, cap);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<String, Object>();

            prefs.put("credentials_enable_service", false);

            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-extensions");

            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        } else if (driver == null) {

            throw new IllegalStateException("Browser not found");
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterTest
    public void close() {
        driver.quit();


    }

}
