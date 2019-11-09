package Application.Pages;

import Application.Common.BaseTestPage;
import org.openqa.selenium.WebElement;

public class CanvasChartPage extends BaseTestPage implements Locators {


    /**
     * it will return the Get the Next Year Data Button
     * @return
     */
    public WebElement getNextYearDataButton(){
        return findElement(CanvasChartLocators.Next_year_data_Button); }

    /**
     * It will return the Canvas Chart
     * @return
     */
    public WebElement getCanvasChart(){
            return findElement(CanvasChartLocators.Graph_Section);}

}
