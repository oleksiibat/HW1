import org.junit.*;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTest {

    WebDriver driver;

    @Before
    public void openBrowser() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","accept");


       //  ChromeOptions ch =new ChromeOptions();
        // ch.addArguments("start-maximized");

        driver = new ChromeDriver(caps);

    }

    @After
    public void closeBrowser() {
          driver.quit();
    }

    @Test
    public void litecartTest() {
        driver.get("http://demo.litecart.net/admin/");
        System.out.println(((HasCapabilities) driver).getCapabilities());


    }

    @Test
    public void ukrNetTest() {
     driver.get("http://ukr.net");

     System.out.println(((HasCapabilities) driver).getCapabilities());


    }


}
