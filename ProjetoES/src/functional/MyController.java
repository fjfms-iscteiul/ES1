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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.TextField;

public class MyController implements Initializable {

	/* File, workbook and list that will be shown in TableView */
	private File excelFile;
	private XSSFWorkbook workbook;
	private ObservableList<MethodClass> data;
	//	private ObservableList<MethodClass> temp;
	private List<MethodClass> rowsList;

	/* Table Fields */
	@FXML private TableView<MethodClass> esTable;
	@FXML private TableColumn<MethodClass, String> methodID;
	@FXML private TableColumn<MethodClass, String> packageName;
	@FXML private TableColumn<MethodClass, String> className;
	@FXML private TableColumn<MethodClass, String> methodName;
	@FXML private TableColumn<MethodClass, String> loc;
	@FXML private TableColumn<MethodClass, String> cyclo;
	@FXML private TableColumn<MethodClass, String> aftd;
	@FXML private TableColumn<MethodClass, String> laa;
	@FXML private TableColumn<MethodClass, String> isLongMethod;
	@FXML private TableColumn<MethodClass, String> iplasma;
	@FXML private TableColumn<MethodClass, String> pmd;
	@FXML private TableColumn<MethodClass, String> isFeatureEnvy;

	/* Defects counters */
	private int dciPlasma = 0;
	private int diiPlasma = 0;
	private int adciPlasma = 0;
	private int adiiPlasma = 0;
	private int dciPMD = 0;
	private int diiPMD = 0;
	private int adciPMD = 0;
	private int adiiPMD = 0;

	/* Buttons used in the interface */
	@FXML private Button importButton;
	@FXML private Button updateDefects;
	@FXML private Button updateLong;
	@FXML private Button updateFeature;
	@FXML private Button resetButton;

	/* Text Fields for Thresholds tab */
	@FXML private TextField locValue;
	@FXML private TextField cycloValue;
	@FXML private TextField aftdValue;
	@FXML private TextField laaValue;

	/* Text Fields and Pie Chart for Defects Tab */
	@FXML private TextField dciValuePlasma;
	@FXML private TextField diiValuePlasma;
	@FXML private TextField adciValuePlasma;
	@FXML private TextField adiiValuePlasma;
	@FXML private TextField dciValuePMD;
	@FXML private TextField diiValuePMD;
	@FXML private TextField adciValuePMD;
	@FXML private TextField adiiValuePMD;

	@FXML private PieChart pieDefectsPlasma;
	@FXML private PieChart pieDefectsPMD;

	/* Values for Threshold Changes */
	private double LOC;
	private double CYCLO;
	private double AFTD;
	private double LAA;	


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


	/* Initialize the table view */
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


	/* Reset the table to its original state */
	@FXML
	public void resetOriginal(ActionEvent event) throws IOException {
		readExcel(excelFile.getAbsolutePath());
	}


	/* Methods to change the thresholds in Long and Feature */
	@FXML
	private void changeValuesLong(ActionEvent event) {
		LOC = Double.valueOf(locValue.getText());
		CYCLO = Double.valueOf(cycloValue.getText());

		ObservableList<MethodClass> temp = FXCollections.observableArrayList();

		for (MethodClass mc : rowsList) {
			if (Double.valueOf(mc.getLoc()) > LOC && Double.valueOf(mc.getCyclo()) > CYCLO) {
				mc.setIsLongMethod("TRUE");	
			} else {
				mc.setIsLongMethod("FALSE");	
			}
		}

		esTable.getItems().removeAll(esTable.getItems());
		temp.addAll(rowsList);
		esTable.getItems().addAll(temp);
	}

	@FXML
	private void changeValuesFeature(ActionEvent event) {
		AFTD = Double.valueOf(aftdValue.getText());
		LAA = Double.valueOf(laaValue.getText());

		ObservableList<MethodClass> temp = FXCollections.observableArrayList();

		for (MethodClass mc : rowsList) {
			if (Double.valueOf(mc.getAftd()) > AFTD && Double.valueOf(mc.getLaa()) < LAA) {
				mc.setIsFeatureEnvy("TRUE");	
			} else {
				mc.setIsFeatureEnvy("FALSE");	
			}
		}
		esTable.getItems().removeAll(esTable.getItems());
		temp.addAll(rowsList);
		esTable.getItems().addAll(temp);
	}


	/* Detects the defects within the a MethodClass item */
	private void defectsDetector(MethodClass tableRow) {


		if(tableRow.getIplasma().equalsIgnoreCase("TRUE") && tableRow.getIsLongMethod().equalsIgnoreCase("TRUE")) {
			dciPlasma++;
		} else if(tableRow.getIplasma().equalsIgnoreCase("TRUE") && tableRow.getIsLongMethod().equalsIgnoreCase("FALSE")) {
			diiPlasma++;
		} else if(tableRow.getIplasma().equalsIgnoreCase("FALSE") && tableRow.getIsLongMethod().equalsIgnoreCase("FALSE")) {
			adciPlasma++;
		} else if(tableRow.getIplasma().equalsIgnoreCase("FALSE") && tableRow.getIsLongMethod().equalsIgnoreCase("TRUE")) {
			adiiPlasma++;
		}
		
		if(tableRow.getPmd().equalsIgnoreCase("TRUE") && tableRow.getIsLongMethod().equalsIgnoreCase("TRUE")) {
			dciPMD++;
		} else if(tableRow.getPmd().equalsIgnoreCase("TRUE") && tableRow.getIsLongMethod().equalsIgnoreCase("FALSE")) {
			diiPMD++;
		} else if(tableRow.getPmd().equalsIgnoreCase("FALSE") && tableRow.getIsLongMethod().equalsIgnoreCase("FALSE")) {
			adciPMD++;
		} else if(tableRow.getPmd().equalsIgnoreCase("FALSE") && tableRow.getIsLongMethod().equalsIgnoreCase("TRUE")) {
			adiiPMD++;
		}
	}
	


	/* Updates the defects view in the GUI */
	@FXML
	private void updateDefectsCount(ActionEvent event) {

		dciPlasma = 0;
		diiPlasma = 0;
		adciPlasma = 0;
		adiiPlasma = 0;
		
		dciPMD = 0;
		diiPMD = 0;
		adciPMD = 0;
		adiiPMD = 0;

		for(MethodClass me: rowsList) {
			defectsDetector(me);
		}

		dciValuePlasma.setText("" + dciPlasma);
		diiValuePlasma.setText("" + diiPlasma);
		adciValuePlasma.setText("" + adciPlasma);
		adiiValuePlasma.setText("" + adiiPlasma);
		
		dciValuePMD.setText("" + dciPMD);
		diiValuePMD.setText("" + diiPMD);
		adciValuePMD.setText("" + adciPMD);
		adiiValuePMD.setText("" + adiiPMD);

		/* Pie Chart update */
		ObservableList<PieChart.Data> pieChartDataPlasma = FXCollections.observableArrayList(
				new PieChart.Data("DCI", dciPlasma),
				new PieChart.Data("DII", diiPlasma),
				new PieChart.Data("ADCI", adciPlasma),
				new PieChart.Data("ADII", adiiPlasma));

		pieDefectsPlasma.setData(pieChartDataPlasma);
		
		ObservableList<PieChart.Data> pieChartDataPMD = FXCollections.observableArrayList(
				new PieChart.Data("DCI", dciPMD),
				new PieChart.Data("DII", diiPMD),
				new PieChart.Data("ADCI", adciPMD),
				new PieChart.Data("ADII", adiiPMD));

		pieDefectsPMD.setData(pieChartDataPMD);

	}


	/* Reads the ExcelFile and stores it in a List */
	private void readExcel(String excel_file) throws IOException {

		FileInputStream fis = new FileInputStream(excelFile);

		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		rowsList = new ArrayList<MethodClass>();

		ObservableList<MethodClass> temp = FXCollections.observableArrayList();

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
		temp.addAll(rowsList);
		esTable.getItems().addAll(temp);

		updateDefectsCount(null);

		workbook.close();
		fis.close();

	}

}