package com.dd.util;

import com.dd.base.TestBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
     public static long PAGE_LOAD = 20;
     public static long IMPLICIT_WAIT = 10;

     public static String TEST_DATA_SHEET_PATH = "/Users/shris/Downloads/Testing/Selenium/DataDrivenSelenium" +
             "/src/main/java/com/dd/testData/FreeCRM_TestData.xlsx";
     static Workbook book;
     static Sheet sheet;

    public static void takeScreenshotAtEndOfTest()throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //String currentDir = System.setProperty("user.dir");
        FileUtils.copyFile(srcFile,new File("/Users/shris/Downloads/Testing/Selenium/" +
                "DataDrivenSelenium"+"/screenshot/"+System.currentTimeMillis()+".png"));
    }

    public void switchToFrame(){
          driver.switchTo().frame("main-nav");
     }

     public void jsScrollIntoView(WebElement element){
          JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("arguments[0].scrollIntoView(true);",element);
          element.click();
     }

     /*public static Object[][] getTestData(String sheetName) {
             Object[][] dataTable = null;
              File file = new File(TEST_DATA_SHEET_PATH);
             try {
                // Create a file input stream to read Excel workbook and worksheet
                FileInputStream xlfile = new FileInputStream(file);
                XSSFWorkbook xlwb = new XSSFWorkbook(xlfile);
                XSSFSheet xlSheet = xlwb.getSheet(sheetName);

                // Get the number of rows and columns
                int numRows = xlSheet.getLastRowNum() + 1;
                int numCols = xlSheet.getRow(0).getLastCellNum();

                // Create double array data table - rows x cols
                // We will return this data table
                dataTable = new String[numRows][numCols];

                // For each row, create a HSSFRow, then iterate through the "columns"
                // For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
                for (int i = 0; i < numRows; i++) {
                    XSSFRow xlRow = xlSheet.getRow(i);
                    for (int j = 0; j < numCols; j++) {
                        XSSFCell xlCell = xlRow.getCell(j);
                        dataTable[i][j] = xlCell.toString();
                    }
                }
            } catch (IOException e) {
                System.out.println("ERROR FILE HANDLING " + e.toString());
            }
            return dataTable;
    }*/

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TEST_DATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int r = sheet.getLastRowNum();
        int c= sheet.getRow(0).getLastCellNum();


        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            /*Row row = sheet.getRow(i+1);
            if(row==null){
                break;
            }*/
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }

     public void actions(WebElement element){
          Actions action = new Actions(driver);
          //Action mouseOver = action.moveToElement(element).click().perform();
          action.moveToElement(element).click().perform();
     }
}
