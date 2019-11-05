import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.*;


public class SeleniumIDETest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void googletest() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1024, 1000));
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div:nth-child(2) > .rc .LC20lb")).click();
        driver.findElement(By.cssSelector("h2:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(1)")).getText(), is("What is Selenium?"));
    }
}
