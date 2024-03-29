package session02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Session2Examples {

    WebDriver drv1,drv2;

    @Before
    public  void start()
    {
        drv1 = new ChromeDriver();
        drv2 = new ChromeDriver();
    }


    @Test
    public void cookieTest() {
        //driver.manage().addCookie(new Cookie("test", "test"));

        drv1.get("http://google.com");
        drv1.manage().addCookie(new Cookie("test", "test"));

        drv2.get("http://google.com");

        System.out.println("Drv1 before: " + drv1.manage().getCookies());
        System.out.println("Drv2 before: " + drv2.manage().getCookies());

        drv1.manage().addCookie(new Cookie("Security_ID", "KJILSDuf984jmmcoidshnfrdoiut98e"));
        System.out.println("Drv1 All: " + drv1.manage().getCookies());
        System.out.println("Drv1 Security_ID: " + drv1.manage().getCookieNamed("Security_ID"));

        drv1.manage().deleteCookieNamed("Security_ID");
        System.out.println("Drv1 Security_ID deleted: " + drv1.manage().getCookies());

        drv1.manage().deleteAllCookies();
        System.out.println("Drv1 delete: " + drv1.manage().getCookies());
        System.out.println("Drv2 delete: " + drv2.manage().getCookies());
    }

    @Test
    public void jsExecutor() {
        drv1.get("https://www.w3.org/");

        List<WebElement> links = (List<WebElement>) ((JavascriptExecutor) drv1)
                .executeScript("return document.getElementsByClassName('headline')");

        for (WebElement item : links) {
            System.out.println(item.getTagName());
        }

        drv2.get("http://www.google.com");

        List<WebElement> input = (List<WebElement>) ((JavascriptExecutor) drv2).executeScript("return document.getElementsByName('q')");
        input.get(0).sendKeys("webdriver");


        if(areElementsPresent(drv2, By.xpath("xxx")))
        {
            System.out.println("Element(s) found");
        }
        else
        {
            System.out.println("Element(s) not found");
        }
    }

    @After
    public void stop()
    {
        drv1.quit();
        drv2.quit();
    }



    private boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (InvalidSelectorException ex)
        {
            throw ex;
        }
        catch (NoSuchElementException ex) {
            return false;
        }
    }

    private boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
