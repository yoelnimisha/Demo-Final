package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		File src=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);

			wb=new XSSFWorkbook(fis);
		}catch (Exception e)
		{
			System.out.println("unable to read Excel file"+e.getMessage());
		}

	}

	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

	public String getStringNumericData(String sheetName,int row,int column)
	{
		switch(wb.getSheet(sheetName).getRow(row).getCell(column).getCellType()){

		case 1: 			
			return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue(); 	
		case 0: 			
			int a=(int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue(); 	
			return String.valueOf(a); 		
		} 	
		return null; 	
	}
	
	public Object[][] getDataprovider(String SheetName)
	{
		int rowCount,colCount =0;
		rowCount= wb.getSheet(SheetName).getPhysicalNumberOfRows();
		System.out.println(rowCount);
		colCount=wb.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
		System.out.println(colCount);
		Object data[][] =new Object[rowCount][colCount];
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String celldata = getStringNumericData(SheetName, i, j);
				System.out.println(celldata+ " | ");
				data[i][j]=celldata;
			}
			System.out.println();
		}
		return data;
	}
	/*
	public static void main(String arg[])
	{
		ExcelDataProvider n=new ExcelDataProvider();
		n.getDataprovider("Pwd");
	}*/
}
