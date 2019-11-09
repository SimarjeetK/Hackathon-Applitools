package Application.Pages;


import org.openqa.selenium.By;

/**
 * This interface is created to Store the application Loactors
 */
public interface Locators {



    /**
     * This is having Login Page Locators which are being used through
     * out the application Test Scripts.
     */


    interface LoginPageLocators {


        By LoginPage_Header=By.className("auth-header");
        By UserName_Icon=By.xpath("//form/div[1]/div[1]");
        By UserName_Label = By.xpath("//form/div[1]/label[1]");
        By UserName_InputTextField = By.id("username");
        By Password_Label = By.xpath("//form/div[2]/label[1]");
        By Password_Icon=By.xpath("//form/div[2]/div[1]");
        By Password_Input_Field = By.id("password");
        By Login_Button = By.id("log-in");
        By RememberMe_Label= By.className("form-check-label");
        By RememberMe_CheckBox=By.className("form-check-input");

        By Warning_Alert=By.xpath("//div[3]");


    }


    /**
     * This is having Home Page Locators which are being used through
     * out the application Test Scripts.
     */


    interface HomePageLocators {

        By Menu_CreditTypes= By.xpath("//li[1]/span[1]");
        By UserProfile_Section=By.className("logged-user-i");


        By TransactionTable_Column_Amount=By.id("amount");
        By TransactionTable_HeaderRow=By.xpath("//table[@id=\"transactionsTable\"]/thead/tr[1]");
        By TransactionalTable_HeaderColumn=By.xpath("//table[@id=\"transactionsTable\"]/thead/tr[1]/th");
        By TransactionTable_DataBody=By.xpath("//table[@id=\"transactionsTable\"]/tbody");
        By TransactionalTable_bodyRows=By.tagName("tr");
        By Compare_Expenses=By.id("showExpensesChart");


        By FlashImage1=By.xpath("//div[@class=\"element-balances\"]/div[2]/img[1]");
        By FlashImage2=By.xpath("//div[@class=\"element-balances\"]/div[4]/img[1]");


    }

    /**
     * This is having canvas Page Locators which are being used through
     * out the application Test Scripts.
     */


    interface CanvasChartLocators {

        By Next_year_data_Button= By.id("addDataset");
        By Graph_Section=By.id("canvas");


    }

}
