package session02.parallel;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void start() {

        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        tlDriver.set(driver);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                }));
    }

}
