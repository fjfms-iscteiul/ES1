package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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

public class MyController implements Initializable {

	/* Hash map to store excel contents and workbook */
	private XSSFWorkbook workbook;
	private Map<Integer, String> excel_table;

	/* Table Fields */
	@FXML
	private TableView<Integer> es_table;
	@FXML
	private TableColumn<Integer, String> method_id;
	@FXML
	private TableColumn<String, String> package_name;
	@FXML
	private TableColumn<String, String> class_name;
	@FXML
	private TableColumn<String, String> method_name;
	@FXML
	private TableColumn<String, String> loc;
	@FXML
	private TableColumn<String, String> cyclo;
	@FXML
	private TableColumn<String, String> aftd;
	@FXML
	private TableColumn<String, String> laa;
	@FXML
	private TableColumn<String, String> is_long_method;
	@FXML
	private TableColumn<String, String> iplasma;
	@FXML
	private TableColumn<String, String> pmd;
	@FXML
	private TableColumn<String, String> is_feature_envy;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//		method_id.setCellValueFactory(new PropertyValueFactory<Integer, String>("method_id"));
		//		package_name.setCellValueFactory(new PropertyValueFactory<String, String>("package_name"));
		//		class_name.setCellValueFactory(new PropertyValueFactory<String, String>("class_name"));
		//		method_name.setCellValueFactory(new PropertyValueFactory<String, String>("method_name"));
		//		loc.setCellValueFactory(new PropertyValueFactory<String, String>("loc"));
		//		cyclo.setCellValueFactory(new PropertyValueFactory<String, String>("cyclo"));
		//		aftd.setCellValueFactory(new PropertyValueFactory<String, String>("aftd"));
		//		laa.setCellValueFactory(new PropertyValueFactory<String, String>("laa"));
		//		is_long_method.setCellValueFactory(new PropertyValueFactory<String,String>("is_long_method"));
		//		iplasma.setCellValueFactory(new PropertyValueFactory<String, String>("iplasma"));
		//		pmd.setCellValueFactory(new PropertyValueFactory<String, String>("pmd"));
		//		is_feature_envy.setCellValueFactory(new PropertyValueFactory<String, String>("is_feature_envy"));

	}

	@FXML
	private Button button_import;

	
	//CODIGO CAROLINA
	@FXML
	TableView tabela;

	/* Chooses file and inputs the path to readExcel */
	public void import_file(ActionEvent event) {

		File excelFile;
		FileInputStream excelFIS = null;
		BufferedInputStream excelBIS = null;
		XSSFWorkbook excelJTableImport;

		System.out.println("importa");

		String defaultCurrentDirectoryPath = "C:\\users\\Authentic\\Desktop";
		JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
		int excelChooser = excelFileChooser.showOpenDialog(null);

		//	readExcel(excelFileChooser.getSelectedFile().getAbsolutePath());

		if(excelChooser == JFileChooser.APPROVE_OPTION) {

			try {
				excelFile = excelFileChooser.getSelectedFile();
				excelFIS = new FileInputStream(excelFile);
				excelBIS = new BufferedInputStream(excelFIS);


				excelJTableImport = new XSSFWorkbook(excelBIS);
				XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

				for (int i = 1; i < excelSheet.getLastRowNum(); i++) {
					XSSFRow excelRow = excelSheet.getRow(i);


					XSSFCell excelMethodID = excelRow.getCell(0);
					XSSFCell excelPackae = excelRow.getCell(1);
					XSSFCell excelClass = excelRow.getCell(2);
					XSSFCell excelMethod = excelRow.getCell(3);
					XSSFCell excelLOC = excelRow.getCell(4);
					XSSFCell excelCYCLO = excelRow.getCell(5);
					XSSFCell excelATFD = excelRow.getCell(6);
					XSSFCell excelLAA = excelRow.getCell(7);
					XSSFCell excelIs_long_method = excelRow.getCell(8);
					XSSFCell excelIPlasma = excelRow.getCell(9);
					XSSFCell excelPMD = excelRow.getCell(10);
					XSSFCell excelIs_feature_envy = excelRow.getCell(11);

					System.out.println(excelMethodID);
					System.out.println(excelPackae);
					System.out.println(excelClass);
					System.out.println(excelMethod);


					tabela.getItems().addAll(excelMethodID, excelPackae, excelClass, excelMethod,
							excelLOC,excelCYCLO,excelATFD,excelLAA,excelIs_long_method,excelIPlasma,
							excelPMD,excelIs_feature_envy);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}


	//CODIGO DO BRAGANÇA
	//	/* Chooses file and inputs the path to readExcel */
	//	public void import_file(ActionEvent event) {
	//		try {
	//			System.out.println("importa");
	//			
	//			
	//			String defaultCurrentDirectoryPath = "C:\\users\\Authentic\\Desktop";
	//			JFileChooser excelFile = new JFileChooser(defaultCurrentDirectoryPath);
	//			excelFile.showOpenDialog(null);
	//			readExcel(excelFile.getSelectedFile().getAbsolutePath());
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}
	//	/* Reads the ExcelFile and stores it in a Hash Map */
	//	private void readExcel(String excel_file) throws IOException {
	//
	//		File excelFile = new File(excel_file);
	//		FileInputStream fis = new FileInputStream(excelFile);
	//
	//		workbook = new XSSFWorkbook(fis);
	//		XSSFSheet sheet = workbook.getSheetAt(0);
	//
	//		excel_table = new HashMap<Integer, String>();
	//
	//		/* Iterate in rows */
	//		Iterator<Row> rowIt = sheet.iterator();
	//
	//		while (rowIt.hasNext()) {
	//			Row row = rowIt.next();
	//
	//			/* Iterate on cells for the current row */
	//			Iterator<Cell> cellIterator = row.cellIterator();
	//
	//			int inicial =1;
	//			while (cellIterator.hasNext()) {
	//				Cell cell = cellIterator.next();
	//				excel_table.put(inicial, cell.toString());
	//				inicial++;
	////				System.out.print(cell.toString() + ";");
	//			}
	//				// Coordinate co = new Coordinate(x, y);
	//
	//				// excel_table.put(co, cell.toString());
	//
	//				// x++;
	//
	//			System.out.println(excel_table.toString());
	//						// y++;
	//
	//		}
	//
	//		workbook.close();
	//		fis.close();
	//
	//	}

}
