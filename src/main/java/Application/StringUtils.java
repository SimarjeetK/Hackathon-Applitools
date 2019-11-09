package Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Class is keeping all the constant Labels which are being used in the application.
 */
public class StringUtils {



    public static String LoginPage_Header ="Login Form";
    public static String Login_Form_UserName_Label="Username";
    public static String Login_Form_Password_Label="Password";
    public static String Login_Button="Log In";
    public static String RememberMe_Label="Remember Me";

    public static String Error_message_UserName_Password_Empty="Both Username and Password must be present";
    public static String Error_message_UserName_Missing="Username must be present";
    public static String Error_Message_Password_Missing="Password must be present";


    public static List<String> Transaction_Table_Headers=new ArrayList<>(Arrays.asList("STATUS","DATE","DESCRIPTION","CATEGORY","AMOUNT"));


}


