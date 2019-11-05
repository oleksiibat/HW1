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

public class HomeWork1 {

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
    public void homeWork1() {

        //  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ?
        driver.get("http://demo.litecart.net/admin/");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> allWebElementLevel1 = driver.findElements(By.className("app"));

        for (int i = 0; i < allWebElementLevel1.size(); i++) {
            allWebElementLevel1 = driver.findElements(By.className("app"));
            allWebElementLevel1.get(i).click();
           driver.findElement(By.xpath("//div[contains(@class,'panel-heading')]"));
          //  driver.findElement(By.id("content"));
            List<WebElement> allWEbElementLevel2 = driver.findElements(By.className("doc"));
            System.out.println(allWEbElementLevel2.size());
            for (int j = 0; j < allWEbElementLevel2.size(); j++) {
                allWEbElementLevel2 = driver.findElements(By.className("doc"));
                allWEbElementLevel2.get(j).click();
               //  driver.findElement(By.id("content"));
                   driver.findElement(By.xpath("//div[contains(@class,'panel-heading')]"));
            }
        }
    }
}