package ExcelReader;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice {
	public static void main(String[] args) throws IOException {
		final String _Filepath = "/home/sb/Desktop/UsersandPass.xlsx";
		FileInputStream fis = new FileInputStream(_Filepath);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow rows;
		int rownum = sheet.getLastRowNum() + 1;
		for (int i = 0; i < rownum; i++) {
			rows = sheet.getRow(i);
			int columnnum = rows.getLastCellNum();
			for (int j = 0; j < columnnum; j++) {
				System.out.print(rows.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}
}
