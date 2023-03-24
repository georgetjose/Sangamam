package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DataReader
{
	public Object[][] readData(String excelfileName)  {
		System.out.println("Excel Reader has started!!!");

        XSSFWorkbook wbook = null;
        try {
            wbook = new XSSFWorkbook("./data/"+excelfileName+".xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue;
			}
		}
        try {
            wbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(data[0][0]);
		return data;
	}
}







