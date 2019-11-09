package Application.Common;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.Eyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

public class BaseTestPage {


  private WebDriver driver;
    private EyesRunner runner;
    private Eyes eyes;
    protected static BatchInfo batch;

   public String APPLITOOLS_API_KEY="gZon3XpUVhhvnHh972vEXHTUdfUTrtOeljEsvfjhlvFc110";



    /**
     *
     * @return therad safe driver
     */
    protected WebDriver getDriver(){

         driver= WebDriverBaseTest.getInstance().getDriver();
         return driver;
     }


    protected Eyes getEyes(){
        eyes= EyesRunnerTest.getInstance().getEyes();
        return eyes;
    }
    @BeforeClass
    public static void setBatch() {
        // Must be before ALL tests (at Class-level)
        batch = new BatchInfo("Demo batch");
    }


    /**
     * This function will run before every Test Method to get the Therad safe Driver and will launch the Website
     */
    @Parameters({"Application_URL","Testapproach"})
    @BeforeMethod
    public void init(String Application_URL, Method method,String Testapproach) {

        System.out.println("I am in Before Method");

        eyes=getEyes();

        // Set your personal Applitols API Key from your environment variables.
        System.out.println("API Key is::"+ APPLITOOLS_API_KEY);
        eyes.setApiKey(APPLITOOLS_API_KEY);

        // set batch name
        eyes.setBatch(batch);
        driver =getDriver();
        if (Testapproach.equalsIgnoreCase("VisualAI")){

            driver=eyes.open(driver, "Demo App- Applitools Hackathon", method.getName());
        }
        driver.manage().window().fullscreen();
        driver.get(Application_URL);


    }


    /**
     * This will run after every Test Method
     */
    @AfterMethod()
    @Parameters("Testapproach")
    public void close( String Testapproach){
        System.out.println("I am in After Method");
    }

    /**
     * Once the Test Execution is complete, it will quite the driver.
     */
    @AfterSuite()
    @Parameters("Testapproach")
    public void tearDown( String Testapproach){

         System.out.println("Quit the driver");  driver.quit();
        // If the test was aborted before eyes.close was called, ends the test as
        // aborted.
        if (Testapproach.equalsIgnoreCase("VisualAI"))eyes.abortIfNotClosed();


    }

    /**
     * Duynamic wait is introduced to validate the Visibility of elements on Screen
      * @param locator is being defined in Locator class
     */
    public void  waitForVisibilityOfElement(By locator) {

        System.out.println("Waiting for the presence of "+locator);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * This will help the driver to perform  findElement API Call
     * @param Locator
     * @return the Locator value which is defined in Locator class
     */
    public WebElement findElement(By Locator){

       return getDriver().findElement(Locator);
    }


    public List<WebElement> findElements(By Locator) {
        return this.getDriver().findElements(Locator);
    }

    /**
     * add logs into testng reports.
     *
     * @param message
     */
    protected static void log(String message) {
        Reporter.log(message + "<br/>");


    }
}
