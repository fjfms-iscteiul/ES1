package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	private Map<Coordinate, String> excel;
	
	private void storeExcel() throws IOException {
		
		File excelFile = new File("long-method.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		/* Iterate in rows */
		Iterator<Row> rowIt = sheet.iterator();
		
		excel = new HashMap<ReadExcel.Coordinate, String>();
		int x = 1;
		int y = 1;
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			/* Iterate on cells for the current row */
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell = cellIterator.next();
				System.out.print(cell.toString() + ";");
				Coordinate co = new Coordinate(x, y);
				
				excel.put(co, cell.toString());
				
				x++;
				
			}
			
			System.out.println();
			y++;
						
		}
		
		workbook.close();
		fis.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		new ReadExcel().storeExcel();
	}
	
	private class Coordinate {
		
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String getCoordinate() {
			return "(" + x + ", " + y +")";
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
	}

	
}
