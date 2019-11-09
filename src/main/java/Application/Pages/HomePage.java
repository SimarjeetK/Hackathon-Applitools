package Application.Pages;

import Application.Common.BaseTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BaseTestPage implements Locators {


                /**
                 * It reads the Element on First Image View and returns it.
                 * @return
                 */
                public WebElement getFlashImage1(){ return findElement(HomePageLocators.FlashImage1);}

                /**
                 * It reads the Element on Second Image View and returns it.
                 * @return
                 */
                public WebElement getFlashImage2(){ return findElement(HomePageLocators.FlashImage2);}


                /**
                 * It gives the User profile section is Left Nav Menu
                  * @return
                 */
                public WebElement getUserInformationSection(){return findElement(Locators.HomePageLocators.UserProfile_Section);}

                /**
                 * It Returns the Amount Column Header
                 * @return
                 */
                public WebElement getAmountColumn(){ return findElement(HomePageLocators.TransactionTable_Column_Amount);}

                /**
                 * It locates the Compare Expense feature in Top Nav Bar
                 * @return
                 */
                public WebElement getCompareExpensesFeature(){ return findElement(HomePageLocators.Compare_Expenses);}


                                    /**
                                     *  It reads the Table Column Headers and return it's Values
                                     * @return
                                     */
                                    public List<String> get_the_Transactional_Table_headers(){

                                        List<String> Columns_Header= new ArrayList<>();
                                        int Header_rows =findElements(HomePageLocators.TransactionTable_HeaderRow).size();
                                        int Coloum_Numbers=findElements(HomePageLocators.TransactionalTable_HeaderColumn).size();


                                        System.out.println("No of Rows::"+Header_rows+"\n"+"No of Columns::"+ Coloum_Numbers);

                                        for(int i=0;i<Coloum_Numbers;i++){

                                            String Column_Name= findElements(HomePageLocators.TransactionalTable_HeaderColumn).get(i).getText();
                                            Columns_Header.add(Column_Name);
                                        }

                                        System.out.println("Headers are ::"+Columns_Header);

                                        return Columns_Header;
                                    }


                                                /**
                                                 * @return The consolidated data from each row of table
                                                 */
                                              public List<String> get_the_Data_by_EachRow_From_Table() {


                                                        List<String> TransactionalTable_RowData = new ArrayList<>();

                                                            WebElement TransactionTable = findElement(HomePageLocators.TransactionTable_DataBody);

                                                            List<WebElement> rows_table = TransactionTable.findElements(HomePageLocators.TransactionalTable_bodyRows);
                                                                int rows_count = rows_table.size();

                                                                    System.out.println("Number of rows are ::" + rows_count);

                                                                            for (int row = 0; row < rows_count; row++) {
                                                        TransactionalTable_RowData.add("\n"+rows_table.get(row).getText());
                                                                            }
                                                                                System.out.println("data from table is" + " :: " + TransactionalTable_RowData);

                                                                            return TransactionalTable_RowData;
                                                }


                                                        /**
                                                         *
                                                         * @param Column_number is the Column from table from which you want to read the data
                                                         * @return all the values of Column_number
                                                         */
                                                        public List<String> get_the_Data_by_EachColumn(int Column_number) {


                                                            List<String> TransactionalTable_ColumnData= new ArrayList<String>();

                                                            WebElement TransactionTable= findElement(HomePageLocators.TransactionTable_DataBody);

                                                            WebElement table_row = TransactionTable.findElement(HomePageLocators.TransactionalTable_bodyRows);

                                                            //To locate columns(cells) of that specific row.
                                                            List<WebElement> Columns_row = table_row.findElements(By.xpath("//td["+Column_number+"]"));

                                                                        //To calculate no of columns(cells) In that specific row.
                                                                         int columns_row_count = Columns_row.size();

                                                                        //Loop will execute till the last cell of that specific row.
                                                                        for (int row = 0; row < columns_row_count; row++) {
                                                                            //get tge Digit Value frrom Amount Column
                                                                            String Column_Value =null;
                                                                            if (Column_number == 5) {
                                                                                Column_Value = Columns_row.get(row).getText();
                                                                                Column_Value = Column_Value.replaceAll("USD", "");
                                                                                Column_Value = Column_Value.replace(",","");
                                                                                Column_Value = Column_Value.substring(1);
                                                                            } else {

                                                                                Column_Value =Columns_row.get(row).getText();
                                                                            }
                                                                            TransactionalTable_ColumnData.add(Column_Value);



                                                                        }

                                                                                System.out.println("data from Column"+Column_number+" :: "+TransactionalTable_ColumnData);
                                                                                return TransactionalTable_ColumnData;
                                                    }


                                    /**
                                     *
                                     * @param AmountColumnData takes the Particular Column data as Argument
                                     * @return the state of Sorting of Amount Columnwhether Data is in Ascending Order or not
                                     * */

                                                    public Boolean sort_theAmount_Column_in_Ascending_Order(List<String> AmountColumnData){

                                                                Boolean sortedFlag=false;
                                                                AmountColumnData= get_the_Data_by_EachColumn(5);
                                                                List<Float> numbers=AmountColumnData.stream().map(s -> Float.parseFloat(s)).collect(Collectors.toList());

                                                                            for (Float number:numbers) {

                                                                                if(number<number+1){
                                                                                    sortedFlag = true;
                                                                                }
                                                                            }

                                                                                return sortedFlag;
                                                    }


}
