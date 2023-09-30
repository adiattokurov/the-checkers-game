package checkersgame.tests;

import checkersgame.base.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {


    protected static WebDriver driver;

    @BeforeTest
    public void setDriver() {

        ConfigProperties.initConfig();
        String browser = ConfigProperties.getProperties("browser");
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else if (browser.equals("firefox")) {
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Invalid browser specified");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }

    @AfterTest
    public void tearDown() {
        driver.close();

    }

}
