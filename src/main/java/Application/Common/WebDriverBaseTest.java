package Application.Common;



import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Singleton Design pattern is used to create a Thread safe driver and to avoid the loss the creation of multiple drivers during Test Execution.
 */
public class WebDriverBaseTest {

    public static String Browser = "Chrome";

    private static WebDriverBaseTest Instance = new WebDriverBaseTest();

    private WebDriverBaseTest() {

    }

    public static WebDriverBaseTest getInstance() {
        return Instance;
    }


    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            WebDriver driver = null;
            if (Browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (Browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            return driver;
        }
    };


    public WebDriver getDriver() {

        return driver.get();
    }


}





