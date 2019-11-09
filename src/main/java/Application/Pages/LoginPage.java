package Application.Pages;

import Application.Common.BaseTestPage;
import Application.StringUtils;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;


public class LoginPage extends BaseTestPage implements Locators{


    public WebElement getLoginPage_Title(){
        return  findElement(LoginPageLocators.LoginPage_Header);
    }

      /**
     @Description This will find the Username Label in Login Form
     */
    public WebElement getLoginPage_UserName_Label(){

        return findElement( LoginPageLocators.UserName_Label);
    }
    /**
     @Description This will find the Username Icon in Login Form
     */
    public WebElement getLoginPage_UserName_Icon(){

        return findElement( LoginPageLocators.UserName_Icon);
    }

    /**
     @Description This will find the Password Label in Login Form
     */
    public WebElement getLoginPage_Password_Label(){

        return findElement( LoginPageLocators.Password_Label);
    }
    /**
     @Description This will find the Password Icon in Login Form
     */
    public WebElement getLoginPage_Password_Icon(){

        return findElement( LoginPageLocators.Password_Icon);
    }

    /**
     @Description This will find the Username Input Field to enter the Username in Login Form
     */
    public WebElement getLoginPage_UserName_InputField(){

        return findElement( LoginPageLocators.UserName_InputTextField);
    }

    /**
     @Description This will find the Password Input Field to enter the Password in Login Form
     */
    public WebElement getLoginPage_Password_InputField(){

        return findElement( LoginPageLocators.Password_Input_Field);
    }

    /**
     @Description This will find the Sign On Button in Login Form
     */
    public WebElement getLoginButton(){

        return findElement( LoginPageLocators.Login_Button);
    }

    /**
     @Description This will find the Sign On Button in Login Form
     */
    public WebElement getRememberMeCheckBox(){

        return findElement( LoginPageLocators.RememberMe_CheckBox);
    }

    /**
     @Description This will find the Sign On Button in Login Form
     */
    public WebElement getRememberMeLabel(){

        return findElement( LoginPageLocators.RememberMe_Label);
    }

     public WebElement getWarningMessage(){
        return  findElement(LoginPageLocators.Warning_Alert);
    }



    /**
     @Description This method is being used to perform the login operations by sending
     Username and Password as String Arguments
     */
    public void login_to_the_application(String Username, String Password){
        log("enter the username as :: "+Username);
        getLoginPage_UserName_InputField().sendKeys(Username);
        log("enter the password as :: "+Password);
        getLoginPage_Password_InputField().sendKeys(Password);
        log("Click on the Login Button");
        getLoginButton().click();


    }
}
