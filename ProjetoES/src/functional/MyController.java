package functional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MyController implements Initializable {

	/* File, workbook and list that will be shown in TableView */
	private File excelFile;
	private XSSFWorkbook workbook;
	private ObservableList<MethodClass> data;

	private List<MethodClass> rowsList;

	/* Table Fields */
	@FXML
	private TableView<MethodClass> esTable;
	@FXML
	private TableColumn<MethodClass, String> methodID;
	@FXML
	private TableColumn<MethodClass, String> packageName;
	@FXML
	private TableColumn<MethodClass, String> className;
	@FXML
	private TableColumn<MethodClass, String> methodName;
	@FXML
	private TableColumn<MethodClass, String> loc;
	@FXML
	private TableColumn<MethodClass, String> cyclo;
	@FXML
	private TableColumn<MethodClass, String> aftd;
	@FXML
	private TableColumn<MethodClass, String> laa;
	@FXML
	private TableColumn<MethodClass, String> isLongMethod;
	@FXML
	private TableColumn<MethodClass, String> iplasma;
	@FXML
	private TableColumn<MethodClass, String> pmd;
	@FXML
	private TableColumn<MethodClass, String> isFeatureEnvy;

	@FXML
	private Button importButton;

	/* Chooses file and inputs the path to readExcel */
	@FXML
	public void importFile(ActionEvent event) {

		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Excel files", "*.xlsx"));
		excelFile = fc.showOpenDialog(null);

		if (excelFile != null) {
			try {
				readExcel(excelFile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		data = FXCollections.observableArrayList();

		methodID.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("methodID"));
		packageName.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("packageName"));
		className.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("className"));
		methodName.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("methodName"));
		loc.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("loc"));
		cyclo.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("cyclo"));
		aftd.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("aftd"));
		laa.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("laa"));
		isLongMethod.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("isLongMethod"));
		iplasma.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("iplasma"));
		pmd.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("pmd"));
		isFeatureEnvy.setCellValueFactory(new PropertyValueFactory<MethodClass, String>("isFeatureEnvy"));

	}

	/* Reads the ExcelFile and stores it in a List */
	private void readExcel(String excel_file) throws IOException {

		FileInputStream fis = new FileInputStream(excelFile);

		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		rowsList = new ArrayList<MethodClass>();

		/* Iterate in rows */
		Iterator<Row> rowIt = sheet.iterator();

		while (rowIt.hasNext()) {

			Row row = rowIt.next();
			MethodClass tableRow = new MethodClass();

			/* Iterate on cells for the current row */
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				if (cell.getColumnIndex() == 0) {
					tableRow.setMethodID(cell.toString());

				}
				if (cell.getColumnIndex() == 1) {
					tableRow.setPackageName(cell.toString());
					System.out.println(cell.toString());

				}
				if (cell.getColumnIndex() == 2) {
					tableRow.setClassName(cell.toString());

				}
				if (cell.getColumnIndex() == 3) {
					tableRow.setMethodName(cell.toString());

				}
				if (cell.getColumnIndex() == 4) {
					tableRow.setLoc(cell.toString());

				}
				if (cell.getColumnIndex() == 5) {
					tableRow.setCyclo(cell.toString());

				}
				if (cell.getColumnIndex() == 6) {
					tableRow.setAftd(cell.toString());

				}
				if (cell.getColumnIndex() == 7) {
					tableRow.setLaa(cell.toString());

				}
				if (cell.getColumnIndex() == 8) {
					tableRow.setIsLongMethod(cell.toString());

				}
				if (cell.getColumnIndex() == 9) {
					tableRow.setIplasma(cell.toString());

				}
				if (cell.getColumnIndex() == 10) {
					tableRow.setPmd(cell.toString());

				}
				if (cell.getColumnIndex() == 11) {
					tableRow.setIsFeatureEnvy(cell.toString());

				}

			}
			rowsList.add(tableRow);

		}

		rowsList.sort(new Comparator<MethodClass>() {

			@Override
			public int compare(MethodClass o1, MethodClass o2) {
				try {
					return Integer.valueOf(o2.getMethodID()) - Integer.valueOf(o1.getMethodID());
				} catch (NumberFormatException ex) { // handle your exception
					return 1;
				}
			}

		});
		esTable.getItems().removeAll(data);
		data.addAll(rowsList);
		esTable.setItems(data);

		workbook.close();
		fis.close();

	}

}