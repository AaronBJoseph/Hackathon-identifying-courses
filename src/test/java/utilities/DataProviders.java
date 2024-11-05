package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider method to provide form data from Excel file
    @DataProvider(name = "formData")
    public Object[][] getGiftCardData() throws Exception {
        // Path to the Excel file
        String excelFilePath = "C:\\Users\\2361361\\eclipse-workspace\\identifying_courses\\testData\\inputfilenew.xlsx";
        
        // Name of the sheet in the Excel file
        String sheetName = "Sheet1";
        
        // Initialize ExcelUtil object with the file path
        ExcelUtil excelUtil = new ExcelUtil(excelFilePath);
        
        // Number of rows of data (assuming only one row of data for simplicity)
        int rowCount = 1;
        
        // Create a 2D array to hold the data (1 row, 8 columns)
        Object[][] data = new Object[1][8];
        
        // Loop through the rows and columns to get the data
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < 8; j++) {
                data[i-1][j] = excelUtil.getCellData(sheetName, i, j);
            }
        }
        
        // Close the ExcelUtil object
        excelUtil.close();
        
        // Return the data array
        return data;
    }
}

