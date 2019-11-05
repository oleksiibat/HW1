package session02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork2 {

    WebDriver driver;
    int timeWait;


    @Before
    public void test() {

        driver = new ChromeDriver();
        //  timeWait = 10;

    }


    @After
    public void endTest() {
        driver.quit();
    }


    @Test
    public void homeWork2() {

        //  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ?
        driver.get("http://demo.litecart.net/");

        driver.findElement(By.xpath("/html/body/div/main/div[2]/section[3]/div/article/a/div[1]/img")).click();
        System.out.println ("test2");


    }
}