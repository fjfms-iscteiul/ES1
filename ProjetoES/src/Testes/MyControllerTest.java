package Testes;

import org.junit.jupiter.api.Test;

import functional.MethodClass;
import functional.MyController;
import javafx.event.ActionEvent;

class MyControllerTest {

	@Test
	void test_importFile() {
		
		MyController mc = new MyController();
//		mc.importFile(null);
		//assertNull(mc);
		
	}
	
	@Test 
	void test_initialize() {
		MyController mc = new MyController();
//		mc.initialize(null, null);
//		assertNull(mc);
		
	}
	
	@Test
	void test_indicator1() {
		MethodClass mc = new MethodClass();
		mc.setPmd("TRUE");
		mc.setIplasma("TRUE");
		mc.setIsLongMethod("TRUE");
	//	assertEquals(mc, "TRUE");
		
	}
//	
//	@Test
//	void test_indicator2() {
//		
//	}
//	@Test
//	void test_indicator3() {
//		
//	}
//	@Test
//	void test_indicator4() {
//		
//	}
	
	@Test
	void test_readExcel() {	
		 
	}
	
	@Test
	void Test_ResetOriginal() throws Exception {
		MyController mc = new MyController();
		ActionEvent event = new ActionEvent();
		//mc.resetOriginal(event);
	}
	
	@Test
	void Test_ReadExcelException() {
		
	}
}

