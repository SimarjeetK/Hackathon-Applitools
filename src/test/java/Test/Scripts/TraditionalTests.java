package Test.Scripts;

import Application.Pages.CanvasChartPage;
import Application.Pages.HomePage;
import Application.Pages.LoginPage;
import Application.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TraditionalTests extends LoginPage {







    /**
     * @Description This Test verifies the UI for the Login Page Form to make sure all required elements are displaying
     * as expected.
     */

    @Test(priority = 0, testName = "Navigate to Login page and Verify the UI of LoginPage")
    public void verify_the_UI_of_Login_Screen(){

        log("Verify the Header of Login Page Displaying as Expected");
        Assert.assertTrue(getLoginPage_Title().getText().equals(StringUtils.LoginPage_Header));
        log("Verify that Username Label and Icon is displaying as expected");
        Assert.assertTrue(getLoginPage_UserName_Label().getText().equals(StringUtils.Login_Form_UserName_Label));
        log("Verify that Username  Icon is displaying as expected");
        Assert.assertTrue(getLoginPage_UserName_Icon().isDisplayed());
        log("Verify that Username input field is displaying as expected");
        Assert.assertTrue(getLoginPage_UserName_InputField().isDisplayed());
        log("Verify that Password Label is displaying as expected");
        Assert.assertTrue(getLoginPage_Password_Label().getText().equals(StringUtils.Login_Form_Password_Label));
        log("Verify that Password input field is displaying as expected");
        Assert.assertTrue(getLoginPage_Password_InputField().isDisplayed());
        log("Verify that Password Icon is displaying as expected");
        Assert.assertTrue(getLoginPage_Password_Icon().isDisplayed());
        log("verify that Remember Me Checkbox Label is displaying expected");
        Assert.assertTrue(getRememberMeLabel().getText().equals(StringUtils.RememberMe_Label));
        log("Verify that Remember me Check Box is Clickable");
        getRememberMeCheckBox().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(getRememberMeCheckBox().isSelected());

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
        Assert.assertTrue(getWarningMessage().getText().equals(StringUtils.Error_message_UserName_Password_Empty));

        log("Verify User see that expected warning message when password is empty and user clicks on Login Button");
        getLoginPage_UserName_InputField().sendKeys(Username);
        getLoginButton().click();
        Assert.assertTrue(getWarningMessage().getText().equals(StringUtils.Error_Message_Password_Missing));

        log("Verify User see that expected warning message when Username is empty and user clicks on Login Button");
        getLoginPage_UserName_InputField().clear();
        getLoginPage_Password_InputField().sendKeys(password);
        getLoginButton().click();
        Assert.assertTrue(getWarningMessage().getText().equals(StringUtils.Error_message_UserName_Missing));

        log("Log into the application using username and password");
        login_to_the_application(Username,password);
        HomePage homePage = new HomePage();
        log("Verify the User is on Home Screen");
        waitForVisibilityOfElement(HomePageLocators.Menu_CreditTypes);
        Assert.assertTrue(homePage.getUserInformationSection().isDisplayed());


    }




    /**
     *
     * @param Username- is registered users's Username to Login to the application
     * @param password-is registered users's Password to Login to the application
     * @Description- Verifies that Data is displayed as expected after Sorting the order in Ascending Order
     */

        @Parameters({"Username","password"})
        @Test(priority = 2, testName = "Verify the Data in Home Page Table")
        public void Verify_the_Data_Displayed_As_Expected_on_Changing_the_Sorting_Order(String Username,String password){

            log("Log into the application using username and password");
            login_to_the_application(Username,password);
            HomePage homePage = new HomePage();
            log("Verify the User is on Home Screen");
            waitForVisibilityOfElement(HomePageLocators.Menu_CreditTypes);
            Assert.assertTrue(homePage.getUserInformationSection().isDisplayed());

            log("Read the each row Data from Table where Amount is unsorted");
            List<String> Unsorted_Data=  homePage.get_the_Data_by_EachRow_From_Table();
            log("Get the Amount Column from Table");
            homePage.get_the_Data_by_EachColumn(5);

            log("Click on Amount Button");
            homePage.getAmountColumn().click();
            log("Read the each row Data from Table where Amount is unsorted");
            List<String> Sorted_Data=homePage.get_the_Data_by_EachRow_From_Table();

            log("Verify Amount Displays in Ascending order");
            List<String> Amount_Column=homePage.get_the_Data_by_EachColumn(5);
            homePage.sort_theAmount_Column_in_Ascending_Order(Amount_Column);

            log("verify the Column structure remains intact");
            List<String> Header_Values=homePage.get_the_Transactional_Table_headers();
            Assert.assertTrue(Header_Values.equals(StringUtils.Transaction_Table_Headers));
            log("Verify that each row’s data stayed intact after the sorting.");
            Assert.assertTrue(Sorted_Data.containsAll(Unsorted_Data));

            homePage.get_the_Data_by_EachColumn(5);


        }




        /**
         *
         * @param Username- is registered users's Username to Login to the application
         * @param password-is registered users's Password to Login to the application
         * @Description- Verifies the Data in the Canvas Chart
     */

    @Parameters({"Username","password"})
    @Test(priority = 3, testName = "verify the Canvas Chart Feature")
    public void Verify_the_Canvas_Chat_Featue(String Username,String password){

        log("Log into the application using username and password");
        login_to_the_application(Username,password);
        HomePage homePage = new HomePage();
        log("Verify the User is on Home Screen");
        waitForVisibilityOfElement(HomePageLocators.Menu_CreditTypes);

        homePage.getCompareExpensesFeature().click();
        CanvasChartPage canvasChartPage = new CanvasChartPage();
        log("Verify the Canvas Chart is displayed");
        Assert.assertTrue(canvasChartPage.getCanvasChart().isDisplayed());
        log("Click on Next year Button");
        canvasChartPage.getNextYearDataButton().click();
        log("Verify the Canvas Chart is displayed after adding data from next year");
        Assert.assertTrue(canvasChartPage.getCanvasChart().isDisplayed());


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
        log("Log into the application using username and password");
        login_to_the_application(Username,password);
        HomePage homePage = new HomePage();
        log("Verify Flash Image Second is displayed on Page");
        Assert.assertTrue(homePage.getFlashImage2().isDisplayed());
        log("Verify Flash Image One is displayed on Page");
        Assert.assertTrue(homePage.getFlashImage1().isDisplayed());


    }

}
