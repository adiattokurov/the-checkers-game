package checkersgame.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    private WebDriver driver;

    /**
     * This Base constructor initializes WebDriver
     * And uses Page Factory pattern to initialize WebElements.
     *
     * @param driver
     */
    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * This method navigates to game page url
     * Using BaseUrl and PageUrl interface annotation
     * And covers our first step for UI testing
     */
    public void go() {
        driver.get(ConfigProperties.getProperties("baseUrl") +
                this.getClass().getAnnotation(PageUrl.class).extention());
    }
}

