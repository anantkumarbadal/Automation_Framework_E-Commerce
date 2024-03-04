package com.store.Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ReadExcelFile {

    //Reading the Excel file where the test data is stored

    public  static FileInputStream fileInputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellValue (String filename, String sheetName, int rowNumber, int cellNumber /*column no*/)
    {
        try
        {
            fileInputStream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNumber);

            /*
            cell = row.getCell(cellNumber);
            workbook.close();
            return cell.getStringCellValue();
             */

            //another way around-ensure that the workbook is closed only after all necessary data has been read.
            if (row != null) {
                 cell = row.getCell(cellNumber);
                if (cell != null) {
                    String cellValue = cell.getStringCellValue();
                    workbook.close();
                    return cellValue;
                }
            }
            workbook.close();
            return "";

        }
        catch (Exception e)
        {
            e.printStackTrace(); // Print the exception for debugging purposes
            return "";
        }
    }

    public static int getRowCount(String fileName, String sheetName)
    {
        try
        {
            fileInputStream = new FileInputStream(fileName);
            //create XSSFWorkbook class object for excel file manipulation
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);

            //get total no of rows
           // int totalRows = sheet.getLastRowNum() + 1;
            int totalRows = sheet.getPhysicalNumberOfRows(); // Use physical number of rows

            workbook.close();

            return totalRows;

        }
        catch (Exception e)
        {
            e.printStackTrace(); // Print the exception for debugging purposes
            return 0;
        }
    }

    public static int getColumnCount(String fileName, String sheetName)
    {
        try
        {
            fileInputStream = new FileInputStream(fileName);
            //create XSSFWorkbook class object for excel file manipulation
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);

            //get total no of columns
          //  int totalCells = sheet.getRow(0).getLastCellNum();

            //another way to get total columns
            row = sheet.getRow(0); // Get the first row to determine the number of cells
            int totalCells = row.getPhysicalNumberOfCells(); // Use physical number of cells

            workbook.close();
            return totalCells;
        }
        catch (Exception e)
        {
            e.printStackTrace(); // Print the exception for debugging purposes
            return 0;
        }
    }

}
