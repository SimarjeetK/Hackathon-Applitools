package Test.Scripts;

import Application.Pages.CanvasChartPage;
import Application.Pages.HomePage;
import Application.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class VisualAITests extends LoginPage {




    /**
     * @Description This Test verifies the UI for the Login Page Form to make sure all required elements are displaying
     * as expected.
     */

    @Test(priority = 0, testName = "Navigate to Login page and Verify the UI of LoginPage")
    public void verify_the_UI_of_Login_Screen(){

        log("Verify the Login Page");
        getEyes().checkWindow("Login Screen=Default Screen");

        log("Verify that Remember me Check Box is Clickable");
        getRememberMeCheckBox().click();

        getEyes().checkWindow("Login Screen- Remember Me Selected");
        getEyes().close();
    }


    /**
     *
     * @param Username- is registered users's Username to Login to the application
     * @param password-is registered users's Password to Login to the application
     * @Description- This Test verifies that User is not able to Login when one of the information or both the information are missing
     */
    @Parameters({"Username","password"})
    @Test(priority = 1,testName = "Verify Registered User can successfully able to Login to the App")
    public void verify_that_User_Experience_for_Login_feature_in_Different_conditions(String Username, String password){

        log("Verify User see that expected warning message when both Username and password are empty and user clicks on Login Button");
        getLoginButton().click();
        waitForVisibilityOfElement(LoginPageLocators.Warning_Alert);

        getEyes().checkWindow("Login Screen- Error Message when UserName and Password are Missing");

        log("Verify User see that expected warning message when password is empty and user clicks on Login Button");


        getLoginPage_UserName_InputField().sendKeys(Username);
        getLoginButton().click();
        getEyes().checkWindow("Login Screen-Error Message Password Missing");

        log("Verify User see that expected warning message when Username is empty and user clicks on Login Button");
        getLoginPage_UserName_InputField().clear();
        getLoginPage_Password_InputField().sendKeys(password);
        getLoginButton().click();
        getEyes().checkWindow("Login Screen-Error Message Username Missing");

        log("enter the username as :: "+Username);
        getLoginPage_UserName_InputField().sendKeys(Username);
        log("enter the password as :: "+password);
        getLoginPage_Password_InputField().sendKeys(password);
        getEyes().checkWindow("Login Screen: When User Enters Both UserName and Password");
        log("Click on the Login Button");
        getLoginButton().click();
        getEyes().checkWindow("Home Screen");
        getEyes().close();



    }




    /**
     *
     * @param Username- is registered users's Username to Login to the application
     * @param password-is registered users's Password to Login to the application
     * @Description- Verifies that Data is displayed as expected after Sorting the order in Ascending Order
     */

    @Parameters({"Username","password"})
    @Test
    public void Verify_the_Data_Displayed_As_Expected_on_Changing_the_Sorting_Order(String Username,String password){

        log("Log into the application using username and password");
        login_to_the_application(Username,password);
        HomePage homePage = new HomePage();
        getEyes().checkWindow("Home Screen-Unsorted Table");


        log("Read the each row Data from Table where Amount is unsorted");
        List<String> Unsorted_Data=  homePage.get_the_Data_by_EachRow_From_Table();
        log("Click on Amount Button");
        homePage.getAmountColumn().click();

        log("Verify Amount Displays in Ascending order");
        List<String> Amount_Column=homePage.get_the_Data_by_EachColumn(5);
        homePage.sort_theAmount_Column_in_Ascending_Order(Amount_Column);

        log("Read the each row Data from Table where Amount is unsorted");
        List<String> Sorted_Data=homePage.get_the_Data_by_EachRow_From_Table();
        log("Verify that each row’s data stayed intact after the sorting.");
        Assert.assertTrue(Sorted_Data.containsAll(Unsorted_Data));
        getEyes().checkWindow("Home Screen-Sorted Table");
        getEyes().close();

    }




    /**
     *
     * @param Username- is registered users's Username to Login to the application
     * @param password-is registered users's Password to Login to the application
     * @Description- Verifies the Data in the Canvas Chart
     */

    @Parameters({"Username","password"})
    @Test
    public void Verify_the_Canvas_Chat_Featue(String Username,String password){

        log("Log into the application using username and password");
        login_to_the_application(Username,password);
        HomePage homePage = new HomePage();
        getEyes().checkWindow("Home Screen");
        homePage.getCompareExpensesFeature().click();
        getEyes().checkWindow("Canvas Chart Screen with Default View of 2017 and 2018 year");
        CanvasChartPage canvasChartPage = new CanvasChartPage();
        log("Click on Next year Button");
        canvasChartPage.getNextYearDataButton().click();
        getEyes().checkWindow("Canvas Chart Screen with Data from Years, {2017,2018,2019}");
        getEyes().close();
    }


    /**
     *
     * @param Username- is registered users's Username to Login to the application
     * @param password-is registered users's Password to Login to the application
     * @param AdUrl-is the redirect url which takes the user to Flash Images in Home Screen
     * @Description- Verifies the Dynamic Flash Images
     */

    @Parameters({"Username","password","AdUrl"})
    @Test(priority = 4, testName = "verify the Dynamic Flash Images")
    public void Verify_the_Dynamic_Flash_Images(String Username,String password,String AdUrl){

        getDriver().navigate().to(AdUrl);
        getEyes().checkWindow("Navigate to Show Ad URL");
        log("Log into the application using username and password");
        login_to_the_application(Username,password);
        getEyes().checkWindow("Home Screen: Flash Images");
        getEyes().close();



    }
}
