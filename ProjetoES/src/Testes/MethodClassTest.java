package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import functional.MethodClass;
import javafx.scene.media.Media;

class MethodClassTest {

	@Test
	void test_GetMethodID() {
		MethodClass c = new MethodClass();
		c.setMethodID("44");
		assertEquals(c.getMethodID(), "44");

	}
	
	@Test
	void test_GetPackegeName() {
		MethodClass c = new MethodClass();
		c.setPackageName("geral");
		assertEquals(c.getPackageName(), "geral");
	}
	
	@Test
	void test_GetClassName() {
		MethodClass c = new MethodClass();
		c.setClassName("MyController");
		assertEquals(c.getClassName(), "MyController");
	}

	@Test
	void test_GetMethodName() {
		MethodClass c = new MethodClass();
		c.setMethodName("read");
		assertEquals(c.getMethodName(), "read");
	}
	
	@Test
	void test_GetLOC() {
		MethodClass c = new MethodClass();
		c.setLoc("22");
		assertEquals(c.getLoc(), "22");
	}
	
	@Test
	void test_GetCyclo() {
		MethodClass c = new MethodClass();
		c.setCyclo("5");
		assertEquals(c.getCyclo(), "5");
	}
	
	@Test
	void test_GetAftd() {
		MethodClass c = new MethodClass();
		c.setAftd("2");
		assertEquals(c.getAftd(), "2");
	}

	@Test
	void test_GetLaa() {
		MethodClass c = new MethodClass();
		c.setLaa("2");
		assertEquals(c.getLaa(), "2");
	}
	
	@Test
	void test_GetIsLongMethod() {
		MethodClass c = new MethodClass();
		c.setIsLongMethod("true");
		assertEquals(c.getIsLongMethod(), "true");
	}
	
	@Test
	void test_GetIPlasma() {
		MethodClass c = new MethodClass();
		c.setIplasma("");
		assertEquals(c.getIplasma(), "");
	}
	
	@Test
	void test_GetPmd() {
		MethodClass c = new MethodClass();
		c.setPmd("");
		assertEquals(c.getPmd(), "");
	}
	
	@Test
	void test_GetIsFeatureEnvy() {
		MethodClass c = new MethodClass();
		c.setIsFeatureEnvy("");
		assertEquals(c.getIsFeatureEnvy(), "");
	}
	
	@Test
	void test_toString() {
		MethodClass c = new MethodClass();
		MethodClass c1 = new MethodClass();
		assertEquals(c.toString(), c1.toString());
	}
	
	@Test
	void test_SegundoConstrutor() {
		MethodClass c = new MethodClass("44","functional", "MyController", "readExcel", "5" , "2" ,"","" , "true","" , "","false");
		assertNotNull(c);
	}
}
