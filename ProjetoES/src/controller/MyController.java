package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import functional.ReadExcel;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MyController implements Initializable{
	
	/* Hash map to store excel contents and workbook */
	private XSSFWorkbook workbook;
	private Map<Integer, String> excel_table;

	
	/* Table Fields */
	@FXML private TableView<Integer> es_table;
	@FXML private TableColumn<Integer, String> method_id;
	@FXML private TableColumn<String, String> package_name;
	@FXML private TableColumn<String, String> class_name;
	@FXML private TableColumn<String, String> method_name;
	@FXML private TableColumn<String, String> loc;
	@FXML private TableColumn<String, String> cyclo;
	@FXML private TableColumn<String, String> aftd;
	@FXML private TableColumn<String, String> laa;
	@FXML private TableColumn<String, String> is_long_method;
	@FXML private TableColumn<String, String> iplasma;
	@FXML private TableColumn<String, String> pmd;
	@FXML private TableColumn<String, String> is_feature_envy;
	
	@FXML private Button button_import;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		method_id.setCellValueFactory(new PropertyValueFactory<>("method_id"));
		package_name.setCellValueFactory(new PropertyValueFactory<>("package_name"));
		class_name.setCellValueFactory(new PropertyValueFactory<>("class_name"));
		method_name.setCellValueFactory(new PropertyValueFactory<>("method_name"));
		loc.setCellValueFactory(new PropertyValueFactory<>("loc"));
		cyclo.setCellValueFactory(new PropertyValueFactory<>("cyclo"));
		aftd.setCellValueFactory(new PropertyValueFactory<>("aftd"));
		laa.setCellValueFactory(new PropertyValueFactory<>("laa"));
		is_long_method.setCellValueFactory(new PropertyValueFactory<>("is_long_method"));
		iplasma.setCellValueFactory(new PropertyValueFactory<>("iplasma"));
		pmd.setCellValueFactory(new PropertyValueFactory<>("pmd"));
		is_feature_envy.setCellValueFactory(new PropertyValueFactory<>("is_feature_envy"));

	}
	
	/* Chooses file and inputs the path to readExcel */
	private void import_file(ActionEvent event) {
		System.out.println("importa");
		String defaultCurrentDirectoryPath = "C:\\users\\Authentic\\Desktop";
		JFileChooser excelFile = new JFileChooser(defaultCurrentDirectoryPath);
		excelFile.showOpenDialog(null);
		readExcel(excelFile.getSelectedFile().getAbsolutePath());
	}
	
	/* Reads the ExcelFile and stores it in a Hash Map */
	private void readExcel(String excel_file) throws IOException {
		
		File excelFile = new File(excel_file);
		FileInputStream fis = new FileInputStream(excelFile);
		
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		excel_table = new HashMap<Integer, String>();
		
		/* Iterate in rows */
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			/* Iterate on cells for the current row */
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell = cellIterator.next();
				System.out.print(cell.toString() + ";");
				Coordinate co = new Coordinate(x, y);
				
				excel_table.put(co, cell.toString());
				
				x++;
				
			}
			
			System.out.println();
			y++;
						
		}
		
		workbook.close();
		fis.close();
		
	}
	
	private void 
}
